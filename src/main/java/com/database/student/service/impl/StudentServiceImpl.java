package com.database.student.service.impl;

import com.database.student.model.Faculty;
import com.database.student.model.Passport;
import com.database.student.model.Student;
import com.database.student.service.StudentService;

import java.time.LocalDate;

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

        if (passport == null) {
            return "Студент с введенными данными не найден";
        } else {
            return STUDENTS.get(passport).toString();
        }
    }

    @Override
    public boolean saveStudent(String series, String number, String name, String lastName,
                               LocalDate birthDate, String birthPlace, String phoneNumber,
                               String address, String email, Faculty faculty) {
        Passport passport = new Passport(series, number, name, lastName, birthDate, birthPlace);
        Student student = new Student(phoneNumber, address, email, faculty);
        STUDENTS.put(passport, student);
        return true;
    }

    @Override
    public boolean deleteStudent(String series, String number) {
        Passport passport = STUDENTS
                .keySet()
                .stream()
                .filter(p -> p.getSeries().equals(series) && p.getNumber().equals(number))
                .findFirst()
                .orElse(null);

        if (passport == null) {
            System.out.println("Студент с введенными данными не найден");
            return false;
        } else {
            STUDENTS.remove(passport);
            return true;
        }
    }
}
