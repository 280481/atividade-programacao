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
public class IFilter extends IExpression {
    
    private String variavel;
    private String operador;
    private String valor;

    @Override
    public String dump() {
        return "`"+variavel+" "+operador+" '"+valor+"'";
    }

    public IFilter(String variavel, String operador, String valor) {
        this.variavel = variavel;
        this.operador = operador;
        this.valor = valor;
    }
    
    
    
    
    
    
}
