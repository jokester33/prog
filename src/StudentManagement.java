import java.util.Scanner;

public class StudentManagement {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        management.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.print("Press 'i' to display the menu or 'q' to quit: ");
            String input = scanner.nextLine();

            if ("i".equalsIgnoreCase(input)) {
                displayMenu();
                int choice = getValidChoice();

                switch (choice) {
                    case 1:
                        saveStudent();
                        break;
                    case 2:
                        searchStudent();
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        printStudentReport();
                        break;
                    case 5:
                        Student.exitStudentApplication();
                        running = false; // Stop loop
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else if ("q".equalsIgnoreCase(input)) {
                Student.exitStudentApplication();
                running = false;
            }
        }
    }

    private void displayMenu() {
        System.out.println("Student Management Menu");
        System.out.println("1. Capture a new Student");
        System.out.println("2. Search for a Student");
        System.out.println("3. Delete a Student");
        System.out.println("4. Print a Student report");
        System.out.println("5. Exit");
        System.out.println("Please select an option:");
    }

    private int getValidChoice() {
        int choice = -1;
        boolean valid = false;

        while (!valid) {
            String input = scanner.nextLine();
            if (input.matches("[1-5]")) {
                choice = Integer.parseInt(input);
                valid = true;
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        return choice;
    }

    private void saveStudent() {
        System.out.println("Please enter Student ID:");
        String id = scanner.nextLine();

        System.out.println("Enter the student's name:");
        String name = scanner.nextLine();

        int age = 0;
        while (age < 16) {
            System.out.println("Enter the student's age (must be 16 or older):");
            age = Student.getValidAge(scanner.nextLine());
            if (age < 16) {
                System.out.println("Invalid age try again(!!important Age must be higher than 16 or equal to it:");
            }
        }

        System.out.print("Enter Student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Student course: ");
        String course = scanner.nextLine();

        Student.saveStudent(id, name, age, email, course);
        System.out.println("Student captured successfully.");
    }

    private void searchStudent() {
        System.out.print("Enter the ID of the Student you wish to search for: ");
        String id = scanner.nextLine();

        Student student = Student.searchStudent(id);
        if (student != null) {
            System.out.println(student.displayDetails());
        } else {
            System.out.println("Student with ID " + id + " was not found.");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter the ID of the Student you intend  to delete: ");
        String id = scanner.nextLine();

        boolean success = Student.deleteStudent(id);
        if (success) {
            System.out.println("Student with ID " + id + " was deleted.");
        } else {
            System.out.println("Student with ID " + id + " was not found.");
        }
    }

    private void printStudentReport() {
        System.out.println("Student Report");
        Student.printStudentReport();
    }

    private void exitStudentApplication() {
        Student.exitStudentApplication();
    }
}

