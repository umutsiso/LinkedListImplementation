package com.Siso;

//Author : Jake Umut Siso

public class Main {

    public static void main(String[] args) {

//        MyLinkedList linkedList = new MyLinkedList(null);
//        linkedList.addItem(new Node("7"));
//        linkedList.addItem(new Node("8"));
//        linkedList.addItem(new Node("9"));
//        linkedList.addItem(new Node("1"));
//        linkedList.addItem(new Node("6"));
//        linkedList.addItem(new Node("2"));
//        linkedList.addItem(new Node("-1"));
//        linkedList.addItem(new Node("7"));
//        linkedList.addItem(new Node("3"));
//        linkedList.addItem(new Node("4"));
//        linkedList.addItem(new Node("5"));
//        linkedList.addItem(new Node("0"));
//        linkedList.iterateList(linkedList.getHead());
//
//        linkedList.removeItem(new Node("GG"));
//        linkedList.removeItem(new Node("0"));
//        linkedList.iterateList(linkedList.getHead());
//
//
//        String stringData = "1 2 5 6 8 9 7 4 3 5 6 4 1";
//
//        String[] stringArray = stringData.split(" ");
//        for (String i : stringArray){
//            linkedList.addItem(new Node(i));
//        }
//
//        linkedList.iterateList(linkedList.getHead());
        String stringArray = "1 9 8 2 3 4 6 4 5";
        SearchTree myTree = new SearchTree(null);
        String[] stringArray2 = stringArray.split(" ");
        for (String i : stringArray2){
            myTree.addItem(new Node(i));
        }
        myTree.iterateList(myTree.getHead());

        myTree.removeItem(new Node(3));
        myTree.removeItem(new Node(5));
        myTree.removeItem(new Node(5));
        myTree.iterateList(myTree.getHead());





    }
}
