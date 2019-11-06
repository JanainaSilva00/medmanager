/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Israel Elias
 */
public class TipoDAO extends DAO<Tipo> {
    @Override
    public boolean inserir(Tipo element) {
        try{
            String sql = "INSERT INTO tipo(descricao) VALUES (?);";
            
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
    public boolean alterar(Tipo element) {
        try{
            String sql = "UPDATE tipo SET " 
                    + "descricao = ? "
                    + "WHERE id_tipo = ?";
            
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
    public boolean remover(Tipo element) {
        try{
            String sql = "DELETE FROM tipo "
                    + "WHERE id_tipo = ?";
            
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
    public List<Tipo> listar() {
        List<Tipo> lstTipo = new ArrayList<>();
        lstTipo = ObservableCollections.observableList(lstTipo);
        
        String sql = "SELECT * from tipo;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Tipo t = new Tipo();
                t.setId(rs.getInt("id_tipo"));
                t.setDescricao(rs.getString("descricao"));
                System.out.println(t.getDescricao());
                lstTipo.add(t);
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao listar tipos");
            System.out.printf(e.getMessage());
        }
        return lstTipo;
    }
}
