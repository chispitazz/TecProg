import java.lang.Iterable;
import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

class Enlace extends Nodo
{
		Nodo NodoEnlazado;

		public Enlace (Nodo nodete){
			NodoEnlazado=nodete;
		}

		int getSize(){
			return NodoEnlazado.getSize();
		}

}