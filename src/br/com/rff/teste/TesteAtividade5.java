/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.teste;

import br.com.rff.contracts.ICriteria;
import br.com.rff.contracts.IFilter;
import br.com.rff.contracts.ISqlUpdate;

/**
 *
 * @author RENATO
 */
public class TesteAtividade5 {
    public static void main(String[] args) {
        ISqlUpdate update = new ISqlUpdate("usuario");
        update.addRowData("nome", "Pedro");
        
        
        ICriteria criterio = new ICriteria();
        criterio.addExpressions(new IFilter("nome", "=", "João"));

        update.setCriterio(criterio);
        
        System.out.println(update.getSql());
    }
}
