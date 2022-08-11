package se.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course(String courseName, LocalDate startDate, int weekDuration, List<Student> students) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
        ++this.id;
    }

    public int getId(){
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void register(Student student){
        students.add(student);
    }

    public void unregister(Student student){
        students.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        return "Course:" +
                "\ncourse id=" + id +
                "\ncourseName='" + courseName + '\'' +
                "\nstartDate=" + startDate +
                "\nweekDuration=" + weekDuration +
                "\nstudents=" + students;
    }
}
