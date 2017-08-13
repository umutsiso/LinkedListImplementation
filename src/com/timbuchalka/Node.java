package com.timbuchalka;

public class Node extends ListItem {
    public Node(Object linkValue) {
        super(linkValue);
    }

    @Override
    ListItem next() {
        return this.getRightLink();
    }

    @Override
    ListItem previous() {
        return this.getLeftLink();
    }

    @Override
    void setPrevious(ListItem item) {
        this.leftLink = item;
    }

    @Override
    void setNext(ListItem item) {
        this.rightLink = item;
    }

    @Override
    int compareTo(ListItem comparedItem) {

        //> 0 ====> COMPARED ITEM SMALLER
        //< 0 ====> COMPARED ITEM BIGGER
        // == 0 if they are the same !
        return ((String) this.getLinkValue()).compareTo((String) comparedItem.getLinkValue());

    }
}
