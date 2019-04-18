package dynamicprogramming;

/**
 * Created by AKRITI on 4/3/2019.
 */
public class FibCalc {


    public int fibUsingRecur(int n){
        if(n==0||n==1){
            return n;
        }
        return fibUsingRecur(n-2) + fibUsingRecur(n-1);
    }

    public int fibUsingDynamicProg(int n){
        int m[] = new int[n+1];
        for(int i=0;i<=n;i++){
            m[i]=-1;
        }
        m[0]=0;
        m[1]=1;
        if(m[n]!=-1){
            return m[n];
        }
        else{
            for(int i=2;i<=n;i++) {
                m[i] = m[i - 2] + m[i - 1];
            }
        }
        return m[n];
    }

    public static void main(String[] args){

        FibCalc fibCalc = new FibCalc();

        System.out.println(fibCalc.fibUsingRecur(6));
        System.out.println(fibCalc.fibUsingDynamicProg(6));
    }

}
