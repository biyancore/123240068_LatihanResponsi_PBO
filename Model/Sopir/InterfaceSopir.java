package Model.Sopir;

import java.util.List;

public interface InterfaceSopir {

public void insert(ModelSopir sopir);

public void update(ModelSopir sopir);

public void delete(int id);

public List<ModelSopir> getAll();

public List<ModelSopir> search(String keyword);

}
