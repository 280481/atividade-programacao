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
public class ISqlInsert extends ISqlInstruction {
    
    private HashMap<String,String> rowData;

    public ISqlInsert(String nomeDaTabela) {
        super(nomeDaTabela);
        this.rowData = new HashMap<>();
    }

    @Override
    public String getSql() {
        this.sql.append("INSERT INTO ");
        this.sql.append(this.tabName);
        this.sql.append(" (`");
        this.sql.append(String.join("`, `", this.rowData.keySet()));
        this.sql.append("`)  VALUES ('");
        this.sql.append(String.join("', '", this.rowData.values()));
        this.sql.append("')");
        return this.sql.toString().replace("'NULL'","NULL");
        
        
    }

    @Override
    public void setCriterio(ICriteria criterio) {
       throw new RuntimeException("Não é necessário critérios para o INSERT!");
    }

    public HashMap<String, String> getRowData() {
        return rowData;
    }

    public void setRowData(HashMap<String, String> rowData) {
        this.rowData = rowData;
    }
    
}
