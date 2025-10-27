package com.database.student.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    private String series;
    private String number;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String birthPlace;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(series, passport.series)
                && Objects.equals(number, passport.number)
                && Objects.equals(name, passport.name)
                && Objects.equals(lastName, passport.lastName)
                && Objects.equals(birthDate, passport.birthDate)
                && Objects.equals(birthPlace, passport.birthPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(series, number, name, lastName, birthDate, birthPlace);
    }
}
