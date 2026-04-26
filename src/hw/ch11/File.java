package hw.ch11;

import java.util.List;
import java.util.ArrayList;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }

    @Override
    protected List<Entry> search(String keyword) {
        List<Entry> entries = new ArrayList<>();
        if (getName().contains(keyword)) {
            entries.add(this);
        }
        return entries;
    }
}
