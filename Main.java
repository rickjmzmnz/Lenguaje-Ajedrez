import src.auxiliares.*;
import src.procedimientos.*;
import src.tipos.*;

//Clase de prueba
public class Main{

    public static void main(String[] args){

    	 Pieza[][] t = new Pieza[8][8];
    	 Tablero tablero = new Tablero(t);
       Posicion posicion = new Posicion(tablero);

    	 System.out.println(tablero.toString());

       Lista<Movimiento> movs = Basico.movimientos(posicion);
       System.out.println(movs.toString());
    }
}
