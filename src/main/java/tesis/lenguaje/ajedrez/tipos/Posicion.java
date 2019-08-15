package tesis.lenguaje.ajedrez.tipos;

public class Posicion
{

    //El tablero define el estado del juego
    private Tablero tablero;

    /**
     * Constructor de la clase Posicion
     * @param tablero el tablero según el estado del juego
     */
    public Posicion(Tablero tablero)
    {
        this.tablero = tablero;
    }

    /**
     * Cambia el estado del tablero
     * @param tablero el nuevo estado
     */
    public void setPosicion(Tablero tablero)
    {
        this.tablero = tablero;
    }

    /**
     * Obtiene el estado del tablero
     * @return el estado actual
     */
    public Tablero getPosicion()
    {
        return this.tablero;
    }

}
