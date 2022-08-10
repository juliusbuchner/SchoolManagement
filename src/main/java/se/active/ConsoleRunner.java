package se.active;

import se.data_access.CourseDAOList;
import se.data_access.StudentDAOList;
import se.model.Course;
import se.model.Student;

import java.util.Scanner;

public class ConsoleRunner implements Console {
    Scanner scan = new Scanner(System.in);
    StudentDAOList students = new StudentDAOList();
    CourseDAOList courses = new CourseDAOList();
    public boolean running=true;
    @Override
    public void run() {
        System.out.println("Note: You can type 'quit' or 'exit' whenever and the application will shut down.\nThe available commands are shown with a capital letter.\nYou can get this message again if you type 'help' anytime.");
        while (running){
            whatToDo();
        }

    }
    public void help(){
        System.out.println("Note: You can type 'quit' or 'exit' whenever and the application will shut down.\nThe available commands are shown with a capital letter.\nYou can get this message again if you type 'help' anytime.");
    }
    public void whatToDo() {
        System.out.println("Do you want to affect a Student or a Course?");
        String neutral = scan.nextLine();
        if (neutral.equalsIgnoreCase("student") || neutral.equalsIgnoreCase("students")) {
            whatToDoStudent();
        } else if (neutral.equalsIgnoreCase("course") || neutral.equalsIgnoreCase("courses")) {
            whatToDoCourse();
        } else if (neutral.equalsIgnoreCase("exit") || neutral.equalsIgnoreCase("quit")) {
            running = false;
        } else if (neutral.equalsIgnoreCase("help")) {
            help();
        } else {
            System.out.println("This application will now return you to the main menu.\nPlease type one of the available commands next time.");
        }
    }

    private void whatToDoCourse() {
        System.out.println("Here you can Create new courses or Edit an existing course. You can also get a List of all existing courses.");
        String course1 = scan.nextLine();
        if (course1.equalsIgnoreCase("create")){

        }
    }
    private void createCourse(){

    }

    public void whatToDoStudent() {
        System.out.println("Here you can Create, Enroll, Expel new students.\nHowever, you can also get a List of all students or Edit an already existing student.");
        String student1 = scan.nextLine();
        if (student1.equalsIgnoreCase("create")) {
            createStudent();
        } else if (student1.equalsIgnoreCase("enroll")){
            if (students.findAll().size()!=0){
                System.out.print("Which student do you want to enroll? ");
                String s1Name = scan.nextLine();
                if (students.findByName(s1Name)!=null){
                    System.out.print("What course do you want the student to enroll in?");
                    String c1Name = scan.nextLine();
                    if (courses.findByName(c1Name)!=null) {
                        enrollStudent(courses.findByName(c1Name).get(0), students.findByName(s1Name).get(0));
                    } else {
                        System.out.println("This course does not exist. You will now return to the main menu.");
                    }
                } else {
                    System.out.println("This student does not exist. You will now return to the main menu.");
                }
            } else {
                System.out.println("There are no student to enroll. You need to create a student first.");
            }
        } else if (student1.equalsIgnoreCase("expel")) {

            if (students.findAll().size()!=0){
                expelStudent();
            } else {
                System.out.println("There are no student to expel. You need to create a student first.");
            }
        } else if (student1.equalsIgnoreCase("list")) {
            if (students.findAll().size()!=0){
                System.out.print("Do you want to get information about a Specific student or a list of All of them? ");
                String f = scan.nextLine();
                if (f.equalsIgnoreCase("specific")){
                    System.out.println("Which student to you want to find?");
                    String n = scan.nextLine();
                    System.out.println(students.findByName(n).get(0));
                } else if (f.equalsIgnoreCase("all")) {
                    System.out.println(students.findAll());
                } else if (f.equalsIgnoreCase("exit") || f.equalsIgnoreCase("quit")) {
                    running = false;
                }
            } else {
                System.out.println("There are no students to find. You need to create a student first.");
            }

        } else if (student1.equalsIgnoreCase("edit")){
            editStudent();
        }else if (student1.equalsIgnoreCase("exit") || student1.equalsIgnoreCase("quit")) {
            running = false;
        }
    }
    public void createStudent(){
        System.out.print("Creating a student:\nWhat is the name of this student? ");
        String name = scan.nextLine();
        System.out.print("What is the email of this student? ");
        String email = scan.nextLine();
        System.out.print("What is the address of this student? ");
        String address = scan.nextLine();
        Student s1 = new Student(name, email, address);
        students.saveStudent(s1);
        System.out.println("You have now created the following student: " + s1);
    }
    public void enrollStudent(Course course, Student student){
        course.register(student);
    }
    public void expelStudent(){
        System.out.print("Which student do you want to expel? ");
        String s1Name = scan.nextLine();
        if (students.findByName(s1Name)!=null){
            System.out.print("From which of these courses do you want to expel the student from?");
            for (int i=0;i<courses.findAll().size();i++){
                if (courses.findAll().get(i).getStudents().contains(students.findByName(s1Name))){
                    System.out.println(courses.findAll().get(i).getCourseName());
                }
            }
            String c1Choice = scan.nextLine();
            courses.findByName(c1Choice).get(0).unregister(students.findByName(s1Name).get(0));
        }
    }
    public void editStudentName(int id, String newName){
        students.editStudentName(id, newName);
    }
    public void editStudentEmail(int id, String newEmail){
        students.editStudentEmail(id, newEmail);
    }
    public void editStudentAddress(int id, String newAddress){
        students.editStudentAddress(id, newAddress);
    }
    public void editStudent(){
        System.out.print("Which student do you want to edit? ");
        String sN = scan.nextLine();
        if (students.findAll().contains(students.findByName(sN).get(0))){
            System.out.print("Do you want to edit the student's Name, Email or Address?");
            String e = scan.nextLine();
            if (e.equalsIgnoreCase("name")){
                System.out.print("What is the student's new name? ");
                String n = scan.nextLine();
                editStudentName(students.findByName(sN).get(0).getId(), n);
                System.out.println(students.findByName(n).get(0));
            } else if (e.equalsIgnoreCase("email")){
                System.out.print("What is the student's new email? ");
                String n = scan.nextLine();
                editStudentEmail(students.findByName(sN).get(0).getId(), n);
                System.out.println(students.findByName(n).get(0));
            } else if (e.equalsIgnoreCase("address")) {
                System.out.print("What is the student's new address? ");
                String n = scan.nextLine();
                editStudentAddress(students.findByName(sN).get(0).getId(), n);
                System.out.println(students.findByName(n).get(0));
            } else if (e.equalsIgnoreCase("exit") || e.equalsIgnoreCase("quit")) {
                running = false;
            }
        }
    }
}