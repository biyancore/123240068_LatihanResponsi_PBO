package View.Sopir;

import Controller.ControllerSopir;

import javax.swing.*;

import java.awt.*;

public class EditSopir extends JFrame {

ControllerSopir controller;

JTextField txtNama;
JTextField txtNoSim;
JTextField txtNoHp;

JButton btnUpdate;

public EditSopir(
        ViewSopir view,
        int id,
        String nama,
        String noSim,
        String noHp) {

    controller =
            new ControllerSopir();

    setTitle("Edit Sopir");

    setSize(350, 250);

    setLocationRelativeTo(null);

    setLayout(new GridLayout(4, 2, 10, 10));

    add(new JLabel("Nama Sopir"));

    txtNama =
            new JTextField(nama);

    add(txtNama);

    add(new JLabel("No SIM"));

    txtNoSim =
            new JTextField(noSim);

    add(txtNoSim);

    add(new JLabel("No HP"));

    txtNoHp =
            new JTextField(noHp);

    add(txtNoHp);

    btnUpdate =
            new JButton("Update");

    add(new JLabel());

    add(btnUpdate);

    btnUpdate.addActionListener(e -> {

        controller.updateSopir(

                id,

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
