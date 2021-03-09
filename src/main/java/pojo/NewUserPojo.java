package pojo;

public class NewUserPojo {
    private String name;
    private String email;
    private String status;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}

// burayi create ettikten sonra createpayloads clasina gidiyoruz
// durin serilization we are gonna use get methods ? tekrar dinle videoyu. api 4. video