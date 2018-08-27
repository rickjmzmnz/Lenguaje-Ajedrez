package src.auxiliares;

import src.tipos.*;

public class Transformacion
{

  /**
   * Dado un Renglon
   * Se obtiene el entero que representa la posicion del renglon del Tablero
   * El tablero se representa como matriz
   * @param ren el renglón a representar
   * @return su valor correspondiente en la matriz
   */
  public static int posicionRenglon(Renglon ren)
  {
      int numRen = ren.getNumRenglon();
      int pos = 0;

      switch(numRen){

          case 1:
              pos = 7;
              break;

          case 2:
              pos = 6;
              break;

          case 3:
              pos = 5;
              break;

          case 4:
              pos = 4;
              break;

          case 5:
              pos = 3;
              break;

          case 6:
              pos = 2;
              break;

          case 7:
              pos = 1;
              break;

          case 8:
              break;

      }

      return pos;
  }

  /**
   * Dada un Columna
   * Se obtiene el entero que representa la posicion de la columna del Tablero
   * El tablero se representa como matriz
   * @param col la columna a representar
   * @return su valor correspondiente en la matriz
   */
   public static int posicionColumna(Columna col)
   {
      int pos = 0;
      String nomColumna = col.getNomColumna();

      switch(nomColumna){

          case "a":
              break;

          case "b":
              pos = 1;
              break;

          case "c":
              pos = 2;
              break;

          case "d":
              pos = 3;
              break;

          case "e":
              pos = 4;
              break;

          case "f":
              pos = 5;
              break;

          case "g":
              pos = 6;
              break;

          case "h":
              pos = 7;
              break;

      }

      return pos;
   }

   /**
    * Convierte el renglon y columna
    * De su representación matrizial a la que utiliza el tipo Casilla
    * @param ren el valor del renglon en la matriz
    * @param col el valor de la columna en la matriz
    * @return la casilla correspondiente a los valores
    */
   public static Casilla toCasilla(int ren,int col)
   {
      int casRen = 0;
      String casCol = "";

      switch(ren){

          case 0:
              casRen = 8;
              break;

          case 1:
              casRen = 7;
              break;

          case 2:
              casRen = 6;
              break;

          case 3:
              casRen = 5;
              break;

          case 4:
              casRen = 4;
              break;

          case 5:
              casRen = 3;
              break;

          case 6:
              casRen = 2;
              break;

          case 7:
              casRen = 1;
              break;

     }

     switch(col){

          case 0:
              casCol = "a";
              break;

          case 1:
              casCol = "b";
              break;

          case 2:
              casCol = "c";
              break;

          case 3:
              casCol = "d";
              break;

          case 4:
              casCol = "e";
              break;

          case 5:
              casCol = "f";
              break;

          case 6:
              casCol = "g";
              break;

          case 7:
              casCol = "h";
              break;

     }

     Renglon renRep = new Renglon(casRen);
     Columna colRep = new Columna(casCol);
     Casilla casilla = new Casilla(colRep,renRep);
     return casilla;
   }

}
