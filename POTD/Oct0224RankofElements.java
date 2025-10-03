import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Oct0224RankofElements {
    class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashSet<Integer> stt = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> mpp = new HashMap<>();//arr[i]->rank
        for(int i:arr) stt.add(i);
         
        for(int i:stt) list.add(i);
        Collections.sort(list);
         
        for(int i=0;i<list.size();i++){
            mpp.put(list.get(i),i+1);
        }

        for(int i=0;i<arr.length;i++){
           int temp = arr[i];
           arr[i] = mpp.get(arr[i]);
        }
        return arr;
        }
}
}
