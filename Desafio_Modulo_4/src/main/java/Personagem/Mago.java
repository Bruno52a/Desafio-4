package Personagem;

public class Mago extends Personagem{
    public Mago(String nome) {
        super(nome, 75, 30, 5);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca com magia!");
        alvo.tomarDano(getAtaque());
    }
}
