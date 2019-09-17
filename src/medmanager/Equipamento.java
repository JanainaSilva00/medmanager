/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medmanager;

/**
 *
 * @author Laboratorio
 */
public class Equipamento {
    private String nome, validade, lote, tipo;
    private int quantidade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getValidade() {
        return validade;
    }

    public String getLote() {
        return lote;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
}
