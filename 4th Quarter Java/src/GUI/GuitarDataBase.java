package GUI;

import java.util.ArrayList;
import java.util.List;

public class GuitarDataBase {

    private static final List<Guitar> guitars = new ArrayList<>();

    public static void addGuitar(Guitar guitar) {
        guitars.add(guitar);
    }

    public static void deleteGuitar(int index) {
        if (index >= 0 && index < guitars.size()) {
            guitars.remove(index);
        }
    }

    public static List<Guitar> getAllGuitars() {
        return guitars;
    }
}
