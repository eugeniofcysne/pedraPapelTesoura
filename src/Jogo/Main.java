package Jogo;

import java.util.Scanner;
import Jogador.Jogador;
import Jogador.Trapaca;
import Jogador.Computador;

public class Main {

	
	public static void main(String[] args) {

		boolean decisao = true;

		int numeroRodada=0;
		while (decisao == true) {
			numeroRodada++;
			Jogador bruno = null;
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Qual a jogada de Bruno? 1 para pedra, 2 para papel, 3 para tesoura, 4 para lagarto, 5 para Spock");
			int decisaoPlayer = scanner.nextInt();
			switch (decisaoPlayer) {
			case 1:
				bruno = new Jogador("Bruno", Escolha.PEDRA);
				break;
			case 2:
				bruno = new Jogador("Bruno", Escolha.PAPEL);
				break;
			case 3:
				bruno = new Jogador("Bruno", Escolha.TESOURA);
				break;				
			case 4:
				bruno = new Jogador("Bruno", Escolha.LAGARTO);
				break;
			case 5:
				bruno = new Jogador("Bruno", Escolha.SPOCK);
				break;
			default:
				System.out.println("ERRO");
			}

			Scanner cebola = new Scanner(System.in);
			System.out.println("Quantos computadores você quer?");
			int qtdComputadores = scanner.nextInt();
			System.out.println(qtdComputadores);
			
			String nomeComputador="Computador";
			String qtdComp=Integer.toString(qtdComputadores);
					
			Computador computador[] = new Computador[qtdComputadores];
			
			for(int i=0;i<qtdComputadores;i++) {
				
				nomeComputador=nomeComputador.substring(0,10);
				
				nomeComputador=nomeComputador.concat(Integer.toString(i+1));
				System.out.println(nomeComputador);
				computador[i]= new Computador(nomeComputador);
			
				System.out.println(computador[i]);
			}
			Jogador[] jogadores= new Jogador[qtdComputadores+1];
			for(int i = 0; i<qtdComputadores; i++) {
				jogadores[i]=computador[i];
			}
			jogadores[qtdComputadores]=bruno;
			Regras regras = new Regras();
			int[] contaEscolhas=regras.calculaEscolhas(jogadores);
			Escolha escolhaVencedora = regras.decidirVencedor(contaEscolhas);
			
			if(escolhaVencedora !=null) {
				for (int i=0; i<qtdComputadores;i++) {
					if (jogadores[i].getEscolha()==escolhaVencedora) {
						jogadores[i].setResultado(); //define o resultado como "GANHOU"
						System.out.println(jogadores[i].getNome()+" "+jogadores[i].getResultado());
					}
				}				
			} else {
				System.out.println("DEU EMPATE");
			}
			BancoDeDados.gravarPartida(jogadores, escolhaVencedora, numeroRodada);
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("deseja jogar de novo? 1 para sim, 2 para nao");
			int resposta = scanner2.nextInt();

			if (resposta == 2) {
				decisao = false;
			}
		} // fim do while
				
	} // fim do main

} //fim da classe