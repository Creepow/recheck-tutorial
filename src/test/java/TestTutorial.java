import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;

public class TestTutorial {
	private WebDriver driver;
	private Recheck re;

	@Before
	public void setUp() {
		re = new RecheckImpl( RecheckOptions.builder().enableReportUpload().build() );
		ChromeOptions options = new ChromeOptions();
		options.addArguments( "--headless", "--window-size=1280,720" );
		driver = new ChromeDriver( options );
	}

	@Test
	public void google() throws Exception {
		re.startTest();

		driver.get( "https://docs.retest.de/" );
		re.check( driver, "open" );
		re.capTest();
	}

	@After
	public void tearDown() {
		driver.quit();
		re.cap();
	}
}
