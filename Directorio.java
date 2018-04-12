import java.lang.Iterable;
import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

class Directorio extends Nodo{
	
		LinkedList<Nodo> hijitos = new LinkedList<Nodo>();

		public Directorio (String nombreDirectorio){
			nombreNodo= nombreDirectorio;
			size=0;
		}
		public int getSize(){
			return size;
		}
		public void setSize(){
			//Calcular tamño hijitos
		}

}