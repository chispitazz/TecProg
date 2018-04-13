
import java.util.*;


class DIRECTORIO extends NODO{
		int size;
		LinkedList<NODO> hijitos = new LinkedList<NODO>();

		public DIRECTORIO (String nombreDirectorio){
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