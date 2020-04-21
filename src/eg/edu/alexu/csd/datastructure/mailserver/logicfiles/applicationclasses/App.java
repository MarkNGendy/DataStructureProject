package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationinterfaces.*;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.ILinkedList;

public class App implements IApp {
    ILinkedList contacts = new DoubleLinkedList();
    @Override
    public boolean signin(String email, String password) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Contact[] contacts = gson.fromJson()
        return false;
    }

    @Override
    public boolean signup(IContact contact) {
    	if(contact.search(contact,contacts))
    	{
    		return false;
    	}
    	else
    	{
    		contacts.add(contact);
    	}

        return true;
    }

    @Override
    public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {

    }

    @Override
    public IMail[] listEmails(int page) {
        return new IMail[0];
    }

    @Override
    public void deleteEmails(ILinkedList mails) {

    }

    @Override
    public void moveEmails(ILinkedList mails, IFolder des) {

    }

    @Override
    public boolean compose(IMail email) {
        return false;
    }
}
