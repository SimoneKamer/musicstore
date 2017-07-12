import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleSearcherChrome {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\s_kam\\Documents\\Cursus Marco\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("cucumber\n"); // send also a "\n"
        element.submit();

        // wait until the google page shows the result
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

        List<WebElement> foundElements = driver.findElements(By.className("_Rm"));
        for (int i=0; i<3; i++){
            String resultAddress = foundElements.get(i).getText();
            int resultNumber = i + 1;
            System.out.println("RESULTAAT" + resultNumber + ": " + resultAddress);
        }
        driver.close();
    }
}