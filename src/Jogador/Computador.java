package Jogador;
import java.util.Random;

import Jogador.Jogador;
import Jogo.Escolha;

public class Computador extends Jogador implements Trapaca{

	
	public Computador() {
		super();
		String nome = this.gerarNome();
		Escolha escolhaComputador = this.escolher();
		this.setNome(nome);
		this.setEscolha(escolhaComputador);
		
	}
	protected String gerarNome() {
		return "Computador";
	}

protected Escolha escolher() {
	Random rand = new Random();
	int n = 1+rand.nextInt(3);
	System.out.println("n = "+n);
	 
	switch (n) {
	case 1:
		return Escolha.PEDRA;
	case 2:
		return Escolha.PAPEL;
	case 3:
		return Escolha.TESOURA;
	default:
		return null;
	}
}


@Override
public String getNome() {
	return "Computador: "+super.getNome();
}
@Override
public void trocaEscolha(Escolha escolha) {
	this.setEscolha(escolha);
}

}
