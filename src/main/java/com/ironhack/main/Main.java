package com.ironhack.main;

import com.ironhack.classes.Course;
import com.ironhack.classes.Student;
import com.ironhack.classes.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Map<String, Teacher> teacherList= new HashMap<>();
        Map<String, Course> courseList= new HashMap<>();
        Map<String, Student> studentList= new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please introduce the name of the school!");
        String schoolName= scanner.nextLine();
        System.out.println("Please introduce the number of teachers");
        int teacherNumber= Integer.parseInt(scanner.nextLine());
        for (int i= 0; i < teacherNumber; i++){
            System.out.println("Please introduce the teacher's name: ");
            String teacherName= scanner.nextLine();
            System.out.println("Please introduce the teacher's salary: ");
            double teacherSalary= Double.parseDouble(scanner.nextLine());
            Teacher teacher=new Teacher(teacherName, teacherSalary);
            teacherList.put(teacher.getTeacherId(),teacher);
        }
        teacherList.forEach((key,value) -> {
            System.out.println(key + "=" + value + " ");
        });

        System.out.println("Please introduce the number of course");
        int courseNumber= Integer.parseInt(scanner.nextLine());
        for (int i= 0; i < courseNumber; i++){
            System.out.println("Please introduce the course name: ");
            String courseName= scanner.nextLine();
            System.out.println("Please introduce the course price: ");
            double coursePrice= Double.parseDouble(scanner.nextLine());
            Course course=new Course(courseName, coursePrice);
            courseList.put(course.getCourseId(),course);
        }
        courseList.forEach((key,value) -> {
            System.out.println(key + "=" + value + " ");
        });

        System.out.println("Please introduce the number of the students");
        int studentNumber= Integer.parseInt(scanner.nextLine());
        for (int i= 0; i < studentNumber; i++){
            System.out.println("Please introduce the student name: ");
            String studentName= scanner.nextLine();
            System.out.println("Please introduce the student address: ");
            String studentAddress= scanner.nextLine();
            System.out.println("Please introduce the student email: ");
            String studentEmail= scanner.nextLine();
            Student student=new Student(studentName, studentAddress, studentEmail);
            studentList.put(student.getStudentId(),student);
        }
        studentList.forEach((key,value) -> {
            System.out.println(key + "=" + value + " ");
        });

        System.out.println("setup is complete, you can now use the commands");
        String command= scanner.nextLine();


        /*lookupCourse(course);
        lookupStudent(student);
        lookupTeacher(teacher);
        System.out.println(lookupCourse(course));
        System.out.println(lookupStudent(student));
        System.out.println(lookupTeacher(teacher));
        enrollStudent(student, course);
        System.out.println(student.getCourse().getCourseId());
        System.out.println(course.getMoney_earned());*/

    }
    public static void enrollStudent(Student student, Course course){
        student.setCourse(course);
        course.setMoney_earned(course.getMoney_earned()+course.getPrice());
    }
    public static void assignTeacher(Teacher teacher, Course course){
        course.setTeacher(teacher);
    }
    public static String lookupCourse(Course course){
        return course.toString();
    }
    public static String lookupStudent(Student student){
        return student.toString();
    }
    public static String lookupTeacher(Teacher teacher){
        return teacher.toString();
    }


}
