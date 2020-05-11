package eg.edu.alexu.csd.datastructure.mailserver.logic.filter;

import eg.edu.alexu.csd.datastructure.mailserver.models.email.IMail;

public class RecieverFilter implements IFilter {
    private String reciever;

    public RecieverFilter(String reciever) {
        this.reciever = reciever;
    }

    @Override
    public boolean matches(IMail mail) {
        return mail.getReciever().equalsIgnoreCase(reciever);
    }
}
