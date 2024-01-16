
import java.util.ArrayList;
import java.util.Scanner;

//By Noah Persily
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ContactList {

    private ArrayList<Person> contacts;
    private Scanner input;
    public ContactList() {
        contacts = new ArrayList<Person>();
        input = new Scanner(System.in);
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

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

    public void run() {
        boolean condition = true;
        while (condition) {
            printInstructions();
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case (0):
                    condition = false;
                    break;
                case (1):
                    addContact();
                case (2):
                    listBy(2);
                    break;
                case (3):
                    listBy(3);
                    break;
                case (4):
                    listBy(4);
                    break;
                case (5):
                    printStudents();
                case (6):

                case (7):

                case (8):

            }
        }
    }

    public void addContact() {
        System.out.println("Select what type of person to add");
        System.out.println("1. Add Student ");
        System.out.println("2. Add Teacher");
        int choice = input.nextInt();
        input.nextLine();

        System.out.println("Please fill in the following instructions");
        System.out.println("First Name :");
        String fname = input.nextLine();
        System.out.println("Last Name");
        String lname = input.nextLine();
        System.out.println("Phone Number: ");
        String phone = input.nextLine();
        if (choice == 1) {
            System.out.println("Grade: ");
            int grade = input.nextInt();
            input.nextLine();
            Person p = new Student(fname, lname, phone, grade);
            contacts.add(p);
        } else {
            System.out.println("Subject: ");
            String subject = input.nextLine();
            Person p = new Teacher(fname, lname, phone, subject);
            contacts.add(p);
        }

    }

    public void printStudents() {

        for (Person p : contacts) {
            if (p instanceof Student) {
                System.out.println(p);
            }
        }
    }

    public void printList() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    public void listBy(int sortBy) {

        // Bubble sort
        int swapCounter = 0;
        while (swapCounter > 0) {
            swapCounter = 0;
            for (int i = 0; i < contacts.size() - 1; i++) {

                switch (sortBy) {
                    case (2):
                        if (contacts.get(i).getFirstName().compareTo(contacts.get(i + 1).getFirstName()) > 0) {
                            swap(i);
                            swapCounter += 1;
                        }
                    case (3):
                        if (contacts.get(i).getLastName().compareTo(contacts.get(i + 1).getLastName()) > 0) {
                            swap(i);
                            swapCounter += 1;
                        }
                    case (4):
                        if (contacts.get(i).getPhone().compareTo(contacts.get(i + 1).getPhone()) > 0) {
                            swap(i);
                            swapCounter += 1;
                        }
                }

            }

        }
        printList();
    }

    public void swap(int index) {
        Person temp = contacts.get(index);
        contacts.set(index, contacts.get(index + 1));
        contacts.set(index + 1, temp);

    }

    public static void main(String[] args) {
        ContactList c = new ContactList();
        c.run();
    }
}

