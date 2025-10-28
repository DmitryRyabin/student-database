package com.database.student.service;

import com.database.student.model.Faculty;

import java.time.LocalDate;

public interface StudentService {
    String getStudent(String series, String number);
    boolean saveStudent(String series, String number, String name,
                        String lastName,  LocalDate birthDate,
                        String birthPlace,  String phoneNumber,
                        String address,  String email, Faculty faculty);

    boolean deleteStudent(String series, String number);
}
