public class Athlete extends Person {

    private String sport;

    // Constructor that takes in all Person data and sport then calls super and sets sport
    public Athlete(String firstName, String lastName, String phone, String sport) {
        super(firstName, lastName, phone);
        this.sport = sport;
    }

    // Getter and Setter for sport
    public String geSsport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return super.toString() + " Sport: " + sport;
    }
}

