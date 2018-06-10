

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
    // Huff's contribution: programming-based testing
    public void testIsValid() {

        /*

            ---- IMPORTANT NOTE ----

        John Eleen found a bug when performing input partition.
        The bug precludes all valid schemes besides http and all valid port numbers in authorities.
        If he had not, this would be the validScheme array passed to our unit test.

            // Valid schemes are described in RFC 3986
            // Because a scheme is optional, the array starts with the empty string.
           String[] validScheme =  { "scheme",
                   //"",
                   "http://",  "https://", "ftp://", "ftps://",
                   "http+://", "ht-tp://", "h.t.t.p.://"
           };

        Also, this would be the invalid authority array.

            String[] invalidAuth = { "authority", "256.255.255.255", "google.255" };

        */
        String[] validScheme = { "scheme", "http://" };

        // Invalid schemes start with a numeric or contain invalid characters. These are a small sample of what should fail.
        String[] invalidScheme = { "scheme", "0http://", "http^://" };

        // Valid Authorities are described in RFC 3986
        String[] validAuth = { "authority", "google.com", "255.255.255.255", "google.co.uk" };

        // Invalid authorities are empty strings, octets and ports out of range, and invalid top level domains
        // Empty strings are excluded from the test to accommodate a bug and still test the other cases.
        String[] invalidAuth = { "authority"};

        // This array's elements each contain a different valid path character
        // Valid path characters can be found in RFC 3986
        // Because a path is optional, the array starts with the empty string.
        String[] validPath = { "path", "",
                "/pathtest", "/PATHTEST", "/pathtest01", "/path.test",
                "/path-test", "/path_test",
                // Commented out in the middle of testing to check subsequent cases: "/path~test",
                "/path!test", "/path$test", "/path&test", "/path'test",
                "/path(test", "/path)test", "/path*test", "/path+test",
                "/path,test", "/path;test", "/path=test", "/path:test",
                "/path@test"
        };

        // Invalid paths contain characters not in that subset. These are a small sample of what should fail.
        String[] invalidPath = { "path", "/path|test", "/path^test", "/path`test" };

        // Valid query characters (basically any non-whitespace character) can be found in RFC 3986
        // Because a query is optional, the array starts with the empty string.
        String[] validQuery = { "query", "", "?", "quarter?name=SP18&final=YES" };

        // Invalid paths contain characters not in that subset. These are a small sample of what should fail.
        String[] invalidQuery = { "query", "? huh" };

        String[][] valids = {validScheme, validAuth, validPath, validQuery};
        String[][] invalids = {invalidScheme, invalidAuth, invalidPath, invalidQuery};

        for (int i = 0; i < valids.length; i++) {

            for (int j = 1; j < valids[i].length; j++) {

                accepted(valids[i], valids[i][j], j, "accepted");
            }
        }

        for (int i = 0; i < invalids.length; i++) {

            for (int j = 1; j < invalids[i].length; j++) {

                accepted(invalids[i], invalids[i][j], j, "rejected");
            }
        }

        System.out.println("All tests successful.");
    }

    /*

    Takes an array of test cases, a particular element in it, that element's position,
    and whether the string is supposed to be rejected or accepted.

    Depending on the element's type (which is provided by the array's 0th index,
    a known valid component is attached to it and the composite string istested for overall validity

    */
    private void accepted(String[] inputArray, String element, int position, String expected) {

        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        String compStr = "compStr has not been set to a valid component type!";
        String componentType = inputArray[0];
        String knownValid;
        String errMsg;

        if (componentType.equals("scheme")) {

            knownValid = "google.com";
            compStr = element + knownValid;
        }

        if (componentType.equals("authority")) {

            knownValid = "http://";
            compStr = knownValid + element;
        }

        if (componentType.equals("path")) {

            knownValid = "http://";
            compStr = knownValid + element;
        }

        if (componentType.equals("query")) {

            knownValid = "http://google.com";
            compStr = knownValid + element;
        }

        if (expected.equals("accepted")) {

            errMsg = "Valid " + componentType + " at index " + Integer.toString(position) + " has been rejected.";
            assertTrue(errMsg, urlVal.isValid(compStr));
        }

        else {

            errMsg = "Invalid " + componentType + " at index " + Integer.toString(position) + " has been accepted.";
            assertFalse(errMsg, urlVal.isValid(compStr));
        }
    }
}
