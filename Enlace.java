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
	public Enlace (Nodo nodete,String nombre) throws ExcepcionNombreIncorrecto{
		NodoEnlazado=nodete;
		nombreNodo=nombre;
		try {
			boolean nombreCorrecto = this.nombreCorrecto(nombre);
		}
		catch (ExcepcionNombreIncorrecto e) {}
	}

	//-----Métodos de Enlace-----
	//Devuelve el tamaño del Nodo apuntado por el objeto que invoca el método
	int getSize(){
		return NodoEnlazado.getSize();
	}

	Nodo getNode(){
		return NodoEnlazado.getNode();
	}

}