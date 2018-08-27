package src.auxiliares;

import src.tipos.*;
import src.auxiliares.Transformacion;

public class MovimientoPieza
{

  /**
   * Regresa los movimientos que podría realizar un peón
   * Dada una posición en el tablero
   * @param ren el renglón de la casilla
   * @param col la columna de la casilla
   * @param color el color de la pieza
   * @param config el tablero actual
   * @return una lista que contiene los movimientos del peón
   */
  public static Lista<Casilla> peon(int ren,int col,String color, Pieza[][] config)
  {
     Lista<Casilla> lista = new Lista<Casilla>();
     int renDes = 0;
     int colDes = 0;
     Pieza pieza = null;

     if(color.equals("Black")) {

         renDes = ren + 1;
         if(verificaRango(renDes) == true) {
             Casilla cas = Transformacion.toCasilla(renDes,col);
             lista.agrega(cas);
         }

         renDes = ren + 1;
         colDes = col + 1;
         if(verificaRango(renDes) == true && verificaRango(colDes) == true) {

             pieza = config[renDes][colDes];
             if(pieza.getColorPieza() != null) {

                Casilla cas = Transformacion.toCasilla(renDes, colDes);
                lista.agrega(cas);

             }
         }

         renDes = ren + 1;
         colDes = col - 1;
         if(verificaRango(renDes) == true && verificaRango(colDes) == true) {

             pieza = config[renDes][colDes];
             if(pieza.getColorPieza() != null) {

                Casilla cas = Transformacion.toCasilla(renDes, colDes);
                lista.agrega(cas);

             }
         }

         if(ren == 1) {
             ren = ren + 2;
             Casilla cas = Transformacion.toCasilla(ren, col);
             lista.agrega(cas);
         }

     } else {

         renDes = ren - 1;
         if(verificaRango(renDes) == true) {
             Casilla cas = Transformacion.toCasilla(renDes,col);
             lista.agrega(cas);
         }

         renDes = ren - 1;
         colDes = col + 1;
         if(verificaRango(renDes) == true && verificaRango(colDes) == true) {

             pieza = config[renDes][colDes];
             if(pieza.getColorPieza() != null) {

                Casilla cas = Transformacion.toCasilla(renDes, colDes);
                lista.agrega(cas);

             }
         }

         renDes = ren - 1;
         colDes = col - 1;
         if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
             pieza = config[renDes][colDes];

             if(pieza.getColorPieza() != null) {

                Casilla cas = Transformacion.toCasilla(renDes, colDes);
                lista.agrega(cas);

             }
         }

         if(ren == 6) {
             ren = ren - 2;
             Casilla cas = Transformacion.toCasilla(ren, col);
             lista.agrega(cas);
         }

     }

     return lista;
  }

  /**
   * Regresa los movimientos que podría realizar una torre
   * Dada una posición en el tablero
   * @param ren el renglón de la casilla
   * @param col la columna de la casilla
   * @return una lista que contiene los movimientos de la torre
   */
 public static Lista<Casilla> torre(int ren, int col)
 {
     Lista<Casilla> lista = new Lista<Casilla>();
     int renDes = 0;
     int colDes = 0;

     /*Primer caso*/
     renDes = ren - 1;
     while(verificaRango(renDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,col);
         lista.agrega(cas);
         renDes--;
     }

     /*Segundo caso*/
     renDes = ren + 1;
     while(verificaRango(renDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,col);
         lista.agrega(cas);
         renDes++;
     }

     /*Tercer caso*/
     colDes = col - 1;
     while(verificaRango(colDes) == true)  {
         Casilla cas = Transformacion.toCasilla(ren,colDes);
         lista.agrega(cas);
         colDes--;
     }

     /*Cuarto caso*/
     colDes = col + 1;
     while(verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(ren,colDes);
         lista.agrega(cas);
         colDes++;
     }

     return lista;
 }

 /**
  * Regresa los movimientos que podría realizar un caballo
  * Dada una posición en el tablero
  * @param ren el renglón de la casilla
  * @param col la columna de la casilla
  * @return una lista que contiene los movimientos del caballo
  */
  public static Lista<Casilla> caballo(int ren,int col)
  {
     Lista<Casilla> lista = new Lista<Casilla>();
     int renDes = 0;
     int colDes = 0;

     /*Primer caso*/
     renDes = ren - 2;
     colDes = col + 1;
     if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
        Casilla cas = Transformacion.toCasilla(renDes,colDes);
        lista.agrega(cas);
     }

     /*Segundo caso*/
     renDes = ren - 1;
     colDes = col + 2;
     if(verificaRango(renDes) == true && verificaRango(colDes) == true)  {
        Casilla cas = Transformacion.toCasilla(renDes,colDes);
        lista.agrega(cas);
     }

     /*Tercer caso*/
     renDes = ren + 1;
     colDes = col + 2;
     if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
        Casilla cas = Transformacion.toCasilla(renDes,colDes);
        lista.agrega(cas);
     }

     /*Cuarto caso*/
     renDes = ren + 2;
     colDes = col + 1;
     if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
        Casilla cas = Transformacion.toCasilla(renDes,colDes);
        lista.agrega(cas);
     }

     /*Quinto caso*/
     renDes = ren + 2;
     colDes = col - 1;
     if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
        Casilla cas = Transformacion.toCasilla(renDes,colDes);
        lista.agrega(cas);
     }

     /*Sexto caso*/
     renDes = ren + 1;
     colDes = col - 2;
     if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
        Casilla cas = Transformacion.toCasilla(renDes,colDes);
        lista.agrega(cas);
     }

     /*Septimo caso*/
     renDes = ren - 1;
     colDes = col - 2;
     if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
        Casilla cas = Transformacion.toCasilla(renDes,colDes);
        lista.agrega(cas);
     }

     /*Octavo caso*/
     renDes = ren - 2;
     colDes = col - 1;
     if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
        Casilla cas = Transformacion.toCasilla(renDes,colDes);
        lista.agrega(cas);
     }

     return lista;
  }

  /**
   * Regresa los movimientos que podría realizar un alfil
   * Dada una posición en el tablero
   * @param ren el renglón de la casilla
   * @param col la columna de la casilla
   * @return una lista que contiene los movimientos del alfil
   */
  public static Lista<Casilla> alfil(int ren,int col)
  {
     Lista<Casilla> lista = new Lista<Casilla>();
     int renDes = 0;
     int colDes = 0;

     /*Primer caso*/
     renDes = ren + 1;
     colDes = col + 1;
     while(verificaRango(renDes) == true && verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,colDes);
         lista.agrega(cas);
         renDes++;
         colDes++;
     }

     /*Segundo caso*/
     renDes = ren - 1;
     colDes = col + 1;
     while(verificaRango(renDes) == true && verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,colDes);
         lista.agrega(cas);
         renDes--;
         colDes++;
     }

     /*Tercer caso*/
     renDes = ren + 1;
     colDes = col - 1;
     while(verificaRango(renDes) == true && verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,colDes);
         lista.agrega(cas);
         renDes++;
         colDes--;
     }

     /*Cuarto caso*/
     renDes = ren - 1;
     colDes = col - 1;
     while(verificaRango(renDes) == true && verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,colDes);
         lista.agrega(cas);
         renDes--;
         colDes--;
     }

     return lista;
  }

  /**
   * Regresa los movimientos que podría realizar una reina
   * Dada una posición en el tablero
   * @param ren el renglón de la casilla
   * @param col la columna de la casilla
   * @return una lista que contiene los movimientos de la reina
   */
  public static Lista<Casilla> reina(int ren,int col)
  {
     Lista<Casilla> listaTorre = torre(ren,col);
     Lista<Casilla> listaAlfil = alfil(ren,col);
     listaTorre.concatena(listaAlfil);
     return listaTorre;
  }

  /**
   * Regresa los movimientos que podría realizar un rey
   * Dada una posición en el tablero
   * @param ren el renglón de la casilla
   * @param col la columna de la casilla
   * @return una lista que contiene los movimientos del rey
   */
  public static Lista<Casilla> rey(int ren, int col)
  {
      Lista<Casilla> lista = new Lista<Casilla>();
      int renDes = 0;
      int colDes = 0;

      /*Primer caso*/
      renDes = ren + 1;
      if(verificaRango(renDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,col);
         lista.agrega(cas);
      }

      /*Segundo caso*/
      renDes = ren + 1;
      colDes = col - 1;
      if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,colDes);
         lista.agrega(cas);
      }

      /*Tercer caso*/
      renDes = ren + 1;
      colDes = col + 1;
      if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,colDes);
         lista.agrega(cas);
      }

      /*Cuarto caso*/
      colDes = col - 1;
      if(verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(ren,colDes);
         lista.agrega(cas);
      }

      /*Quinto caso*/
      colDes = col + 1;
      if(verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(ren,colDes);
         lista.agrega(cas);
      }

      /*Sexto caso*/
      renDes = ren - 1;
      colDes = col - 1;
      if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,colDes);
         lista.agrega(cas);
      }

      /*Septimo caso*/
      renDes = ren - 1;
      if(verificaRango(renDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,col);
         lista.agrega(cas);
      }

      /*Octavo caso*/
      renDes = ren - 1;
      colDes = col + 1;
      if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
         Casilla cas = Transformacion.toCasilla(renDes,colDes);
         lista.agrega(cas);
      }

      return lista;
  }

  /**
   * Verifica que al hacer un movimiento no se salga del tablero
   * @param rango el valor a verificar si se sale del tablero
   * @return true si no se sale del tablero, false en otro caso
   */
  public static boolean verificaRango(int rango)
  {
     if(rango < 0 || rango > 7)
         return false;
     return true;
  }

}
