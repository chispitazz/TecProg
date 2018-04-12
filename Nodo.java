
abstract class Nodo 
{

		String nombreNodo;
		


		public void setNombre(String nombre){
			nombreNodo=nombre;
		}
		public String getNombre(){
			return nombreNodo;
		}
		abstract  int getSize();
}