
import java.util.*;


class Ruta extends Nodo{

		LinkedList<Nodo> hijitosRuta;

		// ------Constructores
		public Ruta(){
			hijitosRuta= new LinkedList<Nodo>();
		}

		public Ruta(Nodo nodete){
			hijitosRuta= new LinkedList<Nodo>();
			hijitosRuta.add(nodete);
		}
		//-------Constructores

		//-------Funciones
		public String pwd(){
			String ruteta="/";
			for(Iterator i = hijitosRuta.iterator();i.hasNext();){

					Nodo aux= (Nodo) i.next();
					ruteta= ruteta +aux.getSize();
				}
				return ruteta;

		}

		int getSize(){
			return 0;
		}
		//-------Funciones

}