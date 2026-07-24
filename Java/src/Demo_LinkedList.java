import java.util.LinkedList;

public class Demo_LinkedList {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        //addding elements
        names.add("vicky");
        names.add("Raj");
        names.add("Karthik");

        System.out.println(names);

        //Adding at the first index
        names.addFirst("Arjun");
        System.out.println(names);

        //Adding at the last of the list
        names.addLast("Geetha");
        System.out.println(names);

        System.out.println(names.getFirst());

        //Remove elements
        names.remove("Raj");
        System.out.println(names);

        //Updating the element
        names.set(1,"Ashok");
        System.out.println(names);



    }
}
