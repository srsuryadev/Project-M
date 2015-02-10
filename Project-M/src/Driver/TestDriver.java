package Driver;


import java.io.IOException;
import SongClassifier.*;
import DataModifier.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

public class TestDriver {
	
	public static void main(String[] args) throws IOException {
	
		if (args.length != 2) {
			System.err.println("Usage: MaxTemperature <input path> <output path>");
			System.exit(-1);
		}
		JobConf conf = new JobConf(TestDriver.class);
		conf.setJobName("Recommender");
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		conf.setMapperClass(TestMapper.class);
		conf.setReducerClass(TestReducer.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(DoubleWritable.class);
		JobClient.runJob(conf);
                JobConf conf1 = new JobConf(TestDriver.class);
		conf1.setJobName("Recommender2");
		FileInputFormat.addInputPath(conf1, new Path(args[2]));
		FileOutputFormat.setOutputPath(conf1, new Path(args[3]));
		conf1.setMapperClass(UserSongMapper.class);
		conf1.setReducerClass(UserSongReducer.class);
		conf1.setOutputKeyClass(Text.class);
		conf1.setOutputValueClass(Text.class);
		JobClient.runJob(conf1);
                
		
	}
}