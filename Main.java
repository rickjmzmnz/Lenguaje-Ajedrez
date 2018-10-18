import src.auxiliares.*;
import src.procedimientos.*;
import src.tipos.*;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Arrays;

//Clase de prueba
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Basico bas = new Basico();

        Posicion pos = inicializaJuego();

        System.out.println(pos.getPosicion());

        // Basico bas = new Basico();
        // Color color = new Color("Black");
        //
        // Renglon ren = new Renglon(2);
        // Columna col = new Columna("b");
        // Casilla cas = new Casilla(col, ren);
        //
        // Renglon renD = new Renglon(3);
        // Columna colD = new Columna("b");
        // Casilla casD = new Casilla(colD, renD);
        //
        // Movimiento m = new Movimiento(cas, casD);
        // bas.realizaMovimiento(m,posicion);
        // Predicado hM = bas.hackeMate(posicion, color);
        // System.out.println(posicion.getPosicion());
        // System.out.println(hM.getValor());

        //creaMovimiento(sc);

        Color color = eligeColor(sc);

        if(color.getColor().equals("White"))
        {
            creaMovimiento(pos, sc);
            System.out.println(pos.getPosicion());
        } else
        {
            juegaOponente(pos, bas.otro(color));
            System.out.println("Aquí debe de jugar la IA\n");
        }

        //boolean b = bas.hacke(posicion, col);
        //System.out.println(b);
        //Lista<Movimiento> movs = Basico.movimientos(posicion);
        //System.out.println(movs.toString());
    }

    public static Posicion inicializaJuego()
    {
        System.out.println("Tablero inicial \n");
        Pieza[][] t = new Pieza[8][8];
        Tablero tablero = new Tablero(t);
        Posicion posicion = new Posicion(tablero);
        return posicion;
    }

    public static void creaMovimiento(Posicion pos, Scanner sc)
    {
        Basico bas = new Basico();
        boolean validacion = false;
        Casilla ori = null;
        Casilla des = null;
        String origen = "";
        String destino = "";
        Movimiento mov = null;
        Predicado pred = null;

        while(!validacion)
        {
            System.out.print("Elige la casilla origen de tu movimiento: ");
            origen = sc.next();
            validacion = validaCasilla(origen);

            if(validacion)
            {
                ori = creaCasilla(origen);

                System.out.print("Elige la casilla destino de tu movimiento: ");
                destino = sc.next();
                validacion = validaCasilla(destino);
            }

            if(validacion)
            {
                des = creaCasilla(destino);
                mov = new Movimiento(ori, des);
                pred = bas.posible(pos, mov);
                System.out.println(pred.getValor());
                if(pred.getValor())
                {
                    bas.realizaMovimiento(mov, pos);
                } else
                {
                    System.out.println("El movimiento es ilegal.");
                    System.out.println("Realiza uno válido.\n");
                    validacion = false;
                }
            }
        }

    }

    public static Casilla creaCasilla(String cas)
    {
        String col = cas.substring(0,1);
        int ren = Integer.parseInt(cas.substring(1));
        Columna columna = new Columna(col);
        Renglon renglon = new Renglon(ren);
        Casilla casilla = new Casilla(columna, renglon);

        return casilla;
    }

    public static boolean validaCasilla(String cas)
    {
        if(cas.length() != 2)
        {
            System.out.println("La casilla debe ser válida de acuerdo a la nomenclatura del juego");
            return false;
        }

        try
        {
            String col = cas.substring(0,1);
            int ren = Integer.parseInt(cas.substring(1));
            String[] columnas = {"a","b","c","d","e","f","g","h"};
            List<String> lista = Arrays.asList(columnas);

            if(ren < 1 || ren > 8)
                throw new Exception();

            if(!lista.contains(col))
                throw new Exception();

        } catch(Exception e) {
            System.out.println("Error: No se eligió una casilla válida");
            return false;
        }

        return true;
    }

    public static Color eligeColor(Scanner sc)
    {

        boolean entrada = true;
        int op = 0;
        Color color = null;

        do
        {
            System.out.println("Elige el color de las piezas con las que jugaras: \n");
            System.out.println("1. Blancas");
            System.out.println("2. Negras\n");
            System.out.print("Selecciona una opción por número: ");

            try
            {
              op = sc.nextInt();

              switch(op)
              {
                  case 1:
                      color = new Color("White");
                      entrada = false;
                      break;
                  case 2:
                      color = new Color("Black");
                      entrada = false;
                      break;
                  default:
                      System.out.println("La opción debe de ser 1 o 2\n");
                      break;

              }

            } catch(InputMismatchException e) {
                System.out.println("La opción debe de ser un entero\n");
                sc.next();
                continue;
            }
        }
        while(entrada);

        System.out.println("Jugarás con las piezas: " + color.getColor() + "\n");
        return color;
    }

    public static void juegaOponente(Posicion pos, Color col)
    {
          Complejo com = new Complejo();
          Lista<Movimiento> analizarMovs = new Lista<Movimiento>();
          Lista<Object> valor = new Lista<Object>();
          com.evalua(pos, col, analizarMovs, valor);
    }
}
