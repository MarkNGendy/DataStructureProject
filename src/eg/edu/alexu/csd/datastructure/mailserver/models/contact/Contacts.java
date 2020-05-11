package eg.edu.alexu.csd.datastructure.mailserver.models.contact;


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
