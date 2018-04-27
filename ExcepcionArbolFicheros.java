//ExcepcionArbolFicheros.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
@SuppressWarnings("serial")
public class ExcepcionArbolFicheros extends Exception{
	String nombreExcept;

	public ExcepcionArbolFicheros(String nombre){
		nombreExcept =nombre;
	}
}
@SuppressWarnings("serial")
class ExcepcionNoExiste extends ExcepcionArbolFicheros{
	public ExcepcionNoExiste(String nombre){
		super("No existe elemento con nombre " + nombre + " en el directorio actual");
	}
	public String toString(){
		return nombreExcept;
	}
}
@SuppressWarnings("serial")
class ExcepcionNombreIncorrecto extends ExcepcionArbolFicheros{
	public ExcepcionNombreIncorrecto(String nombre){
		super("Nombre introducido: " + nombre + " NO valido");
	}
	public String toString(){
		return nombreExcept;
	}
}
@SuppressWarnings("serial")
class ExcepcionNombreRepetido extends ExcepcionArbolFicheros{
	public ExcepcionNombreRepetido(String nombre){
		super("YA EXISTE elemento con nombre: " + nombre + " en el directorio");
	}
	public String toString(){
		return nombreExcept;
	}
}
@SuppressWarnings("serial")
class ExcepcionNombreRaiz extends ExcepcionArbolFicheros{
	public ExcepcionNombreRaiz(String nombre){
		super("Nombre: " + nombre + " no valido para ser raiz de la ruta");
	}
	public String toString(){
		return nombreExcept;
	}
}
@SuppressWarnings("serial")
class ExcepcionTamanyoIncorrecto extends ExcepcionArbolFicheros{
	public ExcepcionTamanyoIncorrecto(){
		super("No se puede asignar un tamanyo negativo a un archivo");
	}
	public String toString(){
		return nombreExcept;
	}
}
@SuppressWarnings("serial")
class ExcepcionNoEsDirectorio extends ExcepcionArbolFicheros {
	public ExcepcionNoEsDirectorio(String nombre) {
		super("El elemento: " + nombre + " al que se pretende acceder no\n es un directorio ni un enlace a uno");
	}
	public String toString() {
		return nombreExcept;
	}
}
