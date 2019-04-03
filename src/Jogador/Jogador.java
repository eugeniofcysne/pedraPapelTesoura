package Jogador;

import Jogo.Escolha;

public class Jogador {

	private Escolha escolha;
	private String nome;

	public Jogador(String nome, Escolha escolha) {
		this.escolha = escolha;
		this.nome = nome;
	}
	
	protected Jogador() {
		
	}

	public Escolha getEscolha() {
		return escolha;
	}

	public String getNome() {
		return nome;
	}

	protected void setEscolha(Escolha escolha) {
		this.escolha = escolha;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Jogador [escolha=" + escolha + ", nome=" + nome + "]";
	}

}
