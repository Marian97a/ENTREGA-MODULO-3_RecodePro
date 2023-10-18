package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Clientes;
import modelos.Destinos;
import modelos.Passagens;

public class PassagensDAO {
	//create
		public void create(Passagens Passagem) {
			
		    String sql = "INSERT INTO Passagem (valorPassagem, idPassagens, idDestino)VALUES(?, ?, ?),";

		    Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
			    connection = ConnectionMySQL.createConnectionMySQL();

			    preparedStatement = connection.prepareStatement(sql);

			    preparedStatement.setDouble(1, Passagem.getvalor_passagens());
			    preparedStatement.setInt(2, Passagem.getDestino().getId());
			    preparedStatement.setInt(3, Passagem.getCliente().getId());
			 
			   

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
		public List<Passagens> read(){
			List<Passagens> Passagens = new ArrayList<Passagens>();
			String sql = " select * from cliente_destino";
			
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			ResultSet rset = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				preparedStatement = conn.prepareStatement(sql);
				rset = preparedStatement.executeQuery();
				
				while (rset.next()) {
					Passagens Passagem = new Passagens();
					Destinos destino = new Destinos();
					Clientes cliente = new Clientes();
					 
					Passagem.setId(rset.getInt("idPassagens"));
					Passagem.setvalor_passagens(rset.getDouble("valor_passagem"));
					
					destino.setId(rset.getInt("id_destino"));
					destino.setOrigem(rset.getString("Origem"));
					destino.setDestino(rset.getString("Destino"));
					destino.setPartida(rset.getString("Partida"));
					destino.setChegada(rset.getString("Chegada"));
				
					cliente.setId(rset.getInt("idcliente"));
					cliente.setNome(rset.getString("nome"));
					cliente.setCPF(rset.getString("cpf"));
					cliente.setEmail(rset.getString("email"));
					cliente.setTelefone(rset.getString("telefone"));
					
					Passagem.setDestino(destino);
					Passagem.setCliente(cliente);
					
					Passagens.add(Passagem);

				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (preparedStatement != null)
				        preparedStatement.close();
				    

				    if (conn != null) {
				        conn.close();
				    }
				}catch (Exception e) {
					e.printStackTrace();
			}
			}
			
			return Passagens;
		}
		
		//update
		public void update(Passagens Passagem) {
			String sql = "UPDATE Passagem SET valorPassagem = ?, fk_Clientes_idClientes = ?, fk_Destinos_idDestino = ? WHERE idPassagem = ?";
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
			    connection = ConnectionMySQL.createConnectionMySQL();

			    preparedStatement = connection.prepareStatement(sql);

			    preparedStatement.setDouble(1, Passagem.getvalor_passagens());
			    preparedStatement.setInt(2, Passagem.getDestino().getId());
			    preparedStatement.setInt(3, Passagem.getCliente().getId());
			    preparedStatement.setInt(4, Passagem.getId());
			 
			   

			    preparedStatement.execute();

			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				    

				    if (connection != null) {
				        connection.close();
				    }
				}catch (Exception e) {
					e.printStackTrace();
			}
		 }

		}
		
		
		//delete
		public void delete(int id) {
			String sql = "DELETE FROM Passagens WHERE idPassagens = ?";
			
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			try {
			    conn = ConnectionMySQL.createConnectionMySQL();

			    preparedStatement = conn.prepareStatement(sql);

			    preparedStatement.setInt(1, id);
			   

			    preparedStatement.execute();

			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (preparedStatement != null)
				        preparedStatement.close();
				    

				    if (conn != null) {
				        conn.close();
				    }
				}catch (Exception e) {
					e.printStackTrace();
			}
		 }

		}
		
		//readByid
		public Passagens readByid(int id) {
			Passagens Passagem = new Passagens();
			String sql = "select * from cliente_destino  WHERE idPassagens = ?";
			
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			ResultSet rset = null;
			
			try {
			    conn = ConnectionMySQL.createConnectionMySQL();

			    preparedStatement = conn.prepareStatement(sql);

			    preparedStatement.setInt(1, id);
			    
			    rset = preparedStatement.executeQuery();
			    
			    rset.next();
			    
				Destinos destino = new Destinos();
				Clientes cliente = new Clientes();
				 
				Passagem.setId(rset.getInt("idPassagens"));
				Passagem.setvalor_passagens(rset.getDouble("valor_passagem"));
				
				destino.setId(rset.getInt("id_destino"));
				destino.setOrigem(rset.getString("Origem"));
				destino.setDestino(rset.getString("Destino"));
				destino.setPartida(rset.getString("Partida"));
				destino.setChegada(rset.getString("Chegada"));
			
				cliente.setId(rset.getInt("idcliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setCPF(rset.getString("cpf"));
				cliente.setEmail(rset.getString("email"));
				cliente.setTelefone(rset.getString("telefone"));
				
				Passagem.setDestino(destino);
				Passagem.setCliente(cliente);
			   

			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (preparedStatement != null)
				        preparedStatement.close();
				    

				    if (conn != null) {
				        conn.close();
				    }
				}catch (Exception e) {
					e.printStackTrace();
			}
		 }
			
			return Passagem;
		}
	}
