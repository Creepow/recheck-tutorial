import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import de.retest.recheck.*;

public class TestTutorial {

	private WebDriver driver;
	private Recheck re;

	@Before
	public void setUp() {
		re = new RecheckImpl();
		driver = new ChromeDriver();
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
