package it.epicode.playerMultimediale;

import java.util.Scanner;

public class LettoreMultimediale {
//	Variables d'appoggio e Array
	static String titolo, tipo, n;
	static int luminosita;
	static Scanner in = new Scanner(System.in);

//Main
	public static void main(String[] args) {
		ElementoMultimediale[] arr = new ElementoMultimediale[5];
//		Welcome message
		System.out.printf("Benvenuto, per avviare il Lettore Multimediale si prega di inserire 5 Elementi:%n");
//		Data Acquisition
		for (int i = 0; i < arr.length; i++) {
			System.out.printf(
					"%n------------------------------------------------------%nElemento-%d%n %nScegliere la tipologia del contenuto:%n- Immagine (digitare 'i')%n- Registrazione (digitare 'r')%n- Video (digitare 'v')%n------------------------------------------------------%n",
					i + 1);
			tipo = in.nextLine();
			while (!(tipo.equals("i") || tipo.equals("r") || tipo.equals("v"))) {
				System.out.printf("%nERRORE, Inserire un comando valido%n");
				tipo = in.nextLine();
			}
			;
			switch (tipo) {
			case "i":
				System.out.println("Hai scelto Immagine, adesso scegli un titolo: ");
				titolo = in.nextLine();
				arr[i] = new Immagine(titolo);
				break;
			case "r":
				System.out.println("Hai scelto Registrazione, adesso scegli un titolo: ");
				titolo = in.nextLine();
				arr[i] = new Registrazione(titolo);
				break;
			case "v":
				System.out.println("Hai scelto Video, adesso scegli un titolo: ");
				titolo = in.nextLine();
				arr[i] = new Video(titolo);
				break;
			default:
				System.out.println("Errore Generico");
			}
		}
		System.out.printf("%n5 Elementi creati correttamente%n--------------------%n%n--------------------%n");
		do {
			System.out.printf("%nSelezionare elementoda eseguire (1,2,3,4,5), Oppure arresta l'operazione (0)%n");
			n = in.nextLine();
			switch (n) {
			case "1":
				arr[0].esegui();
				break;
			case "2":
				arr[1].esegui();
				break;
			case "3":
				arr[2].esegui();
				break;
			case "4":
				arr[3].esegui();
				break;
			case "5":
				arr[4].esegui();
				break;
			case "0":
				System.out.println("Applicazione terminata correttamente");;
				break;
			default:
				System.out.printf("%nERRORE, Inserire un comando valido%n");
			}
		} while (!(n.equals("0")));
		
	}

}
