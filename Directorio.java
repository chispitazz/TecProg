//Directorio.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
import java.util.*;


class Directorio extends Nodo{
		//-----Atributos de Directorio-----
		int size;
		LinkedList<Nodo> hijitos = new LinkedList<Nodo>();

		//-----Constructor de Directorio-----
		//Constructor de Directorio dado un nombreDirectorio
		public Directorio (String nombreDirectorio){
			//COMPROBAR QUE nombreDirectorio es CORRECTO
			nombreNodo = nombreDirectorio;
			size=0;
		}

		//-----Métodos de Directorio-----
		//Añade a la lista de nodos del Directorio el nuevo nodo
		public boolean addNodo(Nodo NodoAnyadir){
			return hijitos.add(NodoAnyadir);
		}

		//Devuelve el valor de size calculado según el contenido de la lista de Nodos
		public int getSize(){
			size=0;
			//Iteramos la lista
			for(Iterator i = hijitos.iterator();i.hasNext();){

				Nodo aux= (Nodo) i.next();
				size= size+aux.getSize();
			}
			return size;
		}

		//Lista el contenido de la lista de Nodos de Directorio
		public String listarDirectorio (){
			String listado="";
			for(Iterator i = hijitos.iterator();i.hasNext();){

				Nodo aux = (Nodo) i.next();
				listado = listado+aux.getNombre()+"\n";
			}
			return listado;

		}

		//Devuelve cierto si existe un Directorio con nombre buscado en Directorio
		public boolean buscarDirectorio(String buscado) {
			boolean esta = false;
			for(Iterator i = hijitos.iterator(); i.hasNext() & !esta;){

				Nodo aux = (Nodo) i.next();
				if (aux instanceof Directorio) { //Si aux es directorio
					esta = buscado.equals(aux.getNombre());
				}

			}
			return esta;
		}
		public Directorio cogerDirectorio(String buscado){
			boolean esta = false;
			for(Iterator i = hijitos.iterator(); i.hasNext() & !esta;){
				Nodo aux = (Nodo) i.next();
				if (aux instanceof Directorio) { //Si aux es directorio
					esta = buscado.equals(aux.getNombre());
					if(esta){
						return (Directorio) aux;
					}
				}

			}
			return  (Directorio) hijitos.getLast();
			
		}
		
}