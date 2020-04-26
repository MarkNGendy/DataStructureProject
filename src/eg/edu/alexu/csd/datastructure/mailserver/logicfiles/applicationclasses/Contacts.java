package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;

public class Contacts {
    private Contact[] contacts;

    public Contacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    public Contacts() {

    }

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }
}
