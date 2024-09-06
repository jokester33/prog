import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getters
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    // StudentDetails Method
    public String displayDetails() {
        return "ID: " + id +
                "\nName: " + name +
                "\nAge: " + age +
                "\nEmail: " + email +
                "\nCourse: " + course;
    }

    // Repository for managing students
    private static final List<Student> students = new ArrayList<>();

    // SaveStudentMethod
    public static void saveStudent(String id, String name, int age, String email, String course) {
        Student student = new Student(id, name, age, email, course);
        students.add(student);
    }

    // SearchStudentMethod
    public static Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // DeleteStudent Method
    public static boolean deleteStudent(String id) {
        Student student = searchStudent(id);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    // StudentReport(print) Method
    public static void printStudentReport() {
        for (Student student : students) {
            System.out.println(student.displayDetails());
            System.out.println("------------");
        }
    }

    // ValidateStudentAge Method
    public static int getValidAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);
            if (age >= 16) {
                return age;
            }
        } catch (NumberFormatException e) {

        }
        return -1;
    }

    // ExitStudentApllication Method
    public static void exitStudentApplication() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    // Getting all the  students (for testing )
    public static List<Student> getAllStudents() {
        return students;
    }
}
