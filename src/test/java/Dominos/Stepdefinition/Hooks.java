//package Dominos.Stepdefinition;
//
//import Dominos.base.Base_Class;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//
//import java.util.ArrayList;
//
//public class Hooks {
//    Base_Class base= new Base_Class();
//
//
//
//    public ArrayList<String> browserTypes()
//    {
//        ArrayList<String> browserTypes=null;
//        try {
//            browserTypes = new ArrayList<String>();
//            browserTypes.add("chrome");
//            browserTypes.add("firefox");
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        return browserTypes;
//    }
//
//    @Before
//    @Parameters({"browser"})
//    public void launchBrowser(String browser)
//    {
//        try
//        {
//            /*
//            ArrayList<String> browsers= browserTypes();
//
//            for(String eachBrowser:browsers)
//            {
//                Base_Class.driver=base.initDrivers(eachBrowser);
//
//            }
//            */
////            Base_Class.driver=base.initDrivers(browser);
//
//
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }
//
//    @After
//    public void closeBrowser()
//    {
//       Base_Class.driver.quit();
//    }
//
//
////    @Before //Cucumber Before Hook
////    public static void setupDriver() throws InterruptedException {
////
////        /*
////         * System.setProperty("webdriver.chrome.driver",
////         * "C:\\Users\\ARUNKUMAR\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe"
////         * ); ChromeOptions opt = new ChromeOptions();
////         * opt.addArguments("--remote-allow-origins=*"); driver = new ChromeDriver(opt);
////         * driver.manage().window().maximize();
////         */		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
////
////        System.out.println("Cross Browser Testing");
////    }
////
////    @After // Cucumber After hook
////    public static void quitDriver() throws Exception {
////        driver.quit();
////    }
//
//
//
//}
