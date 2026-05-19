package View.Sopir;

import Controller.ControllerSopir;

import javax.swing.*;

import java.awt.*;

public class InputSopir extends JFrame {

ControllerSopir controller;

JTextField txtNama;
JTextField txtNoSim;
JTextField txtNoHp;

JButton btnSimpan;

public InputSopir(
        ViewSopir view) {

    controller =
            new ControllerSopir();

    setTitle("Tambah Sopir");

    setSize(350, 250);

    setLocationRelativeTo(null);

    setLayout(new GridLayout(4, 2, 10, 10));

    add(new JLabel("Nama Sopir"));

    txtNama = new JTextField();

    add(txtNama);

    add(new JLabel("No SIM"));

    txtNoSim = new JTextField();

    add(txtNoSim);

    add(new JLabel("No HP"));

    txtNoHp = new JTextField();

    add(txtNoHp);

    btnSimpan =
            new JButton("Simpan");

    add(new JLabel());

    add(btnSimpan);

    btnSimpan.addActionListener(e -> {

        controller.insertSopir(

                txtNama.getText(),

                txtNoSim.getText(),

                txtNoHp.getText()

        );

        view.loadTable();

        dispose();

    });

    setVisible(true);
}

}
