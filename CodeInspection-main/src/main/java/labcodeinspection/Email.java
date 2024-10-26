package labcodeinspection;

import java.util.Locale;
import java.util.Random;

/**
 * Class representing an Email for an employee.
 */
public class Email {

    /** First name of the employee. */
    private final String firstName;

    /** Last name of the employee. */
    private final String lastName;

    /** Password for the email account. */
    private String password;

    /** Department of the employee. */
    private String department;

    /** Default length for generated passwords. */
    private static final int DEFAULT_PASSWORD_LENGTH = 8;

    /** Email address for the employee. */
    private String emailAddress;

    /**
     * Constructor for Email class.
     * 
     * @param firstName First name of the employee. Must not be null or empty.
     * @param lastName  Last name of the employee. Must not be null or empty.
     */
    public Email(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Displays the email information for the employee.
     * This includes the first name, last name, department, email, and password.
     */
    public void showInfo() {
        System.out.println("\nFIRST NAME= " + firstName);
        System.out.println("LAST NAME= " + lastName);
        System.out.println("DEPARTMENT= " + department);
        System.out.println("EMAIL= " + emailAddress);
        System.out.println("PASSWORD= " + password);
    }

    /**
     * Sets the department based on user input.
     * 
     * @param depChoice Integer representing the department choice.
     *                  1 for Sales, 2 for Development, 3 for Accounting.
     */
    public void setDepartment(final int depChoice) {
        switch (depChoice) {
            case 1:
                this.department = "sales";
                break;
            case 2:
                this.department = "dev";
                break;
            case 3:
                this.department = "acct";
                break;
            default:
                this.department = "undefined";
                break;
        }
    }

    /**
     * Generates a random password using a specific character set.
     * 
     * @param length The length of the password to generate.
     * @return The generated random password as a String.
     */
    private String randomPassword(final int length) {
        final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
        final char[] password = new char[length];
        final Random random = new Random();
        for (int i = 0; i < length; i++) {
            final int rand = random.nextInt(set.length());
            password[i] = set.charAt(rand);
        }
        return new String(password);
    }

    /**
     * Generates an email using the first name, last name, and department.
     */
    public void generateEmail() {
        this.password = this.randomPassword(DEFAULT_PASSWORD_LENGTH);
        this.emailAddress = this.firstName.toLowerCase(Locale.ENGLISH) + this.lastName.toLowerCase(Locale.ENGLISH) + "@"
                + this.department + ".espol.edu.ec";
    }
}
