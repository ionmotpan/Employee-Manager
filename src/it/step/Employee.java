package it.step;

import java.time.LocalDate;

public class Employee {

    private int id;
    private String name;
    private String surname;
    //private String gender;
    private Gender gender;
    private LocalDate birthdate;


    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Employee(int id, String name, String surname, Gender gender, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

}
