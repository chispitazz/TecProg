//Directorio.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
abstract class ExcepcionArbolFichero extends Exception{
	String nombreExcept;
	abstract String toString();
}

class ExcepcionNoExiste extends ExcepcionArbolFichero{
	public ExcepcionNoExiste(String nombre){
		nombreExcept=nombre;
	}
	String toString(){
		return nombreExcept;
	}
}