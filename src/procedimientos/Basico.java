package src.procedimientos;

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
import src.auxiliares.*;

public class Basico{

    /* PENDIENTE
     * Dada una posicion del tablero y un movimiento que se quiere realizar
     * Se verifica si es posible realizar el movimiento
     */
    public static Predicado posible(Posicion posicion,Movimiento movimiento) {
        Casilla casillaDestino = movimiento.getCasillaDestino();
        Casilla casillaOrigen = movimiento.getCasillaOrigen();
        Pieza piezaDes = Pieza(casillaDestino, posicion);
        Pieza piezaOri = Pieza(casillaOrigen, posicion);
        Predicado pred = null;

        if(piezaDes.getColorPieza() == null || !piezaDes.getColorPieza().equals(piezaOri.getColorPieza())) {
            pred = new Predicado(true);
        } else {
            pred = new Predicado(false);
        }

        return pred;

    }

    public static Lista<Casilla> camino(Movimiento mov, Posicion pos) {

        Lista<Casilla> lista = new Lista<Casilla>();
        Tablero tablero = pos.getPosicion();
        Pieza[][] config = tablero.getTablero();

        Casilla casOri = mov.getCasillaOrigen();
        Columna colOri = casOri.getColumna();
        int posColOri = MovimientoPieza.posicionColumna(colOri);
        Renglon renOri = casOri.getRenglon();
        int posRenOri = MovimientoPieza.posicionRenglon(renOri);

        Casilla casDes = mov.getCasillaDestino();
        Columna colDes = casDes.getColumna();
        int posColDes = MovimientoPieza.posicionColumna(colDes);
        Renglon renDes = casDes.getRenglon();
        int posRenDes = MovimientoPieza.posicionRenglon(renDes);

        int colNuevo = 0;
        int renNuevo = 0;
        int cont = 0;

        if(posRenOri == posRenDes) {

            cont = posColOri + 1;

            while(cont < posColDes) {

                colNuevo = cont;
                Casilla casilla = MovimientoPieza.toRepresent(posRenOri, colNuevo);
                lista.agrega(casilla);
                cont = cont + 1;

            }

        }

        if(posColOri == posColDes) {

            cont = posRenOri + 1;

            while(cont < posRenDes) {

                renNuevo = cont;
                Casilla casilla = MovimientoPieza.toRepresent(renNuevo, posColOri);
                lista.agrega(casilla);
                cont = cont + 1;

            }

        }

        return lista;

    }

    /* PENDIENTE
     * Dada una posición del tablero
     * Se obtienen todos los movimientos posibles a partir de él
     */
    public static Lista<Movimiento> Movimientos(Posicion posicion) {
      Lista<Movimiento> lista = new Lista<Movimiento>();
      Tablero tablero = posicion.getPosicion();
      Pieza[][] configuracion = tablero.getTablero();

      for(int i = 0; i < 8; i++) {
         for(int j = 0; j < 8; j++) {

              Pieza pieza = configuracion[i][j];
              Casilla casilla = MovimientoPieza.toRepresent(i,j);

              if(pieza.getColorPieza() == null) {
                  continue;
              } else {
                  Lista<Movimiento> movs = movimientoPieza(pieza, casilla);

                  for(int k = 0; k < movs.longitud(); k++) {

                      Movimiento mov = movs.obtenElem(k);
                      if(posible(posicion, mov).getValor() == true){
                          lista.agrega(mov);
                      }
                  }
              }

         }
      }

      return lista;
    }

    /*
     * Obtiene la casilla donde parte un movimiento
     */
    public static Casilla Origen(Movimiento movimiento) {
        return movimiento.getCasillaOrigen();
    }

    /*
     * Obtiene el color de la pieza
     * @return - el color de la pieza
     */
    public static Color Color(Pieza pieza) {
        return pieza.getColorPieza();
    }

    /*
     * Dado un color, se obtiene el contrario
     * @return - el otro color
     */
    public static Color Otro(Color color) {
      String actual = color.getColor();
      if(actual.equals("White")){
          String otro = "Black";
          Color nuevo = new Color(otro);
          return nuevo;
      }else{
          String otro = "White";
          Color nuevo  = new Color(otro);
          return nuevo;
      }
    }

    /*
     * Dada una posicion del tablero y una casilla
     * Se obtiene la pieza que se encuentra en dicha casilla del tablero
     */
    public static Pieza Pieza(Casilla casilla,Posicion posicion){
        Renglon renglon = casilla.getRenglon();
        Columna columna = casilla.getColumna();
        int numRenglon = MovimientoPieza.posicionRenglon(renglon);
        int numColumna = MovimientoPieza.posicionColumna(columna);
        Tablero tablero = posicion.getPosicion();
        Pieza[][] configuracion = tablero.getTablero();
        Pieza pieza = configuracion[numRenglon][numColumna];
        return pieza;
    }

    /*
     * Dada una pieza y una casilla
     * Se regresan los movimientos posibles de esa pieza
     */
    public static Lista<Movimiento> movimientoPieza(Pieza pieza,Casilla origen){
      Lista<Movimiento> lista = new Lista<Movimiento>();
      String nombrePieza = pieza.getNombrePieza();
      Color colorPieza = pieza.getColorPieza();
      String nombreColor = colorPieza.getColor();
      Renglon renglon = origen.getRenglon();
      Columna columna = origen.getColumna();
      int numRenglon = MovimientoPieza.posicionRenglon(renglon);
      int numColumna = MovimientoPieza.posicionColumna(columna);

      if(nombrePieza.equals("Pawn")){
          Lista<Casilla> listaCas = MovimientoPieza.peon(numRenglon,numColumna,nombreColor);
          for(int i = 0; i < listaCas.longitud(); i++) {
              Casilla casilla = listaCas.obtenElem(i);
              Movimiento movimiento = new Movimiento(origen, casilla);
              lista.agrega(movimiento);
          }
      }

      if(nombrePieza.equals("Knight")){
          Lista<Casilla> listaCas = MovimientoPieza.caballo(numRenglon,numColumna);
          int longitud = listaCas.longitud();
          for(int i = 0; i < longitud; i++){
              Casilla casilla = listaCas.obtenElem(i);
              Movimiento movimiento = new Movimiento(origen,casilla);
              lista.agrega(movimiento);
          }
          return lista;
      }

      if(nombrePieza.equals("Bishop")){
          Lista<Casilla> listaCas = MovimientoPieza.alfil(numRenglon,numColumna);
          int longitud = listaCas.longitud();
          for(int i = 0; i < longitud; i++){
              Casilla casilla = listaCas.obtenElem(i);
              Movimiento movimiento = new Movimiento(origen,casilla);
              lista.agrega(movimiento);
          }
          return lista;
      }

      if(nombrePieza.equals("Rook")){
          Lista<Casilla> listaCas = MovimientoPieza.torre(numRenglon,numColumna);
          int longitud = listaCas.longitud();
          for(int i = 0; i < longitud; i++){
              Casilla casilla = listaCas.obtenElem(i);
              Movimiento movimiento = new Movimiento(origen,casilla);
              lista.agrega(movimiento);
          }
          return lista;
      }

      if(nombrePieza.equals("Queen")){
          Lista<Casilla> listaCas = MovimientoPieza.reina(numRenglon,numColumna);
          int longitud = listaCas.longitud();
          for(int i = 0; i < longitud; i++){
              Casilla casilla = listaCas.obtenElem(i);
              Movimiento movimiento = new Movimiento(origen,casilla);
              lista.agrega(movimiento);
          }
          return lista;
      }

      if(nombrePieza.equals("King")){
          Lista<Casilla> listaCas = MovimientoPieza.rey(numRenglon,numColumna);
          int longitud = listaCas.longitud();
          for(int i = 0; i < longitud; i++){
              Casilla casilla = listaCas.obtenElem(i);
              Movimiento movimiento = new Movimiento(origen,casilla);
              lista.agrega(movimiento);
          }
          return lista;
      }
      return lista;
    }

}
