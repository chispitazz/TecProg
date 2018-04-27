//Enlace.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
import java.lang.Iterable;
import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

class Enlace extends Nodo
{
	//-----Atributos de Enlace-----
	Nodo NodoEnlazado;

	//-----Constructor de Enlace-----
	public Enlace (Nodo nodete,String nombre) throws ExcepcionArbolFicheros{
		NodoEnlazado=nodete;
		nombreNodo=nombre;
		boolean nombreCorrecto = this.nombreCorrecto(nombre);
	}

	//-----Métodos de Enlace-----
	//Devuelve el tamaño del Nodo apuntado por el objeto que invoca el método
	public int getSize(){
		return 0;
	}

	public Nodo getNode(){
		return NodoEnlazado.getNode();
	}

}