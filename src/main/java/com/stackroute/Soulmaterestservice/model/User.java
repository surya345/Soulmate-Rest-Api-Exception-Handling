package com.stackroute.Soulmaterestservice.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="FIRST_NAME")
    private String Firstname;
    @Column(name="LAST_NAME")
    private  String Lastname;
    @Column(name="AGE")
    private int age;
    @Column(name="GENDER")
    private String Gender;

    public User() {
    }

    public User(int id, String firstname, String lastname, int age, String gender) {
        this.id = id;
        Firstname = firstname;
        Lastname = lastname;
        this.age = age;
        Gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", age=" + age +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
