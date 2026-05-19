package Controller;

import Model.Sopir.InterfaceSopir;
import Model.Sopir.ModelSopir;
import Model.Sopir.SopirDAO;

import java.util.List;

public class ControllerSopir {

InterfaceSopir dao;

public ControllerSopir() {

    dao = new SopirDAO();

}

public List<ModelSopir> getAllSopir() {

    return dao.getAll();

}

public List<ModelSopir> searchSopir(
        String keyword) {

    return dao.search(keyword);

}

public void insertSopir(
        String nama,
        String noSim,
        String noHp) {

    ModelSopir sopir =
            new ModelSopir();

    sopir.setNama(nama);

    sopir.setNoSim(noSim);

    sopir.setNoHp(noHp);

    dao.insert(sopir);

}

public void updateSopir(
        int id,
        String nama,
        String noSim,
        String noHp) {

    ModelSopir sopir =
            new ModelSopir();

    sopir.setId(id);

    sopir.setNama(nama);

    sopir.setNoSim(noSim);

    sopir.setNoHp(noHp);

    dao.update(sopir);

}

public void deleteSopir(int id) {

    dao.delete(id);

}

}
