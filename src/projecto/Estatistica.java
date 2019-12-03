package projecto;

public class Estatistica{
    private int views, rating;
    private double dinheiro, bilhete, duracao;

    public Estatistica(int views, int rating, float dinheiro, float bilhete, float duracao) {
        this.views = views;
        this.rating = rating;
        this.dinheiro = dinheiro;
        this.bilhete = bilhete;
        this.duracao = duracao;
    }
    
    public Estatistica() {
        this.views = 0;
        this.rating = 0;
        this.dinheiro = 0.0;
        this.bilhete = 0.0;
        this.duracao =  0.0;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public double getBilhete() {
        return bilhete;
    }

    public void setBilhete(double bilhete) {
        this.bilhete = bilhete;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Estatistica{" + "views=" + views + ", rating=" + rating + ", dinheiro=" + dinheiro + ", bilhete=" + bilhete + ", duracao=" + duracao + '}';
    }
    
    
    
    
}
