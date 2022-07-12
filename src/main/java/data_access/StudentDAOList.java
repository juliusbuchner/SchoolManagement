package data_access;

import se.lexicon.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOList implements StudentDAO{
    private static List<Student> students = new ArrayList<>();

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
}
