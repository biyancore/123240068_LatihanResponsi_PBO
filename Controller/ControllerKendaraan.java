package Controller;

import Model.Kendaraan.InterfaceKendaraan;
import Model.Kendaraan.KendaraanDAO;
import Model.Kendaraan.ModelKendaraan;

import java.util.List;

public class ControllerKendaraan {

InterfaceKendaraan dao;

public ControllerKendaraan() {

    dao = new KendaraanDAO();

}

// ambil semua data
public List<ModelKendaraan> getAllKendaraan() {

    return dao.getAll();

}

// search data
public List<ModelKendaraan> searchKendaraan(
        String keyword) {

    return dao.search(keyword);

}

// insert data
public void insertKendaraan(
        String platNomor,
        String jenis,
        String merk) {

    ModelKendaraan kendaraan =
            new ModelKendaraan();

    kendaraan.setPlatNomor(platNomor);

    kendaraan.setJenis(jenis);

    kendaraan.setMerk(merk);

    dao.insert(kendaraan);

}

// update data
public void updateKendaraan(
        int id,
        String platNomor,
        String jenis,
        String merk) {

    ModelKendaraan kendaraan =
            new ModelKendaraan();

    kendaraan.setId(id);

    kendaraan.setPlatNomor(platNomor);

    kendaraan.setJenis(jenis);

    kendaraan.setMerk(merk);

    dao.update(kendaraan);

}

// delete data
public void deleteKendaraan(int id) {

    dao.delete(id);

}

}
