package Jogo;

import Jogador.Jogador;

public class Regras {

	public Jogador jogar(Jogador jogador, Jogador adversario) {
		Resultado resultado = null;
		switch (jogador.getEscolha()) {
		case PEDRA:
			resultado = this.pedraContra(adversario.getEscolha());
			break;
		case PAPEL:
			resultado = this.papelContra(adversario.getEscolha());
			break;
		case TESOURA:
			resultado = this.tesouraContra(adversario.getEscolha());
			break;
		default:
			break;
		}
			if (resultado == Resultado.GANHOU) {
				return jogador;

			} else if (resultado == Resultado.PERDEU) {
				return adversario;
				
			} else if (resultado == Resultado.EMPATOU) {
				return null;
			}
		
		return null;
	}

	protected Resultado pedraContra(Escolha escolha) {

		Resultado resultado = null;
		switch (escolha) {
		case PEDRA:
			resultado = Resultado.EMPATOU;
			break;
		case PAPEL:
			resultado = Resultado.PERDEU;
			break;
		case TESOURA:
			resultado = Resultado.GANHOU;
			break;
		default:
			break;
		}
		return resultado;
	}

	protected Resultado papelContra(Escolha escolha) {

		Resultado resultado = null;
		switch (escolha) {
		case PEDRA:
			resultado = Resultado.GANHOU;
			break;
		case PAPEL:
			resultado = Resultado.EMPATOU;
			break;
		case TESOURA:
			resultado = Resultado.PERDEU;
			break;
		default:
			break;
		}
		return resultado;
	}

	protected Resultado tesouraContra(Escolha escolha) {

		Resultado resultado = null;
		switch (escolha) {
		case PEDRA:
			resultado = Resultado.PERDEU;
			break;
		case PAPEL:
			resultado = Resultado.GANHOU;
			break;
		case TESOURA:
			resultado = Resultado.EMPATOU;
			break;
		default:
			break;
		}
		return resultado;
	}

	{
// if((jogador1.getEscolha()-jogador2.getEscolha())==1 || (jogador1.getEscolha()-jogador2.getEscolha()==-2)){
//	return jogador1;
//} else if ((jogador2.getEscolha()-jogador1.getEscolha())==1 || (jogador2.getEscolha()-jogador1.getEscolha()==-2)){
// return jogador2;
//} else
// return null;
	}
}