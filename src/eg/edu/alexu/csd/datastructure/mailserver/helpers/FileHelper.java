package eg.edu.alexu.csd.datastructure.mailserver.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eg.edu.alexu.csd.datastructure.mailserver.models.contact.Contact;
import eg.edu.alexu.csd.datastructure.mailserver.models.contact.Contacts;
import eg.edu.alexu.csd.datastructure.mailserver.models.email.Mail;
import eg.edu.alexu.csd.datastructure.mailserver.models.email.Mails;
import eg.edu.alexu.csd.datastructure.mailserver.models.folder.Files;
import eg.edu.alexu.csd.datastructure.mailserver.models.folder.IFolder;
import eg.edu.alexu.csd.datastructure.mailserver.useddatastructures.linkedlists.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.mailserver.useddatastructures.linkedlists.ILinkedList;

import java.io.*;

public class FileHelper {
    public ILinkedList getContacts() {
        File file = new File("DataStructureProject/Contacts.json");
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
            }
            bufferedReader.close();
        } catch (Exception e) {
            stringBuilder = new StringBuilder();
        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Contacts contacts = gson.fromJson(stringBuilder.toString(), Contacts.class);
        return contactsArrToList(contacts.getContacts());
    }

    private ILinkedList contactsArrToList(Contact[] contacts) {
        ILinkedList list = new DoubleLinkedList();
        for (int i = 0; i < contacts.length; i++) {
            list.add(contacts[i]);
        }
        return list;
    }

    private ILinkedList filesArrToList(Object[] files) {
        ILinkedList list = new DoubleLinkedList();
        for (int i = 0; i < files.length; i++) {
            list.add(files[i]);
        }
        return list;
    }

    private ILinkedList mailsArrToList(Mail[] mails) {
        ILinkedList list = new DoubleLinkedList();
        for (int i = 0; i < mails.length; i++) {
            list.add(mails[i]);
        }
        return list;
    }

    public void setContacts (ILinkedList contacts) {
        Contacts writeObj = new Contacts();
        writeObj.setContacts(listToArray(contacts));
        File file = new File("Contacts.json");
        Gson gson = new Gson();
        String jsonString = gson.toJson(writeObj);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(jsonString);
            writer.close();
        } catch (Exception e) {

        }
    }

    private Contact[] listToArray(ILinkedList contacts) {
        Contact[] contactsArr = new Contact[contacts.size()];
        for (int i = 0; i < contacts.size(); i++) {
            contactsArr[i] = (Contact) contacts.get(i);
        }
        return contactsArr;
    }

    public ILinkedList getFolders (String userName) {
        return null;
    }

    public ILinkedList getFiles (IFolder folder) {
        File indexes = new File("indexes.json");
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(indexes));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
            }
            bufferedReader.close();
        } catch (Exception e) {
            stringBuilder = new StringBuilder();
        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Files files = gson.fromJson(stringBuilder.toString(), Files.class);
        return filesArrToList(files.getFiles());
    }

    public ILinkedList getMails(String username, IFolder folder) {
        File indexes = new File(username + "/" + folder.getPathName() + "/indexes.json");
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(indexes));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
            }
            bufferedReader.close();
        } catch (Exception e) {
            stringBuilder = new StringBuilder();
        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Mails mails = gson.fromJson(stringBuilder.toString(), Mails.class);
        return mailsArrToList(mails.getMails());
    }

}
