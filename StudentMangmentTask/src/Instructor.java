public class Instructor extends Person {
    private String department;
    public Instructor(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }
    @Override
    public void displayInfo() {
        System.out.println("[Instructor] ID: " + getId() + " Name: " + getName() + " Department: " + department);
    }
}
