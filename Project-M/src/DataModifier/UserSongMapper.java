/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataModifier;

/**
 *
 * @author suryadev
 */

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class UserSongMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
    
    
    
    public void map(LongWritable key, Text value,OutputCollector<Text,Text> output, Reporter reporter)
			throws IOException {
        
        
		String[] words=value.toString().split("\t");
                String userId=words[0];
                String song=words[1];
                
                output.collect(new Text(userId),new Text(song));
                        
	
    }
	
    
}
