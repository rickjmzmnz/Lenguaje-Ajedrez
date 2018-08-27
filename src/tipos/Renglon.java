package src.tipos;

public class Renglon
{

    //número del Renglon
    private int numRen;

    /**
     * Constructor de la clase Renglon
     * @param numRen el numero del renglon
     */
    public Renglon(int numRen)
    {
	     if(numRen > 0 && numRen < 9) {
	        this.numRen = numRen;
	     } else {
	        System.out.println("ERROR: no se puede definir un Renglon " + numRen);
	        System.out.println("El número del Renglon debe de ser entre 1 y 8");
	     }
    }

    /**
     * Obtiene el número delRenglon
     * @return el número del Renglon
     */
    public int getNumRenglon()
    {
	     return this.numRen;
    }

    /**
     * Asigna un nuevo número de Renglon
     * El número debe estar en el intervalo [1,8]
     * @param numRen el nuevo número
     */
    public void setNumRenglon(int numRen)
    {
	     if(numRen > 0 && numRen < 9) {
	        this.numRen = numRen;
	     } else {
	        System.out.println("ERROR: no se puede definir un Renglon " + numRen);
	        System.out.println("El número del Renglon debe de ser entre 1 y 8");
	     }
    }

}
