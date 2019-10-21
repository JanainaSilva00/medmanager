
package medmanager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 *  Autor: William Chapuis Marciano '-'
 *  
 */
public class Paciente
{
    
    private Integer id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Integer id) {
        this.id = id;
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

    private String cpf;

    public static final String PROP_CPF = "cpf";

    /**
     * Get the value of cpf
     *
     * @return the value of cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Set the value of cpf
     *
     * @param cpf new value of cpf
     */
    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        propertyChangeSupport.firePropertyChange(PROP_CPF, oldCpf, cpf);
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
}
