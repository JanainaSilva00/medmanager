package medmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Janaina
 * @param <E>
 */
public abstract class DAO<E> {
    protected Connection conn;
    
    public abstract boolean inserir(E element);
    public abstract boolean alterar(E element);
    public abstract boolean remover(E element);
    public abstract List<E> listar();
    
    public DAO()
    {
        String url = "jdbc:mysql://127.0.0.1:3308/medmanager?serverTimezone=UTC";
        String user = "root";
        String password = "";
        
        try {
           Class.forName("com.mysql.cj.jdbc.Driver"); 
           conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro no driver");
        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        }
    }
}
