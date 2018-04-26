//Archivo.java para la ráctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */


class Archivo extends Nodo
{
	//-----Atributos de Archivo-----
	int size;

	//-----Constructor de Archivo-----
	//Constructor dado un nombreArchivo y tamanyoArchivo
	public Archivo(String NombreArchivo,int tamanyoArchivo){
		//COMPROBAR QUE nombreArchivo es CORRECTO
		nombreNodo=NombreArchivo;
		size=tamanyoArchivo;
	}

	//-----Métodos  de Archivo-----
	//Cambia el valor de size de un Archivo a tamanyoArchivo
	public void setSize(int tamanyoArchivo){
		size=tamanyoArchivo;
	}

	//Devuelve el valor de size de Archivo
	int getSize(){
		return size;
	}
	Nodo getNode(){
		return this;
	}

	

}