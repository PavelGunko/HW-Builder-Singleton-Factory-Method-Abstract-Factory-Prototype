package org.example;

import java.util.Objects;
import java.util.OptionalInt;

//1. Создайте класс Person с полями, необходимыми для хранения данных, указанных в условии.
public class Person {
    private final String name;
    private final String surname;

    //Использую Integer т.к это ссылочный тип и может быть null, что удобно для случая если возвраст не задан
    private OptionalInt age;
    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.city = city;
    }


    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return Objects.nonNull(city);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String address) {

    }

    public void happyBirthday() {
        age.ifPresent(value -> age = OptionalInt.of(value++));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(age, person.age) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setAge(age.getAsInt())
                // .setName(name)
                .setSurname(surname)
                .setAddress(city);
    }
}

