package project_poo;

public class Exp extends OperationUnaire {
    public Exp(double a) {
        super(a);
    }

    public double calculer() {
        return Math.exp(val);
    }
}
