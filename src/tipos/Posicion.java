package src.tipos;

public class Posicion{

    //El tablero define el estado del juego
    private Tablero tablero;

    /*
    * Constructor de la clase Posicion
    */
    public Posicion(Tablero tablero){
        this.tablero = tablero;
    }

    /*
    * Cambia el estado del tablero
    */
    public void setPosicion(Tablero tablero){
      this.tablero = tablero;
    }

    /*
    * Obtiene el estado del tablero
    */
    public Tablero getPosicion(){
        return this.tablero;
    }

}
