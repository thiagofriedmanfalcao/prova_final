package Financeiro;

public class Dividas extends Contas{
    private double percentualDesconto;

    public Dividas() {
    }       

    public Dividas(int idConta, int mesConta, int anoConta, double vlrConta, Pessoas objPessoas, double percentualDesconto) {
        super(idConta, mesConta, anoConta, vlrConta, objPessoas);
        this.percentualDesconto = percentualDesconto;
        this.objPessoas = objPessoas;
    }   

    public Dividas(int mesConta, int anoConta, double vlrConta, Pessoas objPessoas, double percentualDesconto) {
        super(mesConta, anoConta, vlrConta, objPessoas);
        this.percentualDesconto = percentualDesconto;
        this.objPessoas = objPessoas;        
    }

	private double calculaDesconto(){
        return super.getVlrConta() - this.getPercentualDesconto();
    }    

    public Dividas setIdPessoa(int idPessoa) {
        this.objPessoas.idPessoa = idPessoa;
        return this;
    }    

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


    @Override
    public String toString() {
        return  "Nome: " + getObjPessoas().nome + 
                " Email: " + getObjPessoas().email +
                " Ano: " + getAnoConta() +
                " Mês: " + getMesConta() +
                " Valor: " + getVlrConta() +
                " Desconto: " + getPercentualDesconto()
                ;
    }    

}