package examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import payload.GoRestPayloads;
import util.ConfigReader;
import util.TestUtil;

public class GoRestAPIDataProviderTest extends TestUtil {
    @Test(dataProvider="getUsers")
    public void createMultipleUsers(String name, String email, String status, String gender){
        createRequest().body(GoRestPayloads.createMultipleUserPayload(name, email, status, gender));
        executeAPI("POST", ConfigReader.getProperty("postPathParameter"));
        responseSpecification(200);
        getResponse();
    }
    @DataProvider
    public Object[][] getUsers() {
        Object[][] data = {{"Halim sami", "halim@gmail.com","Male","Active"},
                {"Melim selim", "melim@gmail.com","Male","Inactive"},
                {"Hande Melih", "malim@gmail.com","Female","Active"},
                {"Ceren Melih", "ceren@gmail.com","Female","Active"},
                {"Guzin Melih", "guzin@gmail.com","Female","Active"}};
            return data;
    }
    }
