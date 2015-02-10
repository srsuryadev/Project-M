/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModifier;

/**
 *
 * @author velan
 */

import DataManager.IdClassSong;
import DataManager.UserSong;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class UserSongReducer extends MapReduceBase implements Reducer<Text,String,Text,Text>{
   
        
        private IdClassSong Is = new IdClassSong(); 
        private UserSong us=new UserSong();
        private int[] countClass=new int[5];
        private String cid;
        
	public void reduce(Text key, Iterator<String> values,OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {
            
            countClass[0]=countClass[1]=countClass[2]=countClass[3]=countClass[4]=0;
            
            while(values.hasNext())
            {
                
                cid = Is.getKeyValue(values.next());
                
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
            
            us.putClassCount(key.toString(), countClass);
            output.collect(key, new Text(countClass.toString()));
            
        }
}
