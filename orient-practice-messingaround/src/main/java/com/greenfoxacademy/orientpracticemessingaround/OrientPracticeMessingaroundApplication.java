package com.greenfoxacademy.orientpracticemessingaround;

import com.greenfoxacademy.orientpracticemessingaround.model.Human;
import com.greenfoxacademy.orientpracticemessingaround.model.Pet;
import com.greenfoxacademy.orientpracticemessingaround.repository.HumanRepository;
import com.greenfoxacademy.orientpracticemessingaround.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrientPracticeMessingaroundApplication implements CommandLineRunner {

	private HumanRepository people;
	private PetRepository pets;

	public OrientPracticeMessingaroundApplication(HumanRepository people, PetRepository pets) {
		this.people = people;
		this.pets = pets;
	}

	public static void main(String[] args) {
		SpringApplication.run(OrientPracticeMessingaroundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Human human = new Human("Dan");
		Human human2 = new Human("Jan");
		Pet pet = new Pet("Omiš", "Cat");
		Pet pet2 = new Pet("Bax", "Dog");
		Pet pet3 = new Pet("Mike", "Dog");
		Pet pet4 = new Pet("Theo", "Cat");

		people.save(human);
		people.save(human2);
		pets.save(pet);
		pets.save(pet2);
		pets.save(pet3);
		pets.save(pet4);
	}
}
