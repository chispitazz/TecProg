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
	public Archivo(String NombreArchivo,int tamanyoArchivo) throws ExcepcionNombreIncorrecto {
		//COMPROBAR QUE nombreArchivo es CORRECTO
		nombreNodo=NombreArchivo;
		size=tamanyoArchivo;
		try {
			boolean nombreCorrecto = this.nombreCorrecto(NombreArchivo);
			if (!nombreCorrecto) {
				nombreNodo = null;
				size = -1; 
			}
		}
		catch (ExcepcionNombreIncorrecto e) {}
	}

	//-----Métodos  de Archivo-----
	//Cambia el valor de size de un Archivo a tamanyoArchivo
	public void setSize(int tamanyoArchivo) throws ExcepcionTamanyoIncorrecto {
		try {
			if(tamanyoArchivo < 0) {
				throw new ExcepcionTamanyoIncorrecto();
			}
			else {
				size=tamanyoArchivo;
			}
		}
		catch (ExcepcionTamanyoIncorrecto e) {
			System.out.println(e.toString());
		}
	}

	//Devuelve el valor de size de Archivo
	int getSize(){
		return size;
	}
	//Devuelve el valor de Nodo
	Nodo getNode(){
		return this;
	}

	

}