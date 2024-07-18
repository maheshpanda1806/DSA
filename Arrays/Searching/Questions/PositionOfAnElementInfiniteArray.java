public class PositionOfAnElementInfiniteArray{

    public static int answer(int s,int e,int [] arr, int target){
       
        while(e>=s){
    
            int mid = s -(s-e)/2;
    
            if(target>arr[mid]){
                s = mid +1;
            }
    
            else if(target<arr[mid]){
                e= mid -1;
            }
            
            else{
                return mid;
            }
    
        }
            return e;
        }


    public static void main(String[] args) {
        int [] arr = {2,3,5,6,7,8,10,11,12,15,20,23,30};
        int target = 20;
        boolean g =true;
        int i =1;
        int s = 0;
        int e =s+i;

       while(g){

       if(target<=arr[e]){
        g = false;
        break;
         
       }
       else{
        i++;
        e = (s+2*i);

       }
       }
      // System.out.println(s);
       //System.out.println(e);
       
       System.out.println(answer(s, e, arr, target));


    }
}