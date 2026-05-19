package View.Kendaraan;

import Controller.ControllerKendaraan;

import javax.swing.*;

import java.awt.*;

public class InputKendaraan extends JFrame {

ControllerKendaraan controller;

JTextField txtPlat;
JTextField txtJenis;
JTextField txtMerk;

JButton btnSimpan;

public InputKendaraan(
        ViewKendaraan view) {

    controller =
            new ControllerKendaraan();

    setTitle("Tambah Kendaraan");

    setSize(350, 250);

    setLocationRelativeTo(null);

    setLayout(new GridLayout(4, 2, 10, 10));

    add(new JLabel("Plat Nomor"));

    txtPlat = new JTextField();

    add(txtPlat);

    add(new JLabel("Jenis"));

    txtJenis = new JTextField();

    add(txtJenis);

    add(new JLabel("Merk"));

    txtMerk = new JTextField();

    add(txtMerk);

    btnSimpan =
            new JButton("Simpan");

    add(new JLabel());

    add(btnSimpan);

    btnSimpan.addActionListener(e -> {

        controller.insertKendaraan(

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
