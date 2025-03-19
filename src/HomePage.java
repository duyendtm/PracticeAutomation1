import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static java.awt.SystemColor.window;

public class HomePage {
    WebDriver driver;
    public void ThreeSlider() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\4.ECLIPSE SETUP\\chromedriver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get ("https://practice.automationtesting.in/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement ShopLink = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a"));
        ShopLink.click();
        Thread.sleep(2000);

        WebElement HomeLink = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/nav/a"));
        HomeLink.click();
        Thread.sleep(2000);

        //Kiểm tra Homepage có đúng 3 slider
        List<WebElement> sliders = driver.findElements(By.className("n2-ss-slide-background"));
        if(sliders.size() == 3)
        {
            System.out.println("Home page has Three Sliders only");

        }
        else
        {
            System.out.println("Home page has no Three Sliders only");
        }

        // Kiểm tra Homepage có đúng 3 Arrivals
        List<WebElement> arrivals = driver.findElements(By.className("woocommerce-LoopProduct-link"));
        if(arrivals.size() == 3)
        {
            System.out.println("Home page has Three Arrivals only");
        }
        else
        {
            System.out.println("Home page has no Three Arrivals only");
        }
        // Click vao arrival go to the next page
        WebElement ClickImage = driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]/img"));
        ClickImage.click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000);");

        //Click vao Description tab
        WebElement DescriptionTab = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[3]/ul/li[1]/a"));
        DescriptionTab.click();

        // Kiem tra text mo ta san pham co dung ko
        WebElement textdesc = driver.findElement(By.xpath("//*[@id=\"tab-description\"]/p"));

        String productDesc = textdesc.getText();
        String expectDesc = "The Selenium WebDriver Recipes book is a quick problem-solving guide to automated testing web applications with Selenium WebDriver. It contains hundreds of solutions to real-world problems, with clear explanations and ready-to-run test scripts you can use in your own projects.";

        if (productDesc.equals(expectDesc))
        {
            System.out.println("Text dung");
        }
        else
        {
            System.out.println("Text sai");
        }
        Thread.sleep(5000);

        //Kiem tra tab review co review hay khong
        WebElement ReviewTab = driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[3]/ul/li[2]/a"));
        ReviewTab.click();

        //Kiem tra co review hay khong
        WebElement textreview = driver.findElement(By.xpath("//*[@id=\"comments\"]/p"));
        String productReview = textreview.getText();
        String expectReview = "There are no reviews yet.";
        if(productReview.equals(expectReview))
        {
            System.out.println("There should not be a Reviews regarding that book the user clicked on");
        }
        else
        {
            System.out.println("There should be a Reviews regarding that book the user clicked on");
        }
        Thread.sleep(5000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0, -1000);");
        //Add product to basket
        WebElement AddBasket = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/form/button"));
        AddBasket.click();
        Thread.sleep(2000);

       WebElement ViewBasketButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a"));
       ViewBasketButton.click();
       Thread.sleep(2000);


       WebElement InputCoupon = driver.findElement(By.xpath("//*[@id=\"coupon_code\"]"));
       InputCoupon.sendKeys("krishnasakinala");
       Thread.sleep(2000);

       WebElement ApplyCoupon = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"));
       ApplyCoupon.click();
       Thread.sleep(2000);

       //Remove product trong giỏ hàng
       // WebElement RemoveItem = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[1]/a"));
       // RemoveItem.click();

        // Update số lượng
        WebElement quantity = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"));
        quantity.clear();
        quantity.sendKeys("5");
        Thread.sleep(2000);

        WebElement UpdateBasket = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[2]/td/input[1]"));
        UpdateBasket.click();
        Thread.sleep(2000);

        //Checkout
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0, 1000);");
        Thread.sleep(2000);

        WebElement checkoutButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div/div/a"));
        checkoutButton.click();
        Thread.sleep(2000);

        //Bill details
        WebElement InputFN = driver.findElement(By.id("billing_first_name"));
        InputFN.sendKeys("John");
        Thread.sleep(1000);

        WebElement InputLN = driver.findElement(By.id("billing_last_name"));
        InputLN.sendKeys("Smith");
        Thread.sleep(1000);

        WebElement EmailAddress = driver.findElement(By.id("billing_email"));
        EmailAddress.sendKeys("john.smith1@gmail.com");
        Thread.sleep(1000);

        WebElement PhoneNumber = driver.findElement(By.id("billing_phone"));
        PhoneNumber.sendKeys("+9112345678");
        Thread.sleep(2000);

     //   WebElement SelectCountry = driver.findElement(By.id("select2-drop-mask"));

      //  Select select = new Select(SelectCountry);
       // select.selectByVisibleText("India");

        WebElement StreetAddress = driver.findElement(By.id("billing_address_1"));
        StreetAddress.sendKeys("123 Main Street");
        Thread.sleep(1000);

        WebElement TownCity = driver.findElement(By.id("billing_city"));
        TownCity.sendKeys("New York");
        Thread.sleep(1000);

        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0, 400);");
        Thread.sleep(2000);

        WebElement SelectProvince = driver.findElement(By.id("select2-chosen-2"));
        SelectProvince.click();
        WebElement SearchProvince = driver.findElement(By.id("s2id_autogen2_search"));
        SearchProvince.sendKeys("Bihar");
        SearchProvince.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        WebElement PostalCode = driver.findElement(By.id("billing_postcode"));
        PostalCode.sendKeys("12345");
        Thread.sleep(1000);

        //Click Place order
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0, 1000);");
        Thread.sleep(2000);
        WebElement PlaceOrder = driver.findElement(By.id("place_order"));
        PlaceOrder.click();
        Thread.sleep(2000);

        driver.quit();


    }



}

