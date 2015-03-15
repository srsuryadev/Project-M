package DataModifier;

import java.util.*;
import java.lang.*;

/**
*
* @author velan and soorya
*/

public class UserSimilarity {
	
	public double getSimilarity(int[] rating1,int[] rating2){
	
		
		/*double result=0;
		int i;
		for(i=0;i<5;i++){
			result+=Math.abs(count1[i]-count2[i]);			
		}
		return Math.sqrt(result);*/
		
		    double sum_xy = 0;
			double sum_x = 0;
			double sum_y = 0;
		    double sum_x2 = 0;
		    double sum_y2 = 0;
			int	n = 0;
			double x,y;
			for(int i=0;i<5;i++)
			{
				if(rating1[i]!=0&&rating2[i]!=0)
				{
					        n += 1;
							x = rating1[i];
							y = rating2[i];
							sum_xy += x * y;
							sum_x += x;
							sum_y += y;
							sum_x2 +=Math.pow(x,2);
							sum_y2 +=Math.pow(y,2);
				}
			}
			double denominator = Math.sqrt(sum_x2 - (Math.pow(sum_x,2)) / n) * Math.sqrt(sum_y2 -(Math.pow(sum_y,2)) / n);
			if (denominator == 0)
				return 0;
			else
				return (sum_xy - (sum_x * sum_y) / n) / denominator;
			}

}

