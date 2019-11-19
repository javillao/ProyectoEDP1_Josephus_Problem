/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author JordyVillao
 * @param <E>
 */
public class CircularDoublyLinkedList<E> implements List<E>{
    private Node<E> last;
    private int effectiveSize;

    public CircularDoublyLinkedList() {
        effectiveSize = 0;
        last = null;
    }
    
    @Override
    public Iterator<E> iterator() {
        
        return new Iterator<E>(){
            Node<E> node = last.getNext();
            
            @Override
            public boolean hasNext() {
                return node.getNext() != null;
            }

            @Override
            public E next() {
                Node<E> actualNode = node;
                node = node.getNext();
                return actualNode.getContent();
            }  
        };
    }
    
    public ListIterator<E> listIterator(){
        return new ListIterator<E>(){
            private Node<E> next = last.getNext();
            
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public E next() {
                Node<E> actualNext = next;
                next = next.getNext();
                return actualNext.getContent();
            }

            @Override
            public boolean hasPrevious() {
                return true;
            }

            @Override
            public E previous() {
               next = next.getPrev();
               return next.getContent();
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
        
        
        };
    }

    
    @Override
    public boolean addFirst(E element) {
        Node<E> nodo = new Node<>(element);
        if(element == null)
            return false;
        else if(isEmpty()){
            nodo.setPrev(nodo);
            nodo.setNext(nodo);
            last = nodo;
        }else{
            nodo.setPrev(last);
            nodo.setNext(last.getNext());
            last.getNext().setPrev(nodo);
            last.setNext(nodo);
        }
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node<E> nodo = new Node<>(element);
        if(element == null)
            return false;
        else if(isEmpty()){
            nodo.setPrev(nodo);
            nodo.setNext(nodo);
            last = nodo;
        }else{
            nodo.setPrev(last);
            nodo.setNext(last.getNext());
            last.getNext().setPrev(nodo);
            last.setNext(nodo);
            last = nodo;
        }
        effectiveSize ++;
        return true;
    }

    @Override
    public E getFirst() {
        return this.last.getNext().getContent();
    }

    @Override
    public E getLast() {
        return this.last.getContent();
    }
    
    @Override
    public int indexOf(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return this.effectiveSize == 0;
    }

    @Override
    public int size() {
        return this.effectiveSize;
    }

    @Override
    public boolean removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
