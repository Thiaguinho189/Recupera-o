/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;


import br.edu.ifro.model.Carro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 94421340278
 */
public class PrincipalController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button btnSoma;
    @FXML
    private TextField txtNumero1;
    @FXML
    private TextField txtNumero2;
    @FXML
    private TextField txtResultado;
    @FXML
    private Button btnSubtracao;
    @FXML
    private Button btnDivisao;
    @FXML
    private Button btnMultiplicação;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtAno;
    @FXML
    private TextField txtCor;
    
    @FXML
    private void soma(ActionEvent event) {
        Double n1,n2,resultado;
        //Apresenta o erro pois o n1 é double o getText() retorna String
        //n1 = txtNumero1.getText();
        
        //Para que serve o comando Double.parseDouble- converte String para Double
        n2 = Double.parseDouble(txtNumero2.getText());
        n1 = Double.parseDouble(txtNumero1.getText());
        
        resultado= n1+n2;
        //como converte um double para String;
        txtResultado.setText(resultado.toString());
    }
    @FXML
    private void subtracao (ActionEvent event) {
       Double n1,n2,resultado;
        n2 = Double.parseDouble(txtNumero2.getText());
        n1 = Double.parseDouble(txtNumero1.getText());
        
        resultado= n1-n2;
        txtResultado.setText(resultado.toString());
    }
    @FXML
    private void Multiplicacao (ActionEvent event) {
        Double n1,n2,resultado;
        n2 = Double.parseDouble(txtNumero2.getText());
        n1 = Double.parseDouble(txtNumero1.getText());
        
        resultado= n1*n2;
        txtResultado.setText(resultado.toString()); 
    }
    @FXML
    private void Divisao (ActionEvent event) {
        Double n1,n2,resultado;
        n2 = Double.parseDouble(txtNumero2.getText());
        n1 = Double.parseDouble(txtNumero1.getText());
        
        resultado= n1/n2;
        txtResultado.setText(resultado.toString());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    private void gravar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        Carro carro = new Carro();
        
        carro.setAno(Integer.parseInt(txtAno.getText()));
        carro.setCor(txtCor.getText());
        carro.setModelo(txtModelo.getText());
        
        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();
    }
    
}
