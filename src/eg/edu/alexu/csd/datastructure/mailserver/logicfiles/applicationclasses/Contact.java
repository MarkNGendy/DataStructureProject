package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;

import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationinterfaces.IContact;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.ILinkedList;

public class Contact implements IContact {
    public static String emailAdd;
    public static String contactName;
    public static String pass;

    public Contact(String emailAdd, String pass, String contactName) {
        this.emailAdd = emailAdd;
        this.contactName = contactName;
        this.pass = pass;
    }

    public Contact(String emailAdd, String pass) {
        this.emailAdd = emailAdd;
        this.pass = pass;
    }

    @Override
    public boolean search(Contact contact, ILinkedList contacts) {
        boolean isFound = false;
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact1 = (Contact) contacts.get(i);
            if (contact.emailAdd.equals(contact1.emailAdd) && contact.pass.equals(contact1.pass)) {
                isFound = true;
            }
        }
        return isFound;
    }
}
