package Jogo;
import java.util.Scanner;
import Jogador.Jogador;
import Jogador.Trapaca;
import Jogador.Computador;

public class Main {

	public static void main(String[] args) {
		
		boolean decisao = true;
	
		int vitoriaBruno=0;
		int vitoriaComputador=0;
		int empate=0;
		while (decisao = true){
			
			Jogador bruno=null;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Qual a jogada de Bruno? 1 para pedra, 2 para papel, 3 para tesoura");
			int decisaoPlayer= scanner.nextInt();	
			switch(decisaoPlayer) {
			case 1:
				bruno = new Jogador("Bruno", Escolha.PEDRA);
			break;
			case 2:
				bruno = new Jogador("Bruno", Escolha.PAPEL);
			break;
			case 3:
				bruno = new Jogador("Bruno", Escolha.TESOURA);
			break;
			default:
				System.out.println("ERRO");	
			}

		Computador computador = new Computador();
		//Trapaca trapaceiro = computador;
		//trapaceiro.trocaEscolha(Escolha.TESOURA);
		Regras regras = new Regras();
		Jogador ganhador = regras.jogar(bruno, computador);
		imprimirGanhador(ganhador);
		if (ganhador==bruno) {
			vitoriaBruno++;
		}else if (ganhador==computador) {
			vitoriaComputador++;
		} else
			empate++;
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("deseja jogar de novo? 1 para sim, 2 para nao");
		int resposta= scanner2.nextInt();
		
		if (resposta==2) {
			decisao=false;
		}
	}
	}
	
	private static void imprimirGanhador(Jogador ganhador) {
		
		if (ganhador==null) {
			System.out.println("empate!");
		} else {
			System.out.println(" o ganhador 'e: " + ganhador.getNome());
		}
		System.out.println(ganhador);
	}
	
//	Jogador vencedor = regras.jogar(alexandre, computador);
//	imprimirGanhador(vencedor);
	
		
	//	Jogador vencedor = regras.jogar(computador, bruno);
	//	System.out.println("O ganhador é : " + vencedor.getNome());
}