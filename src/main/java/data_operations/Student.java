package data_operations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student {

    private static int nextId = 1;

    private final int studentId;
    private final String studentName;
    private final String gender;

    private static List<Student> students = new ArrayList<>();

    public Student(String studentName, String gender) {
        this.studentName = studentName;
        this.gender = gender;
        this.studentId = nextId++;
        students.add(this);
    }

    public int getStudentId() {
        return studentId;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getGender() {
        return gender;
    }

    public Student findStudent(List<Student> students, int expectedId) {
        return students.stream()
                .filter(s -> s.getStudentId() == expectedId)
                .findFirst()
                .orElse(null);
    }

    public List<Student> findStudentsByGender(List<Student> students, String gender) {
        return students.stream()
                .filter(s -> s.getGender().equals(gender))
                .toList();
    }

    public List<Student> sortedStudentByName(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getStudentName))
                .toList();
    }
}
