package lexicon.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Student b = new Student("Lars", "lars@mail.com", "Gatan 3");

    List<Student> lS = new ArrayList<>(0);

    Course a = new Course("Matte", LocalDate.parse("2022-09-22"), 15, lS);

    @Test
    void getId() {
        int testId = a.getId();
        Assertions.assertEquals(testId, a.getId());
    }

    @Test
    void getCourseName() {
        String testName = a.getCourseName();
        Assertions.assertEquals(testName, a.getCourseName());
    }

    @Test
    void getStartDate() {
        LocalDate testDate = a.getStartDate();
        Assertions.assertEquals(testDate, a.getStartDate());
    }

    @Test
    void getWeekDuration() {
        int testDuration = a.getWeekDuration();
        Assertions.assertEquals(testDuration, a.getWeekDuration());
    }

    @Test
    void getStudents() {
        lS.add(b);
        Assertions.assertEquals(b, lS.get(0));
    }
}