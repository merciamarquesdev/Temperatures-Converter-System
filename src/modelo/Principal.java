package modelo;

import java.util.Scanner;

public class Principal {
	
	//Inicializando o programa
    private static void initialize() {
        System.out.println("\n ------ Bem vindo ao nosso conversor de temperaturas ------");
        //Menu
        System.out.println(" __________________________________________________________");
		System.out.println("|___________________________Menu___________________________|");
		System.out.println("|                                                          |");
		System.out.println("| Escolha uma das opções de unidade abaixo:                |");
		System.out.println("|----------------------------------------------------------|");
		System.out.println("| CELSIUS                                                  |");
		System.out.println("| FAHRENHEIT                                               |");
		System.out.println("| KELVIN                                                   |");
		System.out.println("|_____________________________*____________________________|");
    }
	
  //Unidades de entrada e de saida
  	private static UnityTemp getUnityTemp(String tipo) {
  		Scanner input = new Scanner(System.in);
  	    System.out.println("Digite a unidade de temperatura de " +tipo+": ");
  	    String unidade = input.nextLine();
  	    return UnityTemp.valueOf(unidade.toUpperCase());
  	    }
    
  	private static double getTemp() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("\n\n----------------------------------------------------------");
        System.out.println("| Digite uma temperatura:                                |");
        System.out.println("----------------------------------------------------------");
		return sc.nextDouble();
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        initialize();
        
        System.out.println("\nDigite a quantidade de temperaturas que deseja converter: ");
		int n = sc.nextInt();
		
		//Definindo tipos de temperatura de entrada e de saida
		UnityTemp unityInput = getUnityTemp("entrada");
        UnityTemp unityOutput = getUnityTemp("saída");
		
        //Criando arrays que vao guardar as temperaturas de entrada e de saida
		GetTemp[] temperaturasEntrada = new GetTemp[n];
		GetTemp[] temperaturasSaida = new GetTemp[n];
		
		int i = 0;
		double resultado;
		double somaEntrada = 0;
		double somaResultado = 0;
		
		while(i < n){

			switch (unityOutput) {
            	case CELSIUS:
            		double temp = getTemp();
            		somaEntrada += temp;
        			System.out.println("Você vai transformar " + temp + "º " + unityInput + " em " + unityOutput); //temp por t
            		resultado = toCelsiusTransform(unityInput, temp);
            		somaResultado += resultado;
            		temperaturasEntrada[i] = new GetTemp(temp);
            		//i++;
            		break;

            	case FAHRENHEIT:
            		temp = getTemp();
            		somaEntrada += temp;
        			System.out.println("Você vai transformar " + temp + "º " + unityInput + " em " + unityOutput); //temp por t
            		resultado = toFahrenheitTransform(unityInput, temp);
            		somaResultado += resultado;
            		temperaturasEntrada[i] = new GetTemp(temp);
            		//i++;
            		break;

            	case KELVIN:
            		temp = getTemp();
            		somaEntrada += temp;
        			System.out.println("Você vai transformar " + temp + "º " + unityInput + " em " + unityOutput); //temp por t
            		resultado = toKelvinTransform(unityInput, temp);
            		somaResultado += resultado;
            		temperaturasEntrada[i] = new GetTemp(temp);
            		//i++;
            		break;

            	default:
            		System.out.println("Erro: opção inválida.");
            		resultado = 0;
            		break;
			}

			System.out.printf("O resultado da conversão é: %.2fº %s", resultado,unityOutput);
			temperaturasSaida[i] = new GetTemp(resultado);
			i++;
		}
		System.out.println("\n\n Finalizando entradas...");
		
		//Saida das medias
		double mediaEntrada = (somaEntrada)/temperaturasEntrada.length;
		double mediaSaida = (somaResultado)/temperaturasSaida.length;
		System.out.println(" __________________________________________________________");
		System.out.println("|___________________Média das Temperaturas_________________|");
		System.out.println("|                                                                        |");  
		System.out.printf("| A média das temperaturas de entrada é: %.2fº %s",mediaEntrada,unityInput);  
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| A média das temperaturas de saída é: %.2fº %s",mediaSaida,unityOutput); 
		System.out.println("\n|_____________________________*____________________________|");
		System.out.println("\n\n Finalizando programa...");	
    }
    
    //Transformacao para CELSIUS
    public static double toCelsiusTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT) {
            return (temp - 32) / 1.8;
        } else if (type == UnityTemp.KELVIN) {
            return temp - 273;
        } else {
            return temp;
        }
    }
    
    //Transformacao para FAHRENHEIT
    public static double toFahrenheitTransform(UnityTemp type, double temp) {
    	if (type == UnityTemp.CELSIUS) {
            return (temp * 1.8) + 32;
        } else if (type == UnityTemp.KELVIN) {
            return ((temp - 273) * 1.8) + 32;
        } else {
            return temp;
        }
    }
    
  //Transformacao para KELVIN
    public static double toKelvinTransform(UnityTemp type, double temp) {
    	if (type == UnityTemp.CELSIUS) {
            return temp + 273;
        } else if (type == UnityTemp.FAHRENHEIT) {
            return ((temp - 32) * (5.0/9)) + 273;
        } else {
            return temp;
        }
    }
}