package se.lexicon.active;

import se.lexicon.data_access.CourseDAOList;
import se.lexicon.data_access.StudentDAOList;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.util.Scanner;

public class CommandLineRunner implements CommandLine{
    Scanner scan = new Scanner(System.in);
    StudentDAOList students = new StudentDAOList();
    CourseDAOList courses = new CourseDAOList();
    public boolean running=true;
    @Override
    public void run() {
        System.out.println("Note: You can type 'quit' or 'exit' whenever and the application will shut down.\nYou can get this message again if you type 'help' anytime.");
        while (running){
            whatToDo();
        }

    }
    public void help(){
        System.out.println("Note: You can type 'quit' or 'exit' whenever and the application will shut down.\nYou can get this message again if you type 'help' anytime.");
    }
    public void whatToDo() {
        System.out.println("Do you want to affect a Student or a Course?");
        String neutral = scan.nextLine();
        if (neutral.equalsIgnoreCase("student") || neutral.equalsIgnoreCase("students")) {
            whatToDoStudent();
        } else if (neutral.equalsIgnoreCase("course") || neutral.equalsIgnoreCase("courses")) {

        } else if (neutral.equalsIgnoreCase("exit") || neutral.equalsIgnoreCase("quit")) {
            running = false;
        } else if (neutral.equalsIgnoreCase("help")) {
            help();
        } else {
            System.out.println("This application will now return you to the main menu.\nPlease type one of the available commands next time.");
        }
    }
    public void whatToDoStudent() {
        System.out.println("Here you can Create, Enroll, Expel new students.\nHowever, you can also Find and/or Edit an already existing student.");
        String student1 = scan.nextLine();
        if (student1.equalsIgnoreCase("create")) {
            createStudent();
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
    public void enrollStudent(){
    }
}
