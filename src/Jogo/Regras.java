package Jogo;

import Jogador.Jogador;

public class Regras {

	public Escolha decidirVencedor(int[] contaEscolhas) {

		int pedra = contaEscolhas[0];
		int papel = contaEscolhas[1];
		int tesoura = contaEscolhas[2];
		int lagarto = contaEscolhas[3];
		int spock = contaEscolhas[4];

		if ((lagarto + tesoura) > 0 && (papel + spock) == 0) {
			return Escolha.PEDRA;
		} else if ((pedra + spock) > 0 && (tesoura + lagarto) == 0) {
			return Escolha.PAPEL;
		} else if ((papel + lagarto) > 0 && (pedra + spock) == 0) {
			return Escolha.TESOURA;
		} else if ((papel + spock) > 0 && (pedra + tesoura) == 0) {
			return Escolha.LAGARTO;
		} else if ((papel + tesoura) > 0 && (papel + lagarto) == 0) {
			return Escolha.SPOCK;
		} else {
			return null;
		}
	}

	public int[] calculaEscolhas(Jogador[] jogadores) {

		int contaEscolhas[] = { 0, 0, 0, 0, 0 };// new int[5];
		// for (int j =0; j<5;j++) {
		// contaEscolhas[j]=0;
		// }
		for (int i = 0; i < jogadores.length; i++) {
			switch (jogadores[i].getEscolha()) {
			case PEDRA:
				contaEscolhas[0]++;
				System.out.println(contaEscolhas[0]);
				break;
			case PAPEL:
				contaEscolhas[1]++;
				System.out.println(contaEscolhas[1]);
				break;
			case TESOURA:
				contaEscolhas[2]++;
				System.out.println(contaEscolhas[2]);
				break;
			case LAGARTO:
				contaEscolhas[3]++;
				System.out.println(contaEscolhas[3]);
				break;
			case SPOCK:
				contaEscolhas[4]++;
				System.out.println(contaEscolhas[4]);
				break;
			default:
				System.out.println("Escolha -->" + jogadores[i].getEscolha());
			}
		}
		return contaEscolhas;

	}
}