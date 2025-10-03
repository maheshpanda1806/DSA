public class CountNumberOfSetBit {
    public static void main(String[] args) {
        int n =  76;
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
        //every iteration we find rsb and count it and we turn it off and 
        //then find the next rsb in next iteration 
        while(n!=0){
            int rsbm = n&-n;
            count++;
            n = n - rsbm;//turn off that bit bcoz we have already counted it 
        }
        System.out.println(count);
    }
}
