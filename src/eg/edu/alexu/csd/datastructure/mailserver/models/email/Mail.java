package eg.edu.alexu.csd.datastructure.mailserver.models.email;

import java.util.Date;

public class Mail implements IMail {
    private String id;
    private String sender;
    private String reciever;
    private String subject;
    private Date date;
    private String body;
    private int priority;

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getSender() {
        return sender;
    }

    @Override
    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String getReciever() {
        return reciever;
    }

    @Override
    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }
}
