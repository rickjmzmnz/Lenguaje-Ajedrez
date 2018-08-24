package src.auxiliares;

//import tipos.Casilla;
//import tipos.Color;
//import tipos.Columna;
//import tipos.Lista;
//import tipos.Movimiento;
//import tipos.Pieza;
//import tipos.Posicion;
//import tipos.Predicado;
//import tipos.Renglon;
//import tipos.Tablero;

import src.tipos.*;

public class MovimientoPieza{

  /*
   * Dado un Renglon
   * Se obtiene el entero que representa la posicion del renglon del Tablero
   * El tablero se representa como matriz
   */
  public static int posicionRenglon(Renglon renglon){
      int numRenglon = renglon.getNumRenglon();
      int posicion = 0;
      switch(numRenglon){
        case 1:
          posicion = 7;
          break;
        case 2:
          posicion = 6;
          break;
        case 3:
          posicion = 5;
          break;
        case 4:
          posicion = 4;
          break;
        case 5:
          posicion = 3;
          break;
        case 6:
          posicion = 2;
          break;
        case 7:
          posicion = 1;
          break;
        case 8:
          break;
      }
      return posicion;
  }

  /*
   * Dada un Columna
   * Se obtiene el entero que representa la posicion de la columna del Tablero
   * El tablero se representa como matriz
   */
   public static int posicionColumna(Columna columna){
      int posicion = 0;
      String nomColumna = columna.getNomColumna();
      switch(nomColumna){
        case "a":
          break;
        case "b":
          posicion = 1;
          break;
        case "c":
          posicion = 2;
          break;
        case "d":
          posicion = 3;
          break;
        case "e":
          posicion = 4;
          break;
        case "f":
          posicion = 5;
          break;
        case "g":
          posicion = 6;
          break;
        case "h":
         posicion = 7;
         break;
      }
      return posicion;
   }

   /*
    * Convierte el renglon y columna
    * De su representación matrizial a la que utiliza el tipo Casilla
    */
   public static Casilla toRepresent(int renglon,int columna){
     int casRenglon = 0;
     String casColumna = "";
     switch(renglon){
       case 0:
         casRenglon = 8;
         break;
       case 1:
         casRenglon = 7;
         break;
       case 2:
         casRenglon = 6;
         break;
       case 3:
         casRenglon = 5;
         break;
       case 4:
         casRenglon = 4;
         break;
       case 5:
         casRenglon = 3;
         break;
       case 6:
         casRenglon = 2;
         break;
       case 7:
          casRenglon = 1;
         break;
     }
     switch(columna){
       case 0:
         casColumna = "a";
         break;
       case 1:
         casColumna = "b";
         break;
       case 2:
         casColumna = "c";
         break;
       case 3:
         casColumna = "d";
         break;
       case 4:
         casColumna = "e";
         break;
       case 5:
         casColumna = "f";
         break;
       case 6:
         casColumna = "g";
         break;
       case 7:
        casColumna = "h";
        break;
     }
     Renglon renglonRep = new Renglon(casRenglon);
     Columna columnaRep = new Columna(casColumna);
     Casilla casilla = new Casilla(columnaRep,renglonRep);
     return casilla;
   }

  public static boolean verificaRango(int rango){
     if(rango < 0 || rango > 7)
         return false;
     return true;

  }

  /*
   * Movimiento de un peon
   */
  public static Lista<Casilla> peon(int renglon,int columna,String color){
    Lista<Casilla> lista = new Lista<Casilla>();
     int renglonDes = 0;
     int columnaDes = 0;
     if(color.equals("Black")){
         renglonDes = renglon + 1;
         if(verificaRango(renglonDes) == true){
             Casilla casilla = toRepresent(renglonDes,columna);
             lista.agrega(casilla);
         }
         renglonDes = renglon + 1;
         columnaDes = columna + 1;
         if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true) {
             Casilla casilla = toRepresent(renglonDes, columnaDes);
             lista.agrega(casilla);
         }
         renglonDes = renglon + 1;
         columnaDes = columna - 1;
         if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true) {
             Casilla casilla = toRepresent(renglonDes, columnaDes);
             lista.agrega(casilla);
         }
     }else{
         renglonDes = renglon - 1;
         if(verificaRango(renglonDes) == true){
             Casilla casilla = toRepresent(renglonDes,columna);
             lista.agrega(casilla);
         }
         renglonDes = renglon - 1;
         columnaDes = columna + 1;
         if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true) {
             Casilla casilla = toRepresent(renglonDes, columnaDes);
             lista.agrega(casilla);
         }
         renglonDes = renglon - 1;
         columnaDes = columna - 1;
         if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true) {
             Casilla casilla = toRepresent(renglonDes, columnaDes);
             lista.agrega(casilla);
         }
     }
     return lista;
  }

  /*
   * Movimientos de la torre
   */
 public static Lista<Casilla> torre(int renglon, int columna){
   Lista<Casilla> lista = new Lista<Casilla>();
   int renglonDes = 0;
   int columnaDes = 0;
   /*Primer caso*/
   renglonDes = renglon - 1;
   while(verificaRango(renglonDes) == true){
       Casilla casilla = toRepresent(renglonDes,columna);
       lista.agrega(casilla);
       renglonDes--;
   }
   /*Segundo caso*/
   renglonDes = renglon + 1;
   while(verificaRango(renglonDes) == true){
       Casilla casilla = toRepresent(renglonDes,columna);
       lista.agrega(casilla);
       renglonDes++;
   }
   /*Tercer caso*/
   columnaDes = columna - 1;
   while(verificaRango(columnaDes) == true){
       Casilla casilla = toRepresent(renglon,columnaDes);
       lista.agrega(casilla);
       columnaDes--;
   }
   /*Cuarto caso*/
   columnaDes = columna + 1;
   while(verificaRango(columnaDes) == true){
       Casilla casilla = toRepresent(renglon,columnaDes);
       lista.agrega(casilla);
       columnaDes++;
   }
   return lista;
 }

  /*
   * Movimientos del caballo
   */
  public static Lista<Casilla> caballo(int renglon,int columna){
     Lista<Casilla> lista = new Lista<Casilla>();
     int renglonDes = 0;
     int columnaDes = 0;
     /*Primer caso*/
     renglonDes = renglon - 2;
     columnaDes = columna + 1;
     if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
        Casilla casilla = toRepresent(renglonDes,columnaDes);
        lista.agrega(casilla);
     }
     /*Segundo caso*/
     renglonDes = renglon - 1;
     columnaDes = columna + 2;
     if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
        Casilla casilla = toRepresent(renglonDes,columnaDes);
        lista.agrega(casilla);
     }
     /*Tercer caso*/
     renglonDes = renglon + 1;
     columnaDes = columna + 2;
     if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
        Casilla casilla = toRepresent(renglonDes,columnaDes);
        lista.agrega(casilla);
     }
     /*Cuarto caso*/
     renglonDes = renglon + 2;
     columnaDes = columna + 1;
     if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
        Casilla casilla = toRepresent(renglonDes,columnaDes);
        lista.agrega(casilla);
     }
     /*Quinto caso*/
     renglonDes = renglon + 2;
     columnaDes = columna - 1;
     if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
        Casilla casilla = toRepresent(renglonDes,columnaDes);
        lista.agrega(casilla);
     }
     /*Sexto caso*/
     renglonDes = renglon + 1;
     columnaDes = columna - 2;
     if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
        Casilla casilla = toRepresent(renglonDes,columnaDes);
        lista.agrega(casilla);
     }
     /*Septimo caso*/
     renglonDes = renglon - 1;
     columnaDes = columna - 2;
     if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
        Casilla casilla = toRepresent(renglonDes,columnaDes);
        lista.agrega(casilla);
     }
     /*Octavo caso*/
     renglonDes = renglon - 2;
     columnaDes = columna - 1;
     if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
        Casilla casilla = toRepresent(renglonDes,columnaDes);
        lista.agrega(casilla);
     }
     return lista;
  }

  /*
   * Movimientos del alfil
   */
  public static Lista<Casilla> alfil(int renglon,int columna){
     Lista<Casilla> lista = new Lista<Casilla>();
     int renglonDes = 0;
     int columnaDes = 0;
     /*Primer caso*/
     renglonDes = renglon + 1;
     columnaDes = columna + 1;
     while(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
         Casilla casilla = toRepresent(renglonDes,columnaDes);
         lista.agrega(casilla);
         renglonDes++;
         columnaDes++;
     }
     /*Segundo caso*/
     renglonDes = renglon - 1;
     columnaDes = columna + 1;
     while(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
         Casilla casilla = toRepresent(renglonDes,columnaDes);
         lista.agrega(casilla);
         renglonDes--;
         columnaDes++;
     }
     /*Tercer caso*/
     renglonDes = renglon + 1;
     columnaDes = columna - 1;
     while(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
         Casilla casilla = toRepresent(renglonDes,columnaDes);
         lista.agrega(casilla);
         renglonDes++;
         columnaDes--;
     }
     /*Cuarto caso*/
     renglonDes = renglon - 1;
     columnaDes = columna - 1;
     while(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
         Casilla casilla = toRepresent(renglonDes,columnaDes);
         lista.agrega(casilla);
         renglonDes--;
         columnaDes--;
     }
     return lista;
  }

  /*
   * Movimientos de la reina
   */
  public static Lista<Casilla> reina(int renglon,int columna){
     Lista<Casilla> listaTorre = torre(renglon,columna);
     Lista<Casilla> listaAlfil = alfil(renglon,columna);
     listaTorre.concatena(listaAlfil);
     return listaTorre;
  }

  /*
   * Movimientos del rey
   */
  public static Lista<Casilla> rey(int renglon, int columna){
    Lista<Casilla> lista = new Lista<Casilla>();
    int renglonDes = 0;
    int columnaDes = 0;
    /*Primer caso*/
    renglonDes = renglon + 1;
    if(verificaRango(renglonDes) == true){
       Casilla casilla = toRepresent(renglonDes,columna);
       lista.agrega(casilla);
    }
    /*Segundo caso*/
    renglonDes = renglon + 1;
    columnaDes = columna - 1;
    if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
       Casilla casilla = toRepresent(renglonDes,columnaDes);
       lista.agrega(casilla);
    }
    /*Tercer caso*/
    renglonDes = renglon + 1;
    columnaDes = columna + 1;
    if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
       Casilla casilla = toRepresent(renglonDes,columnaDes);
       lista.agrega(casilla);
    }
    /*Cuarto caso*/
    columnaDes = columna - 1;
    if(verificaRango(columnaDes) == true){
       Casilla casilla = toRepresent(renglon,columnaDes);
       lista.agrega(casilla);
    }
    /*Quinto caso*/
    columnaDes = columna + 1;
    if(verificaRango(columnaDes) == true){
       Casilla casilla = toRepresent(renglon,columnaDes);
       lista.agrega(casilla);
    }
    /*Sexto caso*/
    renglonDes = renglon - 1;
    columnaDes = columna - 1;
    if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
       Casilla casilla = toRepresent(renglonDes,columnaDes);
       lista.agrega(casilla);
    }
    /*Septimo caso*/
    renglonDes = renglon - 1;
    if(verificaRango(renglonDes) == true){
       Casilla casilla = toRepresent(renglonDes,columna);
       lista.agrega(casilla);
    }
    /*Octavo caso*/
    renglonDes = renglon - 1;
    columnaDes = columna + 1;
    if(verificaRango(renglonDes) == true && verificaRango(columnaDes) == true){
       Casilla casilla = toRepresent(renglonDes,columnaDes);
       lista.agrega(casilla);
    }
    return lista;
  }


}
