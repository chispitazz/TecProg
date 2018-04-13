
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
			Directorio ultimo = (Directorio) hijitosRuta.getLast();
			String pantalla= ultimo.listarDirectorio();
			System.out.print(pantalla);
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