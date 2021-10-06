package ifc;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SeleniumExecutor {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    public SeleniumExecutor() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    public void start(String filename) {
        String records = this.readFile(filename);
        String[] parts = records.split("\n");
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1280, 1040));
        driver.findElement(By.linkText("Entrar")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("c@c.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector(".btn")).click();
        for (int i = 1; i < parts.length; i++) {
            String[] content = parts[i].split(";");
            String[] tickets = content[6].split("\\|");
            {
                WebElement element = driver.findElement(By.linkText("Meus Anúncios"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }
            {
                WebElement element = driver.findElement(By.tagName("body"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element, 0, 0).perform();
            }
            driver.findElement(By.linkText("Criar Show")).click();
            driver.findElement(By.name("title")).click();
            driver.findElement(By.name("title")).sendKeys(content[0]);
            driver.findElement(By.id("cep")).click();
            driver.findElement(By.id("cep")).sendKeys(content[1]);
            driver.findElement(By.name("description")).click();
            driver.findElement(By.name("description")).sendKeys(content[2]);
            driver.findElement(By.name("thumbnail")).sendKeys(content[3]);
            driver.findElement(By.id("address")).click();
            driver.findElement(By.cssSelector(".row")).click();
            driver.findElement(By.name("start_date")).click();
            driver.findElement(By.name("start_date")).sendKeys(content[4]);
            driver.findElement(By.name("end_date")).click();
            driver.findElement(By.name("end_date")).sendKeys(content[5]);
            for (int x = 0; x < tickets.length; x++) {
                String[] ticketContent = tickets[x].split(",");
                driver.findElement(By.name("desc_ticket")).click();
                driver.findElement(By.name("desc_ticket")).sendKeys(ticketContent[0]);
                driver.findElement(By.name("price_ticket")).click();
                driver.findElement(By.name("price_ticket")).sendKeys(ticketContent[2]);
                driver.findElement(By.name("qtd_ticket")).click();
                driver.findElement(By.name("qtd_ticket")).sendKeys(ticketContent[1]);
                if (x < tickets.length - 1) {
                    driver.findElement(By.id("add-ticket")).click();
                }
            }
            driver.findElement(By.id("send")).click();
            {
                WebElement element = driver.findElement(By.linkText("Criar Show"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }
            driver.findElement(By.linkText("Criar Show")).click();
        }
        driver.quit();
    }

    private String readFile(String filename) {
        StringBuilder result = new StringBuilder();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result.append(data).append("\n");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return result.toString();
    }
}
