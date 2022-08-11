package lexicon.data_access;

import lexicon.model.Student;

import java.util.List;

public interface StudentDAO {
    Student saveStudent(Student student);
    Student findByEmail(String email);
    List<Student> findByName(String name);
    Student findById(int id);
    List<Student> findAll();
    boolean deleteStudent(Student student);
    void editStudentName(int id, String name);
    void editStudentEmail(int id, String email);
    void editStudentAddress(int id, String address);
}
