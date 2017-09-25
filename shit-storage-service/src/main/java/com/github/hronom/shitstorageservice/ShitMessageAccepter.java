package com.github.hronom.shitstorageservice;

import com.github.hronom.shitstoragecommon.ShitProtoPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;

@EnableBinding(Sink.class)
@MessageEndpoint
public class ShitMessageAccepter {

    private final ShitRepository shitRepository;

    @Autowired
    public ShitMessageAccepter(ShitRepository shitRepository) {
        this.shitRepository = shitRepository;
    }

    @StreamListener(Sink.INPUT)
    public void accept(ShitProtoPojo shit) {
        shitRepository.save(new Shit(shit.getSource(), shit.getText()));
    }
}
