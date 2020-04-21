package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationinterfaces;


import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses.Contact;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.ILinkedList;

public interface IContact {
    public boolean search(Contact contact, ILinkedList contacts);

}
