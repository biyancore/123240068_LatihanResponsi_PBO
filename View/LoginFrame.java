package View;

import Connection.Connector;

import javax.swing.*;

import java.awt.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFrame extends JFrame {

JTextField txtUsername;

JPasswordField txtPassword;

JButton btnLogin;

public LoginFrame() {

    setTitle("LOGIN SISTEM");

    setSize(400, 300);

    setLocationRelativeTo(null);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new GridLayout(4, 2, 10, 10));

    JLabel title =
            new JLabel(
                    "LOGIN SISTEM",
                    SwingConstants.CENTER);

    title.setFont(
            new Font(
                    "Segoe UI",
                    Font.BOLD,
                    22));

    add(title);

    add(new JLabel());

    add(new JLabel("Username"));

    txtUsername =
            new JTextField();

    add(txtUsername);

    add(new JLabel("Password"));

    txtPassword =
            new JPasswordField();

    add(txtPassword);

    add(new JLabel());

    btnLogin =
            new JButton("LOGIN");

    add(btnLogin);

    btnLogin.addActionListener(e -> {

        login();

    });

    setVisible(true);
}

public void login() {

    String username =
            txtUsername.getText();

    String password =
            txtPassword.getText();

    if (username.isEmpty()
            || password.isEmpty()) {

        JOptionPane.showMessageDialog(
                null,
                "Username dan Password wajib diisi!");

        return;
    }

    try {

        Connection conn =
                Connector.getConnection();

        String query =
                "SELECT * FROM users "
                + "WHERE username=? "
                + "AND password=?";

        PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setString(1, username);

        pst.setString(2, password);

        ResultSet rs =
                pst.executeQuery();

        if (rs.next()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Login berhasil!");

            new MenuFrame(username);

            dispose();

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Username atau Password salah!");

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage());

    }
}

}
