package src.estructuras;

import src.tipos.*;

public interface EstructuraBasico
{

    /**
     * Dada una posicion del tablero y un movimiento que se quiere realizar
     * Se verifica si es posible realizar el movimiento
     * @param pos la posicion actual del tablero
     * @param mov el movimiento a realizar
     * @return un predicado indicando si es posible el movimiento
     */
    public Predicado posible(Posicion pos, Movimiento mov);

    /**
     * Obtiene las casillas por las que pasa una pieza al realizar un movimiento
     * Nota: Se omiten las del caballo porque en realidad "salta" las casillas
     * @param mov el movimiento realizado
     * @param pos la posicion actual del tablero
     * @return una lista con las casillas por la que pasa el movimiento
     */
    public Lista<Casilla> camino(Movimiento mov, Posicion pos);

    /**
     * Dada una posición del tablero
     * Se obtienen todos los movimientos posibles a partir de él
     * @param pos la posición actual del tablero
     * @return una lista con todos los movimientos de las piezas del tablero
     */
    public Lista <Movimiento> movimientos(Posicion pos);

    /**
     * Obtiene la casilla donde parte un movimiento
     * @param mov el movimiento realizado
     * @return la casilla de donde parte el movimiento
     */
    public Casilla origen(Movimiento mov);

    /**
    * Obtiene la casilla hacia donde va un movimiento
    * @param mov el movimiento realizado
    * @return la casilla hacia donde va el movimiento
    */
    public Casilla destino(Movimiento mov);

    /**
     * Obtiene el color de la pieza
     * @param pieza la pieza a la que se le obtiene el color
     * @return el color de la pieza
     */
    public Color color(Pieza pieza);

    /**
     * Dado un color, se obtiene el contrario
     * @param color el color a obtener el contrario
     * @return el otro color
     */
    public Color otro(Color color);

    /**
     * Dada una posicion del tablero y una casilla
     * Se obtiene la pieza que se encuentra en dicha casilla del tablero
     * @param cas la casilla donde se quiere obtener la pieza
     * @param pos la posición actual del tablero
     * @return la pieza en la casilla
     */
    public Pieza pieza(Casilla cas,Posicion pos);

    /**
     * Obtiene el color de la pieza
     * Que se encuentra en la casilla destino del movimiento
     * @param mov el movimiento a realizar
     * @param pos la configuración actual del tablero
     * @return el color de la pieza en la casilla destino
     */
    public Color cpd(Movimiento mov, Posicion pos);

    /**
     * Obtiene el color de la pieza
     * Que se encuentra en la casilla origen del movimiento
     * @param mov el movimiento a realizar
     * @param pos la configuración actual del tablero
     * @return el color de la pieza en la casilla origen
     */
    public Color cpo(Movimiento mov, Posicion pos);

    /**
     * Dada una pieza y una casilla
     * Se regresan los movimientos posibles de esa pieza
     * @param pieza la pieza de la que se obtendran los movimientos
     * @param origen la casilla de donde se van a calcular los movimientos
     * @param config la configuración actual del tablero
     * @return una lista con los movimientos que realiza la pieza dada esa configuración
     */
    public Lista<Movimiento> movimientoPieza(Pieza pieza, Casilla origen, Pieza[][] config);

    /**
     * Verifica si existe un hacke a un rey de un color en específico
     * @param pos la configuración actual del tablero
     * @param col el color del rey a verificar
     * @return true si existe un hacke, false en otro caso
     */
    public Predicado hacke(Posicion pos, Color col);

    /**
    * Verifica si existe un hackemate a un rey de un color en específico
    * @param pos la configuración actual del tablero
    * @param col el color del rey a verificar
    * @return true si existe un hackemate, false en otro caso
    */
    public Predicado hackeMate(Posicion pos, Color col);

    /**
     * Dada una posición del tablero, se realiza un movimiento
     * @param mov el movimiento a realizar
     * @param pos la configuración actual del tablero
     */
    public void realizaMovimiento(Movimiento mov, Posicion pos);

    /**
     * Obtiene las casillas donde una pieza puede hacer hacke
     * @param pos la configuración actual del tablero
     * @param col el color del rey a hacer hacke
     * @param pieza la pieza a la que se le va a verificar las casillas
     */
    public Lista<Casilla> casillasHacke(Posicion pos, Color col, Pieza pieza);

    /**
     * Busca piezas en específico en el tablero actual
     * @param pos la configuración actual del tablero
     * @param busca la pieza a buscar con sus respectivas propiedades
     * @return una lista que contiene las casillas de las piezas que coincidan
     *         con las especificaciones dadas
     */
    public Lista<Casilla> buscaPiezas(Posicion pos, Pieza busca);

    /**
     * Busca todas las piezas de un color en específico en el tablero actual
     * @param pos la configuración actual del tablero
     * @param col el color de las piezas buscar
     * @return una lista que contiene las casillas en las que se encuentran las piezas
     */
     public Lista<Casilla> buscaPiezasColor(Posicion pos, Color col);
}
