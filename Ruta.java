//Ruta.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
import java.util.*;


class Ruta extends Nodo{
	//-----Atributos de Ruta-----
	LinkedList<Nodo> hijitosRuta= new LinkedList<Nodo>();

	//-----Constructor de Ruta-----
	public Ruta(Directorio nodete){
		hijitosRuta.add(nodete);
	}


	//-----Métodos de Ruta-----

	//Devuelve la ruta completa, con todos los nombres de los directorios desde
	//la raíz hasta el directorio actual concatenados y separados por el separador “/”
	public String pwd(){
		
		//	Directorio base
		String ruteta="/";
		
		//	Se hace un bucle para recurrer la ruta e ir añadiendo los directorios de la 
		// 	forma /directorio1/directorio2
		
		for(Iterator i = hijitosRuta.iterator();i.hasNext();){
		
				Nodo aux = (Nodo) i.next();
				ruteta = ruteta +aux.getNombre();
				if (i.hasNext()) {
					ruteta = ruteta +"/";
				}
			}
		
			return ruteta;
	}
 	
 	//Muestra por pantalla los nombres de todos los ficheros, directorios y enlaces
 	//contenidos en la ruta actual, cada uno de ellos en una línea diferente, sin
	//ningún dato más
	public void ls(){

		// El ultimo Directorio corresponde al directorio donde nos encontramos

		Directorio ultimo = (Directorio) hijitosRuta.getLast();

		// Accedemos a la funcion de ultimo que nos lista los elementos
		String pantalla= ultimo.listarDirectorio();
		System.out.print(pantalla);
	}

	//Cambia la ruta a otro directorio (path), pasándole el nombre del directorio al 
	//que quiere cambiar. Hay tres casos especiales: “.” se refiere al directorio
	//actual, “..” se refiere al directorio anterior en el árbol de directorios y “/” 
	//se refiere a la raíz del árbol de directorios. También se le puede pasar como 
	//parámetro una ruta completa (varios directorios separados por “/”)
	public void cd(String path) {
		//Dividir la cadena en caso de que hubiera una ruta
		String carpetasRuta[] = path.split("/");
		List<String> carpetasList = Arrays.asList( carpetasRuta );
		for (int i = 0; i < carpetasList.size() ; i = i+1){
			
		}
	}

	//Muestra por pantalla el número que es el tamaño del archivo, directorio o enlace
	//dentro de la ruta actual identificado por la cadena de texto que se le pasa como
	//parámetro. También se le puede pasar una ruta completa.
	public void stat(String element){
		
		String posibleNombre="";
		// Buscamos entre los elementos del ultimo Nodo (nuestro directorio)
		// cuyo nombre se corresponde a "element"
		boolean encontrado = false;
		Directorio ultimo = (Directorio) hijitosRuta.getLast();

		//Se busca sobre este ultimo directorio el archivo cuyo nombre coincida con "element"
		for(Iterator i = ultimo.hijitos.iterator();i.hasNext();){

			Nodo posibleElemento= (Nodo) i.next();
			posibleNombre= posibleElemento.getNombre();

			// Miramos si coincide
			if(posibleNombre == element){
				//Sacamos lo que nos piden por pantalla
				encontrado = true;
				int tamanyo=posibleElemento.getSize();
				System.out.println("El archivo: "+posibleNombre +" tiene un tamaño de: "+tamanyo+" bytes");
				break;
			}
		}

		//Mensaje de Debug
		if(!encontrado){
			System.out.println("Archivo no encontrado");
		}
	}

	//Cambia el tamaño de un archivo dentro de la ruta actual (no se le puede pasar como
	//parámetro una ruta completa). Si el archivo no existe dentro de la ruta actual, se 
	//crea automáticamente con el nombre y tamaño especificados. Si el archivo referenciado
	//por "file" es en realidad un enlace a un archivo, también cambia su tamaño.
	public void vim(String file, int size){
		Directorio ultimo = (Directorio) hijitosRuta.getLast();

		for(Iterator i = ultimo.hijitos.iterator();i.hasNext();){

			Nodo posibleElemento= (Nodo) i.next();
			String posibleNombre= posibleElemento.getNombre();

			// Miramos si coincide
			if(posibleNombre == file ){
					
				if(posibleElemento instanceof Archivo){
					Archivo aux= (Archivo) posibleElemento;
					aux.setSize(size);
				}
				break;
			}
		}
	}

	//Crea un directorio dentro de la ruta actual. No se le puede pasar como
	//parámetro una ruta completa.
	public void mkdir(String dir){
			Directorio ultimo = (Directorio) hijitosRuta.getLast();
			Directorio nuevo = new Directorio(dir);
			ultimo.addNodo(nuevo);
	}

	//Crea un enlace simbólico de nombre "dest" a que enlazar el elemento identificado
	// mediante el nombre "orig". "dest" no puede contener una ruta completa, pero "orig"
	//sí, de tal modo que pueden crearse enlaces simbólicos entre elementos dentro de 
	//diferentes posiciones del árbol de directorios.
	public void ln(String orig, String dest){
		Directorio ultimo = (Directorio) hijitosRuta.getLast();
		for(Iterator i = ultimo.hijitos.iterator();i.hasNext();){

			Nodo posibleElemento= (Nodo) i.next();
			String posibleNombre= posibleElemento.getNombre();

			// Miramos si coincide
			if(posibleNombre == orig ){
				Enlace nuevo= new Enlace(posibleElemento);
				ultimo.hijitos.add(nuevo);
				break;
			}
		}
	}

	//Elimina un elemento dentro de la ruta actual (puede pasársele como parámetro 
	//una ruta completa). Si es un archivo es simplemente eliminado. Si es un enlace 
	//elimina el enlace pero no lo enlazado. Si es un directorio, elimina el directorio
	//y  todo su contenido. Los enlaces a elementos borrados, sin embargo, siguen 
	//enlazando al elemento borrado. Así pues, para eliminar completamente un elemento
	//hay que borrar el elemento y todos los enlaces que apuntan a dicho elemento de forma
	//manual
	public void rm( String e){

		Directorio ultimo = (Directorio) hijitosRuta.getLast();
		for(Iterator i = ultimo.hijitos.iterator();i.hasNext();){

			Nodo posibleElemento= (Nodo) i.next();
			String posibleNombre= posibleElemento.getNombre();

			// Miramos si coincide
			if(posibleNombre == e ){
				posibleElemento= null;
				break;
			}
		}
	}

	//Devuelve el tamaño del Enlace
	int getSize(){
		return 0;
	}
}