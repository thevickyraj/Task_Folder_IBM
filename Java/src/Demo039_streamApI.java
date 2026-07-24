
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo039_streamApI {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Vicky");
        list.add("Raj");
        list.add("Ashok");
        List<String> filtered = list.stream()
                .filter(name -> name.startsWith("V"))
                .collect(Collectors.toList());
        System.out.println(filtered);
    }
}
