package eg.edu.alexu.csd.datastructure.mailserver.logic.filter;

import eg.edu.alexu.csd.datastructure.mailserver.models.email.IMail;

public class AttachFilter implements IFilter {
    @Override
    public boolean matches(IMail mail) {
        return false;
    }
}
