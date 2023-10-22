package utilclasses;

public class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void greet() {
        System.out.printf("Hello, my name is %s, and I am %d years old %s.",
                this.name, this.age, this.gender);
    }

    @Override
    public String toString() {
        return String.format("[%s-%d-%s]",
                this.name, this.age, this.gender);
    }
}
