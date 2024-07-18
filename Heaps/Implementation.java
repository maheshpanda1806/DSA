import java.util.ArrayList;

class Heap {

    private ArrayList<Integer> list;

    public Heap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(int value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    public int remove() {
        if (list.isEmpty()) {
           
            return Integer.MIN_VALUE; // Returning a special value indicating an empty heap.
        }

        int temp = list.get(0);

        int last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min) > list.get(left)) {
            min = left;
        }

        if (right < list.size() && list.get(min) > list.get(right)) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }
    
     private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index) < list.get(p)) {
            swap(index, p);
            upheap(p);
        }
    }

    public ArrayList<Integer> heapSort() {
        ArrayList<Integer> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

    public ArrayList<Integer> constructHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        return list;
    }
}

class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();

        int[] arr = { 6, 5, 4, 3, 2, 1 };
        ArrayList<Integer> list = heap.constructHeap(arr);
        System.out.println(list);
    }
}
