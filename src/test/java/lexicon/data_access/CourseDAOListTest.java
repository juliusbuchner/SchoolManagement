package lexicon.data_access;

import lexicon.model.Course;
import lexicon.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.LocalDate.*;
import static org.junit.jupiter.api.Assertions.*;

class CourseDAOListTest {
    Student b = new Student("Lars", "lars@mail.com", "Gatan 3");

    List<Student> lS = new ArrayList<>(0);

    Course a = new Course("Matte", parse("2022-09-22"), 15, lS);

    CourseDAOList courses = new CourseDAOList();

    @Test
    void findById() {
        boolean isTrue;
        courses.saveCourse(a);
        isTrue= courses.findById(a.getId()).getId() == a.getId();
        Assertions.assertTrue(isTrue);
    }

    @Test
    void findByName() {
        boolean isTrue;
        courses.saveCourse(a);
        isTrue= courses.findByName("Matte").get(0).getCourseName().equalsIgnoreCase(a.getCourseName());
        Assertions.assertTrue(isTrue);
    }

    @Test
    void findByDate() {
        boolean isTrue;
        courses.saveCourse(a);
        isTrue = courses.findByDate(a.getStartDate()).get(0).getStartDate() == a.getStartDate();
        Assertions.assertTrue(isTrue);
    }

    @Test
    void findAll() {
        boolean isTrue;
        courses.saveCourse(a);
        isTrue = courses.findAll().get(0) == a;
        Assertions.assertTrue(isTrue);
    }

    @Test
    void removeCourse() {
        boolean isTrue;
        courses.saveCourse(a);
        courses.removeCourse(a);
        isTrue = courses.findAll().size() == 0;
        Assertions.assertTrue(isTrue);
    }

    @Test
    void editName() {
        boolean isTrue;
        courses.saveCourse(a);
        courses.editName(1, "Skalman");
        isTrue = courses.findAll().get(0).getCourseName().equalsIgnoreCase("Skalman");
        Assertions.assertTrue(isTrue);

    }

    @Test
    void editDate() {
        boolean isTrue;
        courses.saveCourse(a);
        courses.editDate(a.getId(), LocalDate.parse("2022-06-22"));
        isTrue = courses.findAll().get(a.getId()).getStartDate() == a.getStartDate();
        Assertions.assertTrue(isTrue);
    }

    @Test
    void editDuration() {
        boolean isTrue;
        courses.saveCourse(a);
        courses.editDuration(1, 12);
        isTrue = courses.findAll().get(1).getWeekDuration()==12;
        Assertions.assertTrue(isTrue);
    }
}