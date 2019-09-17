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
    private JInternalFrame cadEquipamento;
    
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
    
    public void abrirCadastroEquipamento()
    {
        if(cadEquipamento == null)
        {
            cadEquipamento = new CadastroEquipamento();
            cadEquipamento.setVisible(true);
            add(cadEquipamento);
        }
    }
    
    public void fecharCadastroEquipamento()
    {
        cadEquipamento = null;
    }
}
