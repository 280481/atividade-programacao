/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.teste;

import br.com.rff.contracts.ICriteria;
import br.com.rff.contracts.IFilter;
import br.com.rff.contracts.ISqlSelect;

/**
 *
 * @author RENATO
 */
public class TesteAtividade4 {
    
     public static void main(String[] args) {
        ISqlSelect select = new ISqlSelect("produto");
        select.getCols().add("nome");
        select.getCols().add("valor");

        ICriteria criterio = new ICriteria();
        criterio.addExpressions(new IFilter("situacao", "=", "A"));

        criterio.getProperties().put("limit", 3);
        criterio.getProperties().put("order", "valor desc");

        select.setCriterio(criterio);
        
        System.out.println(select.getSql());
    }
    
}
