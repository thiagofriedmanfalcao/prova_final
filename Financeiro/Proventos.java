package Financeiro;

public class Proventos extends Contas{
    private double imposto;

    public Proventos() {
    }

    public Proventos(double imposto) {
        this.imposto = imposto;
    }

    public Proventos(int idConta, int mesConta, int anoConta, double vlrConta, Pessoas objPessoas, double imposto) {
        super(idConta, mesConta, anoConta, vlrConta, objPessoas);
        this.imposto = imposto;
        this.objPessoas = objPessoas;        
    }    

    public Proventos(int mesConta, int anoConta, double vlrConta, Pessoas objPessoas, double imposto) {
        super(mesConta, anoConta, vlrConta, objPessoas);
        this.imposto = imposto;
        this.objPessoas = objPessoas;        
    }        

    public double getImposto() {
        return this.imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public Proventos setIdPessoa(int idPessoa) {
        this.objPessoas.idPessoa = idPessoa;
        return this;
    }    

    public Proventos imposto(double imposto) {
        this.imposto = imposto;
        return this;
    }

    private double calculaImposto(){
        return super.getVlrConta() + this.getImposto();
    }    

    @Override
    public String toString() {
        return  "Nome: " + getObjPessoas().nome + 
                " Email: " + getObjPessoas().email +
                " Ano: " + getAnoConta() +
                " Mês: " + getMesConta() +
                " Valor: " + getVlrConta() +
                " Desconto: " + getImposto()
                ;
    }    
}