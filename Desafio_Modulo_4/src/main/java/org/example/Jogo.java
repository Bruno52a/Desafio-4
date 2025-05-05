package org.example;

import Personagem.*;
import Utilitario.*;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private static Scanner scanner = new Scanner(System.in);
    private static Personagem jogador;
    private static Random random = new Random();
    private static int moedas = 0;
    private static Ranking ranking = new Ranking();
    private static Loja loja = new Loja();

    public static void main(String[] args) {
        iniciarJogo();
    }

    public static void iniciarJogo() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        exibirOpcoesPersonagens();

        int escolha;
        try {
            escolha = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            escolha = 1;
        }

        switch (escolha) {
            case 1 -> jogador = new Guerreiro(nome);
            case 2 -> jogador = new Mago(nome);
            case 3 -> jogador = new Arqueiro(nome);
            default -> {
                System.out.println("Escolha inválida. Guerreiro selecionado.");
                jogador = new Guerreiro(nome);
            }
        }

        iniciarBatalhas();
    }

    public static void exibirOpcoesPersonagens() {
        System.out.println("Escolha sua classe:");
        System.out.println("1. Guerreiro - Vida alta, ataque médio.");
        System.out.println("2. Mago - Ataque alto, pouca vida.");
        System.out.println("3. Arqueiro - Equilíbrio entre ataque e defesa.");
    }

    public static void iniciarBatalhas() {
        int numeroBatalha = 1;

        while (jogador.estaVivo()) {
            System.out.println("\n--- Batalha " + numeroBatalha + " ---");
            Inimigo inimigo = gerarInimigo();

            while (jogador.estaVivo() && inimigo.estaVivo()) {
                turnoDoJogador(inimigo);
                if (inimigo.estaVivo()) {
                    turnoDoInimigo(inimigo);
                }
            }

            if (!jogador.estaVivo()) {
                System.out.println("Você foi derrotado!");
                break;
            }

            System.out.println("Você venceu a batalha!");
            moedas += 10;
            ranking.registrarVitoria(jogador.getNome());

            loja.abrirLoja(jogador, moedas);

            System.out.println("Deseja continuar lutando? (s/n)");
            String continuar = scanner.nextLine().trim().toLowerCase();
            if (!continuar.equals("s")) {
                System.out.println("Você decidiu encerrar o jogo.");
                break;
            }

            numeroBatalha++;
        }

        ranking.exibirRanking();
    }


    public static void turnoDoJogador(Inimigo inimigo) {
        jogador.exibirStatus();
        inimigo.exibirStatus();

        System.out.println("Ações: 1. Atacar | 2. Defender | 3. Usar Poção");
        int acao;
        try {
            acao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            acao = 0;
        }

        switch (acao) {
            case 1 -> jogador.atacar(inimigo);
            case 2 -> jogador.defender();
            case 3 -> jogador.usarPocao();
            default -> System.out.println("Ação inválida!");
        }
    }

    public static void turnoDoInimigo(Inimigo inimigo) {
        int acao = random.nextInt(100);
        if (acao < 75) {
            inimigo.atacar(jogador);
        } else {
            inimigo.defender();
        }
    }

    public static Inimigo gerarInimigo() {
        String[] nomes = {"Goblin", "Orc", "Zumbi", "Troll", "Esqueleto", "Fantasma", "Lobo Selvagem", "Aranha Gigante", "Slime", "Bruxa", "Ogro", "Vampiro", "Golem de Pedra", "Golem de Ferro", "Golem de Lava", "Minotauro", "Escorpião Gigante", "Necromante", "Cavaleiro Espectral", "Elementar de Fogo", "Elementar de Gelo"};
        String nome = nomes[random.nextInt(nomes.length)];
        int vida = 50 + random.nextInt(30);
        int ataque = 15 + random.nextInt(10);
        int defesa = 5 + random.nextInt(5);
        return new Inimigo(nome, vida, ataque, defesa);
    }
}
