package eg.edu.alexu.csd.datastructure.mailserver.logic.filter;

import eg.edu.alexu.csd.datastructure.mailserver.models.email.IMail;

public class BodyFilter implements IFilter {
    private String query;

    public BodyFilter(String query) {
        this.query = query;
    }

    @Override
    public boolean matches(IMail mail) {
        return mail.getBody().contains(query);
    }
}
