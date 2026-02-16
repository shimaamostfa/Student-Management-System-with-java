import java.util.ArrayList;

public class Student extends Person {
    private int attendanceCount;
    private ArrayList<Integer> addCoursesId;

    public Student() {
    }

    public Student(String name, int id) {
        super(name, id);
        this.attendanceCount = 0;
        this.addCoursesId = new ArrayList<>();

    }

    public void AttendanceCount() {
        this.attendanceCount++;
        System.out.println("Attendance recorded for student " + getName());
    }

    public void addCourse(int courseId) {
        addCoursesId.add(courseId);
    }

    public ArrayList<Integer> getAddCourses() {
        return addCoursesId;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId()  + " Name: " + getName());
        System.out.println("Attendance count: " + attendanceCount + " add courses: " + addCoursesId);
    }


}
