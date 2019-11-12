/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medmanager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/**
 *
 * @author Janaina
 */
public class Fornecedor {
    
    private Integer Id;

    public static final String PROP_ID = "Id";

    /**
     * Get the value of Id
     *
     * @return the value of Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * Set the value of Id
     *
     * @param Id new value of Id
     */
    public void setId(Integer Id) {
        Integer oldId = this.Id;
        this.Id = Id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, Id);
    }

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

    
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.Id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.telefone);
        hash = 97 * hash + Objects.hashCode(this.cnpj);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fornecedor other = (Fornecedor) obj;

        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }

        return true;
    }

}
