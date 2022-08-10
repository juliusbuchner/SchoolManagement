package se.data_access;

import se.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOList implements StudentDAO{
    private static final List<Student> students = new ArrayList<>();

    @Override
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                foundStudents.add(student);
                return foundStudents;
            }
        }
        return null;
    }

    @Override
    public Student findById(int id) {
        for (Student student : students){
            if (student.getId()==id){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        for (int i=0;i<students.size();i++){
           if (students.get(i)==student){
               students.remove(i);
               return true;
           }
        }
        return false;
    }

    @Override
    public void editStudentName(int id, String newName) {
        for (Student student:students){
            if (student.getId()==id){
                student.setName(newName);
            }
        }

    }

    @Override
    public void editStudentEmail(int id, String email) {
        for (Student student:students){
            if (student.getId()==id){
                student.setEmail(email);
            }
        }

    }

    @Override
    public void editStudentAddress(int id, String address) {
        for (Student student:students){
            if (student.getId()==id){
                student.setAddress(address);
            }
        }
    }
}
