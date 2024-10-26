package labcodeinspection;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class for the Email application.
 * Prompts the user for input to create and display an email.
 */
public class EmailApp {

    // Logger instance for logging output
    private static final Logger logger = Logger.getLogger(EmailApp.class.getName());

    /**
     * Private constructor to prevent instantiation.
     */
    private EmailApp() {
        // Prevent instantiation
    }

    /**
     * Main method to run the Email application.
     *
     * @param args command line arguments (not used).
     */
    public static void main(final String[] args) {
        // Try-with-resources to ensure Scanner is closed properly
        try (Scanner scanner = new Scanner(System.in)) {

            // Get user input for first name
            System.out.print("Enter your first name: ");
            final String firstName = scanner.nextLine();

            // Get user input for last name
            System.out.print("Enter your last name: ");
            final String lastName = scanner.nextLine();

            // Display department choices and get department code
            System.out.print("\nDEPARTMENT CODE\n1. for Sales\n2. for Development\n3. for Accounting\nEnter code: ");
            int depChoice = 0;

            try {
                if (scanner.hasNextInt()) {
                    depChoice = scanner.nextInt();
                } else {
                    logger.warning("Invalid input, defaulting to no department.");
                }
            } catch (InputMismatchException e) {
                logger.log(Level.WARNING, "Input mismatch, defaulting to no department.", e);
            }

            // Create email and set department
            final Email email = new Email(firstName, lastName);
            email.setDepartment(depChoice);

            // Generate email and display info
            email.generateEmail();
            email.showInfo();
            
        } catch (Exception e) {
            // Avoid catching generic Exception, but providing a specific logging message
            logger.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
}