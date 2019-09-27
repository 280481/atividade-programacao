/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.contracts;

import java.util.logging.Filter;

/**
 *
 * @author RENATO
 */
public class TestaFiltro {
    
    public static void main(String[] args){
        
        IFilter  f1 = new IFilter("age",">=","18");
        
       System.out.println(f1.dump());
       
       ICriteria c = new ICriteria();
       System.out.println(c.dump());
       
       c.addExpressions(f1);
       System.out.println(c.dump());
       
       c.addExpressions(new IFilter("age", "<=", "30"));
       System.out.println(c.dump());
       
       ICriteria cSorv = new ICriteria();
       cSorv.addExpressions(new IFilter("status", "=", "FINALIZADO"));
       cSorv.addExpressions(new IFilter("status", "=", "EM ANDAMENTO"),
               IExpression.OR_OPERATOR);
       System.out.println(cSorv.dump());
       
       ICriteria c2 = new ICriteria();
       c2.addExpressions(cSorv);
       c2.addExpressions(new IFilter("valor", ">", "10"));
       c2.addExpressions(new IFilter("valor", "<", "20"));
       System.out.println(c2.dump());
       
       c2.getProperties().put("order", "nome");
       c2.getProperties().put("limit", "10");
       c2.getProperties().put("offset", "10");
       
     // if ( ISqlInstruction.QueryType.UPDATE ==
       
      ISqlSelect selecao1 = new ISqlSelect("estado");
      selecao1.getCols().add("nome");
      selecao1.getCols().add("uf");
      
      ICriteria crit = new ICriteria();
      crit.addExpressions(new IFilter("nome","like","A%"));
      
      crit.getProperties().put("limit", 2);
      crit.getProperties().put("order", "nome desc");
      
     //selecao1.criterio = crit;
      selecao1.setCriterio(crit);
      
     System.out.println(selecao1.getSql());
     
     ISqlSelect selecao2 = new ISqlSelect("cidade");
     
     ICriteria ccidade = new ICriteria();
     ccidade.addExpressions(new IFilter("nome","like","%O"));
     ccidade.getProperties().put("order","num_hab desc");
     ccidade.getProperties().put("limit",5);
     ccidade.getProperties().put("offset",5);
     
     //selecao2.criterio = ccidade;
     selecao2.setCriterio(ccidade);
     System.out.println(selecao2.getSql());
     
     
     ISqlInsert ins = new ISqlInsert("cidade");
     ins.getRowData().put("nome", "Palotina");
     ins.getRowData().put("uf", "PR");
     ins.getRowData().put("id", "NULL");
     
     
      System.out.println(ins.getSql());
     
     
          
     
     
      
    }
    
    
}
