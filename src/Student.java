public class Student extends Person {


    private int grade;


    public Student(String firstName, String lastName, String phone, int grade) {
        super(firstName, lastName, phone);
        this.grade = grade;
    }


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

