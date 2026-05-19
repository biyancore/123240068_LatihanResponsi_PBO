package Model.Kendaraan;

import Connection.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class KendaraanDAO implements InterfaceKendaraan {

Connection conn;

public KendaraanDAO() {

    conn = Connector.getConnection();

}

@Override
public void insert(ModelKendaraan kendaraan) {

    try {

        String query =
                "INSERT INTO kendaraan "
                + "(plat_nomor, jenis, merk) "
                + "VALUES (?, ?, ?)";

        PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setString(1, kendaraan.getPlatNomor());

        pst.setString(2, kendaraan.getJenis());

        pst.setString(3, kendaraan.getMerk());

        pst.executeUpdate();

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }
}

@Override
public void update(ModelKendaraan kendaraan) {

    try {

        String query =
                "UPDATE kendaraan SET "
                + "plat_nomor=?, "
                + "jenis=?, "
                + "merk=? "
                + "WHERE id=?";

        PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setString(1, kendaraan.getPlatNomor());

        pst.setString(2, kendaraan.getJenis());

        pst.setString(3, kendaraan.getMerk());

        pst.setInt(4, kendaraan.getId());

        pst.executeUpdate();

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }
}

@Override
public void delete(int id) {

    try {

        String query =
                "DELETE FROM kendaraan WHERE id=?";

        PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setInt(1, id);

        pst.executeUpdate();

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }
}

@Override
public List<ModelKendaraan> getAll() {

    List<ModelKendaraan> list =
            new ArrayList<>();

    try {

        String query =
                "SELECT * FROM kendaraan";

        PreparedStatement pst =
                conn.prepareStatement(query);

        ResultSet rs =
                pst.executeQuery();

        while (rs.next()) {

            ModelKendaraan kendaraan =
                    new ModelKendaraan();

            kendaraan.setId(
                    rs.getInt("id"));

            kendaraan.setPlatNomor(
                    rs.getString("plat_nomor"));

            kendaraan.setJenis(
                    rs.getString("jenis"));

            kendaraan.setMerk(
                    rs.getString("merk"));

            list.add(kendaraan);

        }

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }

    return list;
}

@Override
public List<ModelKendaraan> search(String keyword) {

    List<ModelKendaraan> list =
            new ArrayList<>();

    try {

        String query =
                "SELECT * FROM kendaraan "
                + "WHERE plat_nomor LIKE ? "
                + "OR merk LIKE ?";

        PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setString(1,
                "%" + keyword + "%");

        pst.setString(2,
                "%" + keyword + "%");

        ResultSet rs =
                pst.executeQuery();

        while (rs.next()) {

            ModelKendaraan kendaraan =
                    new ModelKendaraan();

            kendaraan.setId(
                    rs.getInt("id"));

            kendaraan.setPlatNomor(
                    rs.getString("plat_nomor"));

            kendaraan.setJenis(
                    rs.getString("jenis"));

            kendaraan.setMerk(
                    rs.getString("merk"));

            list.add(kendaraan);

        }

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }

    return list;
}

}
