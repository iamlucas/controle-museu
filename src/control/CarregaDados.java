package control;

import java.util.Random;

public class CarregaDados {
	private  String [] NomeObra;
	private double[] ValorObra;
	private int contador;
	
	
	public CarregaDados(int capacidade)
	
		{
	NomeObra = new String[capacidade];
	ValorObra = new double [capacidade];
	this.contador=0;
	}
	
	
	

	public  void adiciona (String nomeObra,double valorObra)
	{
		NomeObra[contador]=nomeObra;
		

		ValorObra[contador]=valorObra;
		
		
		contador++;
		
	}

	
	
public String retornaNomeObra (int posicao)
{
	return NomeObra[posicao];
}
public double retornaValorObra(int posicao)
{
	
	return ValorObra[posicao];
}




	


}
