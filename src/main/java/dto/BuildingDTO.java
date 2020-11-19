package dto;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildingDTO {
    public int id = 934;
    public String name = "Hogwarts";
    public String country = "England";
    public ArrayList<String> facultees = new ArrayList<String>(Arrays.asList("Gryffindor", "Slytherin", "Hufflepuff", "Ravenclaw"));
    public boolean isGood = true;
    public int numStudents = 600;
}
