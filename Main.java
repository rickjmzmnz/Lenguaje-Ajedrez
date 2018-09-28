import src.auxiliares.*;
import src.procedimientos.*;
import src.tipos.*;

//Clase de prueba
public class Main
{
    public static void main(String[] args)
    {
       Color col = new Color("Black");
    	 Pieza[][] t = new Pieza[8][8];
    	 Tablero tablero = new Tablero(t);
       Posicion posicion = new Posicion(tablero);
    	 System.out.println(tablero.toString());
       boolean b = Basico.hacke(posicion, col);
       System.out.println(b);
       //Lista<Movimiento> movs = Basico.movimientos(posicion);
       //System.out.println(movs.toString());
    }
}
