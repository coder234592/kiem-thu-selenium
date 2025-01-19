package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class WebTest {
    WebDriver driver;
    String linkOnline = "https://kiem-thu-selenium.glitch.me";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(linkOnline);
    }

    @Test(priority = 1)
    public void testInvalidLogin() {
        // Điền thông tin đăng nhập sai
        driver.findElement(By.id("username")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        // Xác minh thông báo lỗi xuất hiện
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        Assert.assertTrue(errorMessage.getText().contains("Invalid username or password. Please try again."));
    }

    @Test(priority = 2)
    public void testValidLogin() {
        // Xóa trắng thông tin đăng nhập trước khi nhập tài khoản hợp lệ
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.clear();  // Xóa trường username
        passwordField.clear();  // Xóa trường password

        // Điền thông tin đăng nhập hợp lệ
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        // Xác minh người dùng được chuyển đến trang chính
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(linkOnline + "/search.html"));
    }

    @Test(priority = 3)
    public void testSearchValidProduct() {
        WebElement searchBox = driver.findElement(By.id("search"));
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        searchBox.sendKeys("Laptop");  // Tìm kiếm sản phẩm Laptop
        searchButton.click();

        // Kiểm tra sản phẩm "Laptop" có hiển thị không
        WebElement productList = driver.findElement(By.id("product-list"));
        Assert.assertTrue(productList.getText().contains("Laptop"), "Product list does not contain Laptop.");
    }

    @Test(priority = 4)
    public void testSearchInvalidProduct() {
        WebElement searchBox = driver.findElement(By.id("search"));
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));

        searchBox.sendKeys("NonExistentProduct");  // Tìm kiếm sản phẩm không tồn tại
        searchButton.click();

        // Kiểm tra xem không có sản phẩm nào hiển thị
        WebElement productList = driver.findElement(By.id("product-list"));
        Assert.assertTrue(productList.getText().isEmpty(), "Product list should be empty.");
    }

    @Test(priority = 5)
    public void testLogout() {
        // Nhấn nút Logout
        WebElement logoutButton = driver.findElement(By.xpath("//button[text()='Logout']"));
        logoutButton.click();

        // Kiểm tra người dùng đã quay lại trang đăng nhập (login.html)
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(linkOnline), "User should be redirected to login page.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // Main method để chạy các bài kiểm thử theo thứ tự mong muốn
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testNG = new TestNG();

        // Chạy các bài kiểm thử trong lớp WebTest
        testNG.setTestClasses(new Class[] { WebTest.class });

        // Thêm listener để theo dõi kết quả kiểm thử
        testNG.addListener(new TestResultListener());  // Thêm listener vào đây

        // Bắt đầu thực hiện kiểm thử
        testNG.run();

        // In báo cáo kết quả
        System.out.println("Kết quả kiểm thử đã được ghi ra console.");
    }
}
