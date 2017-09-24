package com.github.hronom.shitstorageclient;

import com.github.hronom.shitstoragecommon.ShitProtoPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

@EnableBinding(Source.class)
@RestController
@RequestMapping("/shits")
public class ShitController {

    private final RestTemplate restTemplate;
    private final MessageChannel messageChannel;

    @Autowired
    public ShitController(
        RestTemplate restTemplate, @Output(Source.OUTPUT) MessageChannel messageChannel
    ) {
        this.restTemplate = restTemplate;
        this.messageChannel = messageChannel;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/texts")
    public void addShit(@RequestBody ShitProtoPojo shit) {
        messageChannel.send(MessageBuilder.withPayload(shit).build());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/texts")
    public Collection<String> getShitTexts() {
        ParameterizedTypeReference<Resources<Shit>> ptr =
            new ParameterizedTypeReference<Resources<Shit>>() {};
        ResponseEntity<Resources<Shit>> exchange =
            restTemplate
                .exchange("http://shit-storage-service/shits", HttpMethod.GET, null, ptr);
        return exchange
            .getBody()
            .getContent()
            .stream()
            .map(Shit::getText)
            .collect(Collectors.toList());
    }

    public static class Shit {
        private Long id;

        private String source;
        private String text;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
