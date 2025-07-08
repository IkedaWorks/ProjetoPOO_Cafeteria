package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectDB;

public class RH extends ConnectDB{

	
	public RH() {
		super();
	}
	
	public int insert(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, sobrenome, email, senha, endereco, cpf, cargo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getSobrenome());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getSenha());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setString(6, funcionario.getCpf());
            stmt.setString(7, funcionario.getCargo());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
	
	public int delete(int idFuncionario) {
        String sql = "DELETE FROM funcionarios WHERE id_funcionario = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, idFuncionario);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
	
	public Funcionario[] select() {
	    Funcionario[] funcionarios = null;
	    String sql = "SELECT id_funcionario, nome, sobrenome, email, cargo FROM funcionarios";

	    try (
	        PreparedStatement stmt = this.getConnection().prepareStatement(
	            sql,
	            ResultSet.TYPE_SCROLL_INSENSITIVE,
	            ResultSet.CONCUR_READ_ONLY
	        );
	        ResultSet rs = stmt.executeQuery();
	    ) {
	    	// Para contar a quantidade de linhas
	        rs.last();
	        int total = rs.getRow();
	        rs.beforeFirst();

	        // Determinando tamanho do array
	        funcionarios = new Funcionario[total];
	        int i = 0;

	        while (rs.next()) {
	            Funcionario f = new Funcionario();
	            f.setId(rs.getInt("id_funcionario"));
	            f.setNome(rs.getString("nome"));
	            f.setSobrenome(rs.getString("sobrenome"));
	            f.setEmail(rs.getString("email"));
	            f.setCargo(rs.getString("cargo"));
	            funcionarios[i++] = f;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return funcionarios;
	}

    
}
