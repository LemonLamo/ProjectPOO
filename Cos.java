public class Cos extends OperationUnaire{
    public Cos (double a) {
        super(a);
    }
    @Override
    public double calculer() {
        return Math.cos(val);
    }
}
