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
        System.out.println("--------------");
        list.removeItem(new Node("Bolivia"));
        list.traverse(list.getRoot());

        System.out.println("===================================");
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());
        String otherString = " gt vbf sd hbt wre gbvds asw ads ght hnt er q w re bvd hrtyg ";
        String[] otherData = otherString.split(" ");
        for (String s:otherData) {
            tree.addItem(new Node(s));
        }
        tree.traverse(tree.getRoot());
    }
}
