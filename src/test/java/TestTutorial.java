import java.util.prefs.Preferences;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;
import de.retest.recheck.Rehub;
import de.retest.recheck.persistence.CloudPersistence;

public class TestTutorial {
	private WebDriver driver;
	private Recheck re;

	@Before
	public void setUp() {
		re = new RecheckImpl(RecheckOptions.builder().reportUploadEnabled(true).build());

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");

		driver = new ChromeDriver(options);
	}

	@Test
	public void google() throws Exception {
		re.startTest();

		System.out.println(getToken());

		driver.get("http://google.com");
		re.check(driver, "open");
		re.capTest();
	}

	private static String getToken() {
		final String tokenFromEnvironment = System.getenv(CloudPersistence.RECHECK_API_KEY);
		final String tokenFromPreferences = Preferences.userNodeForPackage(Rehub.class)
				.get(CloudPersistence.RECHECK_API_KEY, null);

		return tokenFromEnvironment != null ? tokenFromEnvironment : tokenFromPreferences;
	}

	@After
	public void tearDown() {
		driver.quit();
		re.cap();
	}
}
