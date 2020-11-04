package Kitabisa_SeleniumTestNG.Kitabisa_SeleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Pembayaran {
	public String baseUrl = "https://kitabisa.com";
	String drivePath = "C:\\Users\\Imam Setya Utama\\Desktop\\chromedriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", drivePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	@Test(priority = 1)
	
	public void selectCampaign() throws InterruptedException{
		WebElement selectCampaign;
		selectCampaign = driver.findElement(By.xpath("//div[@id='template_horizontal-portrait-card-slider']/div[2]/div[1]/a[2]/div[1]/div[1]/div[1]"));
		selectCampaign.click();
		Thread.sleep(3000);
		WebElement btnDonasi;
		btnDonasi = driver.findElement(By.xpath("//button[@id='campaign-detail_button_donasi-sekarang']"));
		btnDonasi.click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void inputPembayaran() throws InterruptedException{
		WebElement selectNominal;
		selectNominal = driver.findElement(By.xpath("//main[@id='donation-amount']/div[2]"));
		selectNominal.click();
		Thread.sleep(3000);
		WebElement selectMetode;
		selectMetode = driver.findElement(By.xpath("//*[(text() = 'BCA Virtual Account' or . = 'BCA Virtual Account')]"));
		selectMetode.click();
		Thread.sleep(3000);
		WebElement InputFullname;
		InputFullname = driver.findElement(By.name("fullname"));
		InputFullname.sendKeys("RiskhaPutri");
		Thread.sleep(3000);
		WebElement inputEmail;
		inputEmail = driver.findElement(By.name("username"));
		inputEmail.sendKeys("riskahputri@gmail.com");
		Thread.sleep(3000);
		WebElement btnLanjut;
		btnLanjut = driver.findElement(By.xpath("//button[@id='contribute_button_lanjutkan-pembayaran']"));
		btnLanjut.click();
	}
	
	@Test(priority = 3)
	public void closeBack() throws InterruptedException {
		WebElement banner;
		banner = driver.findElement(By.xpath("//main[@id='summary-page']/div[8]/a[2]/img"));
		boolean flag = banner.isEnabled();
		System.out.println("Banner is Enabled");
		Assert.assertTrue(flag);
		Thread.sleep(3000);
		WebElement closeBanner;
		closeBanner = driver.findElement(By.xpath("//main[@id='summary-page']/div[8]/a/span"));
		closeBanner.click();
		Thread.sleep(3000);
		WebElement btn_kembali;
		btn_kembali=driver.findElement(By.xpath("//main[@id='summary-page']/div[6]/div[3]/button"));
		btn_kembali.click();
		Thread.sleep(3000);
		WebElement backArrow;
		backArrow = driver.findElement(By.xpath("//body/div[@id='__next']/main[@id='campaign-page']/div[1]/div[1]/div[1]/*[1]"));
		backArrow.click();
		Thread.sleep(3000);
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
	
	
	
}
