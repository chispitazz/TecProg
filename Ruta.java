
import java.util.*;


class Ruta extends Nodo{

		LinkedList<Nodo> hijitosRuta= new LinkedList<Nodo>();

		// ------Constructores
		

		public Ruta(Directorio nodete){
		
			hijitosRuta.add(nodete);
		}
		//-------Constructores

		//-------Funciones
		public String pwd(){
			//	Directorio base

			String ruteta="/";

			//	Se hace un bucle para recurrer la ruta e ir añadiendo los directorios de la 
			// 	forma /directorio1/directorio2

			for(Iterator i = hijitosRuta.iterator();i.hasNext();){

					Nodo aux= (Nodo) i.next();
					ruteta= ruteta +aux.getSize();
				}
				return ruteta;
		}


		public void ls(){

			// El ultimo Directorio, corresponde al directorio donde nos encontramos

			Directorio ultimo = (Directorio) hijitosRuta.getLast();

			// Accedemos a la funcion de ultimo que nos lista los elemento

			String pantalla= ultimo.listarDirectorio();
			System.out.print(pantalla);
		}

		public void stat(String element){
			String posibleNombre="";
			// Buscamos entre los elementos del ultimo Nodo (nuestro directorio)
			// cuyo nombre se corresponde a "element"
			boolean encontrado = false;
			Directorio ultimo = (Directorio) hijitosRuta.getLast();

			//Se busca sobre este ultimo directorio el archivo cuyo nombre coincida con "element"
			for(Iterator i = ultimo.hijitos.iterator();i.hasNext();){

				Nodo posibleElemento= (Nodo) i.next();
				posibleNombre= posibleElemento.getNombre();

				// Miramos si coincide
				if(posibleNombre == element){
					//Sacamos lo que nos piden por pantalla
					encontrado = true;
					int tamanyo=posibleElemento.getSize();
					System.out.println("El archivo: "+posibleNombre +" tiene un tamaño de: "+tamanyo+" bytes");
					break;
				}
			}

			//Mensaje de Debug
			if(!encontrado){
				System.out.println("Archivo no encontrado");
			}
		}
		/*
		if(n instance of dir){
			Dir d = (Dir)n
		}
		*/

		int getSize(){
			return 0;
		}
		//-------Funciones

}