package Jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jogo.Escolha;
import Jogador.Jogador;

public class BancoDeDados {

	public static void gravarPartida(Jogador[] jogadores, Escolha escolhaVencedora, int numeroRodada) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PPT?user=root&password=cebola123");
		} catch (SQLException e) {
			// tratar erros
			e.printStackTrace();
		}

		String sql = "SELECT * FROM jogos;";
		Statement stmt;
		ResultSet rs;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("idRegistro"));// no lugar de codAluno colocar o nome da coluna que eu
																// quero pegar
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally { // liberar recursos
		}
		Statement stmtUpdate;

		for (int i = 0; i < jogadores.length; i++) {
			sql = "insert into jogos values (null, ";
			sql = sql.concat(Integer.toString(numeroRodada));
			sql = sql.concat(",'");
			sql = sql.concat(jogadores[i].getNome());
			sql = sql.concat("','");
			String pegaEscolha = "" + jogadores[i].getEscolha();
			sql = sql.concat(pegaEscolha);
			sql = sql.concat("','");
			if (jogadores[i].getEscolha() == escolhaVencedora) {
				sql = sql.concat("V');");
			} else {
				sql = sql.concat("P');");
			}
			System.out.println(sql);
	
			try {
				stmtUpdate = conn.createStatement();
				stmtUpdate.executeUpdate(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		sql = "SELECT * FROM jogos;";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("idRegistro"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally { // liberar recursos
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}