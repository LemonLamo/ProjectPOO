package project_poo;

public class Log extends OperationUnaire{
    public Log (double a) {
        super(a);
        if (a <=0) {
            throw new IllegalArgumentException("ur value should be positive for the log");
        }
    }
    @Override
    public double calculer() {
        return Math.log(val);
    }
}