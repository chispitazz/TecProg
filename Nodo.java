//Nodo.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
abstract class Nodo 
{
	//-----Atributos de Nodo-----
	String nombreNodo;
	
	//-----Métodos de Nodo-----
	
	//El nombre del nodo pasa a ser <<nombre>>	
	public void setNombre(String nombre){
		nombreNodo=nombre;
	}
	//Devuelve el nombre del nodo 
	public String getNombre(){
		return nombreNodo;
	}
	
	abstract  int getSize();
}