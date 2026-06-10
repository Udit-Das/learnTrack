package com.airtribe.learnTrack;

import com.airtribe.learnTrack.entity.Course;
import com.airtribe.learnTrack.entity.Enrollment;
import com.airtribe.learnTrack.entity.Student;
import com.airtribe.learnTrack.repository.StudentRepository;
import com.airtribe.learnTrack.service.CourseService;
import com.airtribe.learnTrack.service.EnrollmentService;
import com.airtribe.learnTrack.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add new student");
            System.out.println("2. View all students");
            System.out.println("3. Search student by ID");
            System.out.println("4. Deactivate a student");
            System.out.println("5. Add new course");
            System.out.println("6. View all courses");
            System.out.println("7. Activate/Deactivate a course");
            System.out.println("8. Enroll a student in a course");
            System.out.println("9. View enrollments for a student");
            System.out.println("10. Mark enrollment as completed/cancelled");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter batch: ");
                    String batch = scanner.nextLine();
                    studentService.addStudent(new Student(firstName, lastName, batch, true));
                    break;

                case 2:
                    studentService.listStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    Student student = studentService.getStudentById(studentId);
                    if (student != null) {
                        System.out.println("Student found: " + student.getFirstName() + " " + student.getLastName());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to deactivate: ");
                    int deactivateId = scanner.nextInt();
                    studentService.updateStudent(deactivateId, null, false);
                    break;

                case 5:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    String courseDescription = scanner.nextLine();
                    String durationInWeeks = scanner.nextLine();
                    boolean isActive = true;

                    courseService.addCourse(new Course(courseName, courseDescription, durationInWeeks, isActive));
                    break;

                case 6:
                    courseService.displayCourseList();
                    break;

                case 7:
                    System.out.print("Enter course ID: ");
                    int courseId = scanner.nextInt();
                    System.out.print("Activate (true) or Deactivate (false): ");
                    boolean courseIsActive = scanner.nextBoolean();
                    courseService.updateCourse(courseId, courseIsActive);
                    break;

                case 8:
                    System.out.print("Enter student ID: ");
                    int enrollStudentId = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int enrollCourseId = scanner.nextInt();
                    System.out.print("Enter enrollment date (YYYY-MM-DD): ");
                    String enrollmentDate = scanner.next();
                    enrollmentService.enrollStudent(enrollStudentId, enrollCourseId, enrollmentDate);
                    break;

                case 9:
                    System.out.print("Enter student ID: ");
                    int viewEnrollmentsStudentId = scanner.nextInt();
                    enrollmentService.viewEnrollmentsForStudent(viewEnrollmentsStudentId);
                    break;

                case 10:
                    System.out.print("Enter enrollment ID : ");
                    int enrollmentId = scanner.nextInt();
                    System.out.print("Enter new status (COMPLETED/CANCELLED): ");
                    String status = scanner.next().toUpperCase();
                    enrollmentService.updateEnrollmentStatus(enrollmentId, Enrollment.enrollmentStatus.valueOf(status));
                    break;

                case 0:
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }
}