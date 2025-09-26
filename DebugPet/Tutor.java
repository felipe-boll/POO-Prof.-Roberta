import java.util.ArrayList;

public class Tutor extends Pessoa {
    private ArrayList<Pet> pets = new ArrayList<>();
    private ArrayList<Servico> servicos = new ArrayList<>();
    
    public Tutor(String nome, String cpf, String email, String telefone, int idade, String endereco, ArrayList<Pet> pets, ArrayList<Servico> servicos) {
        super(nome, cpf, email, telefone, idade, endereco);
        this.pets = pets;
        this.servicos = servicos;
        
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }
    
    public void removePet(Pet pet) {
        this.pets.remove(pet);
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void removeServico(Servico servico) {
        this.servicos.remove(servico);
    }

}
