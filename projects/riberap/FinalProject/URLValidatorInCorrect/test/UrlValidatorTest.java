

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }



   public void testManualTest()
   {
//You can use this function to implement your manual testing

    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
    System.out.println("Starting manual testing ...");

    int passTests = 0;
    int failTests = 0;
    int totalTests = 0;

    if (urlVal.isValid("http://www.google.com")) {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("ftp://go.com") {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("h3t://go.au") {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("://256.256.256.256") {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("http:1.2.3") {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("3ht://go.com") {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("http://255.255.255.255") {
        passTests;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("go.1aa") {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    System.out.println("Total tests run...%d", totalTests);
    System.out.println("Total tests failed...%d", failTests);
    System.out.println("Total tests passed...%d", passTests);
   }


   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing

   }

   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing

   }
   //You need to create more test cases for your Partitions if you need to

   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }



}
