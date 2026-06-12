package data_operations;
import java.util.Comparator;
import java.util.List;
public class Operations
{
    public Student findStudent(List<Student> students, int expectedId)
    {
        return students.stream()
                .filter(s -> s.getStudentId().equals(expectedId))
                .findFirst()
                .orElse(null);

    }
    public List<Student> findOnlyMaleStudents(List<Student> students)
    {
        String gender = "Male";

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
