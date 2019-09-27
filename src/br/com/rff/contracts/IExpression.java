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
public abstract class IExpression {
    
    public static final String AND_OPERATOR = " AND ";
    public static final String OR_OPERATOR = "OR ";
    
    
    public abstract String dump();
    
    
    
}
