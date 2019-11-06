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
 * @author Israel Elias
 */
public class Tipo {
    
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
    
    private String descricao;

    public static final String PROP_DESCRICAO = "descricao";

    /**
     * Get the value of Descricao
     *
     * @return the value of Descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Set the value of Descricao
     *
     * @param descricao new value of Descricao
     */
    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
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
