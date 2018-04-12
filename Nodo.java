import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

abstract class Nodo{
		String nombreNodo;
		int size; 								// Solo para Fichero y Directorio


		public void setNombre(String nombre){
			nombreNodo=nombre;
		}
		public String getNombre(){
			return nombreNodo;
		}
		abstract public void setSize();
		abstract public int getSize();
}