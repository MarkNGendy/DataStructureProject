package eg.edu.alexu.csd.datastructure.mailserver;

import eg.edu.alexu.csd.datastructure.mailserver.app.App;
import eg.edu.alexu.csd.datastructure.mailserver.models.contact.Contact;
import eg.edu.alexu.csd.datastructure.mailserver.models.email.IMail;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Welcome to mail server!");
        while (true) {
            System.out.println("Click 1: to login to your email!");
            System.out.println("Click 2: to create a new email!");
            Scanner scanner = new Scanner(System.in);
            int action = scanner.nextInt();
            if (action == 1) { // login
                login(app, scanner);
            } else if (action == 2) {
                signup(app, scanner);
            } else {
                System.out.println("Incorrect action, Please try again!");
            }
        }
    }

    private static void login(App app, Scanner scanner) {
        System.out.println("Enter Email Address: ");
        String email = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();
        if (app.signin(email, password)) {
            actInsideEmail(email, app, scanner);
        } else {
            System.out.println("Invalid email or password, please try again");
            return;
        }
    }

    private static void signup(App app, Scanner scanner) {
        System.out.println("Enter New Email Address: ");
        String email = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();
        System.out.println("Confirm Password: ");
        String confirmPassword = scanner.next();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords don't match, please try again!");
            return;
        }

        if (app.signup(new Contact(email, password))) {
            System.out.println("Email created successfully, you can now login to your email!");
        } else {
            System.out.println("Invalid email or password, please try again");
        }
    }

    private static void actInsideEmail(String email, App app, Scanner scanner) {
        System.out.println("Welcome to your email, " + email);
        int currPage = 1;
        // show default view
        while (true) {
            IMail[] emails = app.listEmails(currPage);
            printEmails(emails);
            System.out.println("Click 1: to compose a new email!");
            System.out.println("Click 2: to move to next or previous pages in the same folder with the same sorting and filtering!");
            System.out.println("Click 3: to change current folder, sorting or filtering!");
            System.out.println("Click 4: to open a specific email!");
            System.out.println("Click 5: to select multiple emails!");
            System.out.println("Click 6: to create a new user folder!");
            System.out.println("Click 7: to delete a user folder!");
            System.out.println("Click 8: to rename a user folder!");
            System.out.println("Click 9: to signout!");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    break;
                case 2:
                    int page = paginate(app, scanner, currPage);
                    if (page != -1) {
                        currPage = page;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    app.signout();
                    return;
                default:
                    System.out.println("Action undefined, please try again!");
            }
        }
    }

    private static void printEmails(IMail[] emails) {
        for (IMail mail : emails) {
            System.out.println("Subject: " + mail.getSubject() +
                            ", Sender: " + mail.getSender() +
                            ", Receiver: " + mail.getReciever() +
                            ", Date: " + mail.getDate()
                    );
        }
    }

    private static int paginate(App app, Scanner scanner, int currPage) {
        System.out.println("Click 1: to move to previous page in the same folder with the same sorting and filtering!");
        System.out.println("Click 2: to move to next page in the same folder with the same sorting and filtering!");
        int action = scanner.nextInt();
        if (action == 1) {
            return currPage - 1;
        } else if (action == 2) {
            return currPage + 1;
        }
        System.out.println("Invalid action!");
        return -1;
    }
}

// compose and send to multiple
// mark multiple emails to move them, delete them
// open specific email
// change folder
// change sort and filter
// create or delete folder