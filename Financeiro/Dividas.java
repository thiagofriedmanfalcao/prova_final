package Financeiro;

public class Dividas extends Contas{
    double percentualDesconto;

    public double getPercentualDesconto() {
        return this.percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public Dividas percentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
        return this;
    }

}