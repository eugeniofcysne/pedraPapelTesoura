import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class BancoDeDados {
	
	
	
public void gravarPartida(String jogador.nome, String computador.nome, Escolha jogador.escolha, Escolha computador.escolha ){
	
	Connection conn = null;
	try {		
	conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/pedraPapelTesoura?user=root&password=solei1slime");
	} catch (SQLException e) {
	// tratar erros
		e.printStackTrace();
	}
	
	
	String sql = "SELECT * FROM aluno;";
		Statement stmt;
	ResultSet rs;
	try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString("codAluno"));//no lugar de codAluno colocar o nome da coluna que eu quero pegar
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
	} finally { // liberar recursos 
	}
	Statement stmtUpdate;
	sql = "insert into Aluno values (null, 'Luciano da Silva', 5555505,  1, '1998-03-03',1);";
	try {
		stmtUpdate=conn.createStatement();
		stmtUpdate.executeUpdate(sql);
	}
	catch(SQLException e1) {
		e1.printStackTrace();
	}
	
	sql="SELECT * FROM aluno;";
	try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString("codAluno"));//no lugar de codAluno colocar o nome da coluna que eu quero pegar
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
	} finally { // liberar recursos 
	}
	
	
	try {
		conn.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	}
}