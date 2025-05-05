package Personagem;

public class Arqueiro extends Personagem{
    public Arqueiro(String nome) {
        super(nome, 100, 15, 15);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca com Arco!");
        alvo.tomarDano(getAtaque());
    }
}
