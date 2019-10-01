/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medmanager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Janaina
 */
public class Fornecedor {
    
    private String nome;

    public static final String PROP_NOME = "nome";

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

        private String telefone;

    public static final String PROP_TELEFONE = "telefone";

    /**
     * Get the value of telefone
     *
     * @return the value of telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Set the value of telefone
     *
     * @param telefone new value of telefone
     */
    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONE, oldTelefone, telefone);
    }

    private String cnpj;

    public static final String PROP_CNPJ = "cnpj";

    /**
     * Get the value of cnpj
     *
     * @return the value of cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Set the value of cnpj
     *
     * @param cnpj new value of cnpj
     */
    public void setCnpj(String cnpj) {
        String oldCnpj = this.cnpj;
        this.cnpj = cnpj;
        propertyChangeSupport.firePropertyChange(PROP_CNPJ, oldCnpj, cnpj);
    }

}
