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
 * @author Alecsandre
 */
public class FornecedorDAO extends DAO<Fornecedor> {
    @Override
    public boolean inserir(Fornecedor element) {
        try{
            String sql = "INSERT INTO fornecedor(nome,telefone, cnpj) VALUES (?,?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                sql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getTelefone());
            stmt.setString(3, element.getCnpj());
            
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
    public boolean alterar(Fornecedor element) {
        try{
            String sql = "UPDATE fornecedor SET nome = ?, telefone = ? WHERE cnpj = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getTelefone());
            stmt.setString(3, element.getCnpj());
            
            if(stmt.executeUpdate() == 1) {
                return true;
            }
        }catch(SQLException e){
            System.out.println("Erro ao alterar: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Fornecedor element) {
        try{
            String sql = "DELETE FROM fornecedor WHERE cnpj = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, element.getCnpj());
            
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
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setCnpj(rs.getString("cnpj"));
                System.out.println(f.getNome());
                lstFornecedor.add(f);
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao listar fornecedores");
            System.out.printf(e.getMessage());
        }
        return lstFornecedor;
    }
}