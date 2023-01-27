package com.ironhack.classes;

public class Teacher {
    private String teacherId;
    private String name;
    private double salary;

    public Teacher(String name, String salary) {
        this.name = name;
        this.salary = salary;
        teacherId = String.valueOf(teacherId.hashCode());
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
