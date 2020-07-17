package entity;

/**
 *
 * @author burak
 */
public class User {

    private String email;
    private String ad;
    private String soyad;
    private String calismaUnvani;
    private String mailOnayUrl;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getCalismaUnvani() {
        return calismaUnvani;
    }

    public void setCalismaUnvani(String calismaUnvani) {
        this.calismaUnvani = calismaUnvani;
    }

    public String getMailOnayUrl() {
        return mailOnayUrl;
    }

    public void setMailOnayUrl(String mailOnayUrl) {
        this.mailOnayUrl = mailOnayUrl;
    }

}
