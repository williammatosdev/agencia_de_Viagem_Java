package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import sql.SqlConexao;

public class ClienteDao implements Crud {

	private static Connection conexao;
	private static String sql;

	public static void create(Cliente cliente)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		sql = "INSERT INTO Cliente (nome, cpf, nascimento, situacao) VALUES (?, ?, ?, ?);";

		try {
			conexao = SqlConexao.getConexao();

			PreparedStatement preparedStatement = conexao.prepareStatement(sql);

			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");

		} catch (SQLException e) {

			System.out.println("--incorrect insert on database" + e.getMessage());

		}

	}

	public static void delete(Cliente cliente) {
		sql = "DELETE FROM Cliente WHERE cpf = ?;";

		try {
			conexao = SqlConexao.getConexao();
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getCpf());

			preparedStatement.executeUpdate();
			System.out.println("Deletado");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao deletar");
		}
	}

	public static List<Cliente> Listar() {
		sql = "SELECT * FROM Cliente";
		
		try {
			conexao = SqlConexao.getConexao();
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement = conexao.prepareStatement(sql);
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			Statement state = conexao.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while(rs.next()) {
				
				
				
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setNascimento(rs.getString("nascimento"));
				cliente.setSituacao(rs.getString("situacao"));
				clientes.add(cliente);
			}
			return clientes;	
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	public static Cliente findByPK(int clienteId) {

		return null;
	}

	public static void update(Cliente cliente) {
		sql = "UPDATE Cliente SET nome = ? WHERE cpf = ?;";

		try {
			conexao = SqlConexao.getConexao();
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());

			preparedStatement.executeUpdate();
			
			System.out.println("Atualizado");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao Atualizar");
		}

	}

}
