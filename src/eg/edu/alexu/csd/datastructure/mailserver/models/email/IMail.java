package eg.edu.alexu.csd.datastructure.mailserver.models.email;

import java.time.LocalDateTime;
import java.util.Date;

public interface IMail {

    int getPriority();

    void setPriority(int priority);

    String getId();

    void setId(String id);

    String getSender();

    void setSender(String sender);

    String getReciever();

    void setReciever(String reciever);

    String getSubject();

    void setSubject(String subject);

    Date getDate();

    void setDate(Date date);

    String getBody();

    void setBody(String body);

    LocalDateTime getTime();
}
