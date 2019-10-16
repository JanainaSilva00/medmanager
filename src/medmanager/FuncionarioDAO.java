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
public class FuncionarioDAO extends DAO<Funcionario> {

    @Override
    public boolean inserir(Funcionario element) {
        try{
            String comando = "INSERT INTO funcionario "
                    + "(nome,cpf) VALUES "
                    + "(?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getCpf());
            
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
    public boolean alterar(Funcionario element) {
        try{
            String comando = "UPDATE funcionario SET "
                    + "nome = ?, cpf = ? "
                    + "WHERE id_funcionario = ?";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getCpf());
            stmt.setInt(3, element.getId());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Funcionario element) {
        try{
            String comando = "DELETE FROM funcionario "
                    + "WHERE id_funcionario = ?";
            
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
    public List<Funcionario> listar() {
        List<Funcionario> lstFuncionario = new ArrayList<>();
        lstFuncionario = ObservableCollections.observableList(lstFuncionario);
        
        String sql = "SELECT * from funcionario;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                System.out.println(f.getNome());
                lstFuncionario.add(f);
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao listar funcionarios");
            System.out.printf(e.getMessage());
        }
        return lstFuncionario;
    }
    
}