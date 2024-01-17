public class Student extends Person {

    private int grade;
    // Constructor that takes in all Person data and Subject then calls super and sets subject
    public Student(String firstName, String lastName, String phone, int grade) {
        super(firstName, lastName, phone);
        this.grade = grade;
    }
    // Getter and setter for grade
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}

