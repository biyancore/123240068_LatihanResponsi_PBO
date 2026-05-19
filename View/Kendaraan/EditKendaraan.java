package View.Kendaraan;

import Controller.ControllerKendaraan;

import javax.swing.*;

import java.awt.*;

public class EditKendaraan extends JFrame {


ControllerKendaraan controller;

JTextField txtPlat;
JTextField txtJenis;
JTextField txtMerk;

JButton btnUpdate;

public EditKendaraan(
        ViewKendaraan view,
        int id,
        String plat,
        String jenis,
        String merk) {

    controller =
            new ControllerKendaraan();

    setTitle("Edit Kendaraan");

    setSize(350, 250);

    setLocationRelativeTo(null);

    setLayout(new GridLayout(4, 2, 10, 10));

    add(new JLabel("Plat Nomor"));

    txtPlat =
            new JTextField(plat);

    add(txtPlat);

    add(new JLabel("Jenis"));

    txtJenis =
            new JTextField(jenis);

    add(txtJenis);

    add(new JLabel("Merk"));

    txtMerk =
            new JTextField(merk);

    add(txtMerk);

    btnUpdate =
            new JButton("Update");

    add(new JLabel());

    add(btnUpdate);

    btnUpdate.addActionListener(e -> {

        controller.updateKendaraan(

                id,

                txtPlat.getText(),

                txtJenis.getText(),

                txtMerk.getText()

        );

        view.loadTable();

        dispose();

    });

    setVisible(true);
}

}
