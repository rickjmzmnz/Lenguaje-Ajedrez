import src.auxiliares.*;
import src.procedimientos.*;
import src.tipos.*;

//Clase de prueba
public class Main
{
    public static void main(String[] args)
    {
       Basico bas = new Basico();
       Color color = new Color("Black");
    	 Pieza[][] t = new Pieza[8][8];
    	 Tablero tablero = new Tablero(t);
       Posicion posicion = new Posicion(tablero);

       Renglon ren = new Renglon(2);
       Columna col = new Columna("b");
       Casilla cas = new Casilla(col, ren);

       Renglon renD = new Renglon(3);
       Columna colD = new Columna("b");
       Casilla casD = new Casilla(colD, renD);

       Movimiento m = new Movimiento(cas, casD);
       bas.realizaMovimiento(m,posicion);
       Predicado hM = bas.hackeMate(posicion, color);
       System.out.println(posicion.getPosicion());
       System.out.println(hM.getValor());
       //boolean b = bas.hacke(posicion, col);
       //System.out.println(b);
       //Lista<Movimiento> movs = Basico.movimientos(posicion);
       //System.out.println(movs.toString());
    }
}
