package ua.samoplavskaya.hw_patterns.Deep_copy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Address {
    private String city;
    private String street;
    private String building;
}
