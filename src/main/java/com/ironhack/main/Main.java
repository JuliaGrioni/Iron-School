package com.ironhack.main;

import com.ironhack.classes.Course;
import com.ironhack.classes.Student;
import com.ironhack.classes.Teacher;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("pepe", 2000.50);
        Course course = new Course("Curso", 200.00);
        Student student = new Student("Pepe","calle13","pepe@pepe.com");

        enrollStudent(student, course);

        System.out.println(student.getCourse().getCourseId());

        System.out.println(course.getMoney_earned());
    }
    public static void enrollStudent(Student student, Course course){
        student.setCourse(course);
        course.setMoney_earned(course.getMoney_earned()+course.getPrice());
    }
    public static void assignTeacher(Teacher teacher, Course course){
        course.setTeacher(teacher);
    }
}
