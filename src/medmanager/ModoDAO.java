/**
 *
 *  William Chapuis '-'
 *  
 */
package medmanager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

public class ModoDAO extends DAO<Modo>
{
    @Override
    public boolean inserir(Modo element)
    {
        try{
            String sql = "INSERT INTO modo_uso(descricao) VALUES (?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                sql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getDescricao());
            
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
    public boolean alterar(Modo element) {
        try{
            String sql = "UPDATE modo_uso SET " 
                    + "descricao = ? "
                    + "WHERE id_modo_uso = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, element.getDescricao());
            stmt.setInt(2, element.getId());
            
            if(stmt.executeUpdate() == 1) {
                return true;
            }
        }catch(SQLException e){
            System.out.println("Erro ao alterar: "+ e.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean remover(Modo element) {
        try{
            String sql = "DELETE FROM modo_uso "
                    + "WHERE id_modo_uso = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
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
    public List<Modo> listar() {
        List<Modo> lstModo = new ArrayList<>();
        lstModo = ObservableCollections.observableList(lstModo);
        
        String sql = "SELECT * from modo_uso;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Modo m = new Modo();
                m.setId(rs.getInt("id_modo_uso"));
                m.setDescricao(rs.getString("descricao"));
                System.out.println(m.getDescricao());
                lstModo.add(m);
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao listar modos");
            System.out.printf(e.getMessage());
        }
        return lstModo;
    }
}
