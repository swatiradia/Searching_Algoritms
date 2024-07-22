package Linked_List;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;


//    Node class to create a Node which has a value and an index. The next obkect
     class Node {
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
         Node temp = head;

         while(temp != null){
             System.out.println(temp.value);
             temp = temp.next;
         }
    }

    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Head: " + tail.value);
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void appendList(int value){

        Node newNode = new Node(value);
        //        When there are zero items in the LinkedList.
         if(length == 0){
             head = newNode;
             tail = newNode;
         }
         else {
             tail.next = newNode;
             tail = newNode;
         }
         length++;
    }


    public Node removeLast(){
        //        When there are zero items in the LinkedList.
         if(length == 0){System.out.println("LinkedList is empty");}

        Node temp = head;
        Node pre = head;
        //        When there is one item in the LinkedList.
        if (length == 1){
            head = null;
            tail = null;
        }else { //        When there are more items in the LinkedList.
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            tail.next = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value){
         Node newNode = new Node(value);
        //        When there are zero items in the LinkedList.
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
         if(length == 0){
             return null;
         }
        Node temp = head;
         head = head.next;
         temp.next = null;
         length--;
         if (length == 0) {
            tail = null;
         }
         return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        for (int i=0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length){return false;}
        if(index ==0){
            prepend(value);
            return true;
        }
        if(index == length){
            appendList(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index -1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length)  return null;
        if(index ==0) return removeFirst();
        if(index == length - 1) return removeLast();
        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
         Node temp = head;
         head = tail;
         tail = temp;

         Node after = temp.next;
         Node before = null;

         for(int i =0; i <length; i++){
             after = temp.next;
             temp.next = before;
             before = temp;
             temp = after;
         }
    }
}
