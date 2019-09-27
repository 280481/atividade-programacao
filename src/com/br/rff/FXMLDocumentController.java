/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.rff;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author RENATO
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Button btnEstado;
    @FXML
    private Button btnCidade;
    @FXML
    private StackPane container;
    
   
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Button getBtnEstado() {
        return btnEstado;
    }

    public void setBtnEstado(Button btnEstado) {
        this.btnEstado = btnEstado;
    }

    public Button getBtnCidade() {
        return btnCidade;
    }

    public void setBtnCidade(Button btnCidade) {
        this.btnCidade = btnCidade;
    }

    public StackPane getContainer() {
        return container;
    }

    public void setContainer(StackPane container) {
        this.container = container;
    }
    
}
