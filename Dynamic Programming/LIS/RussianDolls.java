import java.util.*;

public class RussianDolls {
    
}class Solution {
    public int maxEnvelopes(int[][] envelopes) {
Arrays.sort(envelopes, (int[] a, int[] b) -> {
    if (a[0] != b[0]) {
        return a[0] - b[0];  
    } else {
        return b[1] - a[1];  
    }
});
    List<Integer> list = new ArrayList<>();
    for(int i =0;i<envelopes.length;i++){
        if(list.size()==0 || list.get(list.size()-1)<envelopes[i][1]){
            list.add(envelopes[i][1]);
        }else{
            int idx = Collections.binarySearch(list,envelopes[i][1]);
            if(idx<0) idx = -(idx+1);
            list.set(idx,envelopes[i][1]);
        }
    }
    return list.size();
    }
}
