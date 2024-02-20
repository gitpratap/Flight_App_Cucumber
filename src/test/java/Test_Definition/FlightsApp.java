package Test_Definition;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightsApp 
{
	
	WebDriver driver = new ChromeDriver();
	
	
	@Given("i open browser with url {string}")
	public void i_open_browser_with_url(String url) 
	{
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@When("i click on register link")
	public void i_click_on_register_link() {
	    driver.findElement(By.linkText("Register")).click();
		
	}
	@Then("i should see the register module")
	public void i_should_see_the_register_module() {
	    if (driver.findElement(By.name("submit")).isDisplayed()) {
			System.out.println("Reegister displayed");
		}
	}
	@Then("i enter valid inputs {string} and {string} and {string} and {string}")
	public void i_enter_valid_inputs_and_and_and(String name, String number, String mail, String password) 
	{
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("contact")).sendKeys(number);
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("address")).sendKeys(password);
		Select gender = new Select(driver.findElement(By.name("gender")));
		gender.selectByVisibleText("Male");
		
	}
	@Then("i enter the date {string}")
	public void i_enter_the_date(String date) 
	{
		driver.findElement(By.id("popupDatepicker")).click();
		Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
		month.selectByVisibleText("Jan");
		Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
		year.selectByVisibleText("2023");
		WebElement flycal=driver.findElement(By.className("ui-datepicker-calendar")); 
		List<WebElement> tbrow=flycal.findElements(By.tagName("tr"));
		for(int i=1;i<tbrow.size();i++) {
			List<WebElement> tbcol=tbrow.get(i).findElements(By.tagName("td"));
			for(WebElement element: tbcol) {
				if (element.getText().equals(date)) 
				{
					element.click();
					System.out.println("pass");
					break;		
				}
			}
			
		}
		
	}
	@Then("i click on Register button")
	public void i_click_on_register_button() 
	{
		driver.findElement(By.id("flexCheckChecked")).click();
		driver.findElement(By.name("submit")).click();
	}
	@Then("i should see the login page")
	public void i_should_see_the_login_page() 
	{
	  if (driver.findElement(By.partialLinkText("I forgot")).isDisplayed()) {
		
		  System.out.println("Login page displayed");
	}
	}
	@When("i entered username {string}")
	public void i_entered_username(String mail_id)
	{
	    driver.findElement(By.name("email")).sendKeys(mail_id);
		
	}
	@When("i entered password {string}")
	public void i_entered_password(String password) 
	{
		driver.findElement(By.name("password")).sendKeys(password);
	    
	}
	@When("i click sign in")
	public void i_click_sign_in() 
	{
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("i should see the flightbookig link")
	public void i_should_see_the_flightbookig_link()
	{
	    if (driver.findElement(By.linkText("Flight Bookings")).isDisplayed()) {
			
	    	System.out.println("Login sucessfully");
		}    
	}
	
	@When("i entered th valid date {string}")
	public void i_entered_th_valid_date(String date) 
	{
	    driver.findElement(By.id("search-date")).click();
	   String temp[]= date.split("-");
	   String dt=temp[0];
	   String month=temp[1];
	   String year = temp[2]; 
	  String calyr =driver.findElement(By.className("ui-datepicker-year")).getText();
	  while (!calyr.equals(year)) 
	  {
		driver.findElement(By.linkText("Next")).click();
		calyr = driver.findElement(By.className("ui-datepicker-year")).getText();
	}
	  String calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
	  while (!calmonth.equals(month))
	  {
		  driver.findElement(By.linkText("Next")).click();
		  calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
	  }
	  WebElement caltbl =driver.findElement(By.className("ui-datepicker-calendar"));
			  List<WebElement> caltbrow=caltbl.findElements(By.tagName("tr"));
	   for(int i=1;i<caltbrow.size();i++)
	   {
		List<WebElement> caltbcol=caltbrow.get(i).findElements(By.tagName("td"));
		for(WebElement element2: caltbcol) 
		{
			if (element2.getText().equals(dt)) 
			{
				element2.click();
				break;
			}
		}
	   }   
	}
	
	@When("i click on flightlink {string}")
	public void i_click_on_flightlink(String flights) throws InterruptedException {
	    
		Select fromdate = new Select(driver.findElement(By.xpath("//div[2]/div[1]/div/div/div[2]/select")));
		fromdate.selectByVisibleText("Chennai");
		Select todate = new Select(driver.findElement(By.xpath("//div[2]/div[1]/div/div/div[3]/select")));
		todate.selectByVisibleText("Kolkatha");
		driver.findElement(By.xpath("//div[2]/div[1]/div/div/div[4]/button")).click();
		Thread.sleep(2000);
		WebElement flight_tbl=driver.findElement(By.className("flights_table"));
		   List<WebElement> flyrow =flight_tbl.findElements(By.tagName("tr"));
		   for(int i=1;i<flyrow.size();i++) {
			   List<WebElement> flycol =flyrow.get(i).findElements(By.tagName("td"));
			   for(WebElement element3: flycol) {
				   if (element3.getText().contains("Prasad Airlines"))
				   {
					  // Thread.sleep(2000);
					 //  element3.click();
					   driver.findElement(By.xpath("//button[@data-id='8']")).click();
					   break;	
				   }
			   }  
		   }
	}
	
	@When("i click pn search flight {string}")
	public void i_click_pn_search_flight(String psngrname) throws InterruptedException {
	    driver.findElement(By.id("name")).sendKeys(psngrname);
		Thread.sleep(2000);
	}
	@When("i entered name and class detail")
	public void i_entered_name_and_class_detail() {
		
		driver.findElement(By.xpath("//input[@value= 'Business']")).click();
	    
	}
	@When("i click on insertorder botton")
	public void i_click_on_insertorder_botton() {
		driver.findElement(By.xpath("//div/div[4]/div/button")).click();
		driver.findElement(By.linkText("View Ticket")).click();
		String odrid=driver.findElement(By.xpath("//div[1]/div/div/div/div[2]/div[1]")).getText();
		System.out.println(odrid);
		String bookid=odrid.substring(8);
		System.out.println(bookid);
		driver.navigate().back();
		driver.findElement(By.linkText("Flight Bookings")).click();
		WebElement book_tbl_ele=driver.findElement(By.className("flights_table"));
		List<WebElement> book_tbl_row=book_tbl_ele.findElements(By.tagName("tr"));
		for(int i=1;i<book_tbl_row.size();i++) {
			
			List<WebElement> book_tbl_col=book_tbl_row.get(i).findElements(By.tagName("td"));
			for(WebElement bookelement: book_tbl_col) {
				if (bookelement.getText().contains(bookid)) {
					System.out.println("Test pass"+bookid);
					break;
				}else {
					System.out.println("fail"+bookid);
					break;

				}
				
			}
		}
		
	
//		for (int i = 0; i < 3; i++) {
//			
//			int ss = Integer.parseInt("i");
//			
//			driver.findElement(By.xpath("//ul[@class='pagination']//li//a['"+i+"']")).click();
//		}
//		
//	}
	}
	
	@When("i entered username as {string}")
	public void i_entered_username_as(String usrid) 
	{
		driver.findElement(By.name("email")).sendKeys(usrid);
	    
	}
	

@When("i entered password as {string}")
public void i_entered_password_as(String uspwd) 
{
	driver.findElement(By.name("password")).sendKeys(uspwd);  
}

	
@Then("i should see the error message {string}")
public void i_should_see_the_error_message(String msgerr) 
	{
		String ermsg=driver.findElement(By.xpath("//div/div[2]/div/div[1]")).getText();
		if (ermsg.contains(msgerr)) 
		{
			
			System.out.println("Test pass"+ ermsg);
			
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
