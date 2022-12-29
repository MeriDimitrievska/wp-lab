package mk.ukim.finki.wp.lab.model;

import java.io.Serializable;

public class TeacherFullName implements Serializable {
    public String name;
    public String surname;

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

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
