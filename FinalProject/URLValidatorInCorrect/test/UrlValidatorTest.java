

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
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   
	         
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      // StringBuilder testBuffer = new StringBuilder();
   		String url = "www.google.com";
   		int pass=0; int fail=0;
   		String [] TestUrlScheme = {"","http://","h3t://","3ht://","https://};
   			
   			for(int i=0;i< TestUrlScheme.length;i++){
   			//check even, valid, scheme elements… should return true
   					if(urlVal.isValid(TestUrlScheme[i] + url)){
	   						if(printStatus){
	   						System.out.print("Expected: true" +"\t");
	   						System.out.println("result: " +urlVal.isValid(TestUrlScheme[i] + url));
	   						}
	   						//boolean	expected=false;
	   						//assertEquals(TestUrlScheme[i] + url,expected,urlVal.isValid(TestUrlScheme[i] + url));
   						pass++;}
   					if(!urlVal.isValid(TestUrlScheme[i] + url)){
	   						if(printStatus){
	   						System.out.print("Expected: false" +"\t");
	   						System.out.println("result: " +urlVal.isValid(TestUrlScheme[i] + url));
	   						}
	   						//boolean	expected=false;
   						fail++;
   					}
   			}
   			System.out.println("Scheme Tests:");
   			System.out.println("Pass:"+pass+"--Fail:"+fail);

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
