import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            br.readLine();
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer M = Integer.parseInt(temp[1]);
            N--;M--;

            Integer[] hor = new Integer[N];
            Integer[] ver = new Integer[M];

            for (int i = 0; i < N  ; i++) {
               hor[i] =  Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M  ; i++) {
                ver[i] =  Integer.parseInt(br.readLine());
            }
            Arrays.sort(hor);
            Arrays.sort(ver);

            Integer cost = 0,vertCut =1,horCut =1;
            for(int i = N-1,j = M-1;i >=0 || j>=0;){
                if(i < 0 ){
                    cost += (horCut * ver[j]);
                    vertCut++;
                    j--;
                    continue;
                }
                if(j < 0){
                    cost += ( vertCut * hor[i]);
                    horCut++;
                    i--;
                    continue;
                }
                if(hor[i] >= ver[j]){
                    cost += ( vertCut * hor[i]);
                    horCut++;
                    i--;
                }else {
                    cost += (horCut * ver[j]);
                    vertCut++;
                    j--;
                }
            }
            System.out.println(cost);
	}
	}
}