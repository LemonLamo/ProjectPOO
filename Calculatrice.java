import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez deux nombres : ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        Addition addition = new Addition(a, b);
        System.out.println("Addition : " + addition.calculer());

        Soustraction soustraction = new Soustraction(a, b);
        System.out.println("Soustraction : " + soustraction.calculer());

        Division division = new Division(a, b);
        System.out.println("Division : " + division.calculer());

        Multiplication multiplication = new Multiplication(a, b);
        System.out.println("Multiplication : " + multiplication.calculer());
        
        System.out.println("Entrez un nombre : ");
        double c = scanner.nextDouble();

        Sin sin = new Sin(c);
        System.out.println("Sin : " + sin.calculer());

        Cos cos = new Cos(c);
        System.out.println("Cos : " + cos.calculer());

        Log log = new Log(c);
        System.out.println("Log : " + log.calculer());

        Sqrt sqrt = new Sqrt(c);
        System.out.println("Sqrt : " + sqrt.calculer());

        scanner.close();
    }
}
