//Nodo.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
abstract class Nodo 
{
	//-----Atributos de Nodo-----
	String nombreNodo;
	
	//-----Métodos de Nodo-----

	//Devuelve el nombre del nodo 
	public String getNombre(){
		return nombreNodo;
	}
	//Comprueba que el nombre que se quiere asignar a un Nodo es correcto
	public boolean nombreCorrecto (String nombreCand) throws ExcepcionNombreIncorrecto {
		try {		
			if (nombreCand.equals(".") || nombreCand.equals("..") || //Nombre != "." || ".."
				(nombreCand.length() > 0 && nombreCand.split("/").length > 1) || //Nombre no vacio y no contiene "/"
				(nombreCand.length() > 0 && nombreCand.split(" ").length > 1)) { //Nombre no vacío y contiene " "
				System.out.println("Voy a lanzar excepcion");
				throw new ExcepcionNombreIncorrecto(nombreCand);
			}
			else {
				return true;
			}
		}
		catch (ExcepcionNombreIncorrecto e) {
			return false;
		}
	}
	//Devuelve el valor de Nodo
	abstract Nodo getNode();
	//Devuelve el tamaño del Nodo apuntado por el objeto que invoca el método
	abstract  int getSize(); 
}