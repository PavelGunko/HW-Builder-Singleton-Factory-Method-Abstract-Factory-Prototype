package org.example;

import java.util.Objects;
import java.util.OptionalInt;

/*3. Создайте класс PersonBuilder, наполните его полями для данных
  будущего объекта класса Person и методами их наполняющими (не забудьте про IllegalArgumentException в
  случае ввода недопустимых данных)
   */
public class PersonBuilder {

    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        if (name == null|| name.trim().isEmpty()) {
            throw new IllegalStateException("Указано пустое имя");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null|| surname.trim().isEmpty()) {
            throw new IllegalStateException("Указана пустая фамилия");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Указан некоретный возраст меньше 0: " + age);
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (Objects.isNull(name)) {
            throw new IllegalStateException("Не указана фамилия");
        }
        if (Objects.isNull(surname)) {
            throw new IllegalStateException("Не указано имя");
        }
        if (age.isPresent()) {
            return new Person(name, surname, age.getAsInt(), address);
        }
        return new Person(name, surname, address);
    }

}
