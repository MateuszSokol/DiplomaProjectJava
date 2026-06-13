package data_operations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student
{
    private static Integer studentId =0;
    private String studentName;
    private String gender;
    private static List<Student> students = new ArrayList<>();

    public Student(String studentName, String gender) {
        this.studentName = studentName;
        this.gender = gender;
        studentId++;
        students.add(this);
    }

    public String getGender() {
        return gender;
    }


    public Integer getStudentId() {
        return studentId;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public String getStudentName() {
        return studentName;
    }


    public Student findStudent(List<Student> students, int expectedId)
    {
        return students.stream()
                .filter(s -> s.getStudentId().equals(expectedId))
                .findFirst()
                .orElse(null);

    }
    public List<Student> findStudentsByGender(List<Student> students,String gender)
    {

        return students.stream()
                .filter(s -> s.getGender().equals(gender))
                .toList();
    }
    public List<Student> sortedStudentByName(List<Student> students)
    {
        return students.stream()
                .sorted(Comparator.comparing(Student::getStudentName))
                .toList();
    }
}
