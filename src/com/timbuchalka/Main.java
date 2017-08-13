package com.timbuchalka;

public class Main {

    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList(null);
        linkedList.addItem(new Node("7"));
        linkedList.addItem(new Node("8"));
        linkedList.addItem(new Node("9"));
        linkedList.addItem(new Node("1"));
        linkedList.addItem(new Node("6"));
        linkedList.addItem(new Node("2"));
        linkedList.addItem(new Node("-1"));
        linkedList.addItem(new Node("7"));
        linkedList.addItem(new Node("3"));
        linkedList.addItem(new Node("4"));
        linkedList.addItem(new Node("5"));
        linkedList.addItem(new Node("0"));
        linkedList.iterateList(linkedList.getHead());

        linkedList.removeItem(new Node("GG"));
        linkedList.removeItem(new Node("0"));
        linkedList.removeItem(new Node("-1"));
        linkedList.iterateList(linkedList.getHead());

    }
}
