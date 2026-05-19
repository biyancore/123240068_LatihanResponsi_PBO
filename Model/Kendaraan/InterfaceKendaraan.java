package Model.Kendaraan;

import java.util.List;

public interface InterfaceKendaraan {

public void insert(ModelKendaraan kendaraan);
public void update(ModelKendaraan kendaraan);
public void delete(int id);
public List<ModelKendaraan> getAll();
public List<ModelKendaraan> search(String keyword);

}
