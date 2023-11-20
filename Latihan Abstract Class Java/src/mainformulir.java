public class mainformulir {
    public static void main(String[] args) {
        FormulirMhs formulir01 = new FormulirMhs();
        formulir01.caraPembayaran();
        formulir01.tataTertibAcara();

        FormulirDosen formulir02 = new FormulirDosen();
        formulir02.caraPembayaran();
        formulir02.tataTertibAcara();

        FormulirAdmin formulir03 = new FormulirAdmin();
        formulir03.tataTertibAcara();
        
        BaseFormulir[] listFormulir = new BaseFormulir[5];
        listFormulir[0] = new FormulirAdmin();
        listFormulir[1] = new FormulirDosen();
        listFormulir[2] = new FormulirMhs();
        
        ((FormulirMhs)listFormulir[2]).nim = "1202223063";
    }
}
