package ProjectPOO;
import java.util.Scanner;
import java.util.Stack;

public class Calculatrice {
	private double last = 0;
	
	public String HandleString(String input) {
		input = input.replaceAll("\\s+", "");
		input = input.toLowerCase();
		return input;
	}
	
	public double Calculate(String input, int index) {
		input = HandleString(input);
		double Num = 0;
		char Op = '+';
		double Multiplier = 10;
		Stack<Double> Order = new Stack<Double>();
		try {
		for(int i = index; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if(c >= '0' && c <= '9') {
				if(Multiplier == 10) {
					Num = Num * Multiplier + c - '0';
				}else{
					Num = Num + (c -'0')*Multiplier;
					Multiplier = Multiplier / 10;
				}
				
			}
			if(!(c >= '0' && c <= '9' ) || i == input.length()-1){
				if(c == '.') {
						Multiplier = 0.1;
				}else{
					if(c =='('){
						Num = Calculate(input,i+1);
						
						int left =1,right=0;
						for(int j =i+1;j<input.length();j++) {							
							if(input.charAt(j) == ')') {
								right++;	
								if(left == right) {
									i = j;
									break;
								}
							}else if(input.charAt(j) == '('){
								left++;
							}
							if(j == input.length()-1) {
								throw new Exception("Format missing \")\"");
							}
						}
					}
					if(c >='a' && c<='z') {
						boolean Skip = false;
						switch(c) {
						case 'a':
							if(!input.startsWith("ans", i)) {
								throw new Exception("Unrecognized operation");
							}
							Num = last;
							i = i+3;
							Skip = true;
							break;	
						case 'e':
							if(!input.startsWith("e(", i)) {
								throw new Exception("Unrecognized operation");
							}
							Exp e = new Exp(Calculate(input,i+2));
							Num = e.calculer();
							i =i+2;
							break;
						case 'c':
							if(!input.startsWith("cos(", i)) {
								throw new Exception("Unrecognized operation");
							}
							Cos cos = new Cos(Calculate(input,i+4));
							Num = cos.calculer();
							i =i+4;
							break;
						case 'l':
							if(!input.startsWith("log(", i)) {
								throw new Exception("Unrecognized operation");
							}
							Log log = new Log(Calculate(input,i+4));
							Num = log.calculer();
							i =i+4;
							break;
						case 's':
							if(input.charAt(i+1)=='i') {
								if(!input.startsWith("sin(", i)) {
									throw new Exception("Unrecognized operation");
								}
								Sin sin = new Sin(Calculate(input,i+4));
								Num = sin.calculer();
								i =i+4;
							}else{
								if(!input.startsWith("sqrt(", i)) {
									throw new Exception("Unrecognized operation");
								}
								Sqrt sqrt = new Sqrt(Calculate(input,i+5));
								Num = sqrt.calculer();
								i =i+5;
							}
							break;
						default:
							throw new Exception("Unrecognized operation");
						}
						if(!Skip) {
						int left =1,right =0;
						for(int j =i+1;j<input.length();j++) {							
							if(input.charAt(j) == ')') {
								right++;	
								if(left == right) {
									i = j;
									break;
								}
							}else if(input.charAt(j) == '('){
								left++;
							}
							if(j == input.length()-1) {
								throw new Exception("Format missing \")\"");
							}
						}
						}
					}
					switch(Op) {
					case '+':
						Order.push(Num);
						break;
					case '-':
						Soustraction sous = new Soustraction(0,Num);
						Order.push(sous.calculer());
						break;
					case '*':
						Multiplication M = new Multiplication(Order.pop(),Num);
						Order.push(M.calculer());
						break;
					case '/':
						Division D = new Division(Order.pop(),Num);
						Order.push(D.calculer());
						break;
					}
					Op = c;
					Num = 0;
					Multiplier = 10;
					if(c == ')') {
						break;
					}
				}
			}
			
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
		double answer = 0;
		while(!Order.empty()) {
			Addition A = new Addition(answer,Order.pop());
			answer = A.calculer();
		}
		last = answer;
		return answer;
	}
	// added user experience in the main 
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculatrice calculator = new Calculatrice();

        System.out.println("Welcome to the Calculator!");
		System.out.println("---------------------------------------------------------------");
        System.out.println("(This calculator was created by Koucem Lamia and Naoui Khaled).");
        System.out.println("For an explanation of how to use the calculator, type 'help'.");
        System.out.println("Enter your expression or type 'exit' to quit:");

        String input;
        while (true) {
            input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            } else if (input.equals("help")) {
                displayHelp();
            } else {
                double result = calculator.Calculate(input, 0);
                System.out.println("Result: " + result);
            }
        }
        scanner.close();
    }

    private static void displayHelp() {
        System.out.println("How to Use the Calculator:");
		System.out.println("------------------------------------------------------------");
        System.out.println("1) Type a mathematical expression using the following format:");
        System.out.println("2) Use '+', '-', '*', '/' for basic operations.");
        System.out.println("3) Use functions like 'cos()', 'sin()', 'e()', 'log()', 'sqrt()' for trigonometric and other functions.");
        System.out.println("4) Use 'ans' to refer to the last calculated result.");
        System.out.println("5) Type 'exit' to quit the calculator.");
		System.out.println("\nExample Expression: \"3 * 4 / 2 - ans\"\n");
		System.out.println("------------------------------------------------------------");
		System.out.println("- Enter your expression :) : ");
    }
}
