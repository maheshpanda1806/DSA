import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {

        int startidx = -1, r = 0, l = 0, count = 0, minlen = Integer.MAX_VALUE;
        HashMap<Character, Integer> mpp = new HashMap<>();

        // Preinsert
        for (int i = 0; i < t.length(); i++) {
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (mpp.getOrDefault(ch, 0) > 0) {
                count++;
            }
            mpp.put(ch, mpp.getOrDefault(ch, 0) - 1);

            while (count == t.length()) {
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    startidx = l;
                }
                
                mpp.put(s.charAt(l), mpp.getOrDefault(s.charAt(l), 0) + 1);
                if (mpp.get(s.charAt(l)) > 0)    count--;
                l++;
            }
        }

        return startidx == -1 ? "" : s.substring(startidx, startidx + minlen);
    }
}