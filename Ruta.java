//Ruta.java para la práctica 3 de Tecnología de la Programación
/* Autores: David Ubide Alaiz y Elena Morón Vidal
 * NIA: 736520 y 739324
 */
import java.util.*;


class Ruta extends Nodo{
	//-----Atributos de Ruta-----
	Directorio raiz;
	LinkedList<Nodo> hijitosRuta;
	//-----Constructor de Ruta-----
	public Ruta(Directorio nodete) throws ExcepcionArbolFicheros {
		if (nodete.getNombre().length() == 0) {
			//Nombre de directorio raiz correcto
			raiz = nodete;
			hijitosRuta = new LinkedList<Nodo>();
		}
		else {
			raiz = null;
			hijitosRuta = null;
			throw new ExcepcionNombreRaiz(nodete.getNombre());
		}
	}


	//-----Métodos de Ruta-----

	//Dadas una ruta inicial, una cadena que indica un recorrido y una raiz la funcion
	//devuelve la lista correspondiente de evaluar el recorrido e intentar acceder a él
	private LinkedList<Nodo> busqueda(LinkedList<Nodo> rutaInicial, String path,Directorio Raiz) throws ExcepcionArbolFicheros {
			//Se asume ruta relativa
			LinkedList<Nodo> auxLista=hijitosRuta;
			if( (path != null) && (!path.equals("")) ){	
				//Path no nula y no vacía	
				if(path.equals("/")){
					//Path se refiere directamwente a la raíz
					auxLista=new LinkedList<Nodo>();
					return auxLista;
				}

				else{
					//Path se refiere a una ruta
					String[] siguienteRuta = path.split("/");
					int longitud=siguienteRuta.length;

					if (!siguienteRuta[0].isEmpty()){
						//relativa
							auxLista=rutaInicial;
					}

					for (String AuxRuta : siguienteRuta){
						if((AuxRuta != null) && (!AuxRuta.equals("")) ){
							//Se recorre path y se realizan cambios en auxLista
								switch (AuxRuta){
									//Analiza los posibles valores del path
									case "..":											
										if(auxLista.size() > 0){
											//NO EN raíz por lo que se puede retroceder
											auxLista.removeLast();
										}									
									break;

									case ".": 	
										//Se refiere al directorio actual por lo que no implica cambios
									break;

									default:
										//Comprobar que es un directorio ,o si es el ultimo añadirlo
										if(auxLista.size()==0){
											//En la raiz
											if( longitud == 1){
												//El elemento al que se quiere acceder existe en raiz
												Directorio auxDir = Raiz;
												if(auxDir.buscarNodo(AuxRuta)){
													//Existe el elemento
													Nodo bueno = auxDir.cogerNodo(AuxRuta);
													auxLista.addLast(bueno);
												}
												else{
													//No existe el elemento
													throw new ExcepcionNoExiste(AuxRuta);
												}
											}

											else{
												//Se va a ampliar la ruta
												Directorio auxDir =  Raiz;
												if(auxDir.buscarDirectorio(AuxRuta)){
													//Existe directorio o enlace a directorio con el nombre
													//AuxRuta
													Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
													auxLista.addLast(bueno);
												}
												else{
													//No existe directorio o enlace a directorio con el nombre
													//AuxRuta
													throw new ExcepcionNoEsDirectorio(AuxRuta);
												}	
											}
										}

										else{
											//En la lista de directorios
											Directorio auxDir= (Directorio) auxLista.getLast().getNode();
											//auxDir = directorio actual
											if(longitud == 1){
												//Elemento buscado
												if(auxDir.buscarNodo(AuxRuta)){
													//Elemento buscado existe en directorio actual
													Nodo bueno = auxDir.cogerNodo(AuxRuta);
													auxLista.addLast(bueno);
												}
												else{
													//Elemento buscado no existe en directorio actual
													throw new ExcepcionNoExiste(AuxRuta);

												}
											}

											else{
												//Se va a ampliar la ruta
												if(auxDir.buscarDirectorio(AuxRuta)){
													//Existe directorio o enlace a directorio con el nombre
													//AuxRuta
													Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
													auxLista.addLast(bueno);
												}
												else{
													//No existe directorio o enlace a directorio con el nombre
													//AuxRuta
													throw new ExcepcionNoEsDirectorio(AuxRuta);
												}	
											}
										}
									break;
								}
						//Se descuenta el elemento evaluado de la longitud pendiente por analizar
						}
						
						longitud--;
					} 	
				return auxLista;
			} 
		} 

		else{
			//Path vacía
			return rutaInicial;
		}
	}
	
	//Devuelve la ruta completa, con todos los nombres de los directorios desde
	//la raíz hasta el directorio actual concatenados y separados por el separador “/”
	public String pwd(){
		//Se hace un bucle para recurrer la ruta e ir añadiendo los directorios de la 
		// 	forma /directorio1/directorio2
		String ruteta = raiz.getNombre() + "/";
		for(Nodo aux:hijitosRuta){
			ruteta = ruteta +aux.getNombre()+"/";
		}
		return ruteta;
	}
 	
 	//Muestra por pantalla los nombres de todos los ficheros, directorios y enlaces
 	//contenidos en la ruta actual, cada uno de ellos en una línea diferente, sin
	//ningún dato más
	public void ls(){
		// El ultimo Directorio corresponde al directorio donde nos encontramos
		String pantalla;
		if(hijitosRuta.size() == 0 ){
			//Listar fichero raiz
			pantalla = raiz.listarDirectorio();
		}

		else{
			//Listar ultimo fichero de los enlazados
			Directorio salida= (Directorio) hijitosRuta.getLast().getNode();
			pantalla =salida.listarDirectorio();
		}
		System.out.print(pantalla);
	}


	//Cambia la ruta a otro directorio (path), pasándole el nombre del directorio al 
	//que quiere cambiar. Hay tres casos especiales: “.” se refiere al directorio
	//actual, “..” se refiere al directorio anterior en el árbol de directorios y “/” 
	//se refiere a la raíz del árbol de directorios. También se le puede pasar como 
	//parámetro una ruta completa (varios directorios separados por “/”)
	public void cd(String path) throws ExcepcionArbolFicheros {	
		LinkedList<Nodo> Shadow = new LinkedList<Nodo>(hijitosRuta);
		LinkedList<Nodo> Aux = busqueda(Shadow,path,raiz);

		if(Aux.size() > 0 && !Aux.equals(hijitosRuta)){
			//Aux contiene elementos y es diferente a hijitos ruta
			Nodo PosibleBueno = Aux.getLast().getNode();
			if(PosibleBueno.getNode() instanceof Directorio ){
				//Es directorio
				hijitosRuta=Aux;
			}
			else{
				throw new ExcepcionNoEsDirectorio(PosibleBueno.getNombre());
			}
		}
		else{
			//Raiz
			hijitosRuta=Aux;
		}
	}
		

	//Muestra por pantalla el número que es el tamaño del archivo, directorio o enlace
	//dentro de la ruta actual identificado por la cadena de texto que se le pasa como
	//parámetro. También se le puede pasar una ruta completa.
	public void stat(String element) throws ExcepcionArbolFicheros{

		LinkedList<Nodo> Shadow = new LinkedList<Nodo>(hijitosRuta);
		LinkedList<Nodo> Buscado = busqueda(Shadow,element,raiz);
		if(Buscado.size() == 0 ){
			//En la raiz
			System.out.println("El archivo: "+ element + " tiene un tamano de "+raiz.getSize() + " bytes");
		}
		else{
			Nodo Deseado= Buscado.getLast();
			System.out.println("El archivo: "+ Deseado.getNombre()+ " tiene un tamano de: "+Deseado.getSize()+ " bytes");
		}
	}

	//Cambia el tamaño de un archivo dentro de la ruta actual (no se le puede pasar como
	//parámetro una ruta completa). Si el archivo no existe dentro de la ruta actual, se 
	//crea automáticamente con el nombre y tamaño especificados. Si el archivo referenciado
	//por "file" es en realidad un enlace a un archivo, también cambia su tamaño.
	public void vim(String file, int size) throws ExcepcionArbolFicheros{
		Directorio Cambio;
		if (hijitosRuta.size()==0){
			//No hay hijos en la ruta
			Cambio = raiz;
		}
		else{
			//Hay hijos en la ruta, se escoge el directorio actual
			Cambio = (Directorio) hijitosRuta.getLast().getNode();
		}
		if (Cambio.buscarNodo(file)) {
			//File en nodo
			Nodo buscado = Cambio.cogerNodo(file);
			if(buscado.getNode() instanceof Archivo) {
				//aux es archivo
				Archivo aux = (Archivo) buscado;
				aux.setSize(size);
			}
			else{
				throw new ExcepcionNoEsArchivo(buscado.getNombre());
			}
		}
		else {
			//No file en nodo
			Archivo nuevo = new Archivo(file, size);
			//Lo añadimos
			Cambio.hijitos.addLast(nuevo);
		}
	}

	//Crea un directorio dentro de la ruta actual. No se le puede pasar como
	//parámetro una ruta completa.
	public void mkdir(String dir) throws ExcepcionArbolFicheros{
			Directorio nuevo = new Directorio(dir);
			if (hijitosRuta.size() == 0) { //Añadir en el directorio raíz
				raiz.addNodo(nuevo);
			}
			else { //Añadir en el directorio actual
				Directorio ultimo = (Directorio) hijitosRuta.getLast();
				ultimo.addNodo(nuevo);
			}
	
	}

	//Crea un enlace simbólico de nombre "dest" a que enlazar el elemento identificado
	// mediante el nombre "orig". "dest" no puede contener una ruta completa, pero "orig"
	//sí, de tal modo que pueden crearse enlaces simbólicos entre elementos dentro de 
	//diferentes posiciones del árbol de directorios.
	public void ln(String orig, String dest) throws ExcepcionArbolFicheros {
		LinkedList<Nodo> Shadow= new LinkedList<Nodo>(hijitosRuta);
		LinkedList<Nodo> Buscado=busqueda(Shadow,orig,raiz);

		if(!Buscado.isEmpty()){
			//Buscado contiene elementos
			Nodo PosibleBueno=Buscado.removeLast();
			Enlace Nuevo = new Enlace(PosibleBueno,dest);

			if(hijitosRuta.isEmpty()){
				raiz.addNodo(Nuevo);
			}

			else{
				Directorio objetivo=(Directorio) hijitosRuta.peekLast().getNode();
				objetivo.addNodo(Nuevo);
			}
		}

		else{
			//Enlazando raiz
			Enlace Nuevo = new Enlace(raiz, dest);
			if(hijitosRuta.isEmpty()){
				raiz.addNodo(Nuevo);
			}

			else{
				Directorio objetivo=(Directorio) hijitosRuta.peekLast().getNode();
				objetivo.addNodo(Nuevo);
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
	public void rm(String e) throws ExcepcionArbolFicheros{

		if (!(e.equals("/") || (e.equals(".") && hijitosRuta.size() == 0)) )  {
			//No se intenta eliminar la raíz
			LinkedList<Nodo> Aux=busqueda(hijitosRuta,e,raiz);
			if(!Aux.isEmpty()){
				//Eliminar elemento a borrar
				Nodo elem = Aux.removeLast();
				//Directorio 
				Nodo PosibleBueno=raiz;
				if (Aux.size() > 0) {
					PosibleBueno = Aux.getLast();
					if(PosibleBueno.getNode() instanceof Directorio) {
						//Ruta correcta hasta directorio -> eliminar nodo
						Directorio esBien = (Directorio) PosibleBueno;
						esBien.eliminar(elem.getNombre());
					}
					else{
						throw new ExcepcionNoEsDirectorio(PosibleBueno.getNombre());
					}
				}
				else{
					if(PosibleBueno.getNode() instanceof Directorio) {
						//Ruta correcta hasta directorio -> eliminar nodo
						Directorio esBien = (Directorio) PosibleBueno;
						esBien.eliminar(elem.getNombre());
					}
					else{
						throw new ExcepcionNoEsDirectorio(PosibleBueno.getNombre());
					}
				}
			}
		}
	}

	//Devuelve el tamaño del Nodo apuntado por el objeto que invoca el método
	public int getSize(){
		return 0;
	}
	public Nodo getNode(){
		return this;
	}
}