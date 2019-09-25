package medmanager;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Janaina
 */
public class AreaDeTrabalho extends JDesktopPane
{
    private JInternalFrame cadMedicamento;
    private JInternalFrame geFornecedor;
    
    public void abrirCadastroMedicamento(){
        if (cadMedicamento == null) {
            cadMedicamento = new CadastroMedicamento();
            cadMedicamento.setVisible(true);
            add(cadMedicamento);
        }
    }
    
    public void fecharCadastroMedicamento(){
        cadMedicamento = null;
    }
    
    public void abrirGerenciarFornecedor(){
        if (geFornecedor == null) {
            geFornecedor = new GerenciarFornecedor();
            geFornecedor.setVisible(true);
            add(geFornecedor);
        }
    }
    
    public void fecharGerenciarFornecedor(){
        geFornecedor = null;
    }
            
}
