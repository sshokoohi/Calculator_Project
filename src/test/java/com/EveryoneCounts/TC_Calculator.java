/*
 * Project: Automate online Calculator 2.0
 * Test Engineer: Shawn Shokoohi
 * Java with TestNG, added Maven for connect to Jars repositories and Ant
 * via a batch file to run on GUI less platforms which can be schedule
 * via OS scheduler to run at different times.
 */


package com.EveryoneCounts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

   public class TC_Calculator
   {	
		static WebDriver driver;
		String strWebDriverBrowPath = "C:\\Selenium\\alljars\\chromedriver.exe";
		String strWebDriverType = "webdriver.chrome.driver";
		String strMult_result;
		String strAdd_result;
		String strSub_result;
		String strDiv_result;
		static double n1;
		static double n2;
		static double[][] myArray;
			
		
		@BeforeClass
		  public void BeforeClass() {
			setUpCSVArray();
		  }
		
		
   @BeforeMethod
   public void setUp() {
		  	  
	     System.setProperty(strWebDriverType, strWebDriverBrowPath);
	     driver = new ChromeDriver();		  
	     String strbaseUrl = "http://web2.0calc.com";
	     driver.get(strbaseUrl);
	   	  
   }
   
   
  @Test
  public void testMultipication() {  
	  
		 driver.findElement(By.id("Btn4")).click();
		 driver.findElement(By.id("Btn2")).click();	  
		 driver.findElement(By.id("Btn3")).click();		  
		 driver.findElement(By.id("BtnMult")).click();	 	  
		 driver.findElement(By.id("Btn5")).click();	  
		 driver.findElement(By.id("Btn2")).click();	  
		 driver.findElement(By.id("Btn5")).click();		  
		 driver.findElement(By.id("BtnCalc")).click();	  
		 strMult_result = driver.findElement(By.id("input")).getAttribute("value");
		 System.out.println("The multipication value is: " + strMult_result);
		 Assert.assertEquals(strMult_result, "423*525");		 
  }
 
  @Test
  public void testDivision() {
	 
	 	driver.findElement(By.id("Btn4")).click();
	 	driver.findElement(By.id("Btn0")).click();
	 	driver.findElement(By.id("Btn0")).click();
	 	driver.findElement(By.id("Btn0")).click(); 	
	 	driver.findElement(By.id("BtnDiv")).click();	
	 	driver.findElement(By.id("Btn2")).click();
	 	driver.findElement(By.id("Btn0")).click();
	 	driver.findElement(By.id("Btn0")).click();
	 	driver.findElement(By.id("BtnCalc")).click();
	 	strDiv_result = driver.findElement(By.id("input")).getAttribute("value");
	 	System.out.println("The Divition value is: " + strDiv_result);
	    Assert.assertEquals(strDiv_result, "4000/200");    
  }
  
  @Test
  public void testAddition() {
	    
	    driver.findElement(By.id("BtnMinus")).click();
	    driver.findElement(By.id("Btn2")).click();
	    driver.findElement(By.id("Btn3")).click();
	    driver.findElement(By.id("Btn4")).click();
	    driver.findElement(By.id("Btn2")).click();
	    driver.findElement(By.id("Btn3")).click();
	    driver.findElement(By.id("Btn4")).click();
	    driver.findElement(By.id("BtnPlus")).click();
	    driver.findElement(By.id("Btn3")).click();
	    driver.findElement(By.id("Btn4")).click();
	    driver.findElement(By.id("Btn5")).click();
	    driver.findElement(By.id("Btn3")).click();
	    driver.findElement(By.id("Btn4")).click();
	    driver.findElement(By.id("Btn5")).click();
	    driver.findElement(By.id("BtnCalc")).click();
	    strAdd_result = driver.findElement(By.id("input")).getAttribute("value");
	    System.out.println("The Addition value is: " + strAdd_result);
	    Assert.assertEquals(strAdd_result, "-234234+345345");	    
  }
  
  
  
  @Test
  public void testSubtraction() {
	    
	    driver.findElement(By.id("Btn2")).click();
	    driver.findElement(By.id("Btn3")).click();
	    driver.findElement(By.id("Btn4")).click();
	    driver.findElement(By.id("Btn8")).click();
	    driver.findElement(By.id("Btn2")).click();
	    driver.findElement(By.id("Btn3")).click();
	    driver.findElement(By.id("BtnMinus")).click();
	    driver.findElement(By.id("BtnParanL")).click();
	    driver.findElement(By.id("BtnMinus")).click();
	    driver.findElement(By.id("Btn2")).click();
	    driver.findElement(By.id("Btn3")).click();
	    driver.findElement(By.id("Btn0")).click();
	    driver.findElement(By.id("Btn9")).click();
	    driver.findElement(By.id("Btn4")).click();
	    driver.findElement(By.id("Btn8")).click();
	    driver.findElement(By.id("Btn2")).click();
	    driver.findElement(By.id("Btn3")).click();
	    driver.findElement(By.id("BtnParanR")).click();
	    driver.findElement(By.id("BtnCalc")).click();
	    strSub_result = driver.findElement(By.id("input")).getAttribute("value");
	    System.out.println("The Subtraction value is: " + strSub_result);
	    Assert.assertEquals(strSub_result, "234823-(-23094823)");	  
  }
  
  
  
  @AfterMethod
  public void tearDown() {	  
	  driver.quit();
  }
  @AfterClass
  public void afterClass() {
  }
  @AfterTest
  public void afterTest() {
  }
  
  
  public static void setUpCSVArray()
  {
  	double[][] myArray;
  	  myArray = new double[4][2];
  	  
  	  Scanner scanIn = null;
  	  int Rowc = 0;
  	  //int Row = 0;
  	  //int Colc = 0;
  	  //int Col = 0;
  	  String InputLine = "";
  	  //double xnum = 0;
  	  String xfileLocation;	  
  	  xfileLocation = "c:\\data1.csv";
  	  
  	  System.out.println("\n******** Setup Array ********");
  	  
  	  try
  	  {
  		  //setup a scanner
  		  scanIn = new Scanner (new BufferedReader(new FileReader(xfileLocation)));
  		  		  
  		  //while ((InputLine = scanIn.nextLine())
  		  while (scanIn.hasNextLine())
  		  {  		  
  			  //Read line in from file
  			  InputLine = scanIn.nextLine();
  			  System.out.println("InputLine: " + InputLine);
  			  
  			  
  			  //Split the inputline into an array at the commas
  			  String[] InArray = InputLine.split(",");
  			  
  			  //copy the content of the inArray to the myArray
  			  for (int x = 0; x < InArray.length; x++)				  
  			  {
  				  myArray [Rowc][x] = Double.parseDouble(InArray[x]);				  
  			  }
  			  //Increment the row in the array
  			  Rowc++;		
  			  
  		  }
  		  System.out.println("\n------------------------------");			  
  		  System.out.println("The value of myArray [0][0] is: " + myArray [0][0]);
  		  System.out.println("The value of myArray [0][1] is: " + myArray [0][1]);
  		  System.out.println("The value of myArray [1][0] is: " + myArray [1][0]);
  		  System.out.println("The value of myArray [1][1] is: " + myArray [1][1]);
  		  System.out.println("The value of myArray [2][0] is: " + myArray [2][0]);
  		  System.out.println("The value of myArray [2][1] is: " + myArray [2][1]);
  		  System.out.println("The value of myArray [3][0] is: " + myArray [3][0]);
  		  System.out.println("The value of myArray [3][1] is: " + myArray [3][1]);
  		  
  		    		  		  
  	  } catch (Exception e)
  	  {
  		  System.out.println(e);
  	  }		  
  	  
  }
  
  public void n1Value(){
	  
	  if (myArray [0][0] == 0){
		  n1 = 0;
	  }else if
	  (myArray [0][0] == 1){		  
		  n1 = 1;
	  }else if
	  (myArray [0][0] == 2){		  
		  n1 = 2;
	  }else if
	  (myArray [0][0] == 3){		 
		  n1 = 3;
	  }else if
	  (myArray [0][0] == 4){		  
		  n1 = 4;
	  }else if
	  (myArray [0][0] == 5){		  
		  n1 = 5;
	  }else if
	  (myArray [0][0] == 6){		  
		  n1 = 6;
	  }else if
	  (myArray [0][0] == 7){		  
		  n1 = 7;
	  }else if
	  (myArray [0][0] == 8){		  
		  n1 = 8;
	  }else if
	  (myArray [0][0] == 9){		  
		  n1 = 9;
	  }else if
	  (myArray [0][0] == '-'){		  
		  n1 = '-';
	  }
	  System.out.println("n1 is: " + n1 );
  }
  

  public void n2Value(){
	  
	  if (myArray [0][0] == 0){	  
		  n2 = 0;
	  }else if
	  (myArray [0][0] == 1){		  
		  n2 = 1;
	  }else if
	  (myArray [0][0] == 2){		  
		  n2 = 2;
	  }else if
	  (myArray [0][0] == 3){		  
		  n2 = 3;
	  }else if
	  (myArray [0][0] == 4){		  
		  n2 = 4;
	  }else if
	  (myArray [0][0] == 5){		  
		  n2 = 5;
	  }else if
	  (myArray [0][0] == 6){		  
		  n2 = 6;
	  }else if
	  (myArray [0][0] == 7){		  
		  n2 = 7;
	  }else if
	  (myArray [0][0] == 8){		  
		  n2 = 8;
	  }else if
	  (myArray [0][0] == 9){	  
		  n2 = 9;
	  }else if
	  (myArray [0][0] == '-'){		  
		  n2 = '-';
	  }
	  System.out.println("n2 is: " + n2 );
  }
  
  
  // write a function to read each digit in first array, click the corresponding button on the 
  //calculator for each digit, then save the result in N1, then do the same for second array 
  //and save the result in N2, then do the proper operation on the calculator.
   }
