import java.lang.Iterable;
import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

class Archivo extends Nodo{

	public Archivo(String NombreArchivo,int tamanyoArchivo){
		nombreNodo=NombreArchivo;
		size=tamanyoArchivo;
	}

	public int getSize(){
			return size;
	}
	
	public void setSize(int tamanyoArchivo){
			size=tamanyoArchivo;
	}

}