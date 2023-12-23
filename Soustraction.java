public class Soustraction extends OperationBinaire {
    public Soustraction(double a , double b) {
        super(a, b) ;    
    }
    @Override
    public double calculer() {
        return val1 - val2;
    }

}