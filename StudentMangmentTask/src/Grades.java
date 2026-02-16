public class Grades {
    private int studentId;
    private int courseId;
    private double grade;

    public Grades(int studentId, int courseId, double grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }
    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public double getGrade() {
        return grade;
    }
}
