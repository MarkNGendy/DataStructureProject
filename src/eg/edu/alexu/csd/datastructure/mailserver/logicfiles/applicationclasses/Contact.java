package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;

import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationinterfaces.IContact;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.DoubleLinkedList;

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
    public boolean search(Contact contact, DoubleLinkedList contacts) {
        boolean isFound = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contact.emailAdd.equals(contacts.get(i).emailAdd) && contact.pass.equals(contacts.get(i).pass)) {
                isFound = true;
            }
        }
        return isFound;
    }
}
