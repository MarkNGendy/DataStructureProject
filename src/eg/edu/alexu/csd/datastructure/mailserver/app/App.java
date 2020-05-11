package eg.edu.alexu.csd.datastructure.mailserver.app;

import eg.edu.alexu.csd.datastructure.mailserver.helpers.FileHelper;
import eg.edu.alexu.csd.datastructure.mailserver.logic.filter.AllFilter;
import eg.edu.alexu.csd.datastructure.mailserver.logic.filter.IFilter;
import eg.edu.alexu.csd.datastructure.mailserver.logic.sort.DateSort;
import eg.edu.alexu.csd.datastructure.mailserver.logic.sort.ISort;
import eg.edu.alexu.csd.datastructure.mailserver.models.contact.IContact;
import eg.edu.alexu.csd.datastructure.mailserver.models.email.IMail;
import eg.edu.alexu.csd.datastructure.mailserver.models.folder.IFolder;
import eg.edu.alexu.csd.datastructure.mailserver.useddatastructures.linkedlists.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.mailserver.useddatastructures.linkedlists.ILinkedList;

public class App implements IApp {

    private ILinkedList contacts;
    private IContact contact;
    private FileHelper fileHelper;
    private ILinkedList mails;

    private ISort sort;
    private IFilter filter;

    private int pageSize = 10;

    public App() {
        // fill contacts list
        fileHelper = new FileHelper();
        contacts = fileHelper.getContacts();
    }

    @Override
    public boolean signin(String email, String password) {
        for (int i = 0; i < contacts.size(); i++) {
            IContact contact = (IContact) contacts.get(i);
            if (contact.getEmail().equalsIgnoreCase(email) && contact.getPassword().equals(password)) {
                this.contact = contact;
                this.filter = new AllFilter();
                this.sort = new DateSort(false);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean signup(IContact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            IContact currContact = (IContact) contacts.get(i);
            if (contact.getEmail().equalsIgnoreCase(currContact.getEmail())) {
                return false;
            }
        }
        contacts.add(contact);
        fileHelper.setContacts(contacts);
        return true;
    }

    @Override
    public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
        if (folder == null) {
            return;
        }
        ILinkedList allMails = fileHelper.getMails(contact.getUserName(), folder);
        mails = new DoubleLinkedList();
        if (filter != null) {
            for (int i = 0; i < allMails.size(); i++) {
                if (filter.matches((IMail) allMails.get(i))) {
                    mails.add(allMails.get(i));
                }
            }
            if (sort != null) {
                sort.sort(mails);
            }
        } else if (sort != null) {
            sort.sort(allMails);
        }
    }

    @Override
    public IMail[] listEmails(int page) {
        if (page < 1) {
            return new IMail[0];
        }
        int startIndex = (page - 1) * pageSize;
        int endIndex = (page * pageSize) - 1;
        if (mails.size() <= startIndex) {
            return new IMail[0];
        }
        int size = Math.min(mails.size() - 1, endIndex) - startIndex;
        IMail[] currPage = new IMail[size];
        for (int i = 0; i < size; i++) {
            currPage[i] = (IMail) mails.get(startIndex + i);
        }
        return currPage;
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

    public void signout() {
        this.contact = null;
        this.sort = null;
        this.filter = null;
    }
}
