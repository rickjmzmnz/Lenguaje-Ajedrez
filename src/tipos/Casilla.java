package src.tipos;

public class Casilla
{

    //Renglon de la casilla
    private Renglon renglon;
    //Columna de la casilla
    private Columna columna;

    /**
     * Constructor vacio de la clase Casilla
     */
    public Casilla(){}

    /**
     * Constructor de la clase Casilla
     * @param columna la columna de la casilla
     * @param renglon el renglon de la casilla
     */
    public Casilla(Columna columna,Renglon renglon)
    {
	     this.renglon = renglon;
	     this.columna = columna;
    }

    /**
     * Obtiene el renglon de la casilla
     * @return el renglon de la casilla
     */
    public Renglon getRenglon()
    {
	     return this.renglon;
    }

    /**
     * Asigna un renglon a la casilla
     * @param renglon el nuevo renglon
     */
    public void setRenglon(Renglon renglon)
    {
	     this.renglon = renglon;
    }

    /**
     * Obtiene la columna de la casilla
     * @return la columna de la casilla
     */
    public Columna getColumna()
    {
	     return this.columna;
    }

    /**
     * Asigna una columna a la casilla
     * @param columna la nueva columna
     */
    public void setColumna(Columna columna)
    {
	     this.columna = columna;
    }

    /**
     * Regresa una representación en cadena de la casilla
     * @return la casilla en cadena
     */
    @Override
    public String toString()
    {
	     Renglon renglon = this.getRenglon();
	     Columna columna = this.getColumna();
	     int nomRen = renglon.getNumero();
	     String numCol = columna.getNombre();
	     String casilla = numCol + nomRen;
	     return casilla;
    }

    /**
     * Verifica que una casilla sea igual a otra
     * @param cas la casilla a comparar
     * @return true si son iguales, false en otro caso
     */
    public boolean equals(Casilla cas)
    {
        return (this.renglon.equals(cas.getRenglon())
                && this.columna.equals(cas.getColumna()));
    }

}
