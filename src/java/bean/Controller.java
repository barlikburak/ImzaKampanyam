package bean;

import email.EmailSend;
import entity.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author burak
 */
@ManagedBean(name = "ctrl")
@SessionScoped
public class Controller implements Serializable {

    private User user;

    public void imzaKayit() {
        user.setMailOnayUrl("http://localhost:8080/imzakampanyam/" + getAlphaNumericString(50));
        System.out.println(EmailSend.sendMail(user));
    }

    private String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
