//Author : Jake Umut Siso

package com.Siso;


public abstract class ListItem {

    protected Object linkValue;

    protected void setValue(Object value){
        this.linkValue = value;
    }

    protected ListItem leftLink;
    protected ListItem rightLink;

    public ListItem getLeftLink() {
        return leftLink;
    }

    public ListItem getRightLink() {
        return rightLink;
    }

    public ListItem(Object linkValue) {
        this.linkValue = linkValue;
    }

    abstract ListItem next();
    abstract ListItem previous();
    abstract void setPrevious(ListItem item);
    abstract void setNext(ListItem item);
    abstract int compareTo(ListItem comparedItem);


    protected Object getLinkValue() {

        return linkValue;
    }






}
