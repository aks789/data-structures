package recursions;

/**
 * Created by AKRITI on 4/3/2019.
 */
public class ReverseStringUsingRecur {

    public String reverse(String data){
        if(data.length()<=1){
            return data;
        }
        return reverse(data.substring(1,data.length()))+data.charAt(0);
    }
    public static void main(String[] args){
        ReverseStringUsingRecur reverseStringUsingRecur = new ReverseStringUsingRecur();

        System.out.println(reverseStringUsingRecur.reverse("hello"));
    }

}
