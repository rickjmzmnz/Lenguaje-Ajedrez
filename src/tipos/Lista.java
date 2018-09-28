package src.tipos;
import java.util.ArrayList;
import java.util.List;

public class Lista<T>
{

    //Lista que puede contener cualquier tipo
    private List<T> lista = new ArrayList<T>();

    /**
     * Constructor de la clase Lista
     */
    public Lista(){}

    /**
     * Obtiene la lista
     * @return la lista
     */
    public List<T> getLista()
    {
	     return this.lista;
    }

    /**
     * Agrega un elemento de tipo T a la lista
     * @param t el elemento
     */
    public void agrega(T t)
    {
	     this.lista.add(t);
    }

    /**
     * Obtiene la longitud de la lista
     * @return la longitud de la lista
     */
    public int longitud()
    {
	     return this.lista.size();
    }

    /**
     * Concatena dos listas
     * @param lista la lista con la que se va a concatenar
     */
    public void concatena(Lista<T> lista)
    {
        int longitud = lista.longitud();

        for(int i = 0; i < longitud; i++)
        {
            T t = lista.obtenElem(i);
            this.agrega(t);
        }
    }

    /**
     * Obtiene el i-ésimo elemento de la lista
     * @return el i-ésimo elemento
     */
    public T obtenElem(int i)
    {
	     return this.lista.get(i);
    }

    /**
     * Busca si un elemento está en la lista
     * @param busca el elemento a buscar
     * @return true si lo encuentra, false en otro caso
     */
    public boolean contiene(T busca)
    {
        for(int i = 0; i < this.longitud(); i++)
        {
            T t = this.obtenElem(i);
            if(t.equals(busca))
                return true;
        }
        return false;
    }

    /**
     * Obtiene una representación en cadena de la lista
     * @return la lista en cadena mostrando los elementos que tiene
     */
    @Override
    public String toString()
    {
	     String cadena = "";

	     for(int i=0; i<this.longitud(); i++)
       {
	        T t = this.obtenElem(i);
	        String cadenaT = t.toString();
	        cadena = cadena + "El elemento " + i + " es " + cadenaT + "\n";
	     }
	     return cadena;
    }

}
