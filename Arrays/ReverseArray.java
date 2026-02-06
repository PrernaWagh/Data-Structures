import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class ReverseArray
{	
	public static List<Integer> reverseArray(List<Integer> a) {
        	int start = 0;
        	int end = a.size()-1;
        	while(start < end)
        	{
            		int temp = a.get(start);
            		a.set(start,a.get(end));
            		a.set(end,temp);
            
            		start++;
            		end--;
        	}
      		return a; 
    	}
	public static void main(String s[])
	{
		List<Integer> list = new ArrayList<>();
		int data =0;
		Scanner sc = new Scanner(System.in); 
		for(int i=0;i<5;i++)
		{
			data = sc.nextInt();
			list.add(data);
		}
		list = reverseArray(list);
		System.out.print(list);
        }

}