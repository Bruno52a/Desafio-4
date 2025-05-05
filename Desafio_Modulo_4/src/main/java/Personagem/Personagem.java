package Personagem;

public abstract class Personagem {
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private int pocaoCura = 3;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public abstract void atacar(Personagem alvo);

    public void defender() {
        System.out.println(nome + " está se defendendo!");
        defesa += 5;
    }

    public void tomarDano(int dano) {
        int danoFinal = Math.max(0, dano - defesa);
        vida -= danoFinal;
        System.out.println(nome + " sofreu " + danoFinal + " de dano.");
    }

    public void usarPocao() {
        if (pocaoCura > 0) {
            vida += 20;
            pocaoCura--;
            System.out.println(nome + " usou uma poção de cura. Vida atual: " + vida);
        } else {
            System.out.println(nome + " não tem mais poções!");
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void exibirStatus() {
        System.out.println("[" + nome + "] Vida: " + vida + " | Ataque: " + ataque + " | Defesa: " + defesa + " | Poções: " + pocaoCura);
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
    public int getPocaoCura() { return pocaoCura; }
    
    public void setNome(String nome) { this.nome = nome; }
    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefesa(int defesa) { this.defesa = defesa; }
    public void setPocaoCura(int pocaoCura) { this.pocaoCura = pocaoCura; }
}
