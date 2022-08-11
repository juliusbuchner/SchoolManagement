package lexicon.data_access;

import lexicon.model.Course;
import lexicon.model.Student;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOListTest {
    Student b = new Student("Lars", "lars@mail.com", "Gatan 3");

    List<Student> lS = new ArrayList<>(0);

    Course a = new Course("Matte", LocalDate.parse("2022-09-22"), 15, lS);

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findByDate() {
    }

    @Test
    void findAll() {
    }

    @Test
    void removeCourse() {
    }

    @Test
    void editName() {
    }

    @Test
    void editDate() {
    }

    @Test
    void editDuration() {
    }
}