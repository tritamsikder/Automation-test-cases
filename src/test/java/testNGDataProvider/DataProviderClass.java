package testNGDataProvider;

//import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

//import net.bytebuddy.asm.Advice.Return;

public class DataProviderClass {

  @DataProvider (name = "dp", indices = {3,4})
  public Object[][] loginData() {
    Object data[][] = {
    		
    		{"abc","test123"},
    		{"abd","test023"},
    		{"test","test123"},
    		{"abc","test123"},
    		{"Admin","admin123"},
    		
                       };
    return data;
    }
  }

