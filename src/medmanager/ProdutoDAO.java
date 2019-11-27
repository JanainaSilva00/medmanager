package medmanager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Janaina
 */
public class ProdutoDAO  extends DAO<Produto> {
    @Override
    public boolean inserir(Produto element) {
        Fornecedor f = element.getFornecedor();
        Savepoint sp;
        try{
            conn.setAutoCommit(false);
            sp = conn.setSavepoint("inicio");

        }catch(SQLException e){
            System.out.println("erro ao desligar autocommit");
            return false;
        }
        
        FornecedorDAO fd = new FornecedorDAO(conn);
        if (f.getId()==null) {
            fd.inserir(f);
        }
        
        try{
            String sql = "INSERT INTO produto("
                    + "nome, lote, quantidade, validade, id_fornecedor) "
                    + "VALUES (?, ?, ?, ?, ?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                sql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getLote());
            stmt.setInt(3, element.getQtd());
            stmt.setDate(4, element.getValidade());
            stmt.setInt(5, element.getFornecedor().getId());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setIdProduto(rs.getInt(1));
                conn.commit();
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        
        try{
            System.out.println("rollback");
            conn.rollback(sp);
            
        }catch(SQLException e){
            System.out.println("erro no rollback");
        }
        return false;
    }

    @Override
    public boolean alterar(Produto element) {
        try{
            String sql = "UPDATE produto SET nome = ?, lote = ?, quantidade = ?, "
                    + "validade = ?, id_fornecedor = ? WHERE id_produto = ?;";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getLote());
            stmt.setInt(3, element.getQtd());
            stmt.setDate(4, element.getValidade());
            stmt.setInt(5, element.getFornecedor().getId());
            stmt.setInt(6, element.getIdProduto());
            
            if(stmt.executeUpdate() == 1) {
                return true;
            }
        }catch(SQLException e){
            System.out.println("Erro ao alterar: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Produto element) {
        try{
            String sql = "DELETE FROM produto WHERE id_produto = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, element.getIdProduto());
            
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
    public List<Produto> listar() {
        List<Produto> lstProduto = new ArrayList<>();
        lstProduto = ObservableCollections.observableList(lstProduto);
        FornecedorDAO fd = new FornecedorDAO();
        
        String sql = "SELECT * from produto;";
        
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setLote(rs.getString("lote"));
                p.setQtd(rs.getInt("quantidade"));
                p.setValidade(rs.getDate("validade"));
                p.setFornecedor(fd.getById(rs.getInt("id_fornecedor")));
                lstProduto.add(p);
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao listar produtos");
            System.out.printf(e.getMessage());
        }
        return lstProduto;
    }
}