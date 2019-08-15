package tesis.lenguaje.ajedrez.tipos;

public class Tablero
{

    //Matriz de dos dimensiones que representa el tablero de ajedrez
    private Pieza[][] tablero = new Pieza[8][8];

    /**
     * Constructor de la clase Tablero
     * @param tablero la matriz que representa el tablero de ajedrez
     */
    public Tablero(Pieza[][] tablero)
    {
        Color white = new Color("White");
        Color black = new Color("Black");

        Pieza WP = new Pieza(white,"Pawn");
      	Pieza WR = new Pieza(white,"Rook");
      	Pieza WB = new Pieza(white,"Bishop");
      	Pieza WN = new Pieza(white,"Knight");
      	Pieza WQ = new Pieza(white,"Queen");
      	Pieza WK = new Pieza(white,"King");

      	Pieza BP = new Pieza(black,"Pawn");
      	Pieza BR = new Pieza(black,"Rook");
      	Pieza BB = new Pieza(black,"Bishop");
      	Pieza BN = new Pieza(black,"Knight");
      	Pieza BQ = new Pieza(black,"Queen");
      	Pieza BK = new Pieza(black,"King");

        Pieza libre = new Pieza();

      	tablero[0][0] = BR;
      	tablero[0][1] = BN;
      	tablero[0][2] = BB;
      	tablero[0][3] = BQ;
      	tablero[0][4] = BK;
      	tablero[0][5] = BB;
      	tablero[0][6] = BN;
      	tablero[0][7] = BR;

        for(int j=0; j<8; j++)
        {
	           tablero[1][j] = BP;
	      }

	      for(int i=2; i<6; i++)
        {
	         for(int j=0; j<8; j++)
           {
		          tablero[i][j] = libre;
	         }
	      }

	      for(int j=0; j<8; j++)
        {
	         tablero[6][j] = WP;
	      }

	      tablero[7][0] = WR;
	      tablero[7][1] = WN;
    	  tablero[7][2] = WB;
        tablero[7][3] = WQ;
        tablero[7][4] = WK;
        tablero[7][5] = WB;
        tablero[7][6] = WN;
        tablero[7][7] = WR;

      	this.tablero = tablero;
    }

    /**
     * Obtiene el tablero
     * @return el tablero
     */
    public Pieza[][] getTablero()
    {
	     return this.tablero;
    }

    /**
     * Asigna una nueva configuracion del tablero
     * @param tablero la nueva configuración
     */
    public void setTablero(Pieza[][] tablero)
    {
        this.tablero = tablero;
    }

    /**
     * Regresa una representación en cadena  del tablero
     * @return el tablero en cadena para pintarlo
     */
    @Override
    public String toString()
    {
	     String cadena = "";

	     for(int i=0; i < 8; i++)
       {
	        for(int j=0; j < 8; j++)
          {
		          Pieza pieza = this.tablero[i][j];
		          cadena = cadena + pieza.toString() + " ";
	        }
	        cadena = cadena + "\n";
	     }

	     return cadena;
    }

}
