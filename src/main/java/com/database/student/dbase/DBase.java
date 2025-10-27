package com.database.student.dbase;

import com.database.student.model.Faculty;
import com.database.student.model.Passport;
import com.database.student.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBase {
    public static final Map<Passport, Student> STUDENTS = new HashMap<>();
    public static final List<Faculty> FACULTIES = List.of(
            new Faculty("Физико-математический", "+78362455623", "fizmat@university.com"),
            new Faculty("Юридический", "+78362455514", "yurfak@university.com"),
            new Faculty("Педагогический", "+78362455611", "pedagog@university.com")
    );
}
