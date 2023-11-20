public class FormulirMhs extends BaseFormulir {
    public String nim;
    public String kelas;
    public String semester;
    
    @Override
    void caraPembayaran() {
        System.out.println("Cara Pembayaran Mahasiswa");
    }

    @Override
    void tataTertibAcara() {
        System.out.println("Tata Tertib Acara Mahasiswa");
    }


}   
