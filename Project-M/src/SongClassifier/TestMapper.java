import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class TestMapper extends MapReduceBase
implements Mapper<LongWritable, Text, Text, DoubleWritable> {
	
	
	public static String song_id="SOAKIMP12A8C130995";
	
	public static double attr11=0.463781;
	public static double attr22=0.22566;
	
	
	public void map(LongWritable key, Text value,
			OutputCollector<Text, DoubleWritable> output, Reporter reporter)
			throws IOException {
		
		String[] words = value.toString().split(",");
		String songid=words[0];
		double attr1=Double.parseDouble(words[4]);
		double attr2=Double.parseDouble(words[5]);
		
			
		double distance=Math.sqrt((attr11-attr1)*(attr11-attr1)+(attr22-attr1)*(attr22-attr1));
		
		output.collect(new Text(song_id),new DoubleWritable(distance));
	}
	
	
	
}