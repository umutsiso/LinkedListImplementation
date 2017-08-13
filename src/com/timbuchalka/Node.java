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
        if(comparedItem != null) {
            return ((String) super.getLinkValue()).compareTo((String) comparedItem.getLinkValue());
        } else {
            return -1;
        }
    }
}
