package Personagem;

public class Inimigo extends Personagem {
    public Inimigo(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca ferozmente!");
        alvo.tomarDano(getAtaque());
    }
}
