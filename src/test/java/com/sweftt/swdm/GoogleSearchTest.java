package com.sweftt.swdm;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sweftt.swdm.pages.GooglePage;
import com.sweftt.swdm.pages.SearchResultsPage;

import io.github.bonigarcia.wdm.ChromeDriverManager;


/**
 * Unit test for simple App.
 */
public class GoogleSearchTest {
    
    WebDriver driver;
    
    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }
    
    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        setWebDriver( driver );
    }

    // not needed, automatically closed by selenide
    @After
    public void teardown() {
        if( driver != null ) {
            driver.quit();
        }
    }

    @Test
    public void userCanSearch() {
        GooglePage page = open( "http://google.com", GooglePage.class );
        SearchResultsPage results = page.searchFor( "selenide" );
        results.getResults().shouldHave( size( 10 ) );
        results.getResult( 0 ).shouldHave( text( "Selenide: concise UI tests in Java" ) );
    }

}
