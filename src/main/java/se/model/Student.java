package se.model;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String email;
    private String address;
    private static int nId;

    public Student(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = ++nId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, address);
    }

    @Override
    public String toString() {
        return "Student:" +
                "\nstudent id=" + id +
                "\nname='" + name + '\'' +
                "\nemail='" + email + '\'' +
                "\naddress='" + address;
    }
}
