public class Teacher extends Person {

    private String subject;
    // Constructor that takes in all Person data and Subject then calls super and sets subject
    public Teacher(String firstName, String lastName, String phone, String subject) {
        super(firstName, lastName, phone);
        this.subject = subject;
    }
    // Getter and Setter for Subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + " Subject: " + subject;
    }
}

