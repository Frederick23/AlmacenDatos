package almacendatos2;

/**
 * 
 * @author Diego Cuenca Arriols
 *
 */

public class Almacen2 {

	
	/**
	 * Atributo array de valores enteros
	 */
	private int tvalores[];
	/**
	 * Atributo numero de elementos
	 */
	private int numElementos = 0;
	
	/**
	 * Constructor sin parámetros.
	 * Crea objetos almacen de 10 elementos
	 */
	public Almacen2(){
		this(10);
	}
	
	/**
	 * Constructor con un parámetro.
	 * Crea objetos almacen con un tamaño prefijado
	 * @param tamano tamaño del almacen
	 */
	public Almacen2( int tamano){
		tvalores = new int [tamano];
		init();
	}
	
	/**
	 * Coloca el numero de elementos a 0
	 * @see numElementos
	 */
	public void init (){
		numElementos = 0;
	}
	
	/**
	 * Convierte el contenido del almacen en un String
	 * @return String con el contenido del almacen
	 */
	public String toString (){
		StringBuilder a = new StringBuilder();
		for (int i = 0; i < numElementos; i++){
			a.append(tvalores[i]);
		}
		return a.toString();
	}
	
	/**
	 * Indica el numero de posiciones libres
	 * @return Numero de posiciones libres
	 */
	public int numPosicionesLibres(){
		return tvalores.length-numElementos;
	}
	
	/**
	 * Indica el numero de posiciones ocupadas
	 * @return Numero de posiciones ocupadas
	 */
	public int numPosicionesOcupadas(){
		return numElementos;
	}
	
	/**
	 * Indica la presencia de un valor en el almacen
	 * @param num numero a buscar en el almacen
	 * @return <ul><li>true: el elemento esta en el almacen.</li><li>false: el elemento no está en el almacen</li></ul>
	 */
	public boolean estaValor ( int num){
		for (int i = 0; i < numElementos+1; i++){
			if (tvalores[i] == num){
				return true;
			}
		}
	return false;
	}
	
	/**
	 * Almacena un valor en la tabla
	 * @param num numero a almacenar
	 * @return <ul><li>true: el elemento se ha almacenado.</li><li>false: no se ha podido almacenar, el almacen esta lleno</li></ul>
	 */
	public boolean ponValor (int num){
		int posicion;
		if (numElementos==0){
			posicion = 0;
			tvalores[posicion] = num;
			numElementos++;
			return true;
		}
		else{
			posicion = numElementos;
		
			if (estaLleno()){
				System.out.println("No se ha podido insertar, almacen lleno");
				return false;
			}
			else{
				for(int i = 0; i < numElementos+1; i++){
					if ( num < tvalores[i]){
						posicion = i;
						break;
					}
				}
				if (posicion != numElementos) {
					for (int i = numElementos-1; i >= posicion; i-- ) {
						tvalores[i+1] = tvalores[i];
					}
				}
				tvalores[posicion] = num;
				numElementos++;
				return true;
			}
		}

	}
	
	/**
	 * Elimina un elemento del almacen
	 * @param num Valor a eliminar
	 * @return <ul><li>true: el elemento se ha eliminado.</li><li>false: no se ha podido eliminar, el elemento no se encontraba en la tabla</li></ul>
	 */
	public boolean sacarValor (int num){
		int posicion = 0;
		if (estaValor(num)==true){
			for (int i = 0; i < numElementos; i++) {
				if (tvalores[i] == num) {
					posicion = i;
				}
			}
			for (int i = posicion; i < numElementos; i++) {
				tvalores[i] = tvalores[i+1];
			}
			numElementos--;
			return true;
		}
		else{
			return false;
		}
	
	}
     /**
      * Indica si el almacen esta lleno
      * @return <ul><li>true: almacen lleno.</li><li>false: almacen con posiciones libres</li></ul>
      */
	public boolean estaLleno (){
		if (tvalores.length == numElementos){
			return true;
		}	
		else
			return false;
	}
}
