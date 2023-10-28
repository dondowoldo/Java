package com.greenfoxacademy.springbootpractice;

public class Person {
    private static int currentId;
    private String name;
    private Integer age;
    private String gender;
    private int id;

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = currentId++;
    }

    public Person() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static int incrementID() {
        return currentId++;
    }
}
