package se.lexicon;

public class Student {
    private int id;
    private String name;
    private String email;
    private String address;

    public Student(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
        ++this.id;
    }

    public int getId(){
        return id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
