package bean;

import dao.UserDAO;
import entity.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author burak
 */
@ManagedBean(name = "ctrl")
@SessionScoped
public class Controller implements Serializable {

    private User user;
    private UserDAO userDAO;
    private boolean sartOnay;

    public void imzaKayit() {
        if (sartOnay) {
            user.setMailOnayUrl(getAlphaNumericString(50));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", user);
            getUserDAO().insert(user);
        }
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

    public UserDAO getUserDAO() {
        if (this.userDAO == null) {
            this.userDAO = new UserDAO();
        }
        return userDAO;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isSartOnay() {
        return sartOnay;
    }

    public void setSartOnay(boolean sartOnay) {
        this.sartOnay = sartOnay;
    }

}
