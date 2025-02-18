/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doubly.linked.list;

/**
 *
 * @author sheha
 */
class DNode {
    int data;
    DNode prev, next;

    public DNode(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
public class DoublyLinkedList {
    private DNode head, tail;

    public DoublyLinkedList() {
        this.head = this.tail = null;
    }

    // Insert at the end
    public void insert(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Delete a node by value
    public void delete(int key) {
        if (head == null) return;
        DNode temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) return; // Key not found

        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    // Search for a value
    public boolean search(int key) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // Display forward
    public void displayForward() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " - ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display backward
    public void displayBackward() {
        DNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " - ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
        public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(100);
        list.insert(200);
        list.insert(300);
        list.displayForward();

        System.out.println("Search 200: " + list.search(200));
        list.delete(200);
        list.displayForward();
        list.displayBackward();
    }
}
