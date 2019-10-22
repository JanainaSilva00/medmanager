package medmanager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Janaina
 */
public class FornecedorDAO extends DAO<Fornecedor> {

    @Override
    public boolean inserir(Fornecedor element) {
        try{
            String comando = "INSERT INTO fornecedor "
                    + "(nome,telefone, cnpj) VALUES "
                    + "(?,?, ?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getTelefone());
            stmt.setString(2, element.getCnpj());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean alterar(Fornecedor element) {
        try{
            String comando = "UPDATE fornecedor SET "
                    + "nome = ?, telefone = ?, cnpj = ?"
                    + "WHERE id_fornecedor = ?";
            
            PreparedStatement stmt = conn.prepareStatement(comando);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getTelefone());
            stmt.setString(3, element.getCnpj());
            stmt.setInt(4, element.getId());
            
            if(stmt.executeUpdate() == 1) {
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao alterar: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Fornecedor element) {
        try{
            String comando = "DELETE FROM fornecedor "
                    + "WHERE id_fornecedor = ?";
            
            PreparedStatement stmt = conn.prepareStatement(comando);
            
            stmt.setInt(1, element.getId());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public List<Fornecedor> listar() {
        List<Fornecedor> lstFornecedor = new ArrayList<>();
        lstFornecedor = ObservableCollections.observableList(lstFornecedor);
        
        String sql = "SELECT * from fornecedor;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setCnpj(rs.getString("cnpj"));
                lstFornecedor.add(f);
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao listar fornecedores");
            System.out.printf(e.getMessage());
        }
        return lstFornecedor;
    } 
}