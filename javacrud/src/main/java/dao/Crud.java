package dao;

import java.util.List;

import modelo.Cliente;

public interface Crud {
	
	public static void create (Cliente cliente) {};
	public static void delete(int clienteId) {};
	public static List<Cliente> find(String pesquisa){return null;};
	public static Cliente findByPK(int clienteId) {return null;}
    public static void update(Cliente cliente) {}
}
