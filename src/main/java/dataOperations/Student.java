package dataOperations;

import java.util.ArrayList;
import java.util.List;

public class Student
{
    private Integer studentId;
    private String studentName;
    private String gender;
    List<Student> students = new ArrayList<>();

    public Student(String studentName, Integer studentId, String gender) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
