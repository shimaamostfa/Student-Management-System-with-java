public class Person {
    private String name;
    private int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public void displayInfo(){
        System.out.println("ID: " + id + " Name: " + name);
    }



}
