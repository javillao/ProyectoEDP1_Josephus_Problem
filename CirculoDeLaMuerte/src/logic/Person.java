/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Grupo12
 */
public class Person extends Circle{
    private boolean isAlive;
    private final Label label;
    
    public Person(int label){
        this.label = new Label(Integer.toString(label));
        this.isAlive = true;
        this.setFill(Color.RED);
        this.setRadius(5);
    }
            
    public void setDeath(){
        isAlive = false;
        this.setFill(Color.BLACK);
    }
    
    public boolean isAlive(){
        return this.isAlive;
    }
    
    public Label getLabel(){
        return this.label;
    }
    
    public void setLife(){
        isAlive = true;
        this.setFill(Color.RED);
    }
}
