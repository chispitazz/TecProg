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
		public Directorio (String nombreDirectorio) throws ExcepcionNombreIncorrecto {
			nombreNodo = nombreDirectorio;
			size = 0;
			try {
				boolean nombreCorrecto = this.nombreCorrecto(nombreDirectorio);
				if (!nombreCorrecto) {
					System.out.println(this.nombreNodo + " no valido siendo nombreDir " + nombreDirectorio);
					nombreNodo = null; 
					size = -1; 
				}
			}
			catch (ExcepcionNombreIncorrecto e) {}
		}

		//-----Métodos de Directorio-----
		//Añade a la lista de nodos del Directorio el nuevo nodo y devuelve true si se ha añadido 
		//con exito a la lista de elementos hijos y false en cualquier otro caso
		public boolean addNodo(Nodo NodoAnyadir) throws ExcepcionNombreRepetido {
			if (hijitos.size() > 0) {
				//Si el directorio tiene algun elemento comprueba si ninguno tiene el mismo
				//nombre que el nodo a añadir
				try {
					boolean mismoNombre = false;
					String nombreAnyadir = NodoAnyadir.getNombre();
					//Buscar algun elemento con el mismo nombre
					for (Nodo i:hijitos) {
						mismoNombre = nombreAnyadir.equals(i.getNombre());
						if (mismoNombre) {
							//Existe elemento con mismo nombre -> NO se va añadir el nodo
							throw new ExcepcionNombreRepetido(this.getNombre());
						}
					}

					if (!mismoNombre) {
						//NO existe elemento con mismo nombre -> SE AÑADE el nodo
						return hijitos.add(NodoAnyadir);
					}
				}
				catch (ExcepcionNombreRepetido e) {
					//Ya hay un elemento con mismo nombre
					System.out.println(e.toString());
					return false;
				} 
			}

			else {
				//El directorio está vacío -> Se va a añadir el primer elemento
				return hijitos.add(NodoAnyadir);
			}

			//Nunca debería llegar aquí pero es para que no salten errores de compilación
			return false;
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

		//Devuelve el tamaño del Nodo apuntado por el objeto que invoca el método
		Nodo getNode(){
			return this;
		}

		//Devuelve cierto si existe un nodo con nombre "buscado" en el Directorio
		//que invoca la función
		public boolean buscarNodo(String buscado){
				boolean esta = false;
				for(Nodo i : hijitos){
						if(buscado.equals(i.getNombre()) ) {
							esta=true;
							break;
						}
					}				
				return esta;
		}

		//Devuelve el nodo con nombre "buscado" que se encuentra en el Directorio
		//que invoca la función
		public Nodo cogerNodo(String buscado){
				for(Nodo i : hijitos){
						if(buscado.equals(i.getNombre()) ) {
							return i;						
						}
				}
				return this;
		}

		//Devuelve cierto si existe un Directorio con nombre buscado en Directorio
		public boolean buscarDirectorio(String buscado) {
			boolean esta = false;
			for(Iterator i = hijitos.iterator(); i.hasNext() & !esta;){

				Nodo aux = (Nodo) i.next();
				if (aux.getNode() instanceof Directorio) { //Si aux es directorio
					esta = buscado.equals(aux.getNombre());
					
				}

			}
			return esta;
		}

		//Devuelve el directorio con nombre "buscado" que se encuentra en el Directorio
		//que invoca la función
		public Directorio cogerDirectorio(String buscado){
			boolean esta = false;
			for(Iterator i = hijitos.iterator(); i.hasNext() & !esta;){
				Nodo aux = (Nodo) i.next();
				if (aux.getNode() instanceof Directorio) { //Si aux es directorio
					esta = buscado.equals(aux.getNombre());
					if(esta){
						return (Directorio) aux;
					}
				}

			}
			return  (Directorio) hijitos.getLast();
		}

		//Busca el nodo con "nombreNodo" y lo elimina de la lista de hijos
		public void eliminar(String nombreNodo) {
			//Buscar indice 
			int index = 0;
			for (Nodo i:hijitos){
				if(!nombreNodo.equals(i.getNombre())) {
					index = index+1;
				}
				else {
					break;
				}
			}
			//Eliminar nodo de hijitos
			hijitos.remove(index);
		}
}