package src.procedimientos;

import src.tipos.*;
import src.auxiliares.*;

public class Basico
{

    /**
     * Dada una posicion del tablero y un movimiento que se quiere realizar
     * Se verifica si es posible realizar el movimiento
     * @param pos la posicion actual del tablero
     * @param mov el movimiento a realizar
     * @return un predicado indicando si es posible el movimiento
     */
    public static Predicado posible(Posicion pos,Movimiento mov)
    {
        Casilla casDes = mov.getCasillaDestino();
        Casilla casOri = mov.getCasillaOrigen();
        Pieza piezaDes = pieza(casDes, pos);
        Pieza piezaOri = pieza(casOri, pos);
        Predicado pred = null;

        Lista<Casilla> camino = camino(mov, pos);

        for(int i = 0; i < camino.longitud(); i++) {

            Casilla casilla = camino.obtenElem(i);
            Pieza pieza = pieza(casilla, pos);
            if(pieza.getColorPieza() != null) {
                pred = new Predicado(false);
                return pred;
            }

        }

        if(piezaDes.getColorPieza() == null || !piezaDes.getColorPieza().equals(piezaOri.getColorPieza())) {
            pred = new Predicado(true);
        } else {
            pred = new Predicado(false);
        }

        return pred;

    }

    /**
     * Obtiene las casillas por las que pasa una pieza al realizar un movimiento
     * Nota: Se omiten las del caballo porque en realidad "salta" las casillas
     * @param mov el movimiento realizado
     * @param pos la posicion actual del tablero
     * @return una lista con las casillas por la que pasa el movimiento
     */
    public static Lista<Casilla> camino(Movimiento mov, Posicion pos)
    {
        Lista<Casilla> lista = new Lista<Casilla>();
        Tablero tablero = pos.getPosicion();
        Pieza[][] config = tablero.getTablero();

        Casilla casOri = mov.getCasillaOrigen();
        Columna colOri = casOri.getColumna();
        int posColOri = Transformacion.posicionColumna(colOri);
        Renglon renOri = casOri.getRenglon();
        int posRenOri = Transformacion.posicionRenglon(renOri);

        Casilla casDes = mov.getCasillaDestino();
        Columna colDes = casDes.getColumna();
        int posColDes = Transformacion.posicionColumna(colDes);
        Renglon renDes = casDes.getRenglon();
        int posRenDes = Transformacion.posicionRenglon(renDes);

        int colNuevo = 0;
        int renNuevo = 0;
        int cont = 0;

        if(posRenOri == posRenOri) {

            if(posColOri > posColDes) {

                cont = posColOri - 1;

                while(cont > posColDes) {

                      Casilla casilla = Transformacion.toCasilla(posRenOri, cont);
                      lista.agrega(casilla);
                      cont--;

                }

            } else {

                cont = posColOri + 1;

                while(cont < posColDes) {

                    Casilla casilla = Transformacion.toCasilla(posRenOri, cont);
                    lista.agrega(casilla);
                    cont++;

                }

            }

        }

        if(posColOri == posColDes) {

            if(posRenOri > posRenDes) {

                cont = posRenOri - 1;

                while(cont > posRenDes) {

                    Casilla casilla = Transformacion.toCasilla(cont, posColOri);
                    lista.agrega(casilla);
                    cont--;

                }

            } else {

                cont = posRenOri + 1;

                while(cont < posRenDes) {

                    Casilla casilla = Transformacion.toCasilla(cont, posColOri);
                    lista.agrega(casilla);
                    cont++;

                }

            }

        }

        if(posColOri != posColDes && posRenOri != posRenDes) {

            if(posColOri > posColDes) {

                int difCol = posColOri - posColDes;
                int difRen = posRenDes - posRenOri;

                if(difCol == difRen) {

                    difCol = posColOri - 1;
                    difRen = posRenOri + 1;

                    while(difCol > posColDes) {

                        Casilla casilla = Transformacion.toCasilla(difRen, difCol);
                        lista.agrega(casilla);
                        difCol--;
                        difRen++;

                    }

                }

            } else {

                int difCol = posColDes - posColOri;
                int difRen = posRenOri - posRenDes;

                if(difCol == difRen) {

                    difCol = posColOri + 1;
                    difRen = posRenOri - 1;

                    while(difCol < posColDes) {

                        Casilla casilla = Transformacion.toCasilla(difRen, difCol);
                        lista.agrega(casilla);
                        difCol++;
                        difRen--;

                    }

                }

            }

        }

        return lista;

    }

    /**
     * Dada una posición del tablero
     * Se obtienen todos los movimientos posibles a partir de él
     * @param pos la posición actual del tablero
     * @return una lista con todos los movimientos de las piezas del tablero
     */
    public static Lista<Movimiento> movimientos(Posicion pos)
    {
        Lista<Movimiento> lista = new Lista<Movimiento>();
        Tablero tablero = pos.getPosicion();
        Pieza[][] config = tablero.getTablero();

        for(int i = 0; i < 8; i++) {
           for(int j = 0; j < 8; j++) {

                Pieza pieza = config[i][j];
                Casilla cas = Transformacion.toCasilla(i,j);

                if(pieza.getColorPieza() == null) {
                    continue;
                } else {
                    Lista<Movimiento> movs = movimientoPieza(pieza, cas, config);

                    for(int k = 0; k < movs.longitud(); k++) {

                        Movimiento mov = movs.obtenElem(k);
                        if(posible(pos, mov).getValor() == true){
                            lista.agrega(mov);
                        }

                    }

                }

           }
        }

        return lista;
    }

    /**
     * Obtiene la casilla donde parte un movimiento
     * @param mov el movimiento realizado
     * @return la casilla de donde parte el movimiento
     */
    public static Casilla origen(Movimiento mov)
    {
        return mov.getCasillaOrigen();
    }

    /**
     * Obtiene el color de la pieza
     * @param pieza la pieza a la que se le obtiene el color
     * @return el color de la pieza
     */
    public static Color color(Pieza pieza)
    {
        return pieza.getColorPieza();
    }

    /**
     * Dado un color, se obtiene el contrario
     * @param color el color a obtener el contrario
     * @return el otro color
     */
    public static Color otro(Color color)
    {
        String actual = color.getColor();

        if(actual.equals("White")) {

            String otro = "Black";
            Color nuevo = new Color(otro);
            return nuevo;

        } else {

            String otro = "White";
            Color nuevo  = new Color(otro);
            return nuevo;

        }

    }

    /**
     * Dada una posicion del tablero y una casilla
     * Se obtiene la pieza que se encuentra en dicha casilla del tablero
     * @param cas la casilla donde se quiere obtener la pieza
     * @param pos la posición actual del tablero
     * @return la pieza en la casilla
     */
    public static Pieza pieza(Casilla cas,Posicion pos)
    {
        Renglon ren = cas.getRenglon();
        Columna col = cas.getColumna();
        int numRen = Transformacion.posicionRenglon(ren);
        int numCol = Transformacion.posicionColumna(col);
        Tablero tablero = pos.getPosicion();
        Pieza[][] config = tablero.getTablero();
        Pieza pieza = config[numRen][numCol];
        return pieza;
    }

    /**
     * Dada una pieza y una casilla
     * Se regresan los movimientos posibles de esa pieza
     * @param pieza la pieza de la que se obtendran los movimientos
     * @param origen la casilla de donde se van a calcular los movimientos
     * @param config la configuración actual del tablero
     * @return una lista con los movimientos que realiza la pieza dada esa configuración
     */
    public static Lista<Movimiento> movimientoPieza(Pieza pieza, Casilla origen, Pieza[][] config)
    {
        Lista<Movimiento> lista = new Lista<Movimiento>();
        Lista<Casilla> listaCas = null;

        String nombrePieza = pieza.getNombrePieza();
        Color colorPieza = pieza.getColorPieza();
        String nombreColor = colorPieza.getColor();
        Renglon ren = origen.getRenglon();
        Columna col = origen.getColumna();
        int numRen = Transformacion.posicionRenglon(ren);
        int numCol = Transformacion.posicionColumna(col);

        switch(nombrePieza) {

            case "Pawn":
                listaCas = MovimientoPieza.peon(numRen,numCol,nombreColor, config);
                break;

            case "Knight":
                listaCas = MovimientoPieza.caballo(numRen,numCol);
                break;

            case "Bishop":
                listaCas = MovimientoPieza.alfil(numRen,numCol);
                break;

            case "Rook":
                listaCas = MovimientoPieza.torre(numRen,numCol);
                break;

            case "Queen":
                listaCas = MovimientoPieza.reina(numRen,numCol);
                break;

            case "King":
                listaCas = MovimientoPieza.rey(numRen,numCol);
                break;

        }

        for(int i = 0; i < listaCas.longitud(); i++) {

            Casilla cas = listaCas.obtenElem(i);
            Movimiento mov = new Movimiento(origen, cas);
            lista.agrega(mov);

        }

        return lista;
    }

}
