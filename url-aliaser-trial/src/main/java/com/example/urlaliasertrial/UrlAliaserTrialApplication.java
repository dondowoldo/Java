package com.example.urlaliasertrial;

import com.example.urlaliasertrial.model.Alias;
import com.example.urlaliasertrial.model.Link;
import com.example.urlaliasertrial.repository.AliasRepository;
import com.example.urlaliasertrial.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UrlAliaserTrialApplication implements CommandLineRunner {

	private LinkRepository links;
	private AliasRepository aliases;

	public UrlAliaserTrialApplication(LinkRepository links, AliasRepository aliases) {
		this.links = links;
		this.aliases = aliases;
	}

	public static void main(String[] args) {
		SpringApplication.run(UrlAliaserTrialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Link link = new Link("https://www.greenfoxacademy.cz");
		Alias alias = new Alias("gfa", link);
		Alias alias2 = new Alias("foxxx", link);

		link.getAliases().add(alias);
		link.getAliases().add(alias2);

		links.save(link);

	}
}
