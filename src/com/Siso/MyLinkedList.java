//Author : Jake Umut Siso

package com.Siso;


public class MyLinkedList implements NodeList{


    private ListItem head = null;

    public MyLinkedList(ListItem listItem) {
        this.head = listItem;
    }


    @Override
    public boolean addItem(ListItem newItem) {
        if (this.head == null){
            //List is empty make the new item head !
            this.head = newItem;
        }
        ListItem currentItem = head;
        while (currentItem != null) {
            if (currentItem.compareTo(newItem) < 0) {
                //Compared item is smaller, try to go right
                if (currentItem.next() != null) {
                    //There is more to go !
                    currentItem = currentItem.next();
                } else {
                    // there is no more to go ! ADDING THE ITEM !
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    newItem.setNext(null);
                    return true;
                }
            } else if (currentItem.compareTo(newItem) > 0) {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    currentItem.setPrevious(newItem);
                    newItem.setNext(currentItem);
                    return true;
                } else {
                    //we are at first element, previous points to head!
                    currentItem.setPrevious(newItem);
                    newItem.setNext(currentItem);
                    head = newItem;
                    return true;
                }

            } else {
                System.out.println("Value already exists cannot add !");
                return false;
            }
        }

            return false;
        }






    @Override
    public boolean removeItem(ListItem item) {
        if (head == null){
            //check to see if the list is empty !
            System.out.println("List is empty !");
            return false;
        }
        ListItem currentItem = this.head;
        while (currentItem != null) {
            //This loop will go on until the last link is reached.
            if (currentItem.compareTo(item) == 0) {
                //if the current item and the parameter is same
                if (currentItem.compareTo(head) == 0) {
                    //if the current item that is same to the parameter is the current head then make the head next item.
                    this.head = currentItem.next();
                    return true;
                } else {
                    //if the current item that is same to the parameter is not the head
                    currentItem.previous().setNext(currentItem.next());
                    currentItem.next().setPrevious(currentItem.previous());
                    return true;
                }
            } else {
                // item still not found move on to the next item !
                currentItem = currentItem.next();
            }

        }
        // at this point we iterated through the whole linked list and did not find the item.
        System.out.println("Item does not exist !");
        return  false;
    }

    @Override
    public void iterateList(ListItem head) {
        ListItem currentItem = head;
        while (currentItem != null){
            System.out.println(currentItem.getLinkValue());
            currentItem = currentItem.next();
        }
    }

    @Override
    public ListItem getHead() {
        return this.head;
    }



}
