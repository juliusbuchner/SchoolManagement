package lexicon.data_access;

import lexicon.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOListTest {
    Student a = new Student("Lars", "lars@mail.com", "Gatan 3");
    StudentDAOList allStudents = new StudentDAOList();

    @Test
    void findByEmail() {
        boolean isTrue;
        isTrue= Objects.equals(allStudents.findByEmail(a.getEmail()).getEmail(), a.getEmail());
        Assertions.assertTrue(isTrue);
    }

    @Test
    void findByName() {
        boolean isTrue;
        allStudents.saveStudent(a);
        isTrue= allStudents.findByName("Lars").get(0).getName().equalsIgnoreCase(a.getName());
        Assertions.assertTrue(isTrue);
    }

    @Test
    void findById() {
        boolean isTrue;
        allStudents.saveStudent(a);
        isTrue= allStudents.findById(a.getId()).getId() == a.getId();
        Assertions.assertTrue(isTrue);
    }

    @Test
    void findAll() {
        boolean isTrue;
        allStudents.saveStudent(a);
        isTrue = allStudents.findAll().get(1) == a;
        Assertions.assertTrue(isTrue);
    }

    @Test
    void deleteStudent() {
        boolean isTrue;
        allStudents.saveStudent(a);
        allStudents.deleteStudent(a);
        isTrue = allStudents.findAll().size() == 0;
        Assertions.assertTrue(isTrue);
    }

    @Test
    void editStudentName() {
        boolean isTrue;
        allStudents.saveStudent(a);
        allStudents.editStudentName(2, "Skalman");
        isTrue = allStudents.findAll().get(0).getName().equalsIgnoreCase("Skalman");
        Assertions.assertTrue(isTrue);
    }

    @Test
    void editStudentEmail() {
        boolean isTrue;
        allStudents.saveStudent(a);
        System.out.println(allStudents.findAll());
        allStudents.editStudentEmail(2, "Skalman");
        isTrue = allStudents.findAll().get(0).getEmail().equalsIgnoreCase("Skalman");
        Assertions.assertTrue(isTrue);
    }

    @Test
    void editStudentAddress() {
        boolean isTrue;
        allStudents.saveStudent(a);
        allStudents.editStudentAddress(2, "Skalman");
        isTrue = allStudents.findAll().get(0).getAddress().equalsIgnoreCase("Skalman");
        Assertions.assertTrue(isTrue);
    }
}