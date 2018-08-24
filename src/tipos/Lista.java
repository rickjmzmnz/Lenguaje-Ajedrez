package src.tipos;
import java.util.ArrayList;
import java.util.List;

public class Lista<T>{

    //La lista para cualquier tipo
    private List<T> lista = new ArrayList<T>();

    /*
     * Constructor de la clase Lista
     */
    public Lista(){
    }

    /*
     * Obtiene la lista
     * @return - la lista
     */
    public List<T> getLista(){
	     return this.lista;
    }

    /*
     * Agrega un elemento de tipo T a la lista
     */
    public void agrega(T t){
	     this.lista.add(t);
    }

    /*
     * Obtiene la longitud de la lista
     * @return - la longitud de la lista
     */
    public int longitud(){
	     return this.lista.size();
    }

    /*
     * Concatena dos listas
     */
    public void concatena(Lista<T> lista){
        int longitud = lista.longitud();
        for(int i = 0; i < longitud; i++){
            T t = lista.obtenElem(i);
            this.agrega(t);
        }
    }

    /*
     * Obtiene el i-ésimo elemento de la lista
     * @return - el i-ésimo elemento
     */
    public T obtenElem(int i){
	     return this.lista.get(i);
    }

    /*
     * Obtiene una representación en cadena de la lista
     * @return - la lista en cadena
     */
    @Override
    public String toString(){
	     String cadena = "";
	     for(int i=0; i<this.longitud(); i++){
	        T t = this.obtenElem(i);
	        String cadenaT = t.toString();
	        cadena = cadena + "El elemento " + i + " es " + cadenaT + "\n";
	     }
	     return cadena;
    }

}
