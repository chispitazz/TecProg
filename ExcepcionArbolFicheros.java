//ExcepcionArbolFicheros.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
class ExcepcionArbolFicheros extends Exception{
	String nombreExcept;
}

class ExcepcionNoExiste extends ExcepcionArbolFicheros{
	public ExcepcionNoExiste(String nombre){
		nombreExcept="No existe elemento con nombre " + nombre + " en el directorio actual";
	}
	public String toString(){
		return nombreExcept;
	}
}

class Error extends ExcepcionArbolFicheros{
	public Error(String nombre){
		nombreExcept=nombre;
	}
	public String toString(){
		return nombreExcept;
	}
}

class ExcepcionNombreIncorrecto extends ExcepcionArbolFicheros{
	public ExcepcionNombreIncorrecto(String nombre){
		nombreExcept="Nombre introducido: " + nombre + " NO valido";
	}
	public String toString(){
		return nombreExcept;
	}
}

class ExcepcionNombreRepetido extends ExcepcionArbolFicheros{
	public ExcepcionNombreRepetido(String nombre){
		nombreExcept="YA EXISTE elemento con nombre: " + nombre + " en el directorio";
	}
	public String toString(){
		return nombreExcept;
	}
}

class ExcepcionNombreRaiz extends ExcepcionArbolFicheros{
	public ExcepcionNombreRaiz(String nombre){
		nombreExcept="Nombre: " + nombre + " no valido para ser raiz de la ruta";
	}
	public String toString(){
		return nombreExcept;
	}
}

class ExcepcionTamanyoIncorrecto extends ExcepcionArbolFicheros{
	public ExcepcionTamanyoIncorrecto(){
		nombreExcept="No se puede asignar un tamanyo negativo a un archivo";
	}
	public String toString(){
		return nombreExcept;
	}
}


class ExcepcionOverflow extends ExcepcionArbolFicheros{
	public ExcepcionOverflow(){
		nombreExcept="NO se puede RETROCEDER mas alla de la raiz";
	}
	public String toString(){
		return nombreExcept;
	}
}

class ExcepcionNoEsDirectorio extends ExcepcionArbolFicheros {
	public ExcepcionNoEsDirectorio(String nombre) {
		nombreExcept = "El elemento: " + nombre + " al que se pretende acceder no\n es un directorio ni un enlace a uno";
	}
	public String toString() {
		return nombreExcept;
	}
}
