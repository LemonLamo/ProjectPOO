public class Division extends OperationBinaire {
     public Division (double a, double b) {
        super(a,b);
           if (b == 0) {
             throw new IllegalArgumentException("baa3da don't divide by zero");
           }
     }
     @Override
     public double calculer () {
        return val1/val2;
     }

}
