package repository;

import model.Mahasiswa;

public class MahasiswaTbl {
    private Database db;

    public MahasiswaTbl(Database db) {
        this.db = db;
    }


    public void create(Mahasiswa mahasiswa) {
        db.getTables().dataMahasiswa.add(mahasiswa);
        db.commit();
    }

    public void update(String nim, Mahasiswa mahasiswa) {
        for (int i = 0; i < db.getTables().dataMahasiswa.size(); i++) {
            if (db.getTables().dataMahasiswa.get(i).getNim().equals(nim)) {
                db.getTables().dataMahasiswa.set(i, mahasiswa);
                break;
            }
        }
        db.commit();
    }

    public Mahasiswa getMahasiswaByNim(String nim) {
        for (Mahasiswa mahasiswa : db.getTables().dataMahasiswa) {
            if (mahasiswa.getNim().equals(nim)) {
                return mahasiswa;
            }
        }
        return null;
    }

    public void delete(String nim) {
        for (int i = 0; i < db.getTables().dataMahasiswa.size(); i++) {
            if (db.getTables().dataMahasiswa.get(i).getNim().equals(nim)) {
                db.getTables().dataMahasiswa.remove(i);
                break;
            }
        }
        db.commit();
    }

    public Mahasiswa getMahasiswaByProdiId(String idProdi) {
        for (Mahasiswa mahasiswa : db.getTables().dataMahasiswa) {
            if (mahasiswa.getProdi().getId().equals(idProdi)) {
                return mahasiswa;
            }
        }
        return null;
    }

}
