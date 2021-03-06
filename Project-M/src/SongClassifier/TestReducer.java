package SongClassifier;

import DataManager.IdClassSong;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class TestReducer extends MapReduceBase implements Reducer<Text,String,Text,Text>{

	@Override
        
        
        
	public void reduce(Text key, Iterator<String> values,
			OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {
		
                        IdClassSong Is=new IdClassSong();
                        while(values.hasNext()){
                            Is.putKeyValue(values.next().toString(), key.toString());
                            output.collect(new Text(values.next()), new Text(key));
                        }
			
			
	}

		
}