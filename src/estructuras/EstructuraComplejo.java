package src.estructuras;

import src.tipos.*;

public interface EstructuraComplejo
{

    /**
     * Verifica que un movimiento sea factible con una posición dada
     * @param mov el movimiento a realizar
     * @param pos la posicion actual de las piezas en el tablero
     * @return true si es factible, false en otro caso
     */
    public Predicado factible(Movimiento mov, Posicion pos);

    /**
     * Verifica si una pieza está "pinneada" por otra pieza
     * al tratar de realizar un movimiento
     * @param mov el movimiento a realizar
     * @param pos la configuración actual del tablero
     * @return true si se encuentra "pinneada", false en otro caso
     */
    public Predicado pinned(Movimiento mov, Posicion pos);

    /**
     * Obtiene una lista de los movimientos legales dada una posición
     * @param pos la configuración actual del tablero
     * @param col el color de las piezas a verificar sus movimientos
     * @return una lista que contiene los movimientos legales
     */
    public Lista<Movimiento> legales(Posicion pos, Color col);

}
