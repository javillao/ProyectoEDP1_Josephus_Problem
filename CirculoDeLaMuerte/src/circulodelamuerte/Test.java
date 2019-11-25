/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circulodelamuerte;
import java.util.ListIterator;
import javafx.concurrent.Task;
import logic.*;
/**
 *
 * @author JordyVillao
 */
public class Test {
    public static void main(String[] args){
        CircularDoublyLinkedList<Integer> ld = new CircularDoublyLinkedList<>();        
        for(int i = 1; i <= 12; i++)
            ld.addLast(i);
        ListIterator<Integer> it = ld.listIterator();
        for(int i = 1; i <= 24; i++){
            System.out.println(it.previous());
        }
            
        
    }
}
