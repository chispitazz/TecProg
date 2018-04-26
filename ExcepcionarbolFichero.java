//Directorio.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
abstract class ExcepcionArbolFichero extends Exception{
	String nombreExcept;
}

class ExcepcionNoExiste extends ExcepcionArbolFichero{
	public ExcepcionNoExiste(String nombre){
		nombreExcept=nombre;
	}
	public String toString(){
		return nombreExcept;
	}
}
class Error extends ExcepcionArbolFichero{
	public Error(String nombre){
		nombreExcept=nombre;
	}
	public String toString(){
		return nombreExcept;
	}
}