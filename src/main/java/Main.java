import exception.ProductAlreadyExisteException;
import exception.ProductNotFoundException;

import java.util.Scanner;


public class Main {
	
	static User user = new User();
	static Repository repository = new Repository();
	static Scanner sc;

	public static void main(String[] args) {

		System.out.println("Bienvenue à notre simple application CLI!");
		sc = new Scanner(System.in);
		String input = "";
		System.out.println("Merci d'insérer ces informations pour vous inscrire: ");
		System.out.println("ID:");
		String userID = sc.nextLine();
		System.out.println("Nom:");
		String userName = sc.nextLine();
		System.out.println("Age:");
		String ageUser = sc.nextLine();
		System.out.println("Email:");
		String emailUser = sc.nextLine();
		System.out.println("Mot de passe:");
		String passwordUser = sc.nextLine();

		user.setID(userID);
		user.setName(userName);
		user.setAge(ageUser);
		user.setEmail(emailUser);
		user.setPassword(passwordUser);



		while (!input.equals(-1)) {
			menu();
			input = sc.nextLine();
			switchCaseOfInput(input);
		}
		sc.close();

	}

	private static void switchCaseOfInput(String input) {
		switch (input) {
		case "0": {
			repository.diplayProducts();
			break;
		}
		case "1": {
			System.out.println("ID :");
			String idProduct = sc.nextLine();
			try {
				System.out.println(repository.fetchProductById(idProduct));
			} catch (ProductNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case "2": {
			System.out.println("Saisir  l'ID du produit à ajouter :");
			String idProduct = sc.nextLine();
			System.out.println("Saisir le nom du produit :");
			String nameProduct = sc.nextLine();
			System.out.println("Saisir le prix du produit :");
			String priceProduct = sc.nextLine();
			System.out.println("Saisir la date d'expiration du produit :");
			String dateString = sc.nextLine();
			try {
				System.out.println(repository.addNewProduct(new Product(idProduct, nameProduct, priceProduct, dateString)));
			} catch (ProductAlreadyExisteException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case "3": {
			System.out.println("Donner l'ID du produit à supprimer :");
			String idProduct = sc.nextLine();
			try {
				System.out.println(repository.deleteProduct(idProduct));
			} catch (ProductNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case "4": {
			System.out.println("Donner l'ID du produit que vous voulez mettre à jour :");
			String idProduct = sc.nextLine();
			System.out.println("Saisir le nouveau nom :");
			String nameProduct = sc.nextLine();
			System.out.println("Saisir le nouveau prix :");
			String priceProduct = sc.nextLine();
			System.out.println("Saisir la nouvelle date d'expiration :");
			String dateString = sc.nextLine();
			try {
				System.out.println(repository.updateProduct(new Product(idProduct, nameProduct, priceProduct, dateString)));
			} catch (ProductNotFoundException | ProductAlreadyExisteException e) {
				System.out.println(e.getMessage());
			}
			break;
		}

		case "-1":
			System.out.println("Au revoir...");
			return;

		default:
			System.err.println("Veuillez choisir un nombre correspondant à une option dans le menu.");
			return;
		}
	}



	private static void menu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Veuillez choisir une option :");
		sb.append('\n');
		sb.append("0.Afficher produits.\n");
		sb.append("1.Chercher un produit par son ID.\n");
		sb .append("2.Ajouter un nouveau produit.\n");
		sb.append("3.Supprimer un produit par son ID.\n");
		sb.append("4.Mise a jour d'un produit.\n");
		sb.append("\n" + "-1" + ". Pour quitter.");

		System.out.println(sb.toString());
	}


	public static User getUser() {
		return user;
	}

}
