package com.github.hronom.shitstorageclient;

import com.github.hronom.shitstoragecommon.ShitProtoPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@EnableBinding(Source.class)
@RestController
@RequestMapping("/shits")
public class ShitController {

    private final ShitStorageService shitStorageService;

    @Autowired
    public ShitController(ShitStorageService shitStorageService) {
        this.shitStorageService = shitStorageService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/texts")
    public void addShit(@RequestBody ShitProtoPojo shit) {
        shitStorageService.addShit(shit);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/texts")
    public Collection<String> getShitTexts() {
        return shitStorageService.getShitTexts();
    }
}
