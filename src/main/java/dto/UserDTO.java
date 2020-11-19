package dto;

import java.util.ArrayList;
import java.util.Arrays;

public class UserDTO {
    public int id = 24;
    public String name = "Jack";
    public String surname = "Bauer";
    public ArrayList<String> languages = new ArrayList<String>(Arrays.asList("English", "German", "Russian", "Spanish", "Serbian", "Arabic"));
}
