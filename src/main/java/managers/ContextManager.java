package managers;

import cucumber.TestContext;

public class ContextManager {
	private static ThreadLocal<TestContext> testContext = new ThreadLocal<TestContext>();
	
	public static void initializeTestContext()
	{
		TestContext testContextInstance = new TestContext();
		testContext.set(testContextInstance);
	}
	
	public static TestContext getTestContext() {
		return testContext.get();
	}
}
