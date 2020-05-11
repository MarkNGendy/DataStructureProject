package eg.edu.alexu.csd.datastructure.mailserver.logic.filter;

import eg.edu.alexu.csd.datastructure.mailserver.models.email.IMail;

public class SubjectFilter implements IFilter{
    private String subject;

    public SubjectFilter(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean matches(IMail mail) {
        return mail.getSubject().contains(subject);
    }
}
