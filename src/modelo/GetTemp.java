package modelo;

//Ajuda na criacao dos arrays que guardam as temperaturas de entrada e as de saida
public class GetTemp {
	private double temp;
	
	public GetTemp(double temp) {
		this.temp = temp;
	}
	
	public GetTemp() {
		
	}
	
	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}
}

