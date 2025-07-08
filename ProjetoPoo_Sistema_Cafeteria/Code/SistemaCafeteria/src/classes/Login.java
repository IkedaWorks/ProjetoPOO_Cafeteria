package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectDB;

public class Login extends ConnectDB{

	public Login() {
		super();
	}
	
	public String autenticar(String email, String senha) { // Tipo String pois precisa retornar um cargo
		
		
	    String sql = "SELECT cargo FROM funcionarios WHERE email = ? AND senha = ?";

	    try (
	        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
	    ) {
	    	stmt.setString(1, email);
	    	stmt.setString(2,  senha);
	    	
	    	ResultSet rs = stmt.executeQuery();
	    	
	    	if (rs.next()) {
	    		String cargo = rs.getString("cargo");
	    		return cargo;
	    	}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	
}
