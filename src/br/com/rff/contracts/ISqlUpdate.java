/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.contracts;

import java.util.HashMap;

/**
 *
 * @author RENATO
 */
public class ISqlUpdate extends ISqlInstruction{
    
    private HashMap rowData;

    public ISqlUpdate(String nomeDaTabela) {
        super(nomeDaTabela);
        this.rowData = new HashMap<String,String>();
        
    }

    @Override
    public String getSql() {
        if(this.criterio == null || !this.criterio.hasExpressions()){
            throw new RuntimeException("Não é permitido Update sem Where");
        }
        if(this.rowData.isEmpty()){
            throw new RuntimeException("Não foi passado dados!");
        }
        this.sql.append("UPDATE ");
        this.sql.append(this.tabName);
        this.sql.append(" SET ");
        for (Object k: rowData.keySet()){
            this.sql.append("`");
            this.sql.append(k.toString());
            this.sql.append("`");
            this.sql.append(" = ");
            this.sql.append("'");
            this.sql.append(rowData.get(k).toString());
            this.sql.append("', ");
            
        }
        this.sql.delete(this.sql.lastIndexOf(","), this.sql.length()-1 );
        this.sql.append("WHERE ");
        this.sql.append(this.criterio.dump());
        return this.sql.toString().replace("'NULL'", "'NULL'");
        
        
    }

    public HashMap getRowData() {
        return rowData;
    }

    public void setRowData(HashMap rowData) {
        this.rowData = rowData;
    }
    
    public ISqlUpdate addRowData(String col, Object val){
        if (val==null){
          this.rowData.put(col, "NULL");
        }else {
            this.rowData.put(col, val.toString());
        }
        return this;
    }
    
}
