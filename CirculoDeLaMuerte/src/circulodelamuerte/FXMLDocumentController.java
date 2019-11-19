/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circulodelamuerte;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/**
 *
 * @author JordyVillao
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Slider sldr_NumberPeople;
    @FXML private ChoiceBox chbx_InitialPosition;
    @FXML private RadioButton rdbtn_Clockwise;
    @FXML private RadioButton rdbtn_Anticlockwise;
    @FXML private Button btn_Start;
    @FXML private Pane pane_Container;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
   
    public void startSimulation(ActionEvent event){
        int centerX = 120;
        int centerY = 150; //Valores tomados con medicion manual en SceneBuilder
        double r = 60.0;
        double basisAngle = 360.0/5.0;
        for(int i = 0; i < 5; i++ ){
            double posX = r * Math.cos(Math.toRadians(basisAngle*i));
            double posY = r * Math.sin(Math.toRadians(basisAngle*i));
            Circle circle = new Circle(); 
            circle.setCenterX(posX + centerY);
            circle.setCenterY(posY + centerX);
            circle.setRadius(10);
            circle.setFill(Color.RED);
            pane_Container.getChildren().add(circle);
            System.out.println("Circulo creado");
        } 
    }
    
}
