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
	public Ruta(Directorio nodete){
		raiz =  nodete;
		hijitosRuta = new LinkedList<Nodo>();
	}


	//-----Métodos de Ruta-----
	public LinkedList<Nodo> busqueda(LinkedList<Nodo> rutaInicial, String path,Nodo Raiz){
			LinkedList<Nodo> auxLista=new LinkedList<Nodo>();
			try{
				if( (path != null) && (!path.equals("")) ){		
						if(path.equals("/")){
							auxLista=new LinkedList<Nodo>();
							return auxLista;
						}
						else{
							String[] siguienteRuta = path.split("/");
							int longitud=siguienteRuta.length;

							if (!siguienteRuta[0].isEmpty()){
								auxLista=rutaInicial;
							}
							for (String AuxRuta : siguienteRuta){

								if(!AuxRuta.isEmpty() ){
									System.out.println("Esto vale ruta: "+AuxRuta+" lonitud: "+longitud);
									switch (AuxRuta){
										case "..":
													if(!hijitosRuta.isEmpty()){
														auxLista.removeLast();
													}
													break;
										case ".": 	break;

										default:
												//Comprobar que es un directorio ,o si es el ultimo añadirlo
												if(auxLista.size()==0){

														//La lista esta vacia
														if( longitud == 1){
																//Comprobamos que existe el archivo
															
															Directorio auxDir= (Directorio) Raiz.getNode();
															if(auxDir.buscarNodo(AuxRuta)){
																//Comprobamos que se corresponde a destino.
																Nodo bueno = auxDir.cogerNodo(AuxRuta);
																auxLista.addLast(bueno);
															}
																else{
																	throw new ExcepcionNoExiste("Fallo al insertar ultimo nodo");
																}
														}
														else{
															Directorio auxDir= (Directorio) Raiz.getNode();
															
																if(auxDir.buscarDirectorio(AuxRuta)){
																Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
																auxLista.addLast(bueno);
																}
																else{
																	throw new ExcepcionNoExiste("Fallo al encontrar Directorio");
																}	
														}

														
												}
												else{
													Directorio auxDir= (Directorio) auxLista.getLast().getNode();
													if(longitud == 1){
														
															if(auxDir.buscarNodo(AuxRuta)){
															Nodo bueno = auxDir.cogerNodo(AuxRuta);
																auxLista.addLast(bueno);
															}
															else{
																throw new ExcepcionNoExiste("Fallo al insertar ultimo nodo");
															}
														
														
														
														
													}
													else{
														
															if(auxDir.buscarDirectorio(AuxRuta)){
															Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
															auxLista.addLast(bueno);
															}
															else{
																throw new ExcepcionNoExiste("Fallo al encontrar Directorio");
															}	
														
														
													}
													

												}//Else
									}	//Switch
							


								}//IF
								
								longitud--;
							} //For	
							return auxLista;
					} //Else
				
			} //If grande
			else{
				return rutaInicial;
			}
	}//try
	catch(ExcepcionNoExiste a){
		System.out.println(a.toString());
		return hijitosRuta;
	}

			
} //FIN

	//Devuelve la ruta completa, con todos los nombres de los directorios desde
	//la raíz hasta el directorio actual concatenados y separados por el separador “/”
	public String pwd(){
		
		//	Directorio base
		String ruteta="/";
		
		//	Se hace un bucle para recurrer la ruta e ir añadiendo los directorios de la 
		// 	forma /directorio1/directorio2
		ruteta= ruteta+raiz.getNombre()+"/";
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
		String pantalla;
		if(hijitosRuta.size() == 0 ){
			pantalla = raiz.listarDirectorio();
		}
		else{
			Directorio salida= (Directorio) hijitosRuta.getLast().getNode();
			pantalla =salida.listarDirectorio();
		}
		// Accedemos a la funcion de ultimo que nos lista los elementos
	
		System.out.print(pantalla);
	}


	//Cambia la ruta a otro directorio (path), pasándole el nombre del directorio al 
	//que quiere cambiar. Hay tres casos especiales: “.” se refiere al directorio
	//actual, “..” se refiere al directorio anterior en el árbol de directorios y “/” 
	//se refiere a la raíz del árbol de directorios. También se le puede pasar como 
	//parámetro una ruta completa (varios directorios separados por “/”)
	public void cd(String path) {	
		//Dividir la cadena en caso de que hubiera una ruta

		//Path no nulo y no vacio
		LinkedList<Nodo> Shadow = new LinkedList(hijitosRuta);
		LinkedList<Nodo> Aux=busqueda(Shadow,path,raiz);
			if(!hijitosRuta.isEmpty()&& !Aux.equals(hijitosRuta)){
				Nodo PosibleBueno=hijitosRuta.getLast();
				try{
				if(PosibleBueno instanceof Directorio ){
					hijitosRuta=Aux;
				}
				else{
					throw new ExcepcionNoExiste("Argumento erroneo");
				}
				}
				catch(ExcepcionNoExiste a){
						System.out.println(a.toString());
				}
			}
			else{
				hijitosRuta=Aux;
			}
	}
		

	//Muestra por pantalla el número que es el tamaño del archivo, directorio o enlace
	//dentro de la ruta actual identificado por la cadena de texto que se le pasa como
	//parámetro. También se le puede pasar una ruta completa.
	public void stat(String element){
		
		if( (element != null) && (!element.equals("")) ){			
				
			if (element.equals("/")) {
				System.out.println("Tamanyo de " + raiz.getNombre() + " = " + raiz.getSize());
			}
			else {
				LinkedList<Nodo> auxLista;
				String[] nextElem = element.split("/");
				boolean encontrado=false;
				boolean rutaCorrecta=true;
				int tamanyo = -1;

				//Ruta absoluta
				if (nextElem[0].isEmpty()){
					auxLista=new LinkedList<Nodo>();
				}
				//Ruta relativa
				else{
					auxLista=hijitosRuta;
				}
				//Buscar elemento
				for (String AuxRuta : nextElem) {
					
					if(!AuxRuta.isEmpty()){
						//AuxRuta no es vacío
						if (AuxRuta.equals(nextElem[nextElem.length-1])) {
							//Nodo a buscar
							Directorio auxDir;
							if (auxLista.size() == 0) {
								auxDir = (Directorio) raiz.getNode();
							}
							else {
								auxDir = (Directorio) auxLista.getLast().getNode();
							} 
							tamanyo = auxDir.tamElemento(AuxRuta);
						}

						else {
							//Comprobar ruta correcta
							switch (AuxRuta){
							case "..":
										if (!hijitosRuta.isEmpty()) {
											auxLista.removeLast();
										}
										break;
							case ".": 	
										break;
							default:
									//Comprobar que es un directorio

									if(auxLista.size()==0){
										Directorio auxDir= (Directorio) raiz.getNode();
											if(auxDir.buscarDirectorio(AuxRuta)){
												Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
												auxLista.addLast(bueno);
											}
											else{
												rutaCorrecta=false;
											}	
									}
									else{
										Directorio auxDir= (Directorio) auxLista.getLast().getNode();
											if(auxDir.buscarDirectorio(AuxRuta)){
												Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
												auxLista.addLast(bueno);
											}
											else{
												rutaCorrecta=false;
											}	

									}
									break;
							}

						}
						if(!rutaCorrecta){
							break;
						}
				
					}
					
					
				}
				//Si el elemento existe se muestra por pantalla el número del tamaño del mismo
				if(tamanyo >= 0){
					System.out.println("Tamanyo de " + element + " = " + tamanyo);
				}
				else {
					System.out.println("NO ENCONTRADO");
				}
			}		
		}
	}

	//Cambia el tamaño de un archivo dentro de la ruta actual (no se le puede pasar como
	//parámetro una ruta completa). Si el archivo no existe dentro de la ruta actual, se 
	//crea automáticamente con el nombre y tamaño especificados. Si el archivo referenciado
	//por "file" es en realidad un enlace a un archivo, también cambia su tamaño.
	public void vim(String file, int size){
		Directorio Cambio;
		if (hijitosRuta.size()==0){
			Cambio= raiz;
		}
		else{
			Cambio=(Directorio) hijitosRuta.getLast().getNode();
		}
		boolean encontrado=false;
		for(Nodo posibleElemento : Cambio.hijitos){
			posibleElemento=posibleElemento.getNode();
			String posibleNombre= posibleElemento.getNombre();

			// Miramos si coincide
			if(posibleNombre == file ){
				if(posibleElemento instanceof Archivo){
					Archivo aux= (Archivo) posibleElemento;
					aux.setSize(size);
					encontrado=true;
				}
				else{
					//Dara error
				}
				break;
			}
		}
		if(!encontrado){
			// Lo creamos;
			Archivo nuevo = new Archivo(file,size);
			// Lo añadimos
			Cambio.hijitos.addLast(nuevo);
		}
	}

	//Crea un directorio dentro de la ruta actual. No se le puede pasar como
	//parámetro una ruta completa.
	public void mkdir(String dir){
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
	public void ln(String orig, String dest){
		//Path no nulo y no vacio
		LinkedList<Nodo> Shadow= new LinkedList<Nodo>(hijitosRuta);
		LinkedList<Nodo> Buscado=busqueda(Shadow,orig,raiz);

		if(!Buscado.isEmpty() && ! Buscado.equals(hijitosRuta)){
				Nodo PosibleBueno=Buscado.getLast();
				Buscado.removeLast();
				Enlace Nuevo = new Enlace(PosibleBueno,dest);

				if(hijitosRuta.isEmpty()){
					raiz.addNodo(Nuevo);
				}
				else{
					Directorio objetivo=(Directorio) hijitosRuta.getLast();
					objetivo.addNodo(Nuevo);
				}
			}
		else{
			hijitosRuta=Buscado;
		}

	}

	//Elimina un elemento dentro de la ruta actual (puede pasársele como parámetro 
	//una ruta completa). Si es un archivo es simplemente eliminado. Si es un enlace 
	//elimina el enlace pero no lo enlazado. Si es un directorio, elimina el directorio
	//y  todo su contenido. Los enlaces a elementos borrados, sin embargo, siguen 
	//enlazando al elemento borrado. Así pues, para eliminar completamente un elemento
	//hay que borrar el elemento y todos los enlaces que apuntan a dicho elemento de forma
	//manual
	public void rm(String e){

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
	Nodo getNode(){
		return this;
	}
}