package control.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.dao.coffe.CoffeDAO;
import model.dao.coffe.CoffeDAOImpl;
import model.dao.person.PersonDAO;
import model.dao.person.PersonDAOImpl;
import model.dao.room.RoomDAO;
import model.dao.room.RoomDAOImpl;
import model.entity.coffe.Coffe;
import model.enumeration.PrimaryMenu;
import model.enumeration.SecondaryMenu;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		PrimaryMenu pMenu = PrimaryMenu.INVALID;
		SecondaryMenu sMenu = SecondaryMenu.INVALID;
		
		CoffeDAO coffeDAO = new CoffeDAOImpl();
		PersonDAO personDAO = new PersonDAOImpl();
		RoomDAO roomDAO = new RoomDAOImpl();
		
		System.out.println(
				"Digite um numero para selecionar uma opção"
				+ "\n1 - Sala do café"
				+ "\n2 - Sala do evento"
				+ "\n3 - Pessoas do evento"
				+ "\n4 - Mudar etapa do evento"
				+ "\n5 - Sair");
		
		while (pMenu == PrimaryMenu.INVALID) {
			try {
				pMenu = PrimaryMenu.values()[Integer.parseInt(in.next()) - 1];
			} catch (InputMismatchException ime) {
				System.out.println("Digite apenas numeros inteiros nos menus.");
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.out.println("Digite apenas os numeros do display.");
			}
		}
		
		while (pMenu != PrimaryMenu.EXIT) {

			switch (pMenu) {

			case COFFE:
				while (sMenu != SecondaryMenu.EXIT) {
					System.out.println(
							"Café - Opções"
							+ "\n1 - Cadastrar"
							+ "\n2 - Sair");
					try {
						sMenu = SecondaryMenu.values()[Integer.parseInt(in.next()) - 1];
					} catch (InputMismatchException ime) {
						System.out.println("Digite apenas numeros inteiros nos menus.");
						pMenu = PrimaryMenu.INVALID;
					} catch (ArrayIndexOutOfBoundsException aiobe) {
						System.out.println("Digite apenas os numeros do display.");
						pMenu = PrimaryMenu.INVALID;
					}

					switch (sMenu) {

					case INSERT:

							System.out.println("Digite o nome da sala de café:");
							String name = in.next();
							coffeDAO.insertCoffe(new Coffe(name));
							System.out.println("Sala do café inserida.");

						break;

					}
				}
				
				break;
				
			case ROOM:
				while (sMenu != SecondaryMenu.EXIT) {
					System.out.println(
							"Sala - Opções"
							+ "\n1 - Cadastrar"
							+ "\n2 - Sair");
					try {
						sMenu = SecondaryMenu.values()[Integer.parseInt(in.next()) - 1];
					} catch (InputMismatchException ime) {
						System.out.println("Digite apenas numeros inteiros nos menus.");
						pMenu = PrimaryMenu.INVALID;
					} catch (ArrayIndexOutOfBoundsException aiobe) {
						System.out.println("Digite apenas os numeros do display.");
						pMenu = PrimaryMenu.INVALID;
					}

					switch (sMenu) {

					case INSERT:

							System.out.println("Digite o nome da sala de evento:");
							String name = in.next();
							System.out.println("")
							roomDAO.insertRoom(new Room(name));
							System.out.println("Sala do evento inserida.");

						break;

					}
				}
				
				break;
				
			case PERSON:
				while (sMenu != SecondaryMenu.EXIT) {
					System.out.println(
							"Pessoa - Opções"
							+ "\n1 - Cadastrar"
							+ "\n2 - Sair");
					try {
						sMenu = SecondaryMenu.values()[Integer.parseInt(in.next()) - 1];
					} catch (InputMismatchException ime) {
						System.out.println("Digite apenas numeros inteiros nos menus.");
						pMenu = PrimaryMenu.INVALID;
					} catch (ArrayIndexOutOfBoundsException aiobe) {
						System.out.println("Digite apenas os numeros do display.");
						pMenu = PrimaryMenu.INVALID;
					}

					switch (sMenu) {

					case INSERT:

							System.out.println("Digite o nome da sala de café:");
							String name = in.next();
							coffeDAO.insertCoffe(new Coffe(name));
							System.out.println("Sala do café inserida.");

						break;

					}
				}
				
				break;
			}
		}

	}

}