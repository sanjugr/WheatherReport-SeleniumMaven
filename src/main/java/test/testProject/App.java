package test.testProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App extends Constants 
{
	 
	WebDriver driver;
	

    public void initTest(){
        driver.get(buildLink);
        driver.manage().window().maximize() ;
    }

    public boolean isElementDisplayed(String elementCssSelector){
        if(driver.findElements(By.cssSelector(elementCssSelector)).size()>0)
            return true;
        else
            return false;
    }

    public void waitTillWebElementIsDisplayed(String locator, int waitTIme){
        WebDriverWait wait = new WebDriverWait(driver, waitTIme);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(locator))));
    }

    public void waitTillWebElementIsClickable(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
    }

    public void scrollIntoView(String Locator){
        WebElement element = driver.findElement(By.cssSelector(Locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void wait(int TimeOut){
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
    }

    public void log(String message){
        System.out.println(message);
    }

    public void checkIfElementIsUnderlined(String locator){
        if(driver.findElements(By.cssSelector(".active "+locator)).size()>0){
            log("Test Passed : The Element "+ locator + " is active and underlined");
        }
        else
        {log("Test Failed : The Element "+ locator + " is  Not active and Not underlined");}
    }
    
   
}
