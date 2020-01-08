package zeus.jim;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
//        System.out.println(newItem.getValue() + " -");
        if (this.root == null){
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0){
//                newItem is no next, so insert at the end of list
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }else{
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            }else if( comparison > 0){
//                newItem is less, insert before
                if(currentItem.previous() != null){
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                }else{
//                    the node with a previous is the root
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            }else{
                System.out.println(newItem.getValue() + "is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0 ){
                if(currentItem == this.root){
                    this.root = currentItem.next();
                }else{
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if(comparison < 0){
                currentItem = currentItem.next();
            }else{
//                item is not on the list
                return false;
            }
        }
        //reach the end
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null){
            System.out.println("The list is empty");
        }else{
            while(root != null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
