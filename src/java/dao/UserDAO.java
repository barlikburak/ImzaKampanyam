package dao;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO {

    public void insert(User user) {
        String query = "insert into user1 (email,ad,soyad,calisma_unvani,mail_onay_url) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = getConnection().prepareStatement(query);
            pst.setString(1, user.getEmail());
            pst.setString(2, user.getAd());
            pst.setString(3, user.getSoyad());
            pst.setString(4, user.getCalismaUnvani());
            pst.setString(5, "http://localhost:8080/imzakampanyam/" + user.getMailOnayUrl());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
