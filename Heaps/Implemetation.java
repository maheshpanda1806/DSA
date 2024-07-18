import java.util.ArrayList;

public class Implemetation {
    public static void main(String[] args) {
        Heap h = new Heap();
    
        h.insert(5);
        h.insert(4);
        h.insert(3);
        h.insert(2);
    }
}

class Heap {
    private ArrayList<Integer> list;

    Heap() {
        list = new ArrayList<>();
    }

    public void print() {
        System.out.println(list);
    }

    private void swap(int p, int idx) {
        int temp = list.get(idx);
        list.set(idx, list.get(p));
        list.set(p, temp);
    }

    public void insert(int val) {
        list.add(val);
        int index = list.size() - 1;
        int parent = (index - 1) / 2;
        
        System.out.println("Inserting " + val);

        while (index > 0 && list.get(parent) > list.get(index)) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
        print();
    }
}
