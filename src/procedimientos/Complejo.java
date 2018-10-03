package src.procedimientos;

import src.tipos.*;
import src.auxiliares.Transformacion;
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
                            Lista<Movimiento> antiHackes)
    {
        Lista<Movimiento> legales = this.legales(pos, col);
        Lista<Casilla> casillasHacke = null;
        Tablero tab = pos.getPosicion();
        Pieza[][] config = tab.getTablero();
        Casilla casAct = null;
        Casilla auxCas = null;
        Pieza actual = null;
        Movimiento amove = null;
        hackes = capturas = null;

        for(int i = 0; i < legales.longitud(); i++)
        {
            amove = legales.obtenElem(i);
            if(this.cpd(amove, pos).equals(this.otro(col)))
            {
                capturas.agrega(amove);
            }
            casillasHacke = this.casillasHacke(pos, this.otro(col), this.pieza(this.origen(amove), pos));
            for(int j = 0; j < casillasHacke.longitud(); j++)
            {
                casAct = casillasHacke.obtenElem(j);
                if(this.destino(amove).equals(casAct))
                {
                    hackes.agrega(amove);
                }
            }
        }
        hackeDesde = null;
        material = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                actual = config[i][j];
                material = (actual.getColor().equals(col))
                            ? material + actual.valor()
                            : material - actual.valor();
                casAct = Transformacion.toCasilla(i,j);
                casillasHacke = this.casillasHacke(pos, col, actual);
                for(int k = 0; k < casillasHacke.longitud(); k++)
                {
                    auxCas = casillasHacke.obtenElem(k);
                    if(casAct.equals(auxCas))
                    {
                        hackeDesde.agrega(casAct);
                    }
                }
            }
        }
        if(hackeDesde != null)
        {
            hacke.setValor(true);
        } else
        {
            hacke.setValor(false);
        }
        if(hacke.getValor())
        {
            Pieza rey = new Pieza(col, "King");
            Lista<Casilla> casRey = this.buscaPiezas(pos, rey);
            Casilla actRey = casRey.obtenElem(0);
            Lista<Movimiento> movsRey = this.movimientoPieza(rey, actRey, config);
            Casilla reyDes = null;
            Movimiento movRey = null;
            for(int i = 0; i < movsRey.longitud(); i++)
            {
                movRey = movsRey.obtenElem(i);
                reyDes = this.destino(movRey);
                boolean posible = true;
                for(int j = 0; j < hackeDesde.longitud(); j++)
                {
                    casAct = hackeDesde.obtenElem(j);
                    if(reyDes.equals(casAct))
                    {
                        posible = false;
                    }
                }
                if(posible)
                {
                    antiHackes.agrega(movRey);
                }
            }
        }
        if(hacke.getValor() && antiHackes == null)
        {
            mate.setValor(true);
        } else
        {
            mate.setValor(false);
        }
    }

    /**
     * Obtiene una descripción actual de la partida
     * @param pos la configuración actual del tablero
     * @param col el color de las piezas del jugador actual
     * @param analizarMovs los movimientos a analizar
     * @param valor el valor de la descripción
     */
    public void descripcion(Posicion pos, Color col, Lista<Movimiento> analizarMovs,
                            Lista<Object> valor)
    {
        Predicado hacke = new Predicado(true);
        Predicado mate = new Predicado(true);
        int material = 0;
        Lista<Casilla> hackeDesde = new Lista<Casilla>();
        Lista<Movimiento> hackes = new Lista<Movimiento>();
        Lista<Movimiento> capturas = new Lista<Movimiento>();
        Lista<Movimiento> antiHackes = new Lista<Movimiento>();
        this.informacion(pos, col, hacke, mate, material, hackeDesde,
                         hackes, capturas, antiHackes);
        if(hacke.getValor())
        {
            analizarMovs = antiHackes;
        } else
        {
            analizarMovs.concatena(hackes);
            analizarMovs.concatena(capturas);
        }
        valor.agrega(mate);
        valor.agrega(material);
    }

    /**
     * Compara compara dos evaluaciones
     * @param aValor primera evaluación
     * @param bValor segunda evaluación
     * @return true si la primera evaluación es mejor que la segunda,
     *         false en caso contrario
     */
    public Predicado mejor(Lista<Object> aValor, Lista<Object> bValor)
    {
        Predicado mejor = new Predicado(true);
        Predicado mateA = (Predicado)aValor.obtenElem(0);
        if(mateA.getValor())
        {
            mejor.setValor(false);
            return mejor;
        }
        Predicado mateB = (Predicado)bValor.obtenElem(0);
        if(mateB.getValor())
        {
            return mejor;
        }
        int materialA = (int)aValor.obtenElem(1);
        int materialB = (int)bValor.obtenElem(1);
        if(materialA < materialB)
        {
            mejor.setValor(false);
        }
        return mejor;
    }

    /**
     * Evalua una descripción actual de la partida
     * @param pos la configuración actual del tablero
     * @param col el color de las piezas del jugador actual
     * @param variaciones los movimientos que se pueden realizar
     * @param evaluacion la lista que contiene la evaluación
     */
    public void evalua(Posicion pos, Color col, Lista<Movimiento> variacion,
                       Lista<Object> evaluacion)
    {
        Lista<Object> valor = new Lista<Object>();
        Lista<Movimiento> analizarMovs = new Lista<Movimiento>();
        this.descripcion(pos, col, analizarMovs, valor);
        if(analizarMovs == null)
        {
            evaluacion = valor;
            variacion = null;
        } else
        {
            valor = new Lista<Object>();
            Lista<Movimiento> camino = new Lista<Movimiento>();
            Movimiento mov = null;
            Posicion actual = pos;
            Predicado mejor = null;
            for(int i = 0; i < analizarMovs.longitud(); i++)
            {
                  mov = analizarMovs.obtenElem(i);
                  this.realizaMovimiento(mov, actual);
                  this.evalua(actual, this.otro(col), camino, valor);
                  mejor = this.mejor(valor, evaluacion);
                  if(mejor.getValor())
                  {
                      evaluacion = valor;
                      camino.agrega(mov);
                      variacion = camino;
                  }
            }
        }
    }

}
