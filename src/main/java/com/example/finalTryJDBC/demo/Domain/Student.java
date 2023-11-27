package com.example.finalTryJDBC.demo.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
}
