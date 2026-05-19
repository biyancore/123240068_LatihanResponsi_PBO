package View.Kendaraan;

import Controller.ControllerKendaraan;

import Model.Kendaraan.ModelKendaraan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;

public class ViewKendaraan extends JFrame {

ControllerKendaraan controller;

JTable table;

JTextField txtCari;

JButton btnCari;
JButton btnTambah;
JButton btnEdit;
JButton btnHapus;
JButton btnKembali;

int selectedId = 0;

public ViewKendaraan() {

    controller = new ControllerKendaraan();

    setTitle("Data Kendaraan");

    setSize(700, 500);

    setLocationRelativeTo(null);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new BorderLayout());

    // ===== TITLE =====
    JLabel title =
            new JLabel("TABEL DATA KENDARAAN");

    title.setFont(
            new Font("Segoe UI",
                    Font.BOLD,
                    20));

    JPanel topPanel =
            new JPanel(new BorderLayout());

    topPanel.add(title,
            BorderLayout.WEST);

    // ===== SEARCH =====
    JPanel searchPanel =
            new JPanel();

    txtCari =
            new JTextField(15);

    btnCari =
            new JButton("Cari");

    searchPanel.add(
            new JLabel("Cari :"));

    searchPanel.add(txtCari);

    searchPanel.add(btnCari);

    topPanel.add(searchPanel,
            BorderLayout.EAST);

    add(topPanel,
            BorderLayout.NORTH);

    // ===== TABLE =====
    table = new JTable();

    DefaultTableModel model =
            new DefaultTableModel();

    model.setColumnIdentifiers(
            new String[]{
                "ID",
                "Plat Nomor",
                "Jenis",
                "Merk"
            });

    table.setModel(model);

    JScrollPane scrollPane =
            new JScrollPane(table);

    add(scrollPane,
            BorderLayout.CENTER);

    // ===== BUTTON =====
    JPanel buttonPanel =
            new JPanel();

    btnTambah =
            new JButton("Tambah");

    btnEdit =
            new JButton("Edit");

    btnHapus =
            new JButton("Hapus");
    
    btnKembali =
new JButton("Kembali ke Menu");


    buttonPanel.add(btnTambah);

    buttonPanel.add(btnEdit);

    buttonPanel.add(btnHapus);
    
    buttonPanel.add(btnKembali);

    add(buttonPanel,
            BorderLayout.SOUTH);

    // tampil data
    loadTable();

    // ===== EVENT TABLE =====
    table.getSelectionModel()
            .addListSelectionListener(e -> {

        int row =
                table.getSelectedRow();

        if (row != -1) {

            selectedId =
                    Integer.parseInt(
                            table.getValueAt(row, 0)
                                    .toString());

        }
    });

    // ===== SEARCH =====
    btnCari.addActionListener(e -> {

        String keyword =
                txtCari.getText();

        loadSearch(keyword);

    });

    // ===== TAMBAH =====
    btnTambah.addActionListener(e -> {

        new InputKendaraan(this);

    });

    // ===== EDIT =====
    btnEdit.addActionListener(e -> {

        if (selectedId == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih data dulu!");

        } else {

            int row =
                    table.getSelectedRow();

            String plat =
                    table.getValueAt(row, 1)
                            .toString();

            String jenis =
                    table.getValueAt(row, 2)
                            .toString();

            String merk =
                    table.getValueAt(row, 3)
                            .toString();

            new EditKendaraan(
                    this,
                    selectedId,
                    plat,
                    jenis,
                    merk);

        }

    });

    // ===== DELETE =====
    btnHapus.addActionListener(e -> {

        if (selectedId == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih data dulu!");

        } else {

            int confirm =
                    JOptionPane.showConfirmDialog(
                            null,
                            "Yakin hapus?",
                            "Konfirmasi",
                            JOptionPane.YES_NO_OPTION);

            if (confirm ==
                    JOptionPane.YES_OPTION) {

                controller.deleteKendaraan(
                        selectedId);

                loadTable();

                selectedId = 0;

            }

        }

    });
    
    //====kembali mpruy===
btnKembali.addActionListener(e -> {

new View.MenuFrame("admin");

dispose();
});

    setVisible(true);
    
    
}


// tampil semua data
public void loadTable() {

    DefaultTableModel model =
            (DefaultTableModel)
                    table.getModel();

    model.setRowCount(0);

    List<ModelKendaraan> list =
            controller.getAllKendaraan();

    for (ModelKendaraan kendaraan : list) {

        Object[] row = {

            kendaraan.getId(),

            kendaraan.getPlatNomor(),

            kendaraan.getJenis(),

            kendaraan.getMerk()

        };

        model.addRow(row);

    }
}

// search data
public void loadSearch(String keyword) {

    DefaultTableModel model =
            (DefaultTableModel)
                    table.getModel();

    model.setRowCount(0);

    List<ModelKendaraan> list =
            controller.searchKendaraan(keyword);

    for (ModelKendaraan kendaraan : list) {

        Object[] row = {

            kendaraan.getId(),

            kendaraan.getPlatNomor(),

            kendaraan.getJenis(),

            kendaraan.getMerk()

        };

        model.addRow(row);

    }
}

}
