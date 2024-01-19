
import java.util.ArrayList;
import java.util.Scanner;

//By Noah Persily

public class ContactList {

    public static final int SORT_BY_FIRST_NAME = 2;
    public static final int SORT_BY_LAST_NAME = 3;
    public static final int SORT_BY_PHONE = 4;
    public static final int SEARCH_BY_FIRST_NAME = 6;
    public static final int SEARCH_BY_LAST_NAME = 7;
    public static final int SEARCH_BY_PHONE = 8;
    private ArrayList<Person> contacts;
    private Scanner input;

    public ContactList() {
        contacts = new ArrayList<Person>();
        input = new Scanner(System.in);
    }

    // Getter
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Always prints those instructions
    public static void printInstructions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By Phone Number");
        System.out.println(("0. Exit"));
    }
    //Runs all methods in desired order
    public void run() {

        boolean condition = true;
        while (condition) {
            // Print instructions and get input
            printInstructions();
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                // If input is 0 break out of the while loop
                case (0):
                    condition = false;
                    break;
                // If one add a contact
                case (1):
                    addContact();
                    break;
                // If 2 3 or 4 sort by that quality    
                case (SORT_BY_FIRST_NAME):
                    listBy(SORT_BY_FIRST_NAME);
                    break;
                case (SORT_BY_LAST_NAME):
                    listBy(SORT_BY_LAST_NAME);
                    break;
                case (SORT_BY_PHONE):
                    listBy(SORT_BY_PHONE);
                    break;
                // If 5 print students    
                case (5):
                    printStudents();
                    break;
                // If 6    
                case (SEARCH_BY_FIRST_NAME):
                    // Get the name they want to search by
                    System.out.println("Enter a First Name: ");
                    String firstNameWanted = input.nextLine();
                    // Search for that person and get a pointer
                    Person temp1 = searchBy(SEARCH_BY_FIRST_NAME, firstNameWanted);
                    // If that person exists print them
                    if (!(temp1 == null)) {
                        System.out.println(temp1);
                        break;
                    }
                    // Else signify that they do not exist and break
                    System.out.println("No Such Person has been added");
                    break;
                case (SEARCH_BY_LAST_NAME):
                    // Same as above but with last name
                    System.out.println("Enter a Last Name: ");
                    String lastNameWanted = input.nextLine();
                    Person temp2 = searchBy(SEARCH_BY_LAST_NAME, lastNameWanted);
                    if (!(temp2 == null)) {
                        System.out.println(temp2);
                        break;
                    }
                    System.out.println("No Such Person has been added");
                    break;
                case (SEARCH_BY_PHONE):
                    // Same as above but with phone number
                    System.out.println("Enter a Phone Number: ");
                    String phoneWanted = input.nextLine();
                    Person temp3 = searchBy(SEARCH_BY_PHONE, phoneWanted);
                    if (!(temp3 == null)) {
                        System.out.println(temp3);
                        break;
                    }
                    System.out.println("No Such Person has been added");
                    break;
            }
        }
    }

    public void addContact() {
        // Determine the type of person
        System.out.println("Select what type of person to add");
        System.out.println("1. Add Student ");
        System.out.println("2. Add Athlete");
        int choice = input.nextInt();
        input.nextLine();
        //Ask general questions that apply to all types of people
        System.out.println("Please fill in the following instructions");
        System.out.println("First Name :");
        String fname = input.nextLine();
        System.out.println("Last Name");
        String lname = input.nextLine();
        System.out.println("Phone Number: ");
        String phone = input.nextLine();
        // Depending on the type of person chosen
        if (choice == 1) {
            // Ask about grade
            System.out.println("Grade: ");
            int grade = input.nextInt();
            input.nextLine();
            // Create new Person
            Person p = new Student(fname, lname, phone, grade);
            // Add to list
            contacts.add(p);
        } else {
            // Same as above but with Sport/**/
            System.out.println("Sport: ");
            String sport = input.nextLine();
            Person p = new Athlete(fname, lname, phone, sport);
            contacts.add(p);
        }
    }

    // Prints only students
    public void printStudents() {
        for (Person p : contacts) {
            if (p instanceof Student) {
                System.out.println(p);
            }
        }
    }

    // Prints the entire list
    public void printList() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    // Bubble sort algorithm that sort by given quality, and then prints the sorted list
    public void listBy(int sortBy) {
        // Switch based on the quality you want to sort by
        switch (sortBy) {
            case (SORT_BY_FIRST_NAME):
                // For each person in contacts
                for (int i = 0; i < contacts.size(); i++) {
                    // For each unsorted person
                    for (int j = 0; j < contacts.size() - i - 1; j++) {
                        // If the current person's first name is lexographically lower than the next person
                        if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                            // Swap them
                            swap(j);
                        }
                    }
                }
                break;
            case (SORT_BY_LAST_NAME):
                //same as above but with last name
                for (int i = 0; i < contacts.size(); i++) {
                    for (int j = 0; j < contacts.size() - i - 1; j++) {
                        if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                            swap(j);
                        }
                    }
                }
                break;
            case (SORT_BY_PHONE):
                //same as above but with phone number
                for (int i = 0; i < contacts.size(); i++) {
                    for (int j = 0; j < contacts.size() - i - 1; j++) {
                        if (contacts.get(j).getPhone().compareTo(contacts.get(j + 1).getPhone()) > 0) {
                            swap(j);
                        }
                    }
                }
        }
        printList();
    }

    // Swaps the contact at the given index with the contact ahead of it
    public void swap(int index) {

        Person temp = contacts.get(index);
        contacts.set(index, contacts.get(index + 1));
        contacts.set(index + 1, temp);

    }

    // Linear searching method that returns a person
    public Person searchBy(int searchBy, String match) {
        // Switch based on what quality you want to search by
        switch (searchBy) {
            // Return that person
            case (SEARCH_BY_FIRST_NAME):
                // For each person in the list
                for (Person p : contacts) {
                    // If the current person's first name is the same as the parameter
                    if (p.getFirstName().equals(match)) {
                        // Return that person
                        return p;
                    }
                }
                break;
            case (SEARCH_BY_LAST_NAME):
                // Same as above but with last name
                for (Person p : contacts) {
                    if (p.getLastName().equals(match)) {
                        return p;
                    }
                }
                break;
            case (SEARCH_BY_PHONE):
                // Same as above but with phone number
                for (Person p : contacts) {
                    if (p.getPhone().equals(match)) {
                        return p;
                    }
                }
                break;
        }
        return null;
    }

    // Main function
    public static void main(String[] args) {
        ContactList c = new ContactList();
        c.run();
    }
}

