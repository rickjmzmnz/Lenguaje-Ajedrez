package src.tipos;

public class Movimiento
{

    //Casilla de donde parte el movimiento
    private Casilla casillaOrigen;
    //Casilla donde termina el movimiento
    private Casilla casillaDestino;

    /*
     * Constructor de la clase Movimiento
     * Verifica que no se quede en la misma casilla al hacer el movimiento
     */
    public Movimiento(Casilla casOri, Casilla casDes)
    {
	     Renglon renOrigen = casOri.getRenglon();
	     Columna colOrigen = casOri.getColumna();

	     Renglon renDestino = casDes.getRenglon();
	     Columna colDestino = casDes.getColumna();

	     int numRenOrigen = renOrigen.getNumRenglon();
	     String nomColOrigen = colOrigen.getNomColumna();

	     int numRenDestino = renDestino.getNumRenglon();
	     String nomColDestino = colDestino.getNomColumna();

	     if(numRenOrigen == numRenDestino && nomColOrigen.equals(nomColDestino)) {
	        System.out.println("ERROR: no puedes dejar la pieza en la misma casilla");
	     } else {
	        this.casillaOrigen = casOri;
	        this.casillaDestino = casDes;
	     }
    }

    /*
     * Obtiene la casilla de donde parte el movimiento
     * @return - la casilla de donde parte el movimiento
     */
    public Casilla getCasillaOrigen()
    {
	     return this.casillaOrigen;
    }

    /*
     * Asigna una nueva casilla de donde parte el movimiento
     */
    public void setCasillaOrigen(Casilla casOri)
    {
	     this.casillaOrigen = casOri;
    }

    /*
     * Obtiene la casilla donde termina el movimiento
     * @return - la casilla donde termina el movimiento
     */
    public Casilla getCasillaDestino()
    {
	     return this.casillaDestino;
    }

    /*
     * Asigna una nueva casilla donde termina el movimiento
     */
    public void setCasillaDestino(Casilla casDes)
    {
	     this.casillaDestino = casDes;
    }

    @Override
    public String toString()
    {
      String cadena = "";
      Casilla origen = this.getCasillaOrigen();
      Casilla destino = this.getCasillaDestino();
      cadena = cadena + "Casilla origen: " + origen.toString() + "\n";
      cadena = cadena + "Casilla destino: " + destino.toString() + "\n";
      return cadena;
    }

}
