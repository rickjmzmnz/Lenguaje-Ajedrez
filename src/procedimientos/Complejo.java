package src.procedimientos;

import src.tipos.*;
import src.estructuras.EstructuraComplejo;

public class Complejo extends Basico implements EstructuraComplejo
{

    /**
     * Constructor para poder usar los procedimientos básicos
     */
    public Complejo()
    {
        super();
    }

    /**
     * Verifica que un movimiento sea factible con una posición dada
     * @param mov el movimiento a realizar
     * @param pos la posicion actual de las piezas en el tablero
     * @return true si es factible, false en otro caso
     */
    public Predicado factible(Movimiento mov, Posicion pos)
    {
        Predicado factible = new Predicado(false);
        Color cpd = null;
        Color cpo = null;
        Lista<Movimiento> movs = this.movimientos(pos);
        for(int i = 0; i < movs.longitud(); i++)
        {
            Movimiento m = movs.obtenElem(i);
            if(mov.equals(m))
            {
                factible.setValor(true);
                Lista<Casilla> casillas = this.camino(mov,pos);
                for(int j = 0; j < casillas.longitud(); j++)
                {
                    Casilla cas = casillas.obtenElem(j);
                    Pieza pieza = this.pieza(cas,pos);
                    if(pieza.getLibre() == false)
                    {
                        factible.setValor(false);
                    }
                    cpd = this.cpd(mov,pos);
                    cpo = this.cpo(mov,pos);
                    if(cpo.equals(cpd))
                    {
                        factible.setValor(false);
                    }
                }
            }
        }
        return factible;
    }

    /**
     * Verifica si una pieza está en el estado pinned por otra pieza
     * @param mov el movimiento al realizar para verificar si está pinneada la pieza
     * @param pos la configuración actual del tablero
     * @return true si está en ese estado, false en otro caso
     */
    public Predicado pinned(Movimiento mov, Posicion pos)
    {
        Predicado pinned = new Predicado(false);
        Posicion actual = pos;
        Casilla ori = this.origen(mov);
        Pieza piezaOri = this.pieza(ori, actual);
        this.realizaMovimiento(mov, pos);
        Predicado hacke = this.hacke(actual, piezaOri.getColor());

        if(hacke.getValor())
        {
            pinned.setValor(true);
        }
        return pinned;
    }

    /**
     * Obtiene una lista de los movimientos legales dada una posición
     * @param pos la configuración actual del tablero
     * @param col el color de las piezas a verificar sus movimientos
     * @return una lista que contiene los movimientos legales
     */
    public Lista<Movimiento> legales(Posicion pos, Color col)
    {
        Lista<Movimiento> legales = new Lista<Movimiento>();
        Lista<Movimiento> movimientos = this.movimientos(pos);
        Movimiento mov = null;
        Predicado pinned = null;
        Predicado factible = null;
        Color cpo = null;

        for(int i = 0; i < movimientos.longitud(); i++)
        {
            mov = movimientos.obtenElem(i);
            pinned = this.pinned(mov, pos);
            factible = this.factible(mov, pos);
            cpo = this.cpo(mov, pos);

            if(!pinned.getValor()
            &&  factible.getValor()
            &&  cpo.equals(col))
            {
                legales.agrega(mov);
            }
        }
        return legales;
    }

}
