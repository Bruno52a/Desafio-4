package Utilitario;

import java.util.HashMap;
import java.util.Map;

public class Ranking {
    private Map<String, Integer> pontuacoes = new HashMap<>();

    public void registrarVitoria(String nome) {
        pontuacoes.put(nome, pontuacoes.getOrDefault(nome, 0) + 10);
    }

    public void exibirRanking() {
        System.out.println("\n Ranking:");
        for (Map.Entry<String, Integer> entry : pontuacoes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " pontos");
        }
    }
}
