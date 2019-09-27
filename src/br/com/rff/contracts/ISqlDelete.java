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
public class ISqlDelete extends ISqlInstruction{
    
   

    public ISqlDelete(String nomeDaTabela) {
        super(nomeDaTabela);
        
        
    }

    @Override
    public String getSql() {
        
       if (criterio == null || !criterio.hasExpressions()){
        throw new RuntimeException("É necessário o uso de pelo menos um critério!");
    }
    
     this.sql.append("DELETE FROM ");
     this.sql.append(this.tabName);
     this.sql.append(" WHERE ");
     this.sql.append(this.criterio.dump());
     return sql.toString();
    }    
    
}
   
    

   
   
  
    
    
    

