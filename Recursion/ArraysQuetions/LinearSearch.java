import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
    
          int [] arr ={2,3,4,5,7,6,44}; 
      
          int [] arr2 ={2,3,4,5,6,6,44}; 
        checkMultiple(arr2, 6, 0);
         System.out.println(arrayList);
          ArrayList<Integer> list = new ArrayList<Integer>();
         System.out.println( check2(arr2, 6, 0, list));
          System.out.println();
        System.out.println(check(arr,6, 0));
    }
    //method 1
     public static int check(int [] arr, int target,int i){
         if(i==arr.length){
           return -1;
         }
      if (arr[i]==target) {
        return i;
      }  
      return check(arr, target, i+1);
}

//method 2
static ArrayList<Integer> arrayList = new ArrayList<>();
 public static void checkMultiple(int [] arr, int target,int i){
         if(i==arr.length){
           return;
         }
      if (arr[i]==target) {
         arrayList.add(i);
      }  
       checkMultiple(arr, target, i+1);
    }
//method 3
 public static ArrayList<Integer> check2 (int [] arr, int target,int i,ArrayList<Integer> list){
       if(i==arr.length){
           return list;
         }
      if (arr[i]==target) {
         list.add(i);
      }  
      return check2(arr, target, i+1,list);
    }
 }




