package com.example.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class UserRepresentation {
    @NotNull
    @Range(min = 1, max = 99)
    private long id;

    @NotEmpty
    @Length(max = 20)
    private String name;

    public UserRepresentation() {
        // Jackson deserialization
    }

    public UserRepresentation(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }
}
