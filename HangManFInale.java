import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class HangManFinale {
	
	
	
	public static String inizilizzaParola(Scanner file, int random) {
		
		int counter = 0;
		String indovinaParola = " ";
		
		while ( file.hasNext() ) {
			
			String parola = file.next();
			counter++;
			
			if ( random == counter ) {
			
				indovinaParola = parola;
			
			}
		}
		
		return indovinaParola;
	}
	
	public static char[] inizializzaTrattini ( int lunghezza ) {
		
		char[] trattini = new char[lunghezza];
		
		for ( int i = 0; i < trattini.length; i++ ) {
			
			trattini[i] = '_';
		}
		
		return trattini;
	}
	
	

	public static void main ( String[] args ) throws FileNotFoundException {
		
		Scanner file = new Scanner(new File ("Lorem.txt"));
		Scanner in = new Scanner(System.in);
		int random = (int) ( Math.random() * 100 ) + 1;
		String parolaDaIndovinare = inizilizzaParola(file, random);
		char[] parolaDaIndovinareSplit = parolaDaIndovinare.toCharArray();
		char[] parolaMostrata = new char[parolaDaIndovinare.length()];
		parolaMostrata = inizializzaTrattini(parolaDaIndovinare.length());
		System.out.println("La Parola e': " + parolaDaIndovinare );
		System.out.println(" ");
		int errori = 0;
		int conto = 5;
		int trovate = 0;
		System.out.println("Hai 5 tentativi!");
		
		while ( errori < 5 && trovate < parolaDaIndovinare.length() - 1 ) {
			
			System.out.println(" ");
			String parolaDaMostrare = new String(parolaMostrata);
			System.out.println(parolaMostrata);
			System.out.println(" ");
			System.out.println("Inserisci una lettera");
			char letterina = in.next().charAt(0);
			String letterinaString = Character.toString(letterina);
			boolean trovata = false;
			
			for ( int i = 0; i < parolaDaIndovinare.length(); i++ ) {
				
				String letteraDaIndovinare = Character.toString(parolaDaIndovinareSplit[i]);
				//System.out.println("Eccomi" + letteraDaIndovinare);
				
				if ( letterinaString.equals(letteraDaIndovinare) ) {
					
					parolaMostrata[i] = letterina;
					trovata = true;
					//System.out.println("Hai Indovinato");
					//trovate++;
				}
			}
			
				if ( trovata ) {
					
					System.out.println("Hai Indovinato!");
					trovate++;
				
				} else {
					
					errori++;
					System.out.println("Hai Sbagliato!");
				}
					
				
			/*	} else {
					
					System.out.println("Hai sbagliato! Hai: " + (conto-errori) + "tentativi");
					errori++;
				}*/
			
		}
		
		System.out.println(" " );
		System.out.println("La parola era: " + parolaDaIndovinare );
	}
}