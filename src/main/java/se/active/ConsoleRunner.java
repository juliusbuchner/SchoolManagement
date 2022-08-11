package se.active;

import se.data_access.CourseDAOList;
import se.data_access.StudentDAOList;
import se.model.Course;
import se.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleRunner implements Console {
    Scanner scan = new Scanner(System.in);
    StudentDAOList allStudents = new StudentDAOList();
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

    public void whatToDoCourse() {
        System.out.println("Here you can Create new courses or Edit an existing course. You can also get a List of all existing courses.");
        String course1 = scan.nextLine();
        if (course1.equalsIgnoreCase("create")){
            createCourse();
        } else if (course1.equalsIgnoreCase("edit")){
            editCourse();
        } else if (course1.equalsIgnoreCase("List")){
            findCourse();
        } else if (course1.equalsIgnoreCase("exit") || course1.equalsIgnoreCase("quit")) {
            running = false;
        }
    }
    public void findCourse(){
        if (courses.findAll().size()!=0){
            System.out.print("Do you want to get information about a Specific course or a list of All of them? ");
            String f = scan.nextLine();
            if (f.equalsIgnoreCase("specific")){
                System.out.println("Which course to you want to find?");
                String n = scan.nextLine();
                System.out.println(courses.findByName(n).get(0));
            } else if (f.equalsIgnoreCase("all")) {
                System.out.println(courses.findAll());
            } else if (f.equalsIgnoreCase("exit") || f.equalsIgnoreCase("quit")) {
                running = false;
            }
        } else System.out.println("There are no courses to find. You need to create a course first.");
    }
    public void createCourse(){
        System.out.print("Creating a course:\nWhat is the name of the course? ");
        String name = scan.nextLine();
        System.out.print("When does the course start? Type in the format of 'year-month-day'. ");
        LocalDate startDate = LocalDate.parse(scan.nextLine());
        System.out.print("How long is the course in weeks? ");
        int duration = scan.nextInt();
        List<Student> lS = new ArrayList<>(0);
        Course c1 = new Course(name, startDate, duration, lS);
        courses.saveCourse(c1);
        System.out.println("This is the course that has been created: " + c1);
    }
    public void editCourse(){
        if (courses.findAll().size()!=0) {
            System.out.print("Which course do you want to edit? ");
            String cN = scan.nextLine();
            if (courses.findAll().contains(courses.findByName(cN).get(0))){
                System.out.print("Do you want to edit the course's Name, start Date or Duration? ");
                String c = scan.nextLine();
                if (c.equalsIgnoreCase("name")){
                    System.out.print("What is the new name? ");
                    String cNN = scan.nextLine();
                    editCourseName(courses.findByName(cN).get(0).getId(), cNN);
                    System.out.println("This is the new information about this course: " + courses.findByName(cNN).get(0));
                } else if (c.equalsIgnoreCase("date")) {
                    System.out.print("What is the new start date? Please use the format of 'year-month-day'. ");
                    LocalDate cSD = LocalDate.parse(scan.nextLine());
                    editCourseStartDate(courses.findByName(cN).get(0).getId(), cSD);
                    System.out.println("This is the new information about this course: " + courses.findByName(cN).get(0));
                } else if (c.equalsIgnoreCase("duration")) {
                    System.out.print("What is the new duration of the course? Please give the time in weeks. ");
                    int cD = scan.nextInt();
                    editCourseDuration(courses.findByName(cN).get(0).getId(), cD);
                    System.out.println("This is the new information about this course: " + courses.findByName(cN).get(0));
                } else if (c.equalsIgnoreCase("exit") || c.equalsIgnoreCase("quit")) {
                    running = false;
                }
            }
        } else {
            System.out.println("There are no courses to edit. Please create one first.");
        }
    }
    public void editCourseName(int id, String name){
        courses.editName(id, name);
    }
    public void editCourseStartDate(int id, LocalDate date){
        courses.editDate(id, date);
    }
    public void editCourseDuration(int id, int duration){
        courses.editDuration(id, duration);
    }
    public void whatToDoStudent() {
        System.out.println("Here you can Create, Enroll, Expel new students.\nHowever, you can also get a List of all students or Edit an already existing student.");
        String student1 = scan.nextLine();
        if (student1.equalsIgnoreCase("create")) {
            createStudent();
        } else if (student1.equalsIgnoreCase("enroll")){
            if (allStudents.findAll().size()!=0){
                System.out.print("Which student do you want to enroll? ");
                String s1Name = scan.nextLine();
                if (allStudents.findByName(s1Name)!=null){
                    System.out.print("What course do you want the student to enroll in?");
                    String c1Name = scan.nextLine();
                    if (courses.findByName(c1Name)!=null) {
                        enrollStudent(courses.findByName(c1Name).get(0), allStudents.findByName(s1Name).get(0));
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

            if (allStudents.findAll().size()!=0){
                expelStudent();
            } else {
                System.out.println("There are no student to expel. You need to create a student first.");
            }
        } else if (student1.equalsIgnoreCase("list")) {
            if (allStudents.findAll().size()!=0){
                System.out.print("Do you want to get information about a Specific student or a list of All of them? ");
                String f = scan.nextLine();
                if (f.equalsIgnoreCase("specific")){
                    System.out.println("Which student to you want to find?");
                    String n = scan.nextLine();
                    System.out.println(allStudents.findByName(n).get(0));
                } else if (f.equalsIgnoreCase("all")) {
                    System.out.println(allStudents.findAll());
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
        allStudents.saveStudent(s1);
        System.out.println("You have now created the following student: " + s1);
    }
    public void enrollStudent(Course course, Student student){
        course.register(student);
    }
    public void expelStudent(){
        System.out.print("Which student do you want to expel? ");
        String s1Name = scan.nextLine();
        if (allStudents.findByName(s1Name)!=null){
            System.out.print("From which of these courses do you want to expel the student from?");
            for (int i=0;i<courses.findAll().size();i++){
                if (courses.findAll().get(i).getStudents().contains(allStudents.findByName(s1Name))){
                    System.out.println(courses.findAll().get(i).getCourseName());
                }
            }
            String c1Choice = scan.nextLine();
            courses.findByName(c1Choice).get(0).unregister(allStudents.findByName(s1Name).get(0));
        }
    }
    public void editStudentName(int id, String newName){
        allStudents.editStudentName(id, newName);
    }
    public void editStudentEmail(int id, String newEmail){
        allStudents.editStudentEmail(id, newEmail);
    }
    public void editStudentAddress(int id, String newAddress){
        allStudents.editStudentAddress(id, newAddress);
    }
    public void editStudent(){
        System.out.print("Which student do you want to edit? ");
        String sN = scan.nextLine();
        if (allStudents.findAll().contains(allStudents.findByName(sN).get(0))){
            System.out.print("Do you want to edit the student's Name, Email or Address?");
            String e = scan.nextLine();
            if (e.equalsIgnoreCase("name")){
                System.out.print("What is the student's new name? ");
                String n = scan.nextLine();
                editStudentName(allStudents.findByName(sN).get(0).getId(), n);
                System.out.println(allStudents.findByName(n).get(0));
            } else if (e.equalsIgnoreCase("email")){
                System.out.print("What is the student's new email? ");
                String n = scan.nextLine();
                editStudentEmail(allStudents.findByName(sN).get(0).getId(), n);
                System.out.println(allStudents.findByName(n).get(0));
            } else if (e.equalsIgnoreCase("address")) {
                System.out.print("What is the student's new address? ");
                String n = scan.nextLine();
                editStudentAddress(allStudents.findByName(sN).get(0).getId(), n);
                System.out.println(allStudents.findByName(n).get(0));
            } else if (e.equalsIgnoreCase("exit") || e.equalsIgnoreCase("quit")) {
                running = false;
            }
        }
    }
}