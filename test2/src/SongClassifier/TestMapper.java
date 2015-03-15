package SongClassifier;


import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class TestMapper extends MapReduceBase
implements Mapper<LongWritable, Text, Text, Text> {
	
	
	
        SongClasses S=new SongClasses();
        String songClassId;
        double minDistance=Double.MAX_VALUE;
        
        public void assignClass(String classId,double dist){
                
                 if(minDistance>dist){
                    songClassId=classId;
                    minDistance=dist;
                }
        }
        
        public double distanceBetween(SongClass song,SongClass actualSong){
            
            double result=0;
        //    result+=(song.artistFamilarity-actualSong.artistFamilarity)*(song.artistFamilarity-actualSong.artistFamilarity);
            result+=Math.abs(song.danceAbility-actualSong.danceAbility)*Math.abs(song.danceAbility-actualSong.danceAbility);
            result+=Math.abs(song.energy-actualSong.energy)*Math.abs(song.energy-actualSong.energy);
            result+=Math.abs(song.liveness-actualSong.liveness)*Math.abs(song.liveness-actualSong.liveness);
            result+=Math.abs(song.loudness-actualSong.loudness)*Math.abs(song.loudness-actualSong.loudness);
            result+=Math.abs(song.mode-actualSong.mode)*Math.abs(song.mode-actualSong.mode);
            
            return Math.sqrt(result);
            
        }
        
	public void map(LongWritable key, Text value,
			OutputCollector<Text,Text> output, Reporter reporter)
			throws IOException {
		
		        String[] words = value.toString().split(",");
		        String songId=words[0];
                SongClass actualSong=new SongClass();
                
		        actualSong.danceAbility=Double.parseDouble(words[3]);
		        actualSong.energy=Double.parseDouble(words[4]);
                actualSong.liveness=Double.parseDouble(words[5]);
		        actualSong.loudness=Double.parseDouble(words[6]);
                actualSong.mode=Double.parseDouble(words[7]);
                
		
                
                int i;
               
                double dist=distanceBetween(S.A,actualSong);
                this.assignClass("A", dist);
                dist=distanceBetween(S.B,actualSong);
                this.assignClass("B", dist);
                dist=distanceBetween(S.C,actualSong);
                this.assignClass("C",dist);
                dist=distanceBetween(S.D,actualSong);
                this.assignClass("D",dist);
                dist=distanceBetween(S.E,actualSong);
                this.assignClass("E",dist);
                
                
		        output.collect(new Text(songClassId),new Text(songId));
	
        }
	
	
	
}