

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {
	 private final boolean printStatus = true;
	 private final boolean printIndex = false;

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

    if (urlVal.isValid("ftp://go.com")) {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("h3t://go.au")) {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("://256.256.256.256")) {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("http:1.2.3")) {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("3ht://go.com")) {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("http://255.255.255.255")) {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    if (urlVal.isValid("go.1aa")) {
        passTests++;
    } else {
        failTests++;
    }
    totalTests++;

    System.out.printf("Total tests run...%d", totalTests);
    System.out.printf("Total tests failed...%d", failTests);
    System.out.printf("Total tests passed...%d", passTests);
   }


   public void testYourFirstPartition()
   {
	 	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	      // StringBuilder testBuffer = new StringBuilder();
	   		String url = "www.go.com";
	   		int total=0; int fail=0;
	   		String [] TestUrlScheme = {"http://","http:/"};
	   			
	   			for(int i=0;i< TestUrlScheme.length;i++){
	   			//check even, valid, scheme elements… should return true
	   				if(i%2==0){
	   					if(!urlVal.isValid(TestUrlScheme[i] + url)){
		   						if(printStatus){
		   						System.out.print("Expected: true" +"\t");
		   						System.out.println("result: " +urlVal.isValid(TestUrlScheme[i] + url));
		   						}
		   						//boolean	expected=false;
	   						fail++;
	   					}
	   				}else{//check odd, invalid, scheme elements… should return false
	   					if(urlVal.isValid(TestUrlScheme[i] + url)){
	   						if(printStatus){
	   						System.out.print("Expected: false" +"\t");
	   						System.out.println("result: " +urlVal.isValid(TestUrlScheme[i] + url));
	   						}
	   						//boolean	expected=false;
	   						//assertEquals(TestUrlScheme[i] + url,expected,urlVal.isValid(TestUrlScheme[i] + url));
							fail++;}
	   			}
	   				total++;
	   			
	   			}
	  			 System.out.println("*******Scheme Tests:");
	   			System.out.println("Total:"+total+"--Fail:"+fail);
   }

   public void testYourSecondPartition(){
		   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	      // StringBuilder testBuffer = new StringBuilder();
	   		String url = "http://";
	   		int total=0; int fail=0;
	   		String [] testUrlAuthority = {"google.com",""};
	   		for(int i=0;i< testUrlAuthority.length;i++){
	   			if(i%2==0){
	   			//check even, valid, Authority elements… should return true
	   					if(!urlVal.isValid(url+ testUrlAuthority[i])){
		   						if(printStatus){
		   						System.out.print("Expected: true" +"\t");
		   						System.out.println("result: " +urlVal.isValid(url+testUrlAuthority[i]));
		   						}
		   					
	   						fail++;
	   					}
	   			}else{//check odd, invalid, Authority elements… should return false
	   				if(urlVal.isValid(url+ testUrlAuthority[i])){
   						if(printStatus){
   						System.out.print("Expected: false" +"\t");
   						System.out.println("result: " +urlVal.isValid(testUrlAuthority[i] + url));
   						}
   						
						fail++;}
	   			}
	   			total++;
	   			
	   		}
	  			 System.out.println("*****Authority Tests:");
	   			System.out.println("Total:"+total+"--Fail:"+fail);

   }
	
	
public void testYourThirdPartition(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	      // StringBuilder testBuffer = new StringBuilder();
	   		String url = "http://www.google.com";
	   		int total=0; int fail=0;
	   		String [] testUrlPath = {"/test1/","/../"};
	   		for(int i=0;i< testUrlPath.length;i++){
	   			if(i%2==0){
	   			//check even, valid, false elements… should return true
	   					if(!urlVal.isValid(url+ testUrlPath[i])){
		   						if(printStatus){
		   						System.out.print("Expected: true" +"\t");
		   						System.out.println("result: " +urlVal.isValid(url+testUrlPath[i]));
		   						}
		   						
	   						fail++;
	   					}
	   			}if(i%2!=0){ 
					//check odd, invalid, path elements.... return return false
	   				if(urlVal.isValid(url+ testUrlPath[i])){
						if(printStatus){
						System.out.print("Expected: false" +"\t");
						System.out.println("result: " +urlVal.isValid(url+testUrlPath[i]));
						}
						
						fail++;}
	   			}
	   			total++;
	   		
	   		}
	   		System.out.println("********Path Tests:");
   			System.out.println("total:"+total+"--Fail:"+fail);	
}

   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }



}
