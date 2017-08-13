package com.timbuchalka;

public class SearchTree implements NodeList{

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            //The tree is empty, so new Item because new root
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null){
            if (currentItem.compareTo(newItem) < 0){
                //if new item is bigger, move to the right
                if (currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    //there is no more to go, so add
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (currentItem.compareTo(newItem) > 0) {
                // if item is smaller, move left
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    //there is no more to go
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                // same item, so dont add
                System.out.println(newItem.getLinkValue() + " already exists !");
                return false;
            }
            }
            return false;
        }


    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getLinkValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = (currentItem.compareTo(item));
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                // equal: we've found the item so remove it
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }


    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to left tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            // no left tree, so make parent point to right tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.next());
            } else {
                // again, we are deleting the root
                this.root = item.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier!
            // From the right sub-tree, find the smallest value (i.e., the leftmost).
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // Now put the smallest value into our node to be deleted
            item.setValue(current.getLinkValue());
            // and delete the smallest
            if (leftmostParent == item) {
                // there was no leftmost node, so 'current' points to the smallest
                // node (the one that must now be deleted).
                item.setNext(current.next());
            } else {
                // set the smallest node's parent to point to
                // the smallest node's right child (which may be null).
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void iterateList(ListItem root) {
        if (root != null){
            iterateList(root.previous());
            System.out.println(root.getLinkValue());
            iterateList(root.next());
        }

    }

    @Override
    public ListItem getHead() {
        return this.root;
    }
}
