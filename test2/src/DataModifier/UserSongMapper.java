package DataModifier;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author suryadev
 */

import java.io.IOException;

import DataManager.*;
import DataModifier.*;
import SongClassifier.*;
import Driver.*;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class UserSongMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
    
    
	private IdClassSong Is=new IdClassSong();
	public UserCount Us=SingletonHash.us;
	
	int counta=0,countb=0,countc=0,countd=0,counte=0;
	
	private static String user="";
	
	public void configure(JobConf job) {
	     user=job.get("userID");
	}
	
	/*String user="";
	
	public UserSongMapper(String users) {
		
		user=users;
	}*/
	
    public void map(LongWritable key, Text value,OutputCollector<Text,Text> output, Reporter reporter)
			throws IOException {
        
                //String user="CAKCLXJ1332EB06A11";
    	        //String user=TestDriver.users;
				String[] words=value.toString().split(",");
                String userId=words[0];
                String song=words[1];
                if(user.equals(userId))
                {
                	String classid=Is.getKeyValue(song);
                	if(classid.equals("A"))
                		counta++;
                	if(classid.equals("B"))
                		countb++;
                	if(classid.equals("C"))
                		countc++;
                	if(classid.equals("D"))
                		countd++;
                	if(classid.equals("E"))
                	    counte++;
                	
                	Us.put_keyval("A",counta);
                	Us.put_keyval("B",countb);
                	Us.put_keyval("C",countc);
                	Us.put_keyval("D",countd);
                	Us.put_keyval("E",counte);
                }
                output.collect(new Text(userId),new Text(song));
                        
	
    }
	
    
}