package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationinterfaces.*;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.ILinkedList;

import java.io.*;
import java.lang.reflect.Type;


public class App implements IApp {
    ILinkedList contacts = new DoubleLinkedList();
    @Override
    public boolean signin(String email, String password) throws IOException {
        arrayToList(readJSON(), contacts);
        IContact contact = new Contact(email, password);
        return contact.search((Contact) contact, contacts);
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
    public void arrayToList (Object[] arr, ILinkedList list) {
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
    }
    private Contact[] readJSON() throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        File file = new File("Contacts.json");
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            stringBuilder.append(s);
        }
        System.out.println(stringBuilder.toString());
        Contact[] contactsArr = gson.fromJson(stringBuilder.toString(), (Type) Contact.class);
        return contactsArr;
    }

    public static void main(String[] args) throws IOException {
        App e = new App();
        System.out.println(e.signin("7amada@gmail.com", "sanjone"));
    }
}
