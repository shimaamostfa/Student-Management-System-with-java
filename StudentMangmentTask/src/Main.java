import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Instructor> instructors = new ArrayList<>();
    static ArrayList<Courses> courses = new ArrayList<>();
    static ArrayList<Grades> grades = new ArrayList<>();

    public static void main(String[] args) {
        while(true){
            System.out.println("\n--- Student Management System ---\n");
            System.out.println("1. Add Student     2. Add Instructor       3. Add Courses");
            System.out.println("4. List All        5. Record Attendance    6. Record Grades");
            System.out.println("7. Delete Student  8. Exit");
            System.out.println("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: addStudent();
                break;
                case 2: addInstructor();
                break;
                case 3: addCourses();
                break;
                case 4: listAll();
                break;
                case 5: recordAttendance();
                break;
                case 6: recordGrade();
                break;
                case 7: deleteStudent();
                break;
                case 0: System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    static void addStudent(){
        System.out.println("Enter Student Name: ");
        String name = input.nextLine();
        System.out.println("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();
        students.add(new Student(name,id));
        System.out.println("Student added successfully");
    }
    static void addInstructor(){
        System.out.println("Enter Instructor Name: ");
        String name = input.nextLine();
        System.out.println("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter Department: ");
        String department = input.nextLine();
        instructors.add(new Instructor(name,id,department));
        System.out.println("Student added successfully");

    }
    static void addCourses(){
        System.out.println("Enter Courses Name: ");
        String name = input.nextLine();
        System.out.println("Enter Courses ID: ");
        int id = input.nextInt();
        input.nextLine();
        courses.add(new Courses(id,name));
        System.out.println("Courses added successfully");

    }
    static void listAll(){
        System.out.println("\n Student List \n");

        for(Student s: students){
            s.displayInfo();
            System.out.println(" Grades & courses:");
            boolean hasGrades = false;
            for (Grades g: grades){
                if(g.getStudentId() == s.getId()){
                    String courseName = "Unknown Courses (ID: " + g.getCourseId() + ")";
                    for (Courses courses: courses){
                        if(courses.getCourseName().equals(courseName)){
                            courseName = courses.getCourseName();
                            break;
                        }
                    }

                    System.out.println(" Courses: " + courseName + "Grade: " + g.getGrade());
                    hasGrades = true;
                }
            }
            if(!hasGrades){
                System.out.println(" No Grades Found");
            }
            System.out.println("-----------------------------------");
            System.out.println("\n Instructor List \n");
            for(Instructor instructor: instructors){
                instructor.displayInfo();
            }
        }
    }
    static void recordAttendance(){
        System.out.println("Enter Student ID to record Attendance: ");
        int id = input.nextInt();
        input.nextLine();

        boolean found = false;
        for(Student s: students){
            if(s.getId() == id){
                s.AttendanceCount();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Invalid Student ID");
        }

    }
    static void recordGrade(){
        System.out.println("Enter Student ID to record Grade: ");
        int studentId = input.nextInt();
        System.out.println("Enter Courses ID to record Grade: ");
        int courseId = input.nextInt();
        System.out.println("Enter Score: ");
        double score = input.nextDouble();
        input.nextLine();

        grades.add(new Grades(studentId,courseId,score));

        for (Student s: students){
            if(s.getId() == studentId){
                s.addCourse(courseId);
            }
        }
        System.out.println("Grade recorded successfully");
    }
    static void deleteStudent(){
        System.out.println("Enter Student ID to delete: ");
        int studentId = input.nextInt();
        input.nextLine();

        boolean removed = students.removeIf(s -> s.getId() == studentId);

        if(removed){
            System.out.println("Student deleted successfully");
        }
        else{
            System.out.println("Student not found");
        }


    }
}