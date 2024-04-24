package br.jao.FIPEapp.model;

public class Veiculo {
    public String codigo;
    public String nome;

    public Veiculo(String codigo, String nome){
       this.codigo = codigo;
       this.nome = nome;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

