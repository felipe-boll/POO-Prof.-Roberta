package DebugPet;

import java.time.LocalDate;

public class Servico {
    private Pet pet;
    private String descricao;
    private double valor;
    private LocalDate data;


    public Servico(Pet pet, String descricao, double valor, LocalDate data) {
        this.pet = pet;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}
