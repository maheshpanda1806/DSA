import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        for (int x : arr) {
            int remainder = ((x % k) + k) % k;
            mpp.put(remainder, mpp.getOrDefault(remainder, 0) + 1);
        }
        
        for (int i : mpp.keySet()) {
            if (i == 0) {
                if (mpp.get(i) % 2 != 0) {
                    return false;
                }
            } else if (2 * i == k) {
                if (mpp.get(i) % 2 != 0) {
                    return false;
                }
            } else {
                if (!mpp.get(i).equals(mpp.getOrDefault(k - i, 0))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}