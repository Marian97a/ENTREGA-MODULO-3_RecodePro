package crud;

import java.util.Scanner;

import dao.DestinoDAO;
import modelos.Destinos;

public class DestinosCRUD {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			DestinoDAO destinoDAO = new DestinoDAO();
			int opcao = 0, id = 0;
			
			String origem = "", destino = "", partida = "", chegada = "";
			
			do {
				System.out.println("\n======================================= Destinos =====================================\n");
				System.out.println("1-CRIAR  2- CONSULTAR  3-ATUALIZAR  4-DELETAR  5-CONSULTAR POR ID  0-SAIR");
				opcao = s.nextInt();
				s.nextLine();
				
				switch(opcao) {
				case 1:
					   System.out.println("Digite o origem:");
					   origem = s.nextLine();
					   System.out.println("Digite o destino:");
					   destino = s.nextLine();
					   System.out.println("Digite o partida:");
					   partida = s.nextLine();
					   System.out.println("Digite o chegada:");
					   chegada = s.nextLine();
					   
					   Destinos destino1 = new Destinos (origem, destino, partida, chegada);
						
					   destinoDAO.create(destino1);
					break;
				case 2: 
					for (Destinos c : destinoDAO.read()) {
						System.out.println(c.toString());
					}
					
					break;
				case 3:
					   System.out.println("Digite o id:");
					   id = s.nextInt();
					   s.nextLine();
					   System.out.println("Digite o origem:");
					   origem = s.nextLine();
					   System.out.println("Digite o destino:");
					   destino = s.nextLine();
					   System.out.println("Digite o partida:");
					   partida = s.nextLine();
					   System.out.println("Digite o chegada:");
					   chegada = s.nextLine();
					   
					   Destinos destino2 = new Destinos(id, origem, destino, partida, chegada);
					   
					   destinoDAO.update(destino2);
					
					break;
				case 4:
					System.out.println("Digite o id:");
					id = s.nextInt();
					s.nextLine();
					   
					destinoDAO.delete(id);
					break;
				case 5:
					System.out.println("Digite o id:");
					id = s.nextInt();
					s.nextLine();
					
					Destinos destino3 = destinoDAO.readById(id);
					
					System.out.println(destino3.toString());
					break;
				default:
					
					break;
				}
				 
				
			}while (opcao != 0);
		}
		System.out.println("Até mais!");

	}

	}
