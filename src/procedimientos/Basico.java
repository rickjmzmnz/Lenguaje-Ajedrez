package src.procedimientos;

import src.tipos.*;
import src.auxiliares.*;
import src.estructuras.EstructuraBasico;

public class Basico implements EstructuraBasico
{

    /**
     * Constructor vacío
     */
    public Basico(){}

    /**
     * Dada una posicion del tablero y un movimiento que se quiere realizar
     * Se verifica si es posible realizar el movimiento
     * @param pos la posicion actual del tablero
     * @param mov el movimiento a realizar
     * @return un predicado indicando si es posible el movimiento
     */
    public Predicado posible(Posicion pos,Movimiento mov)
    {
        Casilla casDes = this.destino(mov);
        Casilla casOri = this.origen(mov);
        Pieza piezaDes = pieza(casDes, pos);
        Pieza piezaOri = pieza(casOri, pos);
        Predicado pred = null;

        Lista<Casilla> camino = camino(mov, pos);

        for(int i = 0; i < camino.longitud(); i++)
        {
            Casilla casilla = camino.obtenElem(i);
            Pieza pieza = pieza(casilla, pos);
            if(pieza.getColor() != null)
            {
                pred = new Predicado(false);
                return pred;
            }
        }

        if(piezaDes.getColor() == null ||
           !piezaDes.getColor().equals(piezaOri.getColor()))
        {
            pred = new Predicado(true);
        }
        else
        {
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
    public Lista<Casilla> camino(Movimiento mov, Posicion pos)
    {
        Lista<Casilla> lista = new Lista<Casilla>();
        Tablero tablero = pos.getPosicion();
        Pieza[][] config = tablero.getTablero();

        Casilla casOri = this.origen(mov);
        Columna colOri = casOri.getColumna();
        int posColOri = Transformacion.posicionColumna(colOri);
        Renglon renOri = casOri.getRenglon();
        int posRenOri = Transformacion.posicionRenglon(renOri);

        Casilla casDes = this.destino(mov);
        Columna colDes = casDes.getColumna();
        int posColDes = Transformacion.posicionColumna(colDes);
        Renglon renDes = casDes.getRenglon();
        int posRenDes = Transformacion.posicionRenglon(renDes);

        int colNuevo = 0;
        int renNuevo = 0;
        int cont = 0;

        if(posRenOri == posRenOri)
        {
            if(posColOri > posColDes)
            {
                cont = posColOri - 1;
                while(cont > posColDes)
                {
                    Casilla casilla = Transformacion.toCasilla(posRenOri, cont);
                    lista.agrega(casilla);
                    cont--;
                }
            }
            else
            {
                cont = posColOri + 1;
                while(cont < posColDes)
                {
                    Casilla casilla = Transformacion.toCasilla(posRenOri, cont);
                    lista.agrega(casilla);
                    cont++;
                }
            }
        }
        if(posColOri == posColDes)
        {
            if(posRenOri > posRenDes)
            {
                cont = posRenOri - 1;
                while(cont > posRenDes)
                {
                    Casilla casilla = Transformacion.toCasilla(cont, posColOri);
                    lista.agrega(casilla);
                    cont--;
                }

            }
            else
            {
                cont = posRenOri + 1;
                while(cont < posRenDes)
                {
                    Casilla casilla = Transformacion.toCasilla(cont, posColOri);
                    lista.agrega(casilla);
                    cont++;
                }
            }
        }
        if(posColOri != posColDes && posRenOri != posRenDes)
        {
            if(posColOri > posColDes)
            {
                int difCol = posColOri - posColDes;
                int difRen = posRenDes - posRenOri;
                if(difCol == difRen)
                {
                    difCol = posColOri - 1;
                    difRen = posRenOri + 1;
                    while(difCol > posColDes)
                    {
                        Casilla casilla = Transformacion.toCasilla(difRen, difCol);
                        lista.agrega(casilla);
                        difCol--;
                        difRen++;
                    }
                }
            }
            else
            {
                int difCol = posColDes - posColOri;
                int difRen = posRenOri - posRenDes;
                if(difCol == difRen)
                {
                    difCol = posColOri + 1;
                    difRen = posRenOri - 1;
                    while(difCol < posColDes)
                    {
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
    public Lista<Movimiento> movimientos(Posicion pos)
    {
        Lista<Movimiento> lista = new Lista<Movimiento>();
        Tablero tablero = pos.getPosicion();
        Pieza[][] config = tablero.getTablero();

        for(int i = 0; i < 8; i++)
        {
           for(int j = 0; j < 8; j++)
           {
                Pieza pieza = config[i][j];
                Casilla cas = Transformacion.toCasilla(i,j);
                if(pieza.getColor() != null)
                {
                    Lista<Movimiento> movs = movimientoPieza(pieza, cas, config);
                    for(int k = 0; k < movs.longitud(); k++)
                    {
                        Movimiento mov = movs.obtenElem(k);
                        if(posible(pos, mov).getValor() == true)
                        {
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
    public Casilla origen(Movimiento mov)
    {
        return mov.getCasillaOrigen();
    }

    /**
    * Obtiene la casilla hacia donde va un movimiento
    * @param mov el movimiento realizado
    * @return la casilla hacia donde va el movimiento
    */
    public Casilla destino(Movimiento mov)
    {
        return mov.getCasillaDestino();
    }

    /**
     * Obtiene el color de la pieza
     * @param pieza la pieza a la que se le obtiene el color
     * @return el color de la pieza
     */
    public Color color(Pieza pieza)
    {
        return pieza.getColor();
    }

    /**
     * Dado un color, se obtiene el contrario
     * @param color el color a obtener el contrario
     * @return el otro color
     */
    public Color otro(Color color)
    {
        String actual = color.getColor();

        if(actual.equals("White"))
        {
            String otro = "Black";
            Color nuevo = new Color(otro);
            return nuevo;
        }
        else
        {
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
    public Pieza pieza(Casilla cas,Posicion pos)
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
     * Obtiene el color de la pieza
     * Que se encuentra en la casilla destino del movimiento
     * @param mov el movimiento a realizar
     * @param pos la configuración actual del tablero
     * @return el color de la pieza en la casilla destino
     */
    public Color cpd(Movimiento mov, Posicion pos)
    {
        Tablero tablero = pos.getPosicion();
        Pieza[][] config = tablero.getTablero();
        Casilla des = this.destino(mov);
        Renglon ren = des.getRenglon();
        Columna col = des.getColumna();
        int numRen = Transformacion.posicionRenglon(ren);
        int numCol = Transformacion.posicionColumna(col);
        Pieza pieza = config[numRen][numCol];

        return (pieza == null)
               ? null
               : pieza.getColor();
    }

    /**
     * Obtiene el color de la pieza
     * Que se encuentra en la casilla origen del movimiento
     * @param mov el movimiento a realizar
     * @param pos la configuración actual del tablero
     * @return el color de la pieza en la casilla origen
     */
    public Color cpo(Movimiento mov, Posicion pos)
    {
        Tablero tablero = pos.getPosicion();
        Pieza[][] config = tablero.getTablero();
        Casilla ori = this.origen(mov);
        Renglon ren = ori.getRenglon();
        Columna col = ori.getColumna();
        int numRen = Transformacion.posicionRenglon(ren);
        int numCol = Transformacion.posicionColumna(col);
        Pieza pieza = config[numRen][numCol];

        return (pieza == null)
               ? null
               : pieza.getColor();
    }

    /**
     * Dada una pieza y una casilla
     * Se regresan los movimientos posibles de esa pieza
     * @param pieza la pieza de la que se obtendran los movimientos
     * @param origen la casilla de donde se van a calcular los movimientos
     * @param config la configuración actual del tablero
     * @return una lista con los movimientos que realiza la pieza dada esa configuración
     */
    public Lista<Movimiento> movimientoPieza(Pieza pieza, Casilla origen, Pieza[][] config)
    {
        Lista<Movimiento> lista = new Lista<Movimiento>();
        Lista<Casilla> listaCas = null;

        String nombrePieza = pieza.getNombre();
        Color colorPieza = pieza.getColor();
        String nombreColor = colorPieza.getColor();
        Renglon ren = origen.getRenglon();
        Columna col = origen.getColumna();
        int numRen = Transformacion.posicionRenglon(ren);
        int numCol = Transformacion.posicionColumna(col);

        switch(nombrePieza)
        {
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
        for(int i = 0; i < listaCas.longitud(); i++)
        {
            Casilla cas = listaCas.obtenElem(i);
            Movimiento mov = new Movimiento(origen, cas);
            lista.agrega(mov);
        }
        return lista;
    }

    /**
     * Verifica si existe un hacke a un rey de un color en específico
     * @param pos la configuración actual del tablero
     * @param col el color del rey a verificar
     * @return true si existe un hacke, false en otro caso
     */
    public Predicado hacke(Posicion pos, Color col)
    {
        Predicado pred = new Predicado(true);
        Pieza rey = new Pieza(col, "King");
        Lista<Casilla> casillasRey = this.buscaPiezas(pos, rey);
        Lista<Casilla> contrario = this.buscaPiezasColor(pos, this.otro(col));
        Pieza actual = null;
        Casilla casRey = casillasRey.obtenElem(0);
        Casilla cas = null;
        Casilla des = null;
        Movimiento mov = null;
        Lista<Movimiento> movimientos = null;
        Tablero tab = pos.getPosicion();
        Pieza[][] config = tab.getTablero();

        for(int i = 0; i < contrario.longitud(); i++)
        {
            cas = contrario.obtenElem(i);
            actual = this.pieza(cas, pos);
            movimientos = this.movimientoPieza(actual, cas, config);
            for(int j = 0; j < movimientos.longitud(); j++)
            {
                mov = movimientos.obtenElem(j);
                des = this.destino(mov);
                if(des.equals(casRey))
                    return pred;
            }
        }
        pred.setValor(false);
        return pred;
    }

    /**
    * Verifica si existe un hackemate a un rey de un color en específico
    * @param pos la configuración actual del tablero
    * @param col el color del rey a verificar
    * @return true si existe un hackemate, false en otro caso
    */
    public Predicado hackeMate(Posicion pos, Color col)
    {
        Posicion actual = pos;
        Tablero tab = pos.getPosicion();
        Pieza[][] config = tab.getTablero();
        Predicado hackeMate = new Predicado(true);
        Predicado hacke = null;
        Pieza rey = new Pieza(col, "King");
        Lista<Casilla> casillasRey = this.buscaPiezas(pos, rey);
        Casilla casRey = casillasRey.obtenElem(0);
        Lista<Movimiento> movsRey = this.movimientoPieza(rey, casRey, config);

        for(int i = 0; i < movsRey.longitud(); i++)
        {
            Movimiento movRey = movsRey.obtenElem(i);
            this.realizaMovimiento(movRey, actual);
            hacke = this.hacke(actual, col);
            if(!hacke.getValor())
            {
                hackeMate.setValor(false);
            }
            actual = pos;
        }
        return hackeMate;
    }

    /**
     * Dada una posición del tablero, se realiza un movimiento
     * @param mov el movimiento a realizar
     * @param pos la configuración actual del tablero
     */
    public void realizaMovimiento(Movimiento mov, Posicion pos)
    {
        Predicado posible = this.posible(pos, mov);

        if(posible.getValor())
        {
            Tablero tab = pos.getPosicion();
            Pieza[][] config = tab.getTablero();

            Casilla ori = this.origen(mov);
            Pieza piezaOri = this.pieza(ori, pos);
            Lista<Movimiento> movimientos = this.movimientoPieza(piezaOri, ori, config);
            boolean contiene = false;

            for(int i = 0; i < movimientos.longitud(); i++)
            {
                Movimiento m = movimientos.obtenElem(i);
                if(mov.equals(m))
                {
                    contiene = true;
                    break;
                }
            }
            if(contiene)
            {
                Renglon renOri = ori.getRenglon();
                int intRenOri = Transformacion.posicionRenglon(renOri);
                Columna colOri = ori.getColumna();
                int intColOri = Transformacion.posicionColumna(colOri);

                Casilla des = this.destino(mov);
                Pieza vacia = new Pieza();
                Renglon renDes = des.getRenglon();
                int intRenDes = Transformacion.posicionRenglon(renDes);
                Columna colDes = des.getColumna();
                int intColDes = Transformacion.posicionColumna(colDes);

                config[intRenOri][intColOri] = vacia;
                config[intRenDes][intColDes] = piezaOri;

                tab.setTablero(config);
                pos.setPosicion(tab);
            }
        }
    }

    /**
     * Obtiene las casillas donde una pieza puede hacer hacke
     * @param pos la configuración actual del tablero
     * @param col el color del rey a hacer hacke
     * @param pieza la pieza a la que se le va a verificar las casillas
     */
    public Lista<Casilla> casillasHacke(Posicion pos, Color col, Pieza pieza)
    {
        Lista<Casilla> casillasHacke = new Lista<Casilla>();
        Lista<Casilla> casillas = this.buscaPiezas(pos, pieza);
        Lista<Movimiento> movimientos = null;
        Casilla ori = null;
        Casilla des = null;
        Pieza piezaOri = null;
        Movimiento mov = null;
        Predicado hacke = null;
        Posicion actual = pos;
        Tablero tab = pos.getPosicion();
        Pieza[][] config = tab.getTablero();

        for(int i = 0; i < casillas.longitud(); i++)
        {
            ori = casillas.obtenElem(i);
            piezaOri = this.pieza(ori, pos);
            movimientos = this.movimientoPieza(piezaOri, ori, config);
            for(int j = 0; j < movimientos.longitud(); j++)
            {
                mov = movimientos.obtenElem(j);
                this.realizaMovimiento(mov, actual);
                hacke = this.hacke(actual, col);
                if(hacke.getValor())
                {
                    des = this.destino(mov);
                    casillasHacke.agrega(des);
                }
                actual = pos;
            }
        }
        return casillasHacke;
    }

    /**
     * Busca piezas en específico en el tablero actual
     * @param pos la configuración actual del tablero
     * @param busca la pieza a buscar con sus respectivas propiedades
     * @return una lista que contiene las casillas de las piezas que coincidan
     *         con las especificaciones dadas
     */
    public Lista<Casilla> buscaPiezas(Posicion pos, Pieza busca)
    {
        String nom = busca.getNombre();
        Color col = busca.getColor();
        Tablero tab = pos.getPosicion();
        Pieza[][] config = tab.getTablero();
        Casilla cas = null;
        Lista<Casilla> casillas = new Lista<Casilla>();

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                Pieza pieza = config[i][j];
                boolean libre = pieza.getLibre();
                if(!libre)
                {
                    String nombre = pieza.getNombre();
                    Color color = pieza.getColor();
                    if(nombre.equals(nom) &&
                        color.equals(col))
                    {
                    cas = Transformacion.toCasilla(i,j);
                    casillas.agrega(cas);
                    }
                }
            }
        }
        return casillas;
    }

    /**
     * Busca todas las piezas de un color en específico en el tablero actual
     * @param pos la configuración actual del tablero
     * @param col el color de las piezas buscar
     * @return una lista que contiene las casillas en las que se encuentran las piezas
     */
     public Lista<Casilla> buscaPiezasColor(Posicion pos, Color col)
     {
        Tablero tab = pos.getPosicion();
        Pieza[][] config = tab.getTablero();
        Casilla cas = null;
        Lista<Casilla> casillas = new Lista<Casilla>();

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                Pieza pieza = config[i][j];
                boolean libre = pieza.getLibre();
                if(!libre)
                {
                    Color color = pieza.getColor();
                    if(color.equals(col))
                    {
                        cas = Transformacion.toCasilla(i,j);
                        casillas.agrega(cas);
                    }
                }
            }
        }
        return casillas;
    }

}
