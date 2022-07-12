package data_access;

import se.lexicon.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOList implements CourseDAO{
    private static List<Course> courses = new ArrayList<>();

    @Override
    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> foundCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(name)) {
                foundCourses.add(course);
                return foundCourses;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> foundCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getStartDate() == date) {
                foundCourses.add(course);
                return foundCourses;
            }
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        for (int i=0;i<courses.size();i++){
            if (courses.get(i)==course){
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
}
