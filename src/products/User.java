package products;

public class User extends BaseModel {
    private String idNumber;
    private String name;
    private String email;
    private String password;

    public User(String isNumber, String name, String email, String password) {
        this.idNumber = isNumber;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Long getId(){
        return this.id;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
