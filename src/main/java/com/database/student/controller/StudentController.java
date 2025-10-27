package com.database.student.controller;

import com.database.student.dto.DeleteStudentDTO;
import com.database.student.dto.GetStudentDTO;
import com.database.student.dto.SaveStudentDTO;
import com.database.student.service.StudentService;
import com.database.student.service.impl.StudentServiceImpl;

public class StudentController {

    StudentService studentService = new StudentServiceImpl();

    public String getStudent(GetStudentDTO getStudentDTO) {
        return studentService.getStudent(getStudentDTO.getSeries(), getStudentDTO.getNumber());
    }

    public boolean saveStudent(SaveStudentDTO saveStudentDTO) {
        return studentService.saveStudent(saveStudentDTO.getSeries(), saveStudentDTO.getNumber(),
                saveStudentDTO.getName(), saveStudentDTO.getLastName(),
                saveStudentDTO.getBirthDate(), saveStudentDTO.getBirthPlace(),
                saveStudentDTO.getPhoneNumber(), saveStudentDTO.getAddress(),
                saveStudentDTO.getEmail(), saveStudentDTO.getFacultyName());
    }

    public boolean deleteStudent(DeleteStudentDTO deleteStudentDTO) {
        return studentService.deleteStudent(deleteStudentDTO.getSeries(), deleteStudentDTO.getNumber());
    }
}
