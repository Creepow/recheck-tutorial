import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;

public class TestTutorial {

	private WebDriver driver;
	private Recheck re;

	@Before
	public void setUp() {
		re = new RecheckImpl();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");

		driver = new ChromeDriver(options);
		System.setProperty( de.retest.recheck.Properties.REHUB_REPORT_UPLOAD_ENABLED, "true" );
	}

	@Test
	public void google() throws Exception {
		re.startTest();

		driver.get("http://google.com");
		re.check(driver, "open");

		re.capTest();
	}

	@After
	public void tearDown() {
		driver.quit();
		re.cap();
	}
}
