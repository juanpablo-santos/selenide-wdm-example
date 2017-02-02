package com.sweftt.swdm.rules;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;


public class WebDriverManagerRule implements TestRule {
	
	private final BrowserManagerEnum browser;
	private WebDriver driver = null;
	
	/**
	 * Rule constructor.
	 * 
	 * @param browser see {@link BrowserManagerEnum} for available values.
	 */
	public WebDriverManagerRule( BrowserManagerEnum browser ) {
		this.browser = browser;
	}

	/** {@inheritDoc} */
	@Override
	public Statement apply( Statement base, Description description ) {
		return statement( base );
	}
	
	Statement statement( final Statement base ) {
        return new Statement() {
        	
        	/** {@inheritDoc} */
            @Override
            public void evaluate() throws Throwable {
            	if( driver == null ) {
            		beforeClass();
            		base.evaluate();
            		afterClass();
            	} else {
            		before();
                    try {
                        base.evaluate();
                    } finally {
                        after();
                    }
            	}
            }
        };
    }

    protected void beforeClass() throws Throwable {
    	browser.getBrowserManager().setup();
    	driver = browser.getDriver();
    }

    protected void afterClass() throws Throwable {
    }

    protected void before() throws Throwable {
    	setWebDriver( driver );
    }

    protected void after() {
    	driver.quit();
    }

}
