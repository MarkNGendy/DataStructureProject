package eg.edu.alexu.csd.datastructure.mailserver.models.contact;

public class Contact implements IContact {
    private String email;
    private String password;

    public Contact() {
    }

    public Contact(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUserName() {
        return email.split("@")[0];
    }
}
