package com.user.profile.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private String email;
    private String name;
    private String lastName;
    private Integer age;
    private String country;
    private List<String> products;

    public String getCountry() {
        return country;
    }

    public List<String> getProducts() {
        return products;
    }
}