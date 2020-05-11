package eg.edu.alexu.csd.datastructure.mailserver.logic.filter;

import eg.edu.alexu.csd.datastructure.mailserver.models.email.IMail;

public class PrioFilter implements IFilter {
    private int priority;

    public PrioFilter(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean matches(IMail mail) {
        return mail.getPriority() == priority;
    }
}
