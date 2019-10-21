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
 *  William Chapuis Marciano '-'
 *  
 */

public class MedicoDAO extends DAO<Medico>
{
    @Override
    public boolean inserir(Medico element) {
        String sql = "insert into medico (nome, crm) values (?,?);";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getCrm());
            
            if(stmt.executeUpdate() == 1)
            {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.printf("erro ao inserir : "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean alterar(Medico element) {
        String sql = "update medico set nome = ?, crm = ? where id_medico = ?;";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getCrm());
            stmt.setInt(3, element.getId());
            
            if(stmt.executeUpdate() == 1)
            {
                return true;
            }
        }catch(SQLException e){
            System.out.printf("erro ao alterar : "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Medico element) {
        String sql = "delete from medico where id_medico = ?;";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, element.getId());
            
            if(stmt.executeUpdate() == 1)
            {
                return true;
            }
        }catch(SQLException e){
            System.out.printf("erro ao remover : "+e.getMessage());
        }
        return false;
    }

    @Override
    public List<Medico> listar() {
        List<Medico> lstMedico = new ArrayList<>();
        lstMedico = ObservableCollections.observableList(lstMedico);
        
        String sql = "select * from medico";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                Medico m = new Medico();
                m.setId(rs.getInt("id_medico"));
                m.setNome(rs.getString("nome"));
                m.setCrm(rs.getString("crm"));
                System.out.println(m.getNome());
                lstMedico.add(m);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar medicos");
            System.out.printf(e.getMessage());
        }
        return lstMedico;
    }
}
