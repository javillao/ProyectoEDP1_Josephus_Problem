/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circulodelamuerte;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import logic.CircularDoublyLinkedList;
import logic.Person;
/**
 *
 * @author Grupo12
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Slider sldr_NumberPeople;
    @FXML private ChoiceBox<Integer> chbx_InitialPosition;
    @FXML private RadioButton rdbtn_Clockwise;
    @FXML private RadioButton rdbtn_Anticlockwise;
    @FXML private Button btn_Start;
    @FXML private Button btn_Restart;
    @FXML private Pane pane_Container;
    
    private final CircularDoublyLinkedList<Person> people = new CircularDoublyLinkedList<>();
    
    public static final double R_MIN = 120.0;
    public static final double R_MAX = 135.0;
    public static final int CENTER_X = 188;
    public static final int CENTER_Y = 210;//Valores tomados con medicion manual en SceneBuilder
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChangeListener<Number> listener = listenerSlider();
        addListenerSlider(listener);
        listener.changed(null, 10, 10);
        chbx_InitialPosition.setValue(1);
        this.btn_Restart.setDisable(true);
    }   
   
    public void startSimulation(ActionEvent event){
        Integer pos0 = chbx_InitialPosition.getValue();
        if(pos0 == null){
            System.out.println("Eso no esta bien viejo");
        }else{
            if(rdbtn_Clockwise.isSelected()){
                disableControls();
                simulationClockwise(pos0).start();
            }else if(rdbtn_Anticlockwise.isSelected()){
                disableControls();
                simulationAnticlockwise(pos0).start();
            }
        }
    }
    
    public void addListenerSlider(ChangeListener<Number> listener){
        sldr_NumberPeople.valueProperty().addListener(listener);
    }
    
    public double getPosX(double angle, double radius){
        return radius * Math.cos(Math.toRadians(angle));
    }
    
    public double getPosY(double angle, double radius){
        return radius * Math.sin(Math.toRadians(angle));
    }
    
    public ChangeListener<Number> listenerSlider(){
        return (ov, oldVal, newVal)->{
            System.out.println(oldVal.intValue());
            
            pane_Container.getChildren().clear();
            chbx_InitialPosition.getItems().clear();
            people.clear();
            double basisAngle = 360.0/oldVal.doubleValue();
            for(int i = 0; i < oldVal.intValue(); i++ ){
                Person circle = new Person(i + 1); 
                circle.setCenterX(getPosX(basisAngle*i, R_MIN) + CENTER_X);
                circle.setCenterY(getPosY(basisAngle*i, R_MIN) + CENTER_Y);
                circle.getLabel().setTranslateX(getPosX(basisAngle*i, R_MAX) + CENTER_X - 7);
                circle.getLabel().setTranslateY(getPosY(basisAngle*i, R_MAX) + CENTER_Y - 8);
                people.addLast(circle);
                pane_Container.getChildren().addAll(circle,circle.getLabel());
                chbx_InitialPosition.getItems().add(i+1);
            }
            chbx_InitialPosition.setValue(1);
        };
    }
    
    public Thread simulationClockwise(int initialPosition){
        return new Thread(()->{
            ListIterator<Person> it = people.listIterator();
            
            for(int i = 1; i <= initialPosition; i++)
                it.next();

            int alive = (int) sldr_NumberPeople.getValue();
            while(alive > 1){
                Platform.runLater(()->{
                    Person pKilled = it.next();
                    while(!pKilled.isAlive())
                        pKilled = it.next();
                    pKilled.setDeath();
                    while(!it.next().isAlive()){}
                    //System.out.println(pKilled.getLabel().getText());
                });
                System.out.println(alive--);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
            this.btn_Restart.setDisable(false);
        });
    }
    
    public Thread simulationAnticlockwise(int initialPosition){
        return new Thread(()->{
            ListIterator<Person> it = people.listIterator();
           
            for(int i = 1; i < initialPosition; i++)
                it.next();
            it.previous();
            int alive = (int) sldr_NumberPeople.getValue();
            while(alive > 1){
                Platform.runLater(()->{
                    Person pKilled = it.previous();
                    while(!pKilled.isAlive())
                        pKilled = it.previous();
                    pKilled.setDeath();
                    while(!it.previous().isAlive()){}
                    //System.out.println(pKilled.getLabel().getText());
                });
                System.out.println(alive--);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
            this.btn_Restart.setDisable(false);
        });
    }
    
    public void restart(ActionEvent evt){
        enableControls();
        chbx_InitialPosition.setValue(1);
        this.btn_Restart.setDisable(true);
        //pintar Person's
        for(int i = 0; i < (int)sldr_NumberPeople.getValue(); i++)
            people.get(i).setLife();
    }
    
    public void disableControls(){
        this.btn_Start.setDisable(true);
        this.sldr_NumberPeople.setDisable(true);
        this.chbx_InitialPosition.setDisable(true);
        this.rdbtn_Anticlockwise.setDisable(true);
        this.rdbtn_Clockwise.setDisable(true);
    }
    public void enableControls(){
        this.btn_Start.setDisable(false);
        this.sldr_NumberPeople.setDisable(false);
        this.chbx_InitialPosition.setDisable(false);
        this.rdbtn_Anticlockwise.setDisable(false);
        this.rdbtn_Clockwise.setDisable(false);
    }
}
