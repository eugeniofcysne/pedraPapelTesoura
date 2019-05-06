package Jogador;

import Jogo.Escolha;
import Jogo.Resultado;

public class Jogador {

	private Escolha escolha;
	private String nome;
	private Resultado resultado;

	public Jogador(String nome, Escolha escolha) {
		this.escolha = escolha;
		this.nome = nome;
		this.resultado=Resultado.PERDEU;
	}
	
	protected Jogador() {
		
	}

	public Escolha getEscolha() {
		return escolha;
	}

	public String getNome() {
		return nome;
	}
	public Resultado getResultado() {
		return resultado;
	}
	protected void setEscolha(Escolha escolha) {
		this.escolha = escolha;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setResultado() {
		this.resultado=Resultado.GANHOU;
	}

	@Override
	public String toString() {
		return "Jogador [escolha=" + escolha + ", nome=" + nome + "]";
	}

}
