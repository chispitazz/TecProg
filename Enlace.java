import java.lang.Iterable;
import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

class Enlace extends NODO{
		Nodo NodoEnlazado;

		public Enlace (Nodo nodete){
			NodoEnlazado=nodete;
		}
		public int getSize(){
			return NodoEnlazado.getSize();
		}
		public void setSize(){
			NodoEnlazado.setSize();
		}

}