package com.github.hronom.streamsgroupservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class StreamsGroup {
    @Id
    public String id;

    @Indexed
    public String userId;
    public String description;

    @Version
    public Long version;
    @LastModifiedDate
    public Date date;
}
