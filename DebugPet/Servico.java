public class Servico {
    private Pet pet;
    private String descricao;
    private double valor;
    private String data;
    // Colocar Local Date

    public Servico(){
    }
    // Criar Construtor De Servicos, Passando Serviços Basicos

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
