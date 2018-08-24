package src.auxiliares;

import src.tipos.*;
import src.auxiliares.Transformacion;

public class MovimientoPieza
{

  /*
   * Movimiento de un peon
   */
  public static Lista<Casilla> peon(int ren,int col,String color)
  {
     Lista<Casilla> lista = new Lista<Casilla>();
     int renDes = 0;
     int colDes = 0;

     if(color.equals("Black")) {

         renDes = ren + 1;
         if(verificaRango(renDes) == true) {
             Casilla cas = Transformacion.toCasilla(renDes,col);
             lista.agrega(cas);
         }
         renDes = ren + 1;
         colDes = col + 1;

         if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
             Casilla cas = Transformacion.toCasilla(renDes, colDes);
             lista.agrega(cas);
         }
         renDes = ren + 1;
         colDes = col - 1;

         if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
             Casilla cas = Transformacion.toCasilla(renDes, colDes);
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
             Casilla cas = Transformacion.toCasilla(renDes, colDes);
             lista.agrega(cas);
         }
         renDes = ren - 1;
         colDes = col - 1;

         if(verificaRango(renDes) == true && verificaRango(colDes) == true) {
             Casilla cas = Transformacion.toCasilla(renDes, colDes);
             lista.agrega(cas);
         }
     }

     return lista;
  }

  /*
   * Movimientos de la torre
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

  /*
   * Movimientos del caballo
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

  /*
   * Movimientos del alfil
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

  /*
   * Movimientos de la reina
   */
  public static Lista<Casilla> reina(int ren,int col)
  {
     Lista<Casilla> listaTorre = torre(ren,col);
     Lista<Casilla> listaAlfil = alfil(ren,col);
     listaTorre.concatena(listaAlfil);
     return listaTorre;
  }

  /*
   * Movimientos del rey
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
   */
  public static boolean verificaRango(int rango)
  {
     if(rango < 0 || rango > 7)
         return false;
     return true;
  }

}
