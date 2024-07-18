public class NumberofSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    public static int numberOfSubstrings(String s) {
        int count =0 ;
        int[] hasharr = new int[3];
        for (int i =0;i<hasharr.length;i++) {
            hasharr[i] =-1;
        }
       int l =0,r =0;

        for ( r = 0; r < s.length(); r++) {
            char ch =  s.charAt(r);
            hasharr[ch - 'a'] = r;
            if (containsAll(hasharr)) {
                count=count + 1 + minHash(hasharr);
            }
        }

        return count;
    }
    public static boolean containsAll(int[] arr){
        return arr[0]!=-1 && arr[1]!=-1 && arr[2]!=-1;
    }


    public static int minHash(int [] arr){
        
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            temp = Math.min(temp, arr[i]);
        }
        return temp;
    }
}
