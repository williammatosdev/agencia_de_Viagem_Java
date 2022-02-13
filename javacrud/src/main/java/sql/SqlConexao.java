package sql;

import java.sql.Connection;
import java.sql.DriverManager;


public class SqlConexao {
	

		private static final String url = "jdbc:sqlserver://meuservidor1501.database.windows.net;database=Javacrud";
		private static final String usuario = "admAula0701";
		private static final String senha = "Mariane2010";
		private static Connection conexao = null;

		private SqlConexao() {
			
		}

		private static void abrirConexao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			
		
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
			
			try {
				conexao = DriverManager.getConnection(url, usuario, senha);
				System.out.println("Sucesso!");
				
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Erro!");
				
			}
			
		}
		
		public static Connection getConexao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			
			if(conexao == null) {
				abrirConexao();
			}
			return conexao;
		}

}
