package lexicon.data_access;

import lexicon.model.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseDAO {
    Course saveCourse(Course course);
    Course findById(int id);
    List<Course> findByName(String name);
    List<Course> findByDate(LocalDate date);
    List<Course> findAll();
    boolean removeCourse(Course course);
    void editName(int id, String name);
    void editDate(int id, LocalDate date);
    void editDuration(int id, int duration);
}
