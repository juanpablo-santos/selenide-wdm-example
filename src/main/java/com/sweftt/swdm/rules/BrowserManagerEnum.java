package com.sweftt.swdm.rules;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;

public enum BrowserManagerEnum {
    
    CHROME( ChromeDriverManager.getInstance() ),
    FIREFOX( FirefoxDriverManager.getInstance() ),
    EDGE( EdgeDriverManager.getInstance() ),
    IE( InternetExplorerDriverManager.getInstance() ),
    MARIONETTE( FirefoxDriverManager.getInstance() ),
    OPERA( OperaDriverManager.getInstance() ),
    PHANTOMJS( PhantomJsDriverManager.getInstance() );
    
    private final BrowserManager bm;

    private BrowserManagerEnum( final BrowserManager bm ) {
        this.bm = bm;
    }
    
    public BrowserManager getBrowserManager() {
        return bm;
    }

    public WebDriver getDriver() {
        switch( this ) {
        case CHROME: return new ChromeDriver();
        case FIREFOX: return new FirefoxDriver();
        case EDGE: return new EdgeDriver();
        case IE: return new InternetExplorerDriver();
        case MARIONETTE: return new FirefoxDriver();
        case OPERA: return new OperaDriver();
        case PHANTOMJS: return new PhantomJSDriver();
        default: return null;
        }
    }

}
