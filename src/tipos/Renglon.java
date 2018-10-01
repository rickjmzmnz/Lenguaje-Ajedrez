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
	     if(numRen > 0 && numRen < 9)
       {
	        this.numRen = numRen;
	     }
       else
       {
	        System.out.println("ERROR: no se puede definir un Renglon " + numRen);
	        System.out.println("El número del Renglon debe de ser entre 1 y 8");
	     }
    }

    /**
     * Obtiene el número delRenglon
     * @return el número del Renglon
     */
    public int getNumero()
    {
	     return this.numRen;
    }

    /**
     * Asigna un nuevo número de Renglon
     * El número debe estar en el intervalo [1,8]
     * @param numRen el nuevo número
     */
    public void setNumero(int numRen)
    {
	     if(numRen > 0 && numRen < 9)
       {
	        this.numRen = numRen;
	     }
       else
       {
	        System.out.println("ERROR: no se puede definir un Renglon " + numRen);
	        System.out.println("El número del Renglon debe de ser entre 1 y 8");
	     }
    }

    /**
     * Verifica que un renglon sea igual a otro
     * @param ren el renglon a comparar
     * @return true si son iguales, false en otro caso
     */
    public boolean equals(Renglon ren)
    {
        return (this.numRen == ren.getNumero());
    }

}
