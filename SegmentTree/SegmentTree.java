class SegTree{
    int[] seg;
    int[] arr;
    
    public SegTree(int[] arr, int n){
        this.arr = arr;
        this.seg = new int[4*n];
        build(0,0,n-1);
    }
    
    public int build(int idx, int low, int high){
        if(low == high) return seg[idx] = arr[low];
        
        int mid = (low+high)/2;
        
        int left = build(2*idx+1,low, mid);
        int right = build(2*idx+2,mid+1,high);
        
        return seg[idx] = Math.min(left,right);
    }
    public int query(int L, int R){
        return querySegTree(0,0,arr.length-1,L,R);
    }
    private int querySegTree(int idx, int low, int high, int L, int R){
        //no overlap
        if(high<L || low>R) {
            return Integer.MAX_VALUE;
        }
        
        //complete overlap
        if(L<= low && high<=R){
            return seg[idx];
        }
        //partial overlap
        int mid = (low+high)/2;
        
        int left = querySegTree(2*idx+1,low,mid,L,R);
        int right = querySegTree(2*idx+2,mid+1,high,L,R);
        
        return Math.min(left, right);
    }
    public void update(int i, int val){
        arr[i] = val;
        updateSegTree(0,0,arr.length-1,i,val);
    }
    
    private void updateSegTree(int idx, int low, int high, int i, int val){
        if(low == high) {
            seg[idx] = val;
            return;
        }
        
        int mid = (low+high)/2;
        
        if(i<=mid) updateSegTree(2*idx+1,low,mid,i,val);
        else updateSegTree(2*idx+2,mid+1,high,i,val);
        
        seg[idx] = Math.min(seg[2*idx+1],seg[2*idx+2]);
    }
    
    
}
public class SegmentTree {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 0, 4, 5};
        SegTree sg = new SegTree(arr, arr.length);

        System.out.println("Min in range [0,5]: " + sg.query(0, 5)); // expect 0
        
        sg.update(3, 6);
        System.out.println("Min in range [0,5]: " + sg.query(0, 5)); // expect 1
        sg.update(0, -1);

        System.out.println("\nAfter updating index 0 -> -1:");
        System.out.println("Min in range [0,5]: " + sg.query(0, 5)); // expect -1
        System.out.println("Min in range [0,2]: " + sg.query(0, 2)); // expect -1
    }
}