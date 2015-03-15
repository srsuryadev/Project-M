package DataModifier;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author velan
 */

import java.io.IOException;

import DataManager.*;
import DataModifier.*;
import SongClassifier.*;
import Driver.*;

import java.util.*;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class UserSongReducer extends MapReduceBase implements Reducer<Text,Text,Text,Text>{
   
        
        private IdClassSong Is = new IdClassSong(); 
        private UserSong us=new UserSong();
        private int[] countClass=new int[5];
        private UserCount Us=SingletonHash.us;
        private String cid;
        private Random randomnumber=new Random();
        
        /*String user="";
        
        public UserSongReducer(String users) {
    		
    		user=users;
    	}*/
        
        //String user="CAKCLXJ1332EB06A11";
        //String user=TestDriver.users;
        
        private static String user="";
    	   
        String user1="";
        String user2="";
        String user3="";
        String temp1="";
        String temp2="";
        String outputResult2="";
        
        double max1=0,max2=0,max3=0,t1=0,t2=0;
        
        int a=randomnumber.nextInt(10);
        int b=randomnumber.nextInt(10);
        int c=randomnumber.nextInt(10);
        int d=randomnumber.nextInt(10);
        int e=randomnumber.nextInt(10);
        int count=0;
        int num[]= new int[5];
        
        
      public void configure(JobConf job) {
   	     user=job.get("userID");
   	  } 
        
        public String convertIntString(int[] num) {
        	
        	String result;
        	int i;
        	result="";
        	for(i=0;i<5;i++){
        		
        		result=result+num[i]+",";
        	}
        	return result;
        	
        }
        
        
        
	public void reduce(Text key, Iterator<Text> values,OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {
            
		
		    count++;
            countClass[0]=countClass[1]=countClass[2]=countClass[3]=countClass[4]=0;
        
            num[0]=Us.get_keyval("A")+a;
        	num[1]=Us.get_keyval("B")+b;
        	num[2]=Us.get_keyval("C")+c;
        	num[3]=Us.get_keyval("D")+d;
        	num[4]=Us.get_keyval("E")+e;
            
            
            while(values.hasNext())
            {
            
            	
            	//System.out.println(values.next());
                
            	cid = Is.getKeyValue(values.next().toString());
                
                
                if(cid.equals("A")){
                    countClass[0]++;
                }
                else if(cid.equals("B")){
                    countClass[1]++;
                }
                else if(cid.equals("C")){
                    countClass[2]++;
                }
                else if(cid.equals("D")){
                    countClass[3]++;
                }
                else if(cid.equals("E")){
                    countClass[4]++;
                }
                else {
                    ;
                }
                
                
                
            }
     
                
            	
            	
            
            if(user.equals(key.toString())==false) 
            {
              Double similarity;
              UserSimilarity sv=new UserSimilarity();
              similarity=sv.getSimilarity(num, countClass);
              if(similarity>max1) {
            	  t1=max2;
            	  t2=max1;
            	  temp2=user2;
            	  temp1=user1;
            	  max1=similarity;
            	  user1=key.toString();
            	  
            	  max2=t2;
            	  max3=t1;
            	  //temp=user2;
            	  user2=temp1;
            	  user3=temp2;
              }
              else if(similarity>max2) {
            	  t1=max2;
            	  temp1=user2;
            	  max2=similarity;
            	  user2=key.toString();
            	  max3=t1;
            	  user3=temp1;
              }
              else if(similarity>max3) {
            	  max3=similarity;
            	  user3=key.toString();
              }
              else { ; }
              String similarityString=similarity.toString();
              String outputResult=convertIntString(num)+user1+","+user2+","+user3;
              if(count==12)
            	  output.collect(new Text(user), new Text(outputResult));
            }
          
	}
	  
	    
}