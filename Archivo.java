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
	public Archivo(String NombreArchivo,int tamanyoArchivo) throws ExcepcionArbolFicheros {
		nombreNodo=NombreArchivo;
		size=tamanyoArchivo;
		boolean nombreCorrecto = this.nombreCorrecto(NombreArchivo);
		if (!nombreCorrecto) {
			nombreNodo = null;
			size = -1; 
		}
	}

	//-----Métodos  de Archivo-----
	//Cambia el valor de size de un Archivo a tamanyoArchivo
	public void setSize(int tamanyoArchivo) throws ExcepcionArbolFicheros {
		if(tamanyoArchivo < 0) {
			throw new ExcepcionTamanyoIncorrecto();
		}
		else {
			size=tamanyoArchivo;
		}
	}

	//Devuelve el valor de size de Archivo
	public int getSize(){
		return size;
	}
	//Devuelve el valor de Nodo
	public Nodo getNode(){
		return this;
	}

	

}