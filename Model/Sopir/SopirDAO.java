package Model.Sopir;

import Connection.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class SopirDAO implements InterfaceSopir {

Connection conn;

public SopirDAO() {

    conn = Connector.getConnection();

}

@Override
public void insert(ModelSopir sopir) {

    try {

        String query =
                "INSERT INTO sopir "
                + "(nama, no_sim, no_hp) "
                + "VALUES (?, ?, ?)";

        PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setString(1, sopir.getNama());

        pst.setString(2, sopir.getNoSim());

        pst.setString(3, sopir.getNoHp());

        pst.executeUpdate();

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }
}

@Override
public void update(ModelSopir sopir) {

    try {

        String query =
                "UPDATE sopir SET "
                + "nama=?, "
                + "no_sim=?, "
                + "no_hp=? "
                + "WHERE id=?";

        PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setString(1, sopir.getNama());

        pst.setString(2, sopir.getNoSim());

        pst.setString(3, sopir.getNoHp());

        pst.setInt(4, sopir.getId());

        pst.executeUpdate();

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }
}

@Override
public void delete(int id) {

    try {

        String query =
                "DELETE FROM sopir WHERE id=?";

        PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setInt(1, id);

        pst.executeUpdate();

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }
}

@Override
public List<ModelSopir> getAll() {

    List<ModelSopir> list =
            new ArrayList<>();

    try {

        String query =
                "SELECT * FROM sopir";

        PreparedStatement pst =
                conn.prepareStatement(query);

        ResultSet rs =
                pst.executeQuery();

        while (rs.next()) {

            ModelSopir sopir =
                    new ModelSopir();

            sopir.setId(
                    rs.getInt("id"));

            sopir.setNama(
                    rs.getString("nama"));

            sopir.setNoSim(
                    rs.getString("no_sim"));

            sopir.setNoHp(
                    rs.getString("no_hp"));

            list.add(sopir);

        }

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }

    return list;
}

@Override
public List<ModelSopir> search(String keyword) {

    List<ModelSopir> list =
            new ArrayList<>();

    try {

        String query =
                "SELECT * FROM sopir "
                + "WHERE nama LIKE ? "
                + "OR no_sim LIKE ?";

        PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setString(1,
                "%" + keyword + "%");

        pst.setString(2,
                "%" + keyword + "%");

        ResultSet rs =
                pst.executeQuery();

        while (rs.next()) {

            ModelSopir sopir =
                    new ModelSopir();

            sopir.setId(
                    rs.getInt("id"));

            sopir.setNama(
                    rs.getString("nama"));

            sopir.setNoSim(
                    rs.getString("no_sim"));

            sopir.setNoHp(
                    rs.getString("no_hp"));

            list.add(sopir);

        }

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }

    return list;
}

}
