package pojo;

import java.util.List;

public class Rahul_API_Pojo {
    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private String website;
    private String language;
    private List<String> types;
    private Rahul_API_Location_Pojo location;

    public Rahul_API_Location_Pojo getLocation() {
        return location;
    }

    public void setLocation(Rahul_API_Location_Pojo location) {
        this.location = location;
    }
// more objects more pojo class demek o yuzden locationi baska bir pojo clasina yaziyoruz


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
