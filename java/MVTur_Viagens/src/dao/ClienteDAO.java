package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Clientes;

public class ClienteDAO {
 
	//create
	public void create(Clientes cliente) {
		
	    String sql = "INSERT INTO Clientes (Nome, CPF, Email, Telefone) VALUES('?', '?', '?', '?')";

	    Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
		    connection = ConnectionMySQL.createConnectionMySQL();

		    preparedStatement = connection.prepareStatement(sql);

		    preparedStatement.setString(1, cliente.getNome());
		    preparedStatement.setString(2, cliente.getCPF());
		    preparedStatement.setString(3, cliente.getEmail());
		    preparedStatement.setString(4, cliente.getTelefone());
		   

		    preparedStatement.execute();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			    

			    if (preparedStatement != null) {
			        connection.close();
			    }
			}catch (Exception e) {
				e.printStackTrace();
		}
	}
}
	
	
	//read
	public List<Clientes> read(){
		List<Clientes> Clientes = new ArrayList<Clientes>();
		String sql = "select * from Clientes";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Clientes cliente = new Clientes();
				 
				cliente.setId(rset.getInt("idcliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setCPF(rset.getString("cpf"));
				cliente.setEmail(rset.getString("email"));
				cliente.setTelefone(rset.getString("telefone"));
				
				Clientes.add(cliente);

			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null)
			        pstm.close();
			    

			    if (conn != null) {
			        conn.close();
			    }
			}catch (Exception e) {
				e.printStackTrace();
		}
		}
		
		return Clientes;
	}
	
	//update
	public void update(Clientes cliente) {
		String sql = "UPDATE Clientes SET nome= ?, CPF = ?, email = ?, telefone = ? WHERE idClientes = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
		    conn = ConnectionMySQL.createConnectionMySQL();

		    pstm = conn.prepareStatement(sql);

		    pstm.setString(1, cliente.getNome());
		    pstm.setString(2, cliente.getCPF());
		    pstm.setString(3, cliente.getEmail());
		    pstm.setString(4, cliente.getTelefone());
		    pstm.setInt(5, cliente.getId());
		   

		    pstm.execute();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null)
			        pstm.close();
			    

			    if (conn != null) {
			        conn.close();
			    }
			}catch (Exception e) {
				e.printStackTrace();
		}
	 }

	}
	
	
	//delete
	public void delete(int id) {
		String sql = "DELETE FROM Clientes WHERE idClientes = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
		    conn = ConnectionMySQL.createConnectionMySQL();

		    pstm = conn.prepareStatement(sql);

		    pstm.setInt(1, id);
		   

		    pstm.execute();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null)
			        pstm.close();
			    

			    if (conn != null) {
			        conn.close();
			    }
			}catch (Exception e) {
				e.printStackTrace();
		}
	 }

	}
	
	//readByid
	public Clientes readByid(int id) {
		Clientes Clientes = new Clientes();
		String sql = "select * FROM Clientes WHERE idcliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
		    conn = ConnectionMySQL.createConnectionMySQL();

		    pstm = conn.prepareStatement(sql);

		    pstm.setInt(1, id);
		    
		    rset = pstm.executeQuery();
		    
		    rset.next();
		    
		    Clientes.setId(rset.getInt("idcliente"));
			Clientes.setNome(rset.getString("nome"));
			Clientes.setCPF(rset.getString("cpf"));
			Clientes.setEmail(rset.getString("email"));
			Clientes.setTelefone(rset.getString("telefone"));
		   

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null)
			        pstm.close();
			    

			    if (conn != null) {
			        conn.close();
			    }
			}catch (Exception e) {
				e.printStackTrace();
		}
	 }
		
		return Clientes;
	}
}



















