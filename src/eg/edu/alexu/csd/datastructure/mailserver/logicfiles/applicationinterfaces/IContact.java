package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationinterfaces;


import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses.Contact;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.DoubleLinkedList;

public interface IContact {
    public boolean search(Contact contact, DoubleLinkedList contacts);

}
