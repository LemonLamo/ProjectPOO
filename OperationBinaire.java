public abstract class  OperationBinaire implements CalculMath{
    protected double val1;
    protected double val2;

    public OperationBinaire (double a, double b) {
        this.val1 = a;
        this.val2 = b;
    }

    public abstract double calculer(); // can't be instanciated in an abstract class 
    //needs classes like multiplication , div  
}
