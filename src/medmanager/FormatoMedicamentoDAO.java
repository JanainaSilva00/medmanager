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
 * @author benini
 */
public class FormatoMedicamentoDAO extends DAO<FormatoMedicamento>{
    
    @Override
    public boolean inserir(FormatoMedicamento element) {
        try{
            String comando = "INSERT INTO formato (descricao) VALUES (?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
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
    public boolean alterar(FormatoMedicamento element) {
        try{
            String comando = "UPDATE formato SET descricao = ? " 
                    +"WHERE id_formato = ?;";
            
            PreparedStatement stmt = conn.prepareStatement(comando);
            
            stmt.setString(1, element.getDescricao());
            stmt.setInt(2, element.getId());
            
            if(stmt.executeUpdate() == 1) {
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao alterar: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(FormatoMedicamento element) {
        try{
            String comando = "DELETE FROM formato WHERE id_formato = ?";
            
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
    public List<FormatoMedicamento> listar() {
        List<FormatoMedicamento> lstFormatoMedicamento = new ArrayList<>();
        lstFormatoMedicamento = ObservableCollections.observableList(lstFormatoMedicamento);
        
        String sql = "SELECT * from formato;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                FormatoMedicamento fm = new FormatoMedicamento();
                fm.setId(rs.getInt("id_formato"));
                fm.setDescricao(rs.getString("descricao"));
                lstFormatoMedicamento.add(fm);
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao listar os formatos dos medicamentos");
            System.out.printf(e.getMessage());
        }
        return lstFormatoMedicamento;
    }
}
