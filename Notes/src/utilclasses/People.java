package utilclasses;

import java.util.ArrayList;
import java.util.List;

public class People {

    private List<Person> people;

    public People() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public People instantiatePeople() {
        this.people.add(new Person("Daniel", 31, "male"));
        this.people.add(new Person("Alice", 25, "female"));
        this.people.add(new Person("Bob", 39, "male"));
        this.people.add(new Person("Eva", 35, "female"));
        this.people.add(new Person("David", 29, "male"));
        this.people.add(new Person("Sophia", 38, "female"));
        this.people.add(new Person("John", 47, "male"));
        this.people.add(new Person("Chloe", 22, "female"));
        this.people.add(new Person("Michael", 33, "male"));
        this.people.add(new Person("Emma", 22, "female"));
        this.people.add(new Person("William", 40, "male"));
        this.people.add(new Person("Ava", 31, "female"));
        this.people.add(new Person("James", 26, "male"));
        this.people.add(new Person("Grace", 44, "female"));
        this.people.add(new Person("Liam", 26, "male"));
        this.people.add(new Person("Chloe", 30, "female"));
        this.people.add(new Person("Henry", 39, "male"));
        this.people.add(new Person("Mia", 27, "female"));
        this.people.add(new Person("Daniel", 39, "male"));
        this.people.add(new Person("Sophie", 32, "female"));
        return this;
    }
    public List<Person> getPeople() {
        return people;
    }

}
