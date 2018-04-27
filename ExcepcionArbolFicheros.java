//ExcepcionArbolFicheros.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */

//@SuppresWarnings("serial") para evitar warnings de compilacion innecesarios

/*
 * ExcepcionArbolFicheros es la clase padre cuyos hijos son los distintos
 * tipos de excepciones que pueden considerarse en un ábrol de ficheros
 */
@SuppressWarnings("serial")
public class ExcepcionArbolFicheros extends Exception{
	String nombreExcept;

	public ExcepcionArbolFicheros(String nombre){
		nombreExcept =nombre;
	}
}

/*
 * ExcepcionNoExiste se da cuando en un directorio no se encuentre un elemento
 * de nombre "nombre"
 */
@SuppressWarnings("serial")
class ExcepcionNoExiste extends ExcepcionArbolFicheros{
	public ExcepcionNoExiste(String nombre){
		super("\nNO EXISTE elemento " + nombre + " EN el DIRECTORIO ACTUAL\n");
	}
	public String toString(){
		return nombreExcept;
	}
}

/*
 * ExcepcionNombreIncorrecto se da cuando el nombre que se ha querido dar a un
 * directorio, archivo o enlace no cumple las restricciones pertinentes
 */
@SuppressWarnings("serial")
class ExcepcionNombreIncorrecto extends ExcepcionArbolFicheros{
	public ExcepcionNombreIncorrecto(String nombre){
		super("\n" + nombre + " NO VALIDO\n");
	}
	public String toString(){
		return nombreExcept;
	}
}

/*
 * ExcepcionNombreRepetido se da cuando ya existen un elemento con nombre "nombre"
 * en un directorio
 */
@SuppressWarnings("serial")
class ExcepcionNombreRepetido extends ExcepcionArbolFicheros{
	public ExcepcionNombreRepetido(String nombre){
		super("\nYA EXISTE ELEMENTO con nombre: " + nombre + " en el directorio\n");
	}
	public String toString(){
		return nombreExcept;
	}
}

/*
 * ExcepcionNombreRaiz se da cuando el nombre que se ha querido dar a la raiz
 * de una ruta no cumple con las restricciones
 */
@SuppressWarnings("serial")
class ExcepcionNombreRaiz extends ExcepcionArbolFicheros{
	public ExcepcionNombreRaiz(String nombre){
		super("\nNOMBRE: " + nombre + " NO VALIDO para directorio RAIZ de la ruta\n");
	}
	public String toString(){
		return nombreExcept;
	}
}

/*
 * Se lanza al intentar asignar un tamaño negativo a un archivo
 */
@SuppressWarnings("serial")
class ExcepcionTamanyoIncorrecto extends ExcepcionArbolFicheros{
	public ExcepcionTamanyoIncorrecto(){
		super("\nNo se puede asignar un TAMANYO NEGATIVO a archivo\n");
	}
	public String toString(){
		return nombreExcept;
	}
}

/*
 * Se da cuando el Nodo al que se está intentando acceder no es 
 * de instancia Directorio
 */
@SuppressWarnings("serial")
class ExcepcionNoEsDirectorio extends ExcepcionArbolFicheros {
	public ExcepcionNoEsDirectorio(String nombre) {
		super("\nEl elemento: " + nombre + " al que se pretende acceder NO\nes un DIRECTORIO NI ENLACE a uno\n");
	}
	public String toString() {
		return nombreExcept;
	}
}

/*
 * Se da cuando el Nodo al que se está intentando acceder no es de 
 * instancia Archivo
 */
@SuppressWarnings("serial")
class ExcepcionNoEsArchivo extends ExcepcionArbolFicheros {
	public ExcepcionNoEsArchivo(String nombre) {
		super("\nEl elemento: " + nombre + " al que se pretende acceder no\nes un ARCHIVO NI ENLACE a uno");
	}
	public String toString() {
		return nombreExcept;
	}
}

/*
 * Se da cuando se intenta dar un tamaño negativo a un archivo
 */
@SuppressWarnings("serial")
class Tamano extends ExcepcionArbolFicheros{
	public Tamano(String nombre){
		super("\nNo se puede asignar un TAMANYO NEGATIVO a archivo: " + nombre + "\n");
	}
	public String toString(){
		return nombreExcept;
	}
}
/*
 * Se da cuando se intenta borrar un directorio o enlace a directorio que se encuentra
 * en tu path
 */
@SuppressWarnings("serial")
class Autoeliminacion extends ExcepcionArbolFicheros {
	public Autoeliminacion(String nombre) {
		super("El elemento: " + nombre + " que pretendias borrar esta en tu path");
	}
	public String toString() {
		return nombreExcept;
	}
}