package ProjectPOO;

public class Log extends OperationUnaire{
    public Log (double a) {
        super(a);
        if (a <=0) {
            throw new IllegalArgumentException("your value should be positive for the log");
        }
    }
    @Override
    public double calculer() {
        return Math.log(val);
    }
}