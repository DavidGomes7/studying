
package rpgcreationtools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jdavi
 */
public class ConexaoBD {
    public Connection conectar(){
		Connection conn = null;

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpgcreationtools", "root", null);

			if(conn != null) {
				System.out.println("Conexão estabelecida");
			} else {
				System.out.println("Não foi possível estabeler a conexão");
			}

		} catch (SQLException error) {
			System.err.println("Erro: " + error.getMessage());
		} 
		

		return conn;
	}
}
