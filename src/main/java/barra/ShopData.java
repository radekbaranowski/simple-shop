package barra;

public class ShopData {

    String usedNames;
    String username;
    String email;
    int age;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
        usedNames+=username+" ";
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public String getUsedNames() {
        return usedNames;
    }
    public void setUsedNames(String newnames) {
        this.usedNames = newnames;
    }

    public ShopData() {
        super();
        usedNames="";
    }

}
