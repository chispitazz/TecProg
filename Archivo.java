


class Archivo extends Nodo
{
	int size;

	public Archivo(String NombreArchivo,int tamanyoArchivo){
		nombreNodo=NombreArchivo;
		size=tamanyoArchivo;
	}


	
	public void setSize(int tamanyoArchivo){
		size=tamanyoArchivo;
	}

	int getSize(){
			return size;
	}

	

}