public class Permutation{
    public static void findPermutation(String str, String ans){
        //Base Case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //Recursion
        for(int i=0; i<str.length();i++){
            char current= str.charAt(i);
            //Remove C abcde=> "ab"+"de"=abde
            String newStr= str.substring(0, i)+str.substring(i+1);
            findPermutation(newStr, ans+current);
        }
    }
    public static void main(String[] args) {
        String str= "abc";
        findPermutation(str, "");
    }
}