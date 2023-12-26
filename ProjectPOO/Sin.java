package ProjectPOO;

public class Sin extends OperationUnaire{
    public Sin (double a) {
        super(a);
    }
    @Override
    public double calculer() {
        return Math.sin(val);
    }
}
