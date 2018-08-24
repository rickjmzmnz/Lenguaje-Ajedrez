package src.tipos;

public class Casilla{

    //Renglon de la casilla
    private Renglon renglon;
    //Columna de la casilla
    private Columna columna;

    /*
     * Constructor vacio de la clase Casilla
     */
    public Casilla(){
    }

    /*
     * Constructor de la clase Casilla
     */
    public Casilla(Columna columna,Renglon renglon){
	     this.renglon = renglon;
	     this.columna = columna;
    }

    /*
     * Obtiene el renglon de la casilla
     * @return - el renglon de la casilla
     */
    public Renglon getRenglon(){
	     return this.renglon;
    }

    /*
     * Asigna un renglon a la casilla
     */
    public void setRenglon(Renglon renglon){
	     this.renglon = renglon;
    }

    /*
     * Obtiene la columna de la casilla
     * @return - la columna de la casilla
     */
    public Columna getColumna(){
	     return this.columna;
    }

    /*
     * Asigna una columna a la casilla
     */
    public void setColumna(Columna columna){
	     this.columna = columna;
    }

    /*
     * Regresa una representación en cadena de la casilla
     * @return - la casilla en cadena
     */
    @Override
    public String toString(){
	     Renglon renglon = this.getRenglon();
	     Columna columna = this.getColumna();
	     int nomRen = renglon.getNumRenglon();
	     String numCol = columna.getNomColumna();
	     String casilla = numCol + nomRen;
	     return casilla;
    }

}
