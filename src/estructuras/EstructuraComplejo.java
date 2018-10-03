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

    /**
     * Obtiene la información actual de la partida
     * @param pos la configuración actual del tablero
     * @param col el color de las piezas del jugador actual
     * @param hacke el predicado que indica si se está en hacke
     * @param material las piezas actuales
     * @param casillasHacke las casillas donde se puede hacer hacke al contrario
     * @param hackes los movimientos para hacer hacke
     * @param capturas los movimientos para hacer capturas
     * @param antiHackes los movimientos para no hacer hacke
     */
    public void informacion(Posicion pos, Color col, Predicado hacke, Predicado mate,
                            int material, Lista<Casilla> hackeDesde,
                            Lista<Movimiento> hackes, Lista<Movimiento> capturas,
                            Lista<Movimiento> antiHackes);

    /**
     * Obtiene una descripción actual de la partida
     * @param pos la configuración actual del tablero
     * @param col el color de las piezas del jugador actual
     * @param analizarMovs los movimientos a analizar
     * @param valor el valor de la descripción
     */
    public void descripcion(Posicion pos, Color col, Lista<Movimiento> analizarMovs,
                            Lista<Object> valor);

    /**
     * Compara compara dos evaluaciones
     * @param aValor primera evaluación
     * @param bValor segunda evaluación
     * @return true si la primera evaluación es mejor que la segunda,
     *         false en caso contrario
     */
    public Predicado mejor(Lista<Object> aValor, Lista<Object> bValor);

    /**
     * Evalua una descripción actual de la partida
     * @param pos la configuración actual del tablero
     * @param col el color de las piezas del jugador actual
     * @param variaciones los movimientos que se pueden realizar
     * @param evaluacion la lista que contiene la evaluación
     */
    public void evalua(Posicion pos, Color col, Lista<Movimiento> variacion,
                       Lista<Object> evaluacion);
}
