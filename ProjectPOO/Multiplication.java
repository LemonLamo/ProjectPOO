package ProjectPOO;

public class Multiplication extends OperationBinaire {
    public Multiplication(double a , double b) {
        super(a, b) ;    
    }
    @Override
    public double calculer() {
        return val1 * val2;
    }

}
