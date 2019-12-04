package Financeiro;

import java.util.Objects;

public class Contas {
    protected int idConta;
    protected int mesConta;
    protected int anoConta;
    protected double vlrConta;
    protected Pessoas objPessoas;

    public Contas() {
    }

    public Contas(int idConta, int mesConta, int anoConta, double vlrConta, Pessoas objPessoas) {
        this.idConta    = idConta;
        this.mesConta   = mesConta;
        this.anoConta   = anoConta;
        this.vlrConta   = vlrConta;
        this.objPessoas = objPessoas;
    }

    public Contas(int mesConta, int anoConta, double vlrConta, Pessoas objPessoas) {
        this.mesConta   = mesConta;
        this.anoConta   = anoConta;
        this.vlrConta   = vlrConta;
        this.objPessoas = objPessoas;
    }    

    public int getIdConta() {
        return this.idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getMesConta() {
        return this.mesConta;
    }

    public void setMesConta(int mesConta) {
        this.mesConta = mesConta;
    }

    public int getAnoConta() {
        return this.anoConta;
    }

    public void setAnoConta(int anoConta) {
        this.anoConta = anoConta;
    }

    public double getVlrConta() {
        return this.vlrConta;
    }

    public void setVlrConta(double vlrConta) {
        this.vlrConta = vlrConta;
    }

    public Pessoas getObjPessoas() {
        return this.objPessoas;
    }

    public void setObjPessoas(Pessoas objPessoas) {
        this.objPessoas = objPessoas;
    }

    public Contas idConta(int idConta) {
        this.idConta = idConta;
        return this;
    }

    public Contas mesConta(int mesConta) {
        this.mesConta = mesConta;
        return this;
    }

    public Contas anoConta(int anoConta) {
        this.anoConta = anoConta;
        return this;
    }

    public Contas vlrConta(double vlrConta) {
        this.vlrConta = vlrConta;
        return this;
    }

    public Contas objPessoas(Pessoas objPessoas) {
        this.objPessoas = objPessoas;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Contas)) {
            return false;
        }
        Contas contas = (Contas) o;
        return idConta == contas.idConta && mesConta == contas.mesConta && anoConta == contas.anoConta && vlrConta == contas.vlrConta && Objects.equals(objPessoas, contas.objPessoas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConta, mesConta, anoConta, vlrConta, objPessoas);
    }

    @Override
    public String toString() {
        return "{" +
            " idConta='" + getIdConta() + "'" +
            ", mesConta='" + getMesConta() + "'" +
            ", anoConta='" + getAnoConta() + "'" +
            ", vlrConta='" + getVlrConta() + "'" +
            ", objPessoas='" + getObjPessoas() + "'" +
            "}";
    }

}