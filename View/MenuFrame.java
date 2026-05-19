package View;

import View.Kendaraan.ViewKendaraan;
import View.Sopir.ViewSopir;

import javax.swing.*;

import java.awt.*;

public class MenuFrame extends JFrame {


JButton btnKendaraan;

JButton btnSopir;

JButton btnLogout;

public MenuFrame(String username) {

    setTitle("MENU");

    setSize(400, 300);

    setLocationRelativeTo(null);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new GridLayout(5, 1, 10, 10));

    JLabel title =
            new JLabel(
                    "Selamat Datang, "
                    + username,
                    SwingConstants.CENTER);

    title.setFont(
            new Font(
                    "Segoe UI",
                    Font.BOLD,
                    20));

    add(title);

    btnKendaraan =
            new JButton(
                    "Data Kendaraan");

    btnSopir =
            new JButton(
                    "Data Sopir");

    btnLogout =
            new JButton(
                    "Logout");

    add(btnKendaraan);

    add(btnSopir);

    add(btnLogout);

    // buka kendaraan
    btnKendaraan.addActionListener(e -> {

        new ViewKendaraan();

        dispose();

    });

    // buka sopir
    btnSopir.addActionListener(e -> {

        new ViewSopir();

        dispose();

    });

    // logout
    btnLogout.addActionListener(e -> {

        int confirm =
                JOptionPane.showConfirmDialog(
                        null,
                        "Yakin logout?",
                        "Logout",
                        JOptionPane.YES_NO_OPTION);

        if (confirm
                == JOptionPane.YES_OPTION) {

            new LoginFrame();

            dispose();

        }

    });

    setVisible(true);
}

}
