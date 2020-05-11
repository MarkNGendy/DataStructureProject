package eg.edu.alexu.csd.datastructure.mailserver.logic.filter;

import eg.edu.alexu.csd.datastructure.mailserver.models.email.IMail;

public class SenderFilter implements IFilter {
    private String sender;

    public SenderFilter(String sender) {
        this.sender = sender;
    }

    @Override
    public boolean matches(IMail mail) {
        return mail.getSender().equalsIgnoreCase(sender);
    }
}
