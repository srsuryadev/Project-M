import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class TestReducer extends MapReduceBase implements Reducer<Text,DoubleWritable,Text,DoubleWritable>{

	@Override
	public void reduce(Text key, Iterator<DoubleWritable> values,
			OutputCollector<Text, DoubleWritable> output, Reporter reporter)
			throws IOException {
		
			double minValue=Double.MAX_VALUE;
			while(values.hasNext()){
				if(values.next().get()!=0){
					minValue=Math.min(minValue,values.next().get());
				}
				
			}
			
			output.collect(key, new DoubleWritable(minValue));
		
	}

		
}