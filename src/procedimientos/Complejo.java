package src.procedimientos;

import src.tipos.*;

public class Complejo
{

    /**
     * Verifica que un movimiento sea factible con una posición dada
     * @param mov el movimiento a realizar
     * @param pos la posicion actual de las piezas en el tablero
     * @return true si es factible, false en otro caso
     */
    public static Predicado factible(Movimiento mov, Posicion pos)
    {
        Predicado factible = new Predicado(false);
        Color cpd = null;
        Color cpo = null;
        Lista<Movimiento> movs = Basico.movimientos(pos);
        for(int i = 0; i < movs.longitud(); i++)
        {
            Movimiento m = movs.obtenElem(i);
            if(mov.equals(m))
            {
                factible.setValor(true);
                Lista<Casilla> casillas = Basico.camino(mov,pos);
                for(int j = 0; j < casillas.longitud(); j++)
                {
                    Casilla cas = casillas.obtenElem(j);
                    Pieza pieza = Basico.pieza(cas,pos);
                    if(pieza.getLibre() == false)
                    {
                        factible.setValor(false);
                    }
                    cpd = Basico.cpd(mov,pos);
                    cpo = Basico.cpo(mov,pos);
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
     * @param mov el movimiento
     */
    public static Predicado pinned(Movimiento mov, Posicion pos)
    {
        Predicado pinned = new Predicado(true);
        return pinned;
    }

}