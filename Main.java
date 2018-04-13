import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Main {
   public static void main(String[] args) {

   	//Declaramos directorios
	Directorio raiz= new Directorio("patata");
	Archivo Arriba = new Archivo("Espanya.txt",0);
	Archivo MasArriba = new Archivo("Francia.exe",100);
	Archivo EnlaCumbre = new Archivo("Alemania.NEPE",101);
	// Los anyadimos
	raiz.addNodo(Arriba);
	raiz.addNodo(MasArriba);
	raiz.addNodo(EnlaCumbre);

	// Imprimimos resultado
	int resul=raiz.getSize();
	System.out.println("Este es el resultado: "+resul);

	//	Probamos la ruta
	Ruta rutilla= new Ruta(raiz);
	// Probamos ls sobre una ruta
	rutilla.ls();
   }
};
