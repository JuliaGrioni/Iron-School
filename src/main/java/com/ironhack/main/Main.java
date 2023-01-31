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
        String string = scanner.nextLine();
        while (!isInteger(string)){
            System.out.println("Number of teachers must be a number");
            System.out.println("Please introduce the number of teachers");
            string = scanner.nextLine();
        }
        int teacherNumber= Integer.parseInt(string);
        for (int i= 0; i < teacherNumber; i++){
            System.out.println("Please introduce the teacher's name: ");
            String teacherName= scanner.nextLine();
            System.out.println("Please introduce the teacher's salary: ");
            String salary = scanner.nextLine();
            while (!isDouble(salary) && !isInteger(salary)){
                System.out.println("Salary must be a number");
                System.out.println("Please introduce the teacher's salary: ");
                salary = scanner.nextLine();
            }
            double teacherSalary= Double.parseDouble(salary);
            Teacher teacher=new Teacher(teacherName, teacherSalary);
            teacherList.put(teacher.getTeacherId(),teacher);
        }
        teacherList.forEach((key,value) -> {
            System.out.println(key + "=" + value + " ");
        });

        System.out.println("Please introduce the number of course");
        String numberOfcourses = scanner.nextLine();
        while (!isInteger(numberOfcourses)){
            System.out.println("Number of courses must be a number");
            System.out.println("Please introduce the number of courses");
            numberOfcourses = scanner.nextLine();
        }
        int courseNumber= Integer.parseInt(numberOfcourses);
        for (int i= 0; i < courseNumber; i++){
            System.out.println("Please introduce the course name: ");
            String courseName= scanner.nextLine();
            System.out.println("Please introduce the course price: ");
            String price = scanner.nextLine();
            while (!isDouble(price) && !isInteger(price)){
                System.out.println("Price must be a number");
                System.out.println("Please introduce the course price:");
                price = scanner.nextLine();
            }
            double coursePrice= Double.parseDouble(price);
            Course course=new Course(courseName, coursePrice);
            courseList.put(course.getCourseId(),course);
        }
        courseList.forEach((key,value) -> {
            System.out.println(key + "=" + value + " ");
        });
        System.out.println("Please introduce the number of the students:");
        String students = scanner.nextLine();
        while (!isInteger(students)){
            System.out.println("Number of students must be a number");
            System.out.println("Please introduce the number of students:");
            students = scanner.nextLine();
        }
        int studentNumber= Integer.parseInt(students);
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






        boolean execute=true;
        System.out.println("type HELP to show commands!");
        System.out.println("setup is complete, you can now use the commands");
        while (execute) {
            String command= scanner.nextLine();
            String [] commandArray= command.split(" ");
            switch (commandArray[0]){
                case "HELP":
                    help();
                    break;
                case "EXIT":
                    execute= false;
                    break;
                case "SHOW":
                    if(commandArray[1].equals("COURSES")){
                        courseList.forEach((key,value) -> {
                            System.out.println(value);
                        });
                    } else if (commandArray[1].equals("TEACHERS")){
                        teacherList.forEach((key,value) -> {
                            System.out.println(value);
                        });
                    } else if (commandArray[1].equals("STUDENTS")){
                        studentList.forEach((key,value) -> {
                            System.out.println(value);
                        });
                    } else if (commandArray[1].equals("PROFIT")){
                        double profits = showProfit((HashMap<String, Teacher>) teacherList, (HashMap<String, Course>) courseList);
                        System.out.println(profits);
                    } else {
                        System.out.println("type HELP to show commands!");
                        System.out.println("commands not exist!");
                    }
                    break;
                case "LOOKUP":
                    if(commandArray[1].equals("COURSE")){
                        System.out.println(courseList.get(commandArray[2]));
                    } else if (commandArray[1].equals("TEACHER")){
                        System.out.println(teacherList.get(commandArray[2]));
                    } else if (commandArray[1].equals("STUDENT")){
                        System.out.println(studentList.get(commandArray[2]));
                    } else {
                        System.out.println("type HELP to show commands!");
                        System.out.println("commands not exist!");
                    }
                    break;
                case "ASSIGN":
                        assignTeacher(teacherList.get(commandArray[1]), courseList.get(commandArray[2]));
                    break;
                case "ENROLL":
                        enrollStudent(studentList.get(commandArray[1]), courseList.get(commandArray[2]));
                    break;
                    default: System.out.println("type HELP to show commands!");
                    System.out.println("commands not exist!");
            }
            scanner.close();
        }




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
    public static boolean isInteger(String numero){
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public static boolean isDouble(String numero){
        try{
            Double.parseDouble(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public static void enrollStudent(Student student, Course course){
        student.setCourse(course);
        course.setMoney_earned(course.getMoney_earned()+course.getPrice());
    }
    public static void assignTeacher(Teacher teacher, Course course){
        course.setTeacher(teacher);
    }

    public static double showProfit(HashMap<String, Teacher> teachers, HashMap<String, Course> courses){
        double profit = 0;
        double teachersSalaries = 0;
        for(Map.Entry<String,Teacher> entry: teachers.entrySet()){
            teachersSalaries = teachersSalaries + entry.getValue().getSalary();
        }
        for(Map.Entry<String,Course> entry: courses.entrySet()){
            profit = profit + entry.getValue().getMoney_earned();
        }
        return profit-teachersSalaries;
    }

    public static void help(){
        System.out.println("ENROLL [STUDENT_ID] [COURSE_ID]\n" +
                "ASSIGN [TEACHER_ID] [COURSE_ID]\n" +
                "SHOW COURSES\n" +
                "LOOKUP COURSE [COURSE_ID]\n" +
                "SHOW STUDENTS\n" +
                "LOOKUP STUDENT [STUDENT_ID]\n" +
                "SHOW TEACHERS\n" +
                "LOOKUP TEACHER [TEACHER_ID]\n" +
                "SHOW PROFIT\n" +
                "EXIT");
    }

}
