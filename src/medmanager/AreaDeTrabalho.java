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
    private JInternalFrame geFuncionario;
    private JInternalFrame geMedico;
    private JInternalFrame gePaciente;
    private JInternalFrame geNivelAcesso;
    private JInternalFrame geTipo;
    private JInternalFrame geProduto;
    
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
    
    public void abrirGerenciarPaciente()
    {
        if(gePaciente == null)
        {
            gePaciente = new GerenciarPaciente();
            gePaciente.setVisible(true);
            add(gePaciente);
        }
    }
    
    public void fecharGerenciarPaciente()
    {
        gePaciente = null;
    }
    
     public void abrirGerenciarFuncionario(){
        if (geFuncionario == null) {
            geFuncionario = new GerenciarFuncionario();
            geFuncionario.setVisible(true);
            add(geFuncionario);
        }
    }
    
    public void fecharGerenciarFuncionario(){
        geFuncionario = null;
    } 
    
     public void abrirGerenciarMedico(){
        if (geMedico == null) {
            geMedico = new GerenciarMedico();
            geMedico.setVisible(true);
            add(geMedico);
        }
    }
    
    public void fecharGerenciarMedico(){
        geMedico = null;
    } 
    
    public void abrirGerenciarNivelAcesso(){
        if (geNivelAcesso == null) {
            geNivelAcesso = new GerenciarNivelAcesso();
            geNivelAcesso.setVisible(true);
            add(geNivelAcesso);
        }
    }
    
    public void fecharGerenciarNivelAcesso(){
        geNivelAcesso = null;
    } 
    
    public void abrirGerenciarTipoMedicamento(){
        if (geTipo == null) {
            geTipo = new GerenciarTipoMedicamento();
            geTipo.setVisible(true);
            add(geTipo);
        }
    }
    public void fecharGerenciarTipoMedicamento(){
        geTipo = null;
    } 
    
    public void abrirGerenciarProduto(){
        if (geProduto == null) {
            geProduto = new GerenciarProduto();
            geProduto.setVisible(true);
            add(geProduto);
        }
    }
    public void fecharGerenciarProduto(){
        geProduto = null;
    } 
}
