/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.rff;

import br.com.rff.controller.TelaPesquisaController;
import br.com.rff.dao.TableModelInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author RENATO
 */
public class CidadeEstado extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
       //Carrega o layout e o controller principal
       FXMLLoader loaderPrincipal = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loaderPrincipal.load();
        FXMLDocumentController pc = loaderPrincipal.getController();
        
        //Carrega o layout e o controller de pesquisa
        FXMLLoader loaderPesquisa = new FXMLLoader(getClass().getResource("/br/com/rff/view/TelaPesquisa.fxml"));
        Parent bp = loaderPesquisa.load();
        TelaPesquisaController tpc = loaderPesquisa.getController();
        
        pc.getBtnCidade().addEventHandler(ActionEvent.ACTION, (event) -> {
            pc.getContainer().getChildren().clear();
            pc.getContainer().getChildren().add(bp);
            TableModelInterface tm = new FalseDaoCidade();
            tpc.configure(tm);
            stage.setTitle("!PESQUISA DE CIDADE!");
            
        });
        pc.getBtnEstado().addEventHandler(ActionEvent.ACTION, (event) -> {
            pc.getContainer().getChildren().clear();
            pc.getContainer().getChildren().add(bp);
            TableModelInterface tm = new FalseDaoEstado();
            tpc.configure(tm);
            stage.setTitle("!PESQUISA DE ESTADO!");
        });
        
       
       
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
      
     // Estado e = new Estado();
      //e.setId(1);
     // e.setNome("PARANÁ");
     // e.setUf("PR");
      
     // Cidade c = new Cidade();
     // c.setId(1);
     // c.setNome("Palotina");
     // c.setEstado(e);
      
     // System.out.println(c.getEstado().getNome());
    //  System.out.println(c.getEstado().getNome().replace("A", "I"));
              
      
      
    }
    
}
