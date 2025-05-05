package Personagem;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 150, 20, 15);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca com espada!");
        alvo.tomarDano(getAtaque());
    }
}
