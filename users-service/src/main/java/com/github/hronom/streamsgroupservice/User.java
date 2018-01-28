package com.github.hronom.streamsgroupservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class User {
    @Id
    public String id;

    public String username;
    public String password;

    public String email;

    public String firstName;
    public String lastName;

    @Version
    public Long version;
    @LastModifiedDate
    public Date date;
}
