package project_poo;

public abstract class OperationUnaire  implements CalculMath{
      protected double val;

      public OperationUnaire (double a) {
        this.val= a;
      }
      public abstract double calculer(); //same as OperationBinaire

}

