package com.database.student.service.impl;

import com.database.student.model.Faculty;
import com.database.student.model.Passport;
import com.database.student.model.Student;
import com.database.student.service.StudentService;

import java.time.LocalDate;

import static com.database.student.dbase.DBase.FACULTIES;
import static com.database.student.dbase.DBase.STUDENTS;

public class StudentServiceImpl implements StudentService {
    @Override
    public String getStudent(String series, String number) {
        Passport passport = STUDENTS
                .keySet()
                .stream()
                .filter(p -> p.getSeries().equals(series) && p.getNumber().equals(number))
                .findFirst()
                .orElse(null);
        return STUDENTS.get(passport).toString();
    }

    @Override
    public boolean saveStudent(String series, String number, String name, String lastName,
                               LocalDate birthDate, String birthPlace, String phoneNumber,
                               String address, String email, String facultyName) {
        Passport passport = new Passport(series, number, name, lastName, birthDate, birthPlace);
        Faculty faculty = FACULTIES
                .stream()
                .filter(f -> f.getName().equals(facultyName))
                .findFirst()
                .orElse(null);
        Student student = new Student(phoneNumber, address, email, faculty);
        STUDENTS.put(passport, student);
        return true;
    }

    @Override
    public boolean deleteStudent(String series, String number) {
        STUDENTS.keySet()
                .stream()
                .filter(p -> p.getSeries().equals(series) && p.getNumber().equals(number))
                .forEach(STUDENTS::remove);
        return true;
    }
}
