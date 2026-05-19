package Model.Kendaraan;

public class ModelKendaraan {

private int id;

private String platNomor;

private String jenis;

private String merk;

// constructor kosong
public ModelKendaraan() {

}

// constructor isi data
public ModelKendaraan(int id,
        String platNomor,
        String jenis,
        String merk) {

    this.id = id;

    this.platNomor = platNomor;

    this.jenis = jenis;

    this.merk = merk;
}

// getter
public int getId() {
    return id;
}

public String getPlatNomor() {
    return platNomor;
}

public String getJenis() {
    return jenis;
}

public String getMerk() {
    return merk;
}

// setter
public void setId(int id) {
    this.id = id;
}

public void setPlatNomor(String platNomor) {
    this.platNomor = platNomor;
}

public void setJenis(String jenis) {
    this.jenis = jenis;
}

public void setMerk(String merk) {
    this.merk = merk;
}

}
