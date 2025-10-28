package com.database.student.controller;

import com.database.student.dto.DeleteStudentDTO;
import com.database.student.dto.GetStudentDTO;
import com.database.student.dto.SaveStudentDTO;
import com.database.student.model.Faculty;
import com.database.student.service.StudentService;
import com.database.student.service.impl.StudentServiceImpl;

import static com.database.student.dbase.DBase.FACULTIES;

public class StudentController {

    StudentService studentService = new StudentServiceImpl();

    public String getStudent(GetStudentDTO getStudentDTO) {

        if (getStudentDTO.getSeries().length() != 4) {
            return "Введите корректную серию паспорта";
        }
        if (getStudentDTO.getNumber().length() != 6) {
            return "Введите корректный номер паспорта";
        }

        return studentService.getStudent(getStudentDTO.getSeries(), getStudentDTO.getNumber());
    }

    public boolean saveStudent(SaveStudentDTO saveStudentDTO) {
        Faculty faculty = FACULTIES
                .stream()
                .filter(f -> f.getName().equals(saveStudentDTO.getFacultyName()))
                .findFirst()
                .orElse(null);

        if (faculty == null) {
            System.out.println("Не корректно указано название факультета");
            return false;
        } else if (saveStudentDTO.getSeries().length() != 4) {
            System.out.println("Введите корректную серию паспорта");
            return false;
        } else if (saveStudentDTO.getNumber().length() != 6) {
            System.out.println("Введите корректный номер паспорта");
            return false;
        } else {
            return studentService.saveStudent(saveStudentDTO.getSeries(), saveStudentDTO.getNumber(),
                    saveStudentDTO.getName(), saveStudentDTO.getLastName(),
                    saveStudentDTO.getBirthDate(), saveStudentDTO.getBirthPlace(),
                    saveStudentDTO.getPhoneNumber(), saveStudentDTO.getAddress(),
                    saveStudentDTO.getEmail(), faculty);
        }
    }

    public boolean deleteStudent(DeleteStudentDTO deleteStudentDTO) {

        if (deleteStudentDTO.getSeries().length() != 4) {
            System.out.println("Введите корректную серию паспорта");
            return false;
        }

        if (deleteStudentDTO.getNumber().length() != 6) {
            System.out.println("Введите корректный номер паспорта");
            return false;
        }

        return studentService.deleteStudent(deleteStudentDTO.getSeries(), deleteStudentDTO.getNumber());
    }
}
