package zeus.jim;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<String> linkedList = new LinkedList<String>();
        addStr(linkedList, "john");
        addStr(linkedList, "rthn");
        addStr(linkedList, "tthn");
        addStr(linkedList, "qwhn");
        addStr(linkedList, "fghn");

        printLinkedList(linkedList);

    }
    public static void addStr(LinkedList<String> linkedList, String str){
        ListIterator<String> listIterator = linkedList.listIterator();

        while (listIterator.hasNext()){
            int comparison = listIterator.next().compareTo(str);
//            System.out.println(comparison + " - " + str);
            if(comparison == 0){
                System.out.println(str+ " Already exists");
                return;
            }else if(comparison > 0){
                listIterator.previous();
                listIterator.add(str);
                return;
            }else if(comparison < 0){
//                return;
            }
        }
        linkedList.add(str);
    }
    public static void printLinkedList(LinkedList<String> list){
        Iterator<String> i  = list.iterator();
        while (i.hasNext()){
            System.out.println(" - " + i.next());
//            i = i.next();
//            i.next();
        }
    }
}
