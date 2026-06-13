package data_operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentTest
{
    @BeforeEach
    void resetStaticFields() {
        Student.getStudents().clear();

        try {
            var field = Student.class.getDeclaredField("nextId");
            field.setAccessible(true);
            field.set(null, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void testFindStudent() {
        Student s1 = new Student("Mateusz", "Male"); // ID = 1

        Student found = s1.findStudent(Student.getStudents(), s1.getStudentId());

        assertNotNull(found);
        assertEquals("Mateusz", found.getStudentName());
    }

    @Test
    void testFindStudentsByGender() {
        new Student("Mateusz", "Male");
        new Student("Anna", "Female");
        new Student("Kuba", "Male");

        Student helper = new Student("X", "Male"); // tylko do wywołania metody

        List<Student> males = helper.findStudentsByGender(Student.getStudents(), "Male");

        assertEquals(3, males.size());
    }

    @Test
    void testSortedStudentsByName() {
        new Student("Zofia", "Female");
        new Student("Adam", "Male");
        new Student("Kamil", "Male");

        List<Student> sorted = new Student("A", "Male")
                .sortedStudentByName(Student.getStudents());

        sorted = sorted.stream()
                .filter(s -> !s.getStudentName().equals("A"))
                .toList();

        assertEquals("Adam", sorted.get(0).getStudentName());
        assertEquals("Kamil", sorted.get(1).getStudentName());
        assertEquals("Zofia", sorted.get(2).getStudentName());
    }

}
