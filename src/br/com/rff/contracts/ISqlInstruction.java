/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.contracts;

/**
 *
 * @author RENATO
 */
public abstract class ISqlInstruction {
    
    public enum QueryType {
        INSERT, UPDATE, SELECT, DELETE
    }
    protected StringBuilder sql;
    protected ICriteria criterio;
    protected String tabName;
    
    public abstract String getSql();

    public ISqlInstruction(String nomeDaTabela) {
        this.tabName = nomeDaTabela;
        this.sql = new StringBuilder();
        
    }

    public ICriteria getCriterio() {
        return criterio;
    }

    public void setCriterio(ICriteria criterio) {
        this.criterio = criterio;
    }
    
    
    
    
}
