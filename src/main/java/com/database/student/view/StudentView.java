package com.database.student.view;

import com.database.student.controller.StudentController;
import com.database.student.dto.DeleteStudentDTO;
import com.database.student.dto.GetStudentDTO;
import com.database.student.dto.SaveStudentDTO;
import com.database.student.util.DateFormatUtil;

import java.util.Scanner;

public class StudentView {

    public final static StudentController studentController = new StudentController();

    public static void runInterface () {

        System.out.println("----------------------------------------");
        System.out.println("Выберите действие (1, 2 ил 3):");
        System.out.println("1. Добавить студента в базу");
        System.out.println("2. Найти студента в базе");
        System.out.println("3. Удалить студента из базы");

        Scanner scanner = new Scanner(System.in);
        int intChoice = 0;
        try {
            intChoice = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Выберите пункт меню 1, 2 или 3");
            runInterface();
        }

        switch (intChoice) {
            case 1 -> {
                boolean isSaved = saveStudent();
                if (isSaved) System.out.println("Студен успешно создан");
                else System.out.println("Не получилось добавить студента. Попробуйте снова");
                runInterface();
            }
            case 2 -> {
                String value = getStudent();
                System.out.println(value);
                runInterface();
            }
            case 3 -> {
                boolean isDeleted = deleteStudent();
                if (isDeleted) {
                    System.out.println("Студент удален из базы");
                } else {
                    System.out.println("Удалить студента из базы не удалось." +
                            "\nПопробуйте повторить действие.");
                }
                runInterface();
            }
            default -> {
                System.out.println("Выберите пункт меню 1, 2 или 3");
                runInterface();
            }
        }

    }

    public static boolean saveStudent() {
        String series = userInput("Введите серию паспорта:");
        String number = userInput("Введите номер паспорта:");
        String name = userInput("Введите имя студента:");
        String lastName = userInput("Введите фамилию студента:");
        String birthDate = userInput("Введите дату рождения в формате гггг-мм-дд:");
        String birthPlace = userInput("Введите место рождения:");
        String phoneNumber = userInput("Введите номер телефона в формате +7-ХХХ-ХХХ-ХХ-ХХ:");
        String address = userInput("Введите адрес:");
        String email = userInput("Введите адрес электронной почты");
        String facultyName = userInput("Введите название факультета " +
                "(Физико-математический, Юридический, Педагогический):");

        return studentController.saveStudent(new SaveStudentDTO(series, number, name, lastName,
                DateFormatUtil.formatStringToDate(birthDate), birthPlace, phoneNumber,
                address, email, facultyName));
    }

    public static String getStudent() {

        String series = userInput("Введите серию паспорта:");
        String number = userInput("Введите номер паспорта:");
        return studentController.getStudent(new GetStudentDTO(series, number));
    }

    public static boolean deleteStudent() {
        String series = userInput("Введите серию паспорта:");
        String number = userInput("Введите номер паспорта:");
        return studentController.deleteStudent(new DeleteStudentDTO(series, number));
    }

    public static String userInput (String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
