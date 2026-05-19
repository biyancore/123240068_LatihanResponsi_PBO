package Model.Sopir;

public class ModelSopir {

private int id;

private String nama;

private String noSim;

private String noHp;

public ModelSopir() {

}

public ModelSopir(
        int id,
        String nama,
        String noSim,
        String noHp) {

    this.id = id;

    this.nama = nama;

    this.noSim = noSim;

    this.noHp = noHp;
}

public int getId() {
    return id;
}

public String getNama() {
    return nama;
}

public String getNoSim() {
    return noSim;
}

public String getNoHp() {
    return noHp;
}

public void setId(int id) {
    this.id = id;
}

public void setNama(String nama) {
    this.nama = nama;
}

public void setNoSim(String noSim) {
    this.noSim = noSim;
}

public void setNoHp(String noHp) {
    this.noHp = noHp;
}


}
