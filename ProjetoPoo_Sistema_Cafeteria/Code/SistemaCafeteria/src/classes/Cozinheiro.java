package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectDB;

public class Cozinheiro extends ConnectDB{

	public Cozinheiro() {
		super();
	}
	
	public int inserirReceita(Receita receita) {
	    String sql = "INSERT INTO receitas (nome_bebida, modo_preparo, observacoes) VALUES (?, ?, ?)";
	    try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
	        stmt.setString(1, receita.getNomeBebida());
	        stmt.setString(2, receita.getModoPreparo());
	        stmt.setString(3, receita.getObservacoes());
	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
	
	public String[][] listarReceitas() {
	    String sql = "SELECT id_receita, nome_bebida, modo_preparo, observacoes FROM receitas";
	    try (
	        PreparedStatement stmt = this.getConnection().prepareStatement(sql,
	            ResultSet.TYPE_SCROLL_INSENSITIVE,
	            ResultSet.CONCUR_READ_ONLY);
	        ResultSet rs = stmt.executeQuery()
	    ) {
	        rs.last();
	        int total = rs.getRow();
	        rs.beforeFirst();

	        String[][] receitas = new String[total][4];
	        int i = 0;
	        while (rs.next()) {
	            receitas[i][0] = String.valueOf(rs.getInt("id_receita"));
	            receitas[i][1] = rs.getString("nome_bebida");
	            receitas[i][2] = rs.getString("modo_preparo");
	            receitas[i][3] = rs.getString("observacoes");
	            i++;
	        }
	        return receitas;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return new String[0][0];
	    }
	}

	public int deletarReceita(int idReceita) {
	    String sql = "DELETE FROM receitas WHERE id_receita = ?";
	    try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
	        stmt.setInt(1, idReceita);
	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

}
