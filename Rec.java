import java.util.LinkedList;
public class Rec{
	public static void main(String[] args){
		//Factorial fact = new Factorial(7,1);
		Ackerman ak32 = new Ackerman(2,1,1);

	}
	//public String searchPath(int num){}
	}

	class Factorial{
		private LinkedList<Integer> factores;
		private String display; //String del proceso de calulo
		private boolean DISPLAY=true; //Desplegar el proceso de calculo?
		private int result;

		public Factorial(int nesimo,int display){
			factores = new LinkedList<Integer>();
			this.DISPLAY= display==1? true:false;
			result = factorial(nesimo);
			if(!DISPLAY)
				System.out.println(nesimo+"! = "+result);
		}

		/**
		*Calcula el n-esimo numero factorial. n=num.
		*como usa int el maximo factorial soportado es 12S!
		*@param int num n-esimo factorial a calcular
		*@author Diego Porras,16001742
		*/
		public int factorial(int num){
			int result=0;
			if(num == 0) {
				factores.add(0);
				if(DISPLAY){
					display=factores.toString().replace("]","").replace("[","").replace(","," *")+"!";
					System.out.println(display);
					System.out.println(display.replace("0!","1"));
				}
				return 1; //caso base
			}
			factores.add(num);
			if(DISPLAY)
				System.out.println(factores.toString().replace("]","").replace("[","").replace(","," *")+"!");
			result = num * factorial(num-1); //Caso inductivo
			factores.pollLast();
			factores.pollLast();
			factores.add(result);
			if(DISPLAY)
				System.out.println(factores.toString().replace("]","").replace("[","").replace(","," *"));
			return result;
		}
	}

	class Ackerman{
	private LinkedList<Integer> operandos;
	private String display; //String del proceso de calulo
	private boolean DISPLAY=true; //Desplegar el proceso de calculo?
	private int result;

	public Ackerman(int a,int b, int display){
		this.DISPLAY= display==1? true:false;
		operandos = new LinkedList<Integer>();
		operandos.add(a);
		operandos.add(b);
		System.out.println("B:"+operandos + " = ") ;
		result = ack(a,b);
		if(!DISPLAY)
			System.out.println(result);
	}
			/**
		*Calcula el resultado de la funcion de Ackerman A(a,b)
		*@param int a A(a,)
		*@param int a A(,b)
		*@author Diego Porras,16001742
		*/
	public int ack(int a,int b){
		int result=0;
		//Implementando algunas propiedades para ahorrar procesamiento
		//Faster whitout display!
		if(!DISPLAY){
			if(a==1 && b>=0) return b+2;
			if(a==2 && b>=0) return (2*b)+3;
			if(a==3 && b>=0) return ((int) Math.pow(2,b+3))-3;
		}
		if(a==0){ 
			int tmp=b+1;
			displayCase1(tmp);
			return tmp;
		}
		if(b==0){
			displayCase2(a);
			result += ack(a-1,1);
		}
		if(a!=0 && b!=0){
			displayCase3(a,b);
			result += ack(a-1,ack(a,b-1));}
		return result;
	}
	private void displayCase1(int number){
			operandos.pollLast();
			operandos.pollLast();
			operandos.add(number);	
			System.out.println("S:"+operandos);
	}
	private void displayCase2(int number){
			operandos.pollLast();
			operandos.pollLast();
			operandos.add(number-1);
			operandos.add(1);
			System.out.println("C2:"+operandos);
	}
	private void displayCase3(int a, int b){
			operandos.pollLast();
			operandos.pollLast();
			operandos.add(a-1);
			operandos.add(a);
			operandos.add(b-1);
			System.out.println("C:"+operandos);
	}
}