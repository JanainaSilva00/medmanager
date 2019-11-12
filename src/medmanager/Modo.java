/**
 *
 *  William Chapuis '-'
 *  
 */
package medmanager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Modo
{

    private Integer Id;

    public static final String PROP_ID = "Id";

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        Integer oldId = this.Id;
        this.Id = Id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, Id);
    }

    private String descricao;

    public static final String PROP_DESCRICAO = "descricao";

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
