package ProjectPOO;

public class Addition extends OperationBinaire {
    public Addition(double a , double b) {
        super(a, b) ;    
    }
    
    @Override
    public double calculer() {
        return val1 + val2;
    }

}
