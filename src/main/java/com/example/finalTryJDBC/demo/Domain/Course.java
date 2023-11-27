package com.example.finalTryJDBC.demo.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    private int courseId;
    private String link;
    private String description;
    private String title;


}
