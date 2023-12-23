public class Sqrt extends OperationUnaire {
    public Sqrt(double a) {
        super(a);
        if (a<0) {
            throw new IllegalArgumentException("don't put a negative value in a square root x)");
        }
    }

    public double calculer() {
        return Math.sqrt(val);
    }
}