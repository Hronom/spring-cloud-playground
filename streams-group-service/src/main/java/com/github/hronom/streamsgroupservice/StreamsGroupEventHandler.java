package com.github.hronom.streamsgroupservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(StreamsGroup.class)
public class StreamsGroupEventHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StreamsGroupRepository streamsGroupRepository;

    @HandleAfterCreate
    public void handleAfterCreate(StreamsGroup user) {
        logger.info("Handle after create");
    }

    @HandleAfterSave
    public void handleAfterSave(StreamsGroup user) {
        logger.info("Handle after save");
    }

    @HandleAfterDelete
    public void handleAfterDelete(StreamsGroup user) throws Exception {
        logger.info("Handle after delete");
    }
}
