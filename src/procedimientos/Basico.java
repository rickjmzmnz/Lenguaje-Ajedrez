package src.procedimientos;

import src.tipos.*;
import src.auxiliares.*;

public class Basico
{

    /* PENDIENTE
     * Dada una posicion del tablero y un movimiento que se quiere realizar
     * Se verifica si es posible realizar el movimiento
     */
    public static Predicado posible(Posicion pos,Movimiento mov)
    {
        Casilla casDes = mov.getCasillaDestino();
        Casilla casOri = mov.getCasillaOrigen();
        Pieza piezaDes = Pieza(casDes, pos);
        Pieza piezaOri = Pieza(casOri, pos);
        Predicado pred = null;

        if(piezaDes.getColorPieza() == null || !piezaDes.getColorPieza().equals(piezaOri.getColorPieza())) {
            pred = new Predicado(true);
        } else {
            pred = new Predicado(false);
        }

        return pred;

    }

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

        if(posRenOri == posRenDes) {

            cont = posColOri + 1;

            while(cont < posColDes) {

                colNuevo = cont;
                Casilla cas = Transformacion.toCasilla(posRenOri, colNuevo);
                lista.agrega(cas);
                cont = cont + 1;

            }

        }

        if(posColOri == posColDes) {

            cont = posRenOri + 1;

            while(cont < posRenDes) {

                renNuevo = cont;
                Casilla cas = Transformacion.toCasilla(renNuevo, posColOri);
                lista.agrega(cas);
                cont = cont + 1;

            }

        }

        return lista;

    }

    /* PENDIENTE
     * Dada una posición del tablero
     * Se obtienen todos los movimientos posibles a partir de él
     */
    public static Lista<Movimiento> Movimientos(Posicion pos)
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
                    Lista<Movimiento> movs = movimientoPieza(pieza, cas);

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

    /*
     * Obtiene la casilla donde parte un movimiento
     */
    public static Casilla Origen(Movimiento mov)
    {
        return mov.getCasillaOrigen();
    }

    /*
     * Obtiene el color de la pieza
     * @return - el color de la pieza
     */
    public static Color Color(Pieza pieza)
    {
        return pieza.getColorPieza();
    }

    /*
     * Dado un color, se obtiene el contrario
     * @return - el otro color
     */
    public static Color Otro(Color color)
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

    /*
     * Dada una posicion del tablero y una casilla
     * Se obtiene la pieza que se encuentra en dicha casilla del tablero
     */
    public static Pieza Pieza(Casilla cas,Posicion pos)
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

    /*
     * Dada una pieza y una casilla
     * Se regresan los movimientos posibles de esa pieza
     */
    public static Lista<Movimiento> movimientoPieza(Pieza pieza,Casilla origen)
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
                listaCas = MovimientoPieza.peon(numRen,numCol,nombreColor);
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
