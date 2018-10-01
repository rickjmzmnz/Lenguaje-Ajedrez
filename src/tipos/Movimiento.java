package src.tipos;

public class Movimiento
{

    //Casilla de donde parte el movimiento
    private Casilla casillaOrigen;
    //Casilla donde termina el movimiento
    private Casilla casillaDestino;

    /**
     * Constructor de la clase Movimiento
     * Verifica que no se quede en la misma casilla al hacer el movimiento
     * @param casOri la casilla origen
     * @param casDes la casilla destino
     */
    public Movimiento(Casilla casOri, Casilla casDes)
    {
	     Renglon renOrigen = casOri.getRenglon();
	     Columna colOrigen = casOri.getColumna();

	     Renglon renDestino = casDes.getRenglon();
	     Columna colDestino = casDes.getColumna();

	     int numRenOrigen = renOrigen.getNumero();
	     String nomColOrigen = colOrigen.getNombre();

	     int numRenDestino = renDestino.getNumero();
	     String nomColDestino = colDestino.getNombre();

	     if(numRenOrigen == numRenDestino && nomColOrigen.equals(nomColDestino))
       {
	        System.out.println("ERROR: no puedes dejar la pieza en la misma casilla");
	     }
       else
       {
	        this.casillaOrigen = casOri;
	        this.casillaDestino = casDes;
	     }
    }

    /**
     * Obtiene la casilla de donde parte el movimiento
     * @return la casilla de donde parte el movimiento
     */
    public Casilla getCasillaOrigen()
    {
	     return this.casillaOrigen;
    }

    /**
     * Asigna una nueva casilla de donde parte el movimiento
     * @param casOri la nueva casilla origen
     */
    public void setCasillaOrigen(Casilla casOri)
    {
	     this.casillaOrigen = casOri;
    }

    /**
     * Obtiene la casilla donde termina el movimiento
     * @return la casilla donde termina el movimiento
     */
    public Casilla getCasillaDestino()
    {
	     return this.casillaDestino;
    }

    /**
     * Asigna una nueva casilla donde termina el movimiento
     * @param casDes la nueva casilla destino
     */
    public void setCasillaDestino(Casilla casDes)
    {
	     this.casillaDestino = casDes;
    }

    /**
     * Representacion en cadena de un movimiento
     * @return la cadena que representa el origen y destino del movimiento
     */
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

    /**
     * Verifica que un movimiento sea igual a otro
     * @param mov el movimiento a comparar
     * @return true si son iguales, false en otro caso
     */
    public boolean equals(Movimiento mov)
    {
        return (this.casillaOrigen.equals(mov.getCasillaOrigen())
               && this.casillaDestino.equals(mov.getCasillaDestino()));
    }

}
