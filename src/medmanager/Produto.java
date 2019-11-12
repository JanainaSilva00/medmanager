/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medmanager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Date;

/**
 *
 * @author Janaina
 */
public class Produto {
    
    private Integer idProduto;

    public static final String PROP_IDPRODUTO = "idProduto";

    /**
     * Get the value of idProduto
     *
     * @return the value of idProduto
     */
    public Integer getIdProduto() {
        return idProduto;
    }

    /**
     * Set the value of idProduto
     *
     * @param idProduto new value of idProduto
     */
    public void setIdProduto(Integer idProduto) {
        Integer oldIdProduto = this.idProduto;
        this.idProduto = idProduto;
        propertyChangeSupport.firePropertyChange(PROP_IDPRODUTO, oldIdProduto, idProduto);
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

    private String lote;

    public static final String PROP_LOTE = "lote";

    /**
     * Get the value of lote
     *
     * @return the value of lote
     */
    public String getLote() {
        return lote;
    }

    /**
     * Set the value of lote
     *
     * @param lote new value of lote
     */
    public void setLote(String lote) {
        String oldLote = this.lote;
        this.lote = lote;
        propertyChangeSupport.firePropertyChange(PROP_LOTE, oldLote, lote);
    }

    private int qtd;

    public static final String PROP_QTD = "qtd";

    /**
     * Get the value of qtd
     *
     * @return the value of qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * Set the value of qtd
     *
     * @param qtd new value of qtd
     */
    public void setQtd(int qtd) {
        int oldQtd = this.qtd;
        this.qtd = qtd;
        propertyChangeSupport.firePropertyChange(PROP_QTD, oldQtd, qtd);
    }

    private Date validade;

    public static final String PROP_VALIDADE = "validade";

    /**
     * Get the value of validade
     *
     * @return the value of validade
     */
    public Date getValidade() {
        return validade;
    }

    /**
     * Set the value of validade
     *
     * @param validade new value of validade
     */
    public void setValidade(Date validade) {
        Date oldValidade = this.validade;
        this.validade = validade;
        propertyChangeSupport.firePropertyChange(PROP_VALIDADE, oldValidade, validade);
    }

    private Fornecedor fornecedor;

    public static final String PROP_FORNECEDOR = "fornecedor";

    /**
     * Get the value of fornecedor
     *
     * @return the value of fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * Set the value of fornecedor
     *
     * @param fornecedor new value of fornecedor
     */
    public void setFornecedor(Fornecedor fornecedor) {
        Fornecedor oldFornecedor = this.fornecedor;
        this.fornecedor = fornecedor;
        propertyChangeSupport.firePropertyChange(PROP_FORNECEDOR, oldFornecedor, fornecedor);
    }

}
