package com.github.hronom.shitstorageservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyShitCLR implements CommandLineRunner {

    private final ShitRepository shitRepository;

    @Autowired
    public DummyShitCLR(ShitRepository shitRepository) {
        this.shitRepository = shitRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        shitRepository.save(new Shit("twitter", "A person with a \"Lets work this shit out\" mindset >>>>>"));
        shitRepository.save(new Shit("twitter", "holy crap"));
        shitRepository.save(new Shit("twitter", "What the crap just happened?!"));
        shitRepository.findAll().forEach(System.out::println);
    }
}
