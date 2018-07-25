package it.polito.tdp.anagrammi.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class DizionarioDAO {
	
	
	// metodo che verifica se l'anagramma è contenuto nel dizionario
	public boolean isCorrect(String anagramma) {
		
		final String sql = "SELECT nome FROM parola WHERE nome = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			boolean found = rs.next();
			
			conn.close();
			
			return found;
					
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
	
	
	
	
	

}
