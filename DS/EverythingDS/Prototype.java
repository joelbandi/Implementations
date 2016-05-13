
public class Prototype<E>{

  private Node<E> head;
  private Node<E> tail;
  private boolean empty;
  
  Prototype(){
    this.head = null;
    this.tail = null;
    this.empty = true;
  }

  public boolean addLeft(E data){
    Node<E> node = new Node<E>(data);
    if(empty){
      head = node;
      tail = node;
      empty = false;
      return true;
    }
    if(!empty){
      node.next =  head;
      head = node;
      return true;
    }
    return true;
  }


  public boolean addRight(E data){
    Node<E> node  = new Node<E>(data);

    if(empty){
      tail = node;
      head = node;
      empty = false;
      return true;
    }

    if(!empty){
      tail.next = node;
      node.prev = tail;
      tail = node;
      return true;
    }


    return true;
  }

  public E popLeft(){

    if(empty){
      return null;
    }

    if(!empty){
        Node<E> node = head;
        head = head.next;
        //head.prev = null;
        return node.data;
    }
    return null;
  }

  public E popRight(){

    if(empty){
      return null;
    }
    if(!empty){
      Node<E> node  = tail;
      tail = tail.prev;
      return node.data;
    }
    return null;
  }

}

class Node<E>{
  E data;
  Node<E> next;
  Node<E> prev;
  Node(E data){
    this.data = data;
    this.next = null;
    this.prev = null;
  }

}