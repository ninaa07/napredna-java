package view_models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class AddPersonDto {

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private final UUID id;
    private final String name;

    public AddPersonDto(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
