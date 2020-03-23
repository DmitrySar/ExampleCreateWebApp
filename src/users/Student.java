package users;

public class Student {

    private int id;
    private String name;
    private int age;
    private int groupNumber;

    public Student(String name, int age, int groupNumber) {
        this.name = name;
        this.age = age;
        this.groupNumber = groupNumber;
    }

    public Student(int id, String name, int age, int groupNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.groupNumber = groupNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGroupNumber() {
        return groupNumber;
    }
}
