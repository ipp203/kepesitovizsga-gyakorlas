package hu.nive.ujratervezes.kepesitovizsga5.snowwhite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SnowWhite {

    private List<Dwarf> dwarfs;


    public SnowWhite(List<Dwarf> dwarfs) {
        this.dwarfs = new ArrayList<>(dwarfs);
    }

    public List<Dwarf> getSevenDwarfs() {
        return new ArrayList<>(dwarfs);
    }

    public List<Dwarf> getSevenDwarfsOrderedByNames() {
//        dwarfs.sort((d1, d2) -> d1.getName().compareTo(d2.getName()));
//        return new ArrayList<>(dwarfs);
        return dwarfs.stream()
                .sorted(Comparator.comparing(Dwarf::getName))
                .collect(Collectors.toList());
    }

    public List<Dwarf> getSevenDwarfsOrderedByAges() {
//        dwarfs.sort((d1,d2)->Integer.compare(d1.getAge(),d2.getAge()));
//        return new ArrayList<>(dwarfs);
        return dwarfs.stream()
                .sorted(Comparator.comparingInt(Dwarf::getAge))
                .collect(Collectors.toList());
    }
}
