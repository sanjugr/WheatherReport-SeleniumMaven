package test.testProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.testProject.App;

/**
 * Unit test for simple App.
 */
public class AppTest extends App {
	
	@BeforeMethod
	public void beforeMethod() {
		 driver = new ChromeDriver();
	}
	
	@Test
	public void testTemperature(){
        log(" \n TEST 1 ---- Test If Temperature is Greater than 15 C ---------");
        Constants constants = new Constants();
        initTest();
        waitTillWebElementIsDisplayed(constants.currentLocationTemperature,10);
        if(isElementDisplayed(currentLocationTemperature)){
         String temp = driver.findElement(By.cssSelector(currentLocationTemperature)).getText();
         int temperature =Integer.parseInt(temp.substring(0,2));
         if (temperature>15){
            log("Test Passed : Temperature Displayed is = "+ temperature + "C");
            }
            else{
             log("Test Failed : Temperature Displayed =" + temperature + " C");
            }
        }
         else
        {
         log("Test Failed - Temperature is not displayed");
        }
        driver.close();
    }

	@Test
    public void openWeatherNews(){
        log(" \n TEST 2 ---- Test open See All news under weather news ---------");
        Constants constants = new Constants();
        initTest();
        waitTillWebElementIsDisplayed(constants.currentLocationTemperature,10);
        scrollIntoView(constants.seeAllNewsButton);
        driver.findElement(By.cssSelector(constants.seeAllNewsButton)).click();
        waitTillWebElementIsClickable(constants.latestButton,20);
        if(isElementDisplayed(constants.latestButton))
            log("Test Passed- Navigated Successfully to See All news Page ");
        else
            log("Test Failed- Navigated Failed to See All news Page ");
        driver.close();
    }

	@Test
    public void testLatestIsUnderlined(){
        log(" \n TEST 3 ---- Test if latest button is underlined or not ---------");
        Constants constants = new Constants();
        initTest();
        waitTillWebElementIsDisplayed(constants.currentLocationTemperature,10);
        scrollIntoView(constants.seeAllNewsButton);
        driver.findElement(By.cssSelector(constants.seeAllNewsButton)).click();
        waitTillWebElementIsClickable(constants.latestButton,10);
        if(isElementDisplayed(constants.latestButton)){
            log(" Navigated Successfully to See All news Page ");
            checkIfElementIsUnderlined(constants.latestButton);
            checkIfElementIsUnderlined(constants.weatherButton); // Double checking if another element is not underlined or not
        }
        else
            log("Navigation Failed to See All news Page ");

        driver.close();
    }
    
}
