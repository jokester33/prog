import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest{

    @BeforeEach
    public void setup() {
        // Clear the static list before each test
        Student.getAllStudents().clear();
    }

    @Test
    public void testSaveStudent() {
        System.out.println("Running testSaveStudent...");
        Student.saveStudent("8594", "Kyle Mahn", 20, "kylemahn@gmail.com", "SSA");
        Student student = Student.searchStudent("8594");
        assertNotNull(student);
        assertEquals("Kyle Mahn", student.getName());
        System.out.println("Student saved.");
    }

    @Test
    public void testSearchStudent() {
        System.out.println("Running testSearchStudent...");
        Student.saveStudent("7778", "Mary Ann", 19, "maryann@outlook.com", "lee");
        Student student = Student.searchStudent("7778");
        assertNotNull(student);
        assertEquals("Mary Ann", student.getName());
        System.out.println("Student found and verified.");
    }

    @Test
    public void testSearchStudentNotFound() {
        System.out.println("Running testSearchStudentNotFound...");
        Student student = Student.searchStudent("999");
        assertNull(student);
        System.out.println("Verified that student was not found.");
    }

    @Test
    public void testDeleteStudent() {
        System.out.println("Running testDeleteStudent...");
        Student.saveStudent("4587", "Angus September", 20, "angusseptember@gmail.com", "buis");
        boolean deleted = Student.deleteStudent("4587");
        assertTrue(deleted);
        Student student = Student.searchStudent("4587");
        assertNull(student);
        System.out.println("Student deleted.");
    }

    @Test
    public void testDeleteStudentNotFound() {
        System.out.println("Running testDeleteStudentNotFound...");
        boolean deleted = Student.deleteStudent("999");
        assertFalse(deleted);
        System.out.println("Verified that no student was deleted.");
    }

    @Test
    public void testPrintStudentReport() {
        System.out.println("Running testPrintStudentReport...");
        Student.saveStudent("4", "Bob Brown", 25, "bob@example.com", "Art");
        Student.saveStudent("5", "Eve White", 30, "eve@example.com", "Engineering");
        // Redirect output to a stream to capture and verify output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        Student.printStudentReport();

        String output = outContent.toString();
        assertTrue(output.contains("Bob Brown"));
        assertTrue(output.contains("Eve White"));
        System.out.println("Student report printed and verified.");
    }

    @Test
    public void testStudentAgeValid() {
        System.out.println("Running testStudentAgeValid...");
        assertEquals(20, Student.getValidAge("20"));
        System.out.println("Verified valid age.");
    }

    @Test
    public void testStudentAgeInvalid() {
        System.out.println("Running testStudentAgeInvalid...");
        assertEquals(-1, Student.getValidAge("15"));
        System.out.println("Invalid age.");
    }

    @Test
    public void testStudentAgeInvalidCharacter() {
        System.out.println("Running testStudentAgeInvalidCharacter...");
        assertEquals(-1, Student.getValidAge("abc"));
        System.out.println("Verified invalid character input.");
    }
}