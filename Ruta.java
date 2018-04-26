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

	//Dadas una ruta inicial, una cadena que indica un recorrido y una raiz la funcion
	//devuelve la lista correspondiente de evaluar el recorrido e intentar acceder a él
	private LinkedList<Nodo> busqueda(LinkedList<Nodo> rutaInicial, String path,Nodo Raiz){
			
			LinkedList<Nodo> auxLista=new LinkedList<Nodo>();
			
			if( (path != null) && (!path.equals("")) ){	
				//Recorrido no vacío y no nulo
				if(path.equals("/")){
					//Acceder a raíz
					auxLista=new LinkedList<Nodo>();
					return auxLista;
				}

				else{
					//Acceder a ruta
					String[] siguienteRuta = path.split("/");
					int longitud=siguienteRuta.length;

					if (!siguienteRuta[0].isEmpty()){
						//Ruta relativa
						auxLista=rutaInicial;
					}
					//Búsqueda y comprobación de ruta correcta
					for (String AuxRuta : siguienteRuta){

						if(!AuxRuta.isEmpty() ){
							//AuxRuta no vacío 
							switch (AuxRuta){
								case "..":
											if(!hijitosRuta.isEmpty()){
												//No en la raíz
												auxLista.removeLast();
											}
											break;
								case ".": 	
											break;
								default:
										//Comprobar que es un directorio o enlace a directorio
										
										if(auxLista.size()==0){
												//En la RAIZ
												Directorio auxDir= (Directorio) Raiz.getNode();
												if(longitud == 1){
													//Comprobar que existe el nodo (enlace/directorio/archivo) en raiz
													try{
														if(auxDir.buscarNodo(AuxRuta)){
															//Comprobamos que se corresponde a destino.
															Nodo bueno = auxDir.cogerNodo(AuxRuta);
															auxLista.addLast(bueno);
														}
														else{
															throw new ExcepcionNoExiste("Fallo al insertar ultimo nodo");
														}
													}
													catch(ExcepcionNoExiste a){
														System.out.println(a.toString());
													}													
												}

												else{
													try{
														if(auxDir.buscarDirectorio(AuxRuta)){
															Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
															auxLista.addLast(bueno);
														}
														else{
															throw new ExcepcionNoExiste("Fallo al encontrar Directorio");
														}	
													}
													catch(ExcepcionNoExiste a){
															System.out.println(a.toString());
													}												
												}		
										}

										else{
											//NO en la raiz
											Directorio auxDir= (Directorio) auxLista.getLast().getNode();
											if(longitud == 1){
												try{
													if(auxDir.buscarNodo(AuxRuta)){
														Nodo bueno = auxDir.cogerNodo(AuxRuta);
														auxLista.addLast(bueno);
													}
													else{
														throw new ExcepcionNoExiste("Fallo al insertar ultimo nodo");
													}
												}
												catch(ExcepcionNoExiste a){
														System.out.println(a.toString());
												}												
											}

											else{
												try{
													if(auxDir.buscarDirectorio(AuxRuta)){
														Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
														auxLista.addLast(bueno);
													}
													else{
														throw new ExcepcionNoExiste("Fallo al encontrar Directorio");
													}	
												}
												catch(ExcepcionNoExiste a){
														System.out.println(a.toString());
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
		//Recorrido vacío o nulo
		return rutaInicial;
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
		if(hijitosRuta.size()==0){
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
		LinkedList<Nodo> Aux=busqueda(hijitosRuta,path,raiz);
		System.out.println("Esta es la ruta: ");
			if(!hijitosRuta.isEmpty()){
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
		
		if ( (element.equals("/")) || (element.equals(".") && hijitosRuta.size() == 0) )  {
				System.out.println("Tamanyo de " + raiz.getNombre() + " = " + raiz.getSize());
		}

		else {
			LinkedList<Nodo> Aux=busqueda(hijitosRuta,element,raiz);
			if(!Aux.isEmpty()){
				//NO raíz
				Nodo PosibleBueno=Aux.getLast();
				System.out.println("Tamanyo de " + PosibleBueno.getNombre() + " = " + PosibleBueno.getSize());
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
		if( (orig != null) && (!orig.equals("")) && (dest != null) && (!dest.equals("")) ){

				boolean rutaCorrecta=true;
				boolean archivoCorrecto=true;
				boolean encontrado= false;
				Directorio DirDest;

				LinkedList<Nodo> auxLista;
				String[] siguienteRuta = orig.split("/");
				int longitud= siguienteRuta.length;
				
			
				if (siguienteRuta[0].isEmpty()){
					auxLista=new LinkedList<Nodo>();
					DirDest=raiz;
				}
				else{
					auxLista=hijitosRuta;
					DirDest= (Directorio) hijitosRuta.getLast();
				}


				for (String AuxRuta : siguienteRuta){
				
					if(!AuxRuta.isEmpty()){

						switch (AuxRuta){
							case "..":
										if(!hijitosRuta.isEmpty()){
											auxLista.removeLast();
										}
										break;
							case ".": 	break;

							default:
									//Comprobar que es un directorio

									if(auxLista.size()==0){
											Directorio auxDir= (Directorio) raiz.getNode();
											if(longitud==1){
												
												//Comprobamos que existe el archivo
												if(auxDir.buscarNodo(AuxRuta)){
													//Comprobamos que se corresponde a destino.
													Nodo bueno = auxDir.cogerNodo(AuxRuta);
												
													Enlace DeboAnyadir = new Enlace(bueno,dest);
													DirDest.addNodo(DeboAnyadir);
													encontrado=true;
												}
												else{
													archivoCorrecto=false;
												}
											}
											else{
												if(auxDir.buscarDirectorio(AuxRuta)){
													Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
													auxLista.addLast(bueno);
												}
												else{
													rutaCorrecta=false;
												}	
											}		
									}
									else{
										Directorio auxDir= (Directorio) auxLista.getLast().getNode();
											if(longitud==1){
												if(auxDir.buscarNodo(AuxRuta)){
													Nodo bueno = auxDir.cogerNodo(AuxRuta);

													Enlace DeboAnyadir = new Enlace(bueno,dest);
													DirDest.addNodo(DeboAnyadir);
													encontrado=true;
												}
												else{
													archivoCorrecto=false;
												}
											}
											else{
												if(auxDir.buscarDirectorio(AuxRuta)){
													Directorio bueno = auxDir.cogerDirectorio(AuxRuta);
													auxLista.addLast(bueno);
													encontrado=true;
												}
												else{
													rutaCorrecta=false;
												}	
											}
											

									}
									break;
						}

						if(!rutaCorrecta || encontrado || ! archivoCorrecto){
							break;
						}
					}
					longitud--;
				}
				if(!rutaCorrecta){
					System.out.println("Ruta incorrecta");
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
	public void rm(String e){

		try{
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
					}
					try{
						if(PosibleBueno instanceof Directorio) {
							//Ruta correcta hasta directorio -> eliminar nodo
							Directorio esBien = (Directorio) PosibleBueno;
							System.out.println("Se quiere eliminar " + elem.getNombre());
							esBien.eliminar(elem.getNombre());
						}
						else{
							throw new ExcepcionNoExiste("Argumento erroneo");
						}
					}
					catch(ExcepcionNoExiste a){
							System.out.println(a.toString());
					}
				}
			}

			else {
				//Se está intentando eliminar la raiz
				throw new ExcepcionNoExiste("Se esta intentando eliminar la raiz");
			}
		} 
		catch(ExcepcionNoExiste a){
			System.out.println(a.toString());
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