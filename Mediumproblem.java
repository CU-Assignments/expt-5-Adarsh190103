import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

public class StudentSerialization {

    public static void main(String[] args) {
        Student student = new Student(1, "John Doe", 3.75);
        String filename = "student.ser";

        try {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
                out.writeObject(student);
            }

            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
                Student deserializedStudent = (Student) in.readObject();
                System.out.println(deserializedStudent);
            }
        } catch (FileNotFoundException | IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
