/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.dao;

import java.util.ArrayList;
import javafx.scene.control.TableColumn;

/**
 *
 * @author RENATO
 */
public interface TableModelInterface {
    
    //retorna uma lista de colunas que voce deseja exibir na table
    
    public ArrayList<TableColumn<Object,Object>> getCols();
    
    //retorna uma lista de objetos conforme o parametro de pesquisa
    public ArrayList<Object> pesquisar(String param);
    
}
