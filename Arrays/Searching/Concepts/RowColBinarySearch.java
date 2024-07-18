package Concepts;

import java.util.Arrays;

public class RowColBinarySearch {
    public static void main(String[] args) {
        int [][] arr ={{10,20,30,40},
                     {15,25,35,45},
                     {28,29,37,49},
                     {33,34,38,50}
                    };

                    
        int [][] arr1 = {{1,2,3,4},
                          {5,6,7,8},
                         {9,10,11,12},
                           {13,14,15,16}
                        };

        System.out.println(Arrays.toString(Search(arr1, 3)));
        System.out.println(Arrays.toString(Search(arr, 37)));
    }

    public static int [] Search(int [][]matrix,int target){
        int r =0;
        int c = matrix.length -1;

        while(r<matrix.length && c>=0){
            if(target == matrix[r][c]){
                return new int[] {r,c};
            }
            else if(matrix[r][c]>target){
                c--;
            }
            else{
                r++;
            }
  
        }
        return new int[] {-1,-1};
    }
    
}
