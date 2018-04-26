//Main.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;



class Main {
   public static void main(String[] args) {

   	//Declaramos directorios
	Directorio raiz= new Directorio("patata");
	Archivo Arriba = new Archivo("Espanya.txt",0);
	Archivo MasArriba = new Archivo("Francia.exe",100);
	Archivo EnlaCumbre = new Archivo("Alemania.NEPE",101);
	Directorio Fir= new Directorio("NP");

	// Los anyadimos
	
	raiz.addNodo(Arriba);
	raiz.addNodo(MasArriba);
	raiz.addNodo(EnlaCumbre);
	Fir.addNodo(Arriba);
	raiz.addNodo(Fir);


	// Imprimimos resultado
	int resul=raiz.getSize();
	System.out.println("Este es el resultado: "+resul);

	//	Probamos la ruta
	Ruta rutilla= new Ruta(raiz);
	// Probamos ls sobre una ruta
	rutilla.ls();
	System.out.println("\n Empieza stat \n");
	rutilla.stat("/");
	System.out.println("\n Fin stat \n");

	/*//Probamos el pwd sobre un elemento concreto
	String rutaA= rutilla.pwd();
	System.out.println(rutaA+ " Entro al CD");

	//Prueba de Vim
		rutilla.vim("Espanya.txt",50);
		rutilla.ls();
		System.out.println("\n Este es el Segundo ls \n");
		rutilla.vim("nuevoArchivo",60);
		rutilla.ls();


	//Prueba de CD
	System.out.println("\n Este es el primer cd\n");
	String Prueba2="/NP";
	rutilla.cd(Prueba2);
	rutaA= rutilla.pwd();


	System.out.println(rutaA);
	System.out.println("\n Empieza stat \n");
	rutilla.stat("Francia.exe");
	System.out.println("\n Fin stat \n");
	
	String Prueba="/NP/asfsd/popoppop";
	String carpetasRuta[] = Prueba.split("/");
	System.out.println(carpetasRuta[1]);
	System.out.println(carpetasRuta[2]);
	System.out.println(carpetasRuta[3]);*/



   }
};
