package com.database.student.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String phoneNumber;
    private String address;
    private String email;
    private Faculty faculty;
}
