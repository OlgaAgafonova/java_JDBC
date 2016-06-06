package examples;

public class User {
    private final int id;
    private final String name;
    private final int age;
    private final String email;

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(String name, String email) {
        this.id = 0;
        this.name = name;
        this.age = 0;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%3d %-15s %-3d %-1s", id, name, age, email);
    }
}
