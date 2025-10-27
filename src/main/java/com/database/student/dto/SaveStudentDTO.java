package com.database.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveStudentDTO {

    private String series;
    private String number;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String birthPlace;
    private String phoneNumber;
    private String address;
    private String email;
    private String facultyName;
}
