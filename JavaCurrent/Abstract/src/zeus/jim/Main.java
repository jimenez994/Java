package zeus.jim;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());
        String myString = "Bolivia Ecuador Chile Brazil Colombia Bolivia Peru Argentina Mexico Spana Russia Honduras";
        String[] data  = myString.split(" ");
        for (String word:data) {
            list.addItem(new Node(word));
        }
        list.traverse(list.getRoot());
//        list.
    }
}
