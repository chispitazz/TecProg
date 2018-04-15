import java.util.*;


class Directorio extends Nodo{
		//Atributos
		int size;
		LinkedList<Nodo> hijitos = new LinkedList<Nodo>();

		// Funciones

		public Directorio (String nombreDirectorio){
			nombreNodo= nombreDirectorio;
			size=0;
		}

		public boolean addNodo(Nodo NodoAnyadir){
			return hijitos.add(NodoAnyadir);
		}


		public int getSize(){
			int tamanyo=0;
			//Iteramos la lista
			for(Iterator i = hijitos.iterator();i.hasNext();){

				Nodo aux= (Nodo) i.next();
				tamanyo= tamanyo+aux.getSize();
			}
			return tamanyo;
		}

		public String listarDirectorio (){
			String listado="";
			for(Iterator i = hijitos.iterator();i.hasNext();){

				Nodo aux= (Nodo) i.next();
				listado= listado+aux.getNombre()+"\n";
			}
			return listado;

		}
		
}