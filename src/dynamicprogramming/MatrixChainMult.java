package dynamicprogramming;

/**
 * Find the minimum number of operations to multiply matrices via recursive method as well as dynamic programming
 * Created by AKRITI on 3/30/2019.
 */
public class MatrixChainMult {


    // A[i] is matrix of p[i-1],p[i]
    public static int matrixChainMultRecur(int p[] , int i , int j){
        int minOperRes=0;
        if(i==j){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            minOperRes = matrixChainMultRecur(p,i,k) + matrixChainMultRecur(p,k+1,j) + p[i-1]*p[k]*p[j];
            if(minOperRes<min){
                min=minOperRes;
            }
        }
        return min;
    }

    public static int matrixChainDynProg(int p[] , int n){
        int m[][] = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            m[i][i]=0;
        }

        for(int k=1;k<n;k++) {
            for (int i = 1; i <= n-k; i++) {
                int j = i + k;
                if(k==1) {
                    m[i][j] = m[i][i] + m[j][j] + (p[i - 1] * p[i] * p[j]);
                }else{
                    int compareData=Integer.MAX_VALUE;
                    for(int y=i;y<j;y++){
                        int operations = m[i][y]+ m[y+1][j]+(p[i-1]*p[y]*p[j]);
                        if(operations<compareData){
                            compareData=operations;
                        }
                    }
                    m[i][j]=compareData;
                }

            }
        }
        return m[1][n];
    }


    public static void main(String[] args){
        int[] arr = new int[] {10,30,5,60,70,80};
        int n = arr.length;
        System.out.println(matrixChainMultRecur(arr,1,n-1));
        System.out.println(matrixChainDynProg(arr,n-1));
    }
}
