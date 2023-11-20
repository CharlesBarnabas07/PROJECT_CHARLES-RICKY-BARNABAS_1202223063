public class FormulirDosen extends BaseFormulir{
    public String KodeDosen;

    @Override
    void caraPembayaran() {
        System.out.println("Cara Pembayaran Dosen");
        super.caraPembayaran();
    }

    @Override
    void tataTertibAcara() {
        System.out.println("Tata Tertib Acara Dosen");
    }
}
