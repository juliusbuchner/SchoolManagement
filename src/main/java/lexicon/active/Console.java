package lexicon.active;

import lexicon.model.Course;
import lexicon.model.Student;

import java.time.LocalDate;

public interface Console {
    void run();
    void help();
    void whatToDo();
    void whatToDoCourse();
    void findCourse();
    void createCourse();
    void editCourse();
    void editCourseName(int id, String name);
    void editCourseStartDate(int id, LocalDate date);
    void editCourseDuration(int id, int duration);
    void whatToDoStudent();
    void createStudent();
    void enrollStudent(Course course, Student student);
    void expelStudent();
    void editStudentName(int id, String newName);
    void editStudentEmail(int id, String newEmail);
    void editStudentAddress(int id, String newAddress);
    void editStudent();
}
