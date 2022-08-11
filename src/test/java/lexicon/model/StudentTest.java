package lexicon.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student a = new Student("Lars", "lars@mail.com", "Gatan 3");

    @Test
    void getId() {
        int testId = a.getId();
        Assertions.assertEquals(testId, a.getId());
    }

    @Test
    void getName() {
        Assertions.assertEquals("Lars", a.getName());
    }

    @Test
    void getEmail() {
        Assertions.assertEquals("lars@mail.com", a.getEmail());
    }

    @Test
    void getAddress() {
        Assertions.assertEquals("Gatan 3", a.getAddress());
    }
}