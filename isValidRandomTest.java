import java.util.concurrent.ThreadLocalRandom;

// https://www.programcreek.com/java-api-examples/index.php?source_dir=gwt-commons-validator-master/src/test/java/org/apache/commons/validator/ResultPair.java
public class ResultPair {
     public String item;
     public boolean valid;

     public ResultPair(String item, boolean valid) {
        this.item = item;
        this.valid = valid;
     }
  }

public void isValidRandomTest() {
    public static final int numOfTests = 5000;
		Random rand = new Random();
		UrlValidator urlVal = new UrlValidator();
		int passedTests = 0;
        int failedTests = 0;


    // took examples from testURLvalidator.java
    ResultPair[] testUrlScheme = {new ResultPair("http://", true),
                                new ResultPair("ftp://", true),
                                new ResultPair("h3t://", true),
                                new ResultPair("3ht://", false),
                                new ResultPair("http:/", false),
                                new ResultPair("http:", false),
                                new ResultPair("http/", false),
                                new ResultPair("://", false),
                                new ResultPair("", true)};

    ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
                                   new ResultPair("go.com", true),
                                   new ResultPair("go.au", true),
                                   new ResultPair("0.0.0.0", true),
                                   new ResultPair("255.255.255.255", true),
                                   new ResultPair("256.256.256.256", false),
                                   new ResultPair("255.com", true),
                                   new ResultPair("1.2.3.4.5", false),
                                   new ResultPair("1.2.3.4.", false),
                                   new ResultPair("1.2.3", false),
                                   new ResultPair(".1.2.3.4", false),
                                   new ResultPair("go.a", false),
                                  new ResultPair("go.a1a", false),
                                   new ResultPair("go.1aa", false),
                                   new ResultPair("aaa.", false),
                                   new ResultPair(".aaa", false),
                                   new ResultPair("aaa", false),
                                   new ResultPair("", false)
    };
    ResultPair[] testUrlPort = {new ResultPair(":80", true),
                              new ResultPair(":65535", true),
                              new ResultPair(":0", true),
                              new ResultPair("", true),
                              new ResultPair(":-1", false),
                             new ResultPair(":65636",false),
                              new ResultPair(":65a", false)
    };
    ResultPair[] testPath = {new ResultPair("/test1", true),
                           new ResultPair("/t123", true),
                           new ResultPair("/$23", true),
                           new ResultPair("/..", false),
                           new ResultPair("/../", false),
                           new ResultPair("/test1/", true),
                           new ResultPair("", true),
                           new ResultPair("/test1/file", true),
                           new ResultPair("/..//file", false),
                           new ResultPair("/test1//file", false)

for (int i = 0; i < numOfTests; i++) {
      boolean expectedResult = true;
			// select a random number that corresponds to a part of the url
			int randomScheme = ThreadLocalRandom.current().nextInt(0, 8 + 1);
			int randomAuthority = ThreadLocalRandom.current().nextInt(0, 17 + 1);
			int randomPort = ThreadLocalRandom.current().nextInt(0, 6 + 1);
			int randomPath = ThreadLocalRandom.current().nextInt(0, 10 + 1);

			// get the corresponding string
			String randomSchemeStr = testUrlScheme[randomScheme];
      if (testUrlScheme[randomScheme].valid == false):
        expectedResult = false;
			String randomAuthString = testUrlAuthority[randomAuthority];
      if (testUrlAuthority[randomAuthority].valid == false):
        expectedResult = false;
			String randomPortStr = testUrlPort[randomPort];
      if (testUrlPort[randomPort].valid == false):
        expectedResult = false;
			String randomPathStr = testPath[randomPath];
      if (testPath[randomPath].valid == false):
        expectedResult = false;


			//build the url
			String url = randUrlScheme + randAuth + randPort + randPath;
			boolean actual = urlVal.isValid(url);
			boolean result = assertTrue(expected, actual);
			if(result == false) {
				failedTests++;
			}
			else {
				passedTests++;
			}
		}
		System.out.println("random test for isValid results are.... ");
		System.out.println("tests passed: " + passedTests);
		System.out.println("tests failed: " + failedTests);
	}
