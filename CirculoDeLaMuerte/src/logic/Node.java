/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Administrador
 * @param <E>
 */
public class Node<E> {
    private E content;
    private Node<E> next;
    private Node<E> prev;
    
    public Node(E data){
        this.content = data;
        this.prev = this.next = null;
    }

    public E getContent() {
        return content;
    }

    public void setData(E data) {
        this.content = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    } 
    
    public Node<E> getPrev(){
        return prev;
    }
    
    public void setPrev(Node<E> prev){
        this.prev = prev;
    }
        
}
