/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.dao;

import br.com.rff.contracts.ISqlDelete;
import br.com.rff.contracts.ISqlInsert;
import br.com.rff.contracts.ISqlInstruction;
import br.com.rff.contracts.ISqlSelect;
import br.com.rff.contracts.ISqlUpdate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author RENATO
 */
public abstract class AbstractDao implements DaoInterface{
    
    protected Connection conn;
    
    protected abstract String getTableName();
    //este metodo é um FactoryMethod (padão de projeto)
    public ISqlInstruction newInstruction(ISqlInstruction.QueryType tipo){
       switch (tipo){
           case INSERT: return new ISqlInsert(this.getTableName());
           case UPDATE: return new ISqlUpdate(this.getTableName());
           case DELETE: return new ISqlDelete(this.getTableName());
           default: return new ISqlSelect(this.getTableName()); 
       } 
    }
    
    protected <T> T executeSql(ISqlInstruction sql) throws SQLException {
        PreparedStatement ps = this.conn.prepareStatement(sql.getSql(),Statement.RETURN_GENERATED_KEYS);
        if(sql instanceof ISqlSelect){
            ResultSet rs = ps.executeQuery();
            return (T) this.resultSetToArrayList(rs);
        }
        if (sql instanceof ISqlInsert){
            int affectedRows = ps.executeUpdate();
            if(affectedRows > 0){
                ResultSet rsk = ps.getGeneratedKeys();
                if (rsk.next()){
                    return (T) rsk.getObject(1, Long.class);
                }
            }
        }
       Integer affected = ps.executeUpdate();
       return (T) affected;
    }
    private List resultSetToArrayList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns  = md.getColumnCount();
        ArrayList lista = new ArrayList();
        while(rs.next()) { //este while percorre linha por linha
          HashMap row = new HashMap(columns);  
          for (int i = 1; i<=columns; i++){
              row.put(md.getColumnName(i), rs.getObject(i));
          }
          lista.add(row);
          
        }
        return lista;
    } 
    
}
