/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDBContext extends DBContext {

    public Account getAccount(String userName, String passWord) {
        String sql = "select userName, passWord, role from Account\n"
                + "where userName = ? and passWord = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, passWord);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account c = new Account();
                c.setUserName(rs.getString("userName"));
                c.setPassWord(rs.getString("passWord"));
                c.setRole(rs.getInt("role"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
