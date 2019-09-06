package ru.job4j.inheritance;

import java.util.Date;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private Date birthDate;

<<<<<<< HEAD
    public Profession() {
    }
=======
  public Profession() {

  }
>>>>>>> task_165095

    public Profession(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public Profession(String surname, String name, String education, Date birthDate) {
        this.surname = surname;
        this.name = name;
        this.education = education;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
