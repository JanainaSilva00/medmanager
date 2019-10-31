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
 * @author Janaina
 */
public class NivelAcessoDAO extends DAO<NivelAcesso> {
    @Override
    public boolean inserir(NivelAcesso element) {
        return false;
    }

    @Override
    public boolean alterar(NivelAcesso element) {
        try{
            String sql = "UPDATE nivel_acesso SET descricao = ? WHERE id_nivel = ?";
            
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
    public boolean remover(NivelAcesso element) {
        return false;
    }

    @Override
    public List<NivelAcesso> listar() {
        List<NivelAcesso> lstNivelAcesso = new ArrayList<>();
        lstNivelAcesso = ObservableCollections.observableList(lstNivelAcesso);
        
        String sql = "SELECT * from nivel_acesso;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                NivelAcesso n = new NivelAcesso();
                n.setDescricao(rs.getString("descricao"));
                n.setId(rs.getInt("id_nivel"));
                lstNivelAcesso.add(n);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar Niveis de Acesso");
            System.out.printf(e.getMessage());
        }
        return lstNivelAcesso;
    }
}