package Financeiro;

public class Pessoas{
    int idPessoa;
    String nome;
    String email;

    public Pessoas() {
    }

    public Pessoas(int idPessoa, String nome, String email) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
    }

    public int getIdPessoa() {
        return this.idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoas idPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
        return this;
    }

    public Pessoas nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Pessoas email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoas)) {
            return false;
        }
        Pessoas pessoas = (Pessoas) o;
        return idPessoa == pessoas.idPessoa && Objects.equals(nome, pessoas.nome) && Objects.equals(email, pessoas.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, email);
    }

    @Override
    public String toString() {
        return "{" +
            " idPessoa='" + getIdPessoa() + "'" +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
      
}