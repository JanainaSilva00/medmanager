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
public class PacienteDAO extends DAO<Paciente>{

    @Override
    public boolean inserir(Paciente element) {
        try{
            String comando = "INSERT INTO funcionario (nome,cpf) VALUES (?,?);";
            
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
    public boolean alterar(Paciente element) {
        try{
            String comando = "UPDATE funcionario SET nome = ?, cpf = ? WHERE id_funcionario = ?";
            
            PreparedStatement stmt = conn.prepareStatement(comando);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getCpf());
            stmt.setInt(3, element.getId());
            
            if(stmt.executeUpdate() == 1) {
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao alterar: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Paciente element) {
        try{
            String comando = "DELETE FROM funcionario WHERE id_funcionario = ?";
            
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
    public List<Paciente> listar() {
        List<Paciente> lstPaciente = new ArrayList<>();
        lstPaciente = ObservableCollections.observableList(lstPaciente);
        
        String sql = "SELECT * from funcionario;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Paciente f = new Paciente();
                f.setId(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                System.out.println(f.getNome());
                lstPaciente.add(f);
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao listar funcionarios");
            System.out.printf(e.getMessage());
        }
        return lstPaciente;
    }
    
}