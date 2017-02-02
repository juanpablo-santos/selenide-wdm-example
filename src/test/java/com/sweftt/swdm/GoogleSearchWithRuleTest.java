package com.sweftt.swdm;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import com.sweftt.swdm.pages.GooglePage;
import com.sweftt.swdm.pages.SearchResultsPage;
import com.sweftt.swdm.rules.BrowserManagerEnum;
import com.sweftt.swdm.rules.WebDriverManagerRule;


/**
 * Unit test for simple App.
 */
public class GoogleSearchWithRuleTest {
    
    @ClassRule @Rule
    public static WebDriverManagerRule testRule = new WebDriverManagerRule( BrowserManagerEnum.FIREFOX );
    
    @Test
    public void userCanSearch() {
        GooglePage page = open( "http://google.com", GooglePage.class );
        SearchResultsPage results = page.searchFor( "selenide" );
        results.getResults().shouldHave( size( 10 ) );
        results.getResult( 0 ).shouldHave( text( "Selenide: concise UI tests in Java" ) );
    }

}
