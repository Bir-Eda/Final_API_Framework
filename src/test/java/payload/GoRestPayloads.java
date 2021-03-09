package payload;

import org.testng.annotations.DataProvider;
import pojo.NewUserPojo;

public class GoRestPayloads {
    public static String createUserPayload(){
        return  "{\"name\":\"Hande Yildirim\",\n" +
                "\"gender\":\"Female\", \n" +
                "\"email\":\"hande@gmail.com\",\n" +
                "\"status\":\"Active\"\n" +
                "}";
    }
    public static String updateUserPayload(){
        return  "{\"name\":\"Serkan Yildirim\",\n" +
                "\"gender\":\"Male\", \n" +
                "\"email\":\"serkan@gmail.com\",\n" +
                "\"status\":\"Active\"\n" +
                "}";
    }

    public static NewUserPojo createUserPayload2(){
        NewUserPojo user=new NewUserPojo();
        user.setGender("Male");
        user.setName("Husnu");
        user.setEmail("husnu@gmail.com");
        user.setStatus("Active");
        return user;
        // buradan  GoRestAPI_Ilkhali ne gidiyoruz

    }
    public static NewUserPojo createMultipleUserPayload(String name, String email, String gender, String status){
        NewUserPojo user=new NewUserPojo();
        user.setName(name);
        user.setEmail(email);
        user.setGender(gender);
        user.setStatus(status);
        return user;
        // buradan  GoRestAPI_Ilkhali ne gidiyoruz

    }
    @DataProvider
    public Object[][] getUser(){
       Object [][] data={{"Chen U", "chen@gmail.com", "Active", "Male"}, {"Tamara", "t@gmail.com", "Acvite", "Female"}, {"Sena", "s@gmail.com", "Active", "Female"}};
        return data;
    }
}


















// we can create object
// we can do extention
//
