package arrays;

import java.util.Arrays;

/**
 * Created by AKRITI on 2/2/2019.
 */
public class ArrayRotation {


    public static int[] rotate(int[] arr , int n , int s){
        int temp[] = new int[n];
        int k=0;
        for (int i=0;i<s;i++){
            if(i<n){
                temp[i]=arr[i];
            }
            if(i<s-n) {
                arr[i] = arr[i + n];
            }
            if(i>=s-n){
                arr[i]=temp[k];
                k++;
            }
        }
        return arr;
    }

    public static int[] juggAlgo(int[] arr , int n , int s){

        for(int i=0;i<gcd(n,s);i++){

            int k,j,temp=0;
            temp=arr[i];
            j=i;
            while(true){
                k=j+n;
                if(k>=s){
                    k=k-s;
                }
                if(k==i){
                    break;
                }
                arr[j]=arr[k];
                j=k;
            }
            arr[j]=temp;

        }
        return arr;
    }



    public static int gcd(int n , int s){
        if(s==0){
            return n;
        }else{
            return gcd(s, n%s );
        }
    }

    public static void main(String[] args){
        int[] input = new int[]{1,2,3,4,5,6,7};

        int[] res = juggAlgo(input,2,7);
        System.out.println(Arrays.toString(res));
        System.out.println(gcd(2,12));
    }
}
