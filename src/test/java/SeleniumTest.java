import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	@Test
	public void test() {
		final WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait( 3, TimeUnit.MICROSECONDS );
		driver.get( "https://www.surveymonkey.com/r/L9DJGXR" );

		final WebElement acceptButton = driver.findElement( By.id( "234136539_1601280849" ) );
		acceptButton.click();
	}

	@Test
	public void test2() throws MalformedURLException {
		final WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait( 3, TimeUnit.MICROSECONDS );
		driver.get( Paths.get( "src/test/resources/Site.html" ).toUri().toURL().toString() );

		final WebDriverWait wait = new WebDriverWait( driver, 3 );
		final boolean invisible = wait.until( ExpectedConditions.invisibilityOfElementLocated( By.id( "over" ) ) );
		if ( invisible ) {
			final WebElement searchButton =
					wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "under" ) ) );
			searchButton.click();
		}
	}

	@Test
	public void click_overlapping_elements_should_work() throws MalformedURLException {
		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		final WebDriver driver = new ChromeDriver();
		//		Actions action = new Actions( driver );
		driver.get( Paths.get( "src/test/resources/Site.html" ).toUri().toURL().toString() );
		final WebElement element = driver.findElement( By.id( "under" ) );
		//		js.executeScript( "arguments[0].click();", element );
		//		if ( WebDriverUtils.isClickable( element, driver ) ) {
		//					action.moveToElement( element ).click().perform();
		element.click();
		//		}
	}

	@Test
	public void switchWindowsTest() throws InterruptedException {
		final WebDriver driver = new ChromeDriver();
		driver.get( "https://retest.de/" );
		driver.manage().window().maximize();

		final Set<String> windowHandlesBeforeAction = driver.getWindowHandles();
		System.out.println( driver.findElements( By.tagName( "iframe" ) ).toString() );

		final String openLinkInNewTab = Keys.chord( Keys.CONTROL, Keys.RETURN );
		driver.findElement( By.linkText( "Pricing" ) ).sendKeys( openLinkInNewTab );

		Thread.sleep( 5000 );

		driver.switchTo().frame( 0 );
		//		switchToNewWindowIfNeeded( windowHandlesBeforeAction, driver );
	}

	private void switchToNewWindowIfNeeded( final Set<String> windowHandlesBeforeAction, final WebDriver driver ) {
		final Set<String> windowHandlesAfterAction = driver.getWindowHandles();
		windowHandlesAfterAction.stream() //
				.filter( afterWindowHandle -> !windowHandlesBeforeAction.contains( afterWindowHandle ) ) //
				.findAny() //
				.ifPresent( newWindowHandle -> {
					driver.switchTo().window( newWindowHandle );
				} );
	}
}
