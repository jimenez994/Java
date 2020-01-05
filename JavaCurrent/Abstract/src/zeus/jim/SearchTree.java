package zeus.jim;

public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(this.root == null){
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison < 0){
//                new item is greater move right if possible
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }else{
                    currentItem.setNext(item);
                    return true;
                }
            }else if(comparison > 0){
//                new item is less move left if possible
                if(currentItem.previous() != null){
                    currentItem = currentItem.previous();
                }else{
//                    there no node to the left, so add at this point
                    currentItem.setPrevious(item);
                    return true;
                }
            }else{
                System.out.println(item.getValue() + " is already present");
                return false;
            }
        }
//        we can't actually get here , but java is complaining of not having a return here
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root !=  null){
//            this way the tree will print out in alphabetic order,
//            but if you switch .previous with .next and .next with previous it will backwards alphbetic order
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
