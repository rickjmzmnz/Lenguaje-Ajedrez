package src.tipos;

public class Predicado
{

    //Valor de verdad del predicado
    private boolean valor;

    /**
     * Constructor de la clase Predicado
     * @param valor el valor de verdad
     */
    public Predicado(boolean valor)
    {
	     this.valor = valor;
    }

    /**
     * Obtiene el valor de verdad del predicado
     * @return el valor de verdad del predicado
     */
    public boolean getValor()
    {
	     return this.valor;
    }

    /**
     * Asigna un valor de verdad al predicado
     * @return el valor de verdad
     */
    public void setValor(boolean valor)
    {
	     this.valor = valor;
    }

}
