package Utilitario;

import Personagem.Personagem;
import java.util.Scanner;

public class Loja {
    private Scanner scanner = new Scanner(System.in);

    public void abrirLoja(Personagem jogador, int moedas) {
        System.out.println("\n Loja - Você tem " + moedas + " moedas.");
        System.out.println("1. Aumentar Ataque (+5) - 10 moedas");
        System.out.println("2. Aumentar Vida (+20) - 10 moedas");
        System.out.println("3. Sair da Loja");

        int escolha = Integer.parseInt(scanner.nextLine());

        if (moedas < 10 && escolha != 3) {
            System.out.println("Moedas insuficientes!");
            return;
        }

        switch (escolha) {
            case 1 -> {
                jogador.setAtaque(jogador.getAtaque() + 5);
                System.out.println("Ataque aumentado para " + jogador.getAtaque());
            }
            case 2 -> {
                jogador.setVida(jogador.getVida() + 20);
                System.out.println("Vida aumentada para " + jogador.getVida());
            }
            case 3 -> System.out.println("Saindo da loja.");
            default -> System.out.println("Opção inválida.");
        }
    }
}
