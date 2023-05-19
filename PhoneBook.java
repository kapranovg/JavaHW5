import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, ArrayList<String>> map = new HashMap<>();

    void add(String lastName, String phoneNumber) {
        if (map.containsKey(lastName)) {
            ArrayList<String> list = map.get(lastName);
            list.add(phoneNumber);
            map.put(lastName, list);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(phoneNumber);
            map.put(lastName, list);
        }
    }

    String getByLastName(String lastName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey().equals(lastName)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append(": ");
                stringBuilder.append(entry.getValue());
                stringBuilder.append("\n");
            }
        }
        if (stringBuilder.length() == 0) {
            System.out.println("No such contact");
        }
        return stringBuilder.toString();
    }

    String getAllBook() {
        System.out.println("All contacts: ");
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append(": ");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("\n");
        }
        
        return stringBuilder.toString();

    }

    String getAllBook2(){
        return map.toString();
    }
    
}