package com.database.student.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatUtil {

    public static LocalDate formatStringToDate (String date) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.parse(date, dateTimeFormatter);
    }
}
