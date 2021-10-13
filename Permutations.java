package org.itstep;

public class Permutations {

    static String s = "abcd";
    static int count = s.length();
    static StringBuilder sb = new StringBuilder(s);

    public static void main(String[] args) {
permute(0);

    }
    public static void swap(int i, int j){
       char temp = sb.charAt(i);
       sb.setCharAt(i,sb.charAt(j));
       sb.setCharAt(j,temp);
    }

public static void permute(int i){
        if (i==count-1) System.out.println(sb.toString());
        else for (int j = i; j<count; j++){
            swap(i, j);
            permute(i+1);
            swap(i, j);

        }
}
}
