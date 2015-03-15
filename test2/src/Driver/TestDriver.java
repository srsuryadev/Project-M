package Driver;



import java.io.BufferedReader;
import org.apache.hadoop.conf.Configuration;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import DataManager.*;
import DataModifier.*;
import SongClassifier.*;
import Driver.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.*;

public class TestDriver {
	
	public static String users;
	
	/*TestDriver() {
		
		users="";
	}*/
	
	public static void filewrite(BufferedWriter bw,BufferedReader reader ) throws IOException{
		
		String line="";
		String newstr="";
		while((line=reader.readLine()) != null){
        	
        	String c='\t'+"";
        	boolean retval = line.contains(c);
        	if(retval==true) {        		
        		 newstr=line.replace('\t', ',');
                 bw.write(newstr);
                 bw.write("\n");
        	}
        	
        	else if(retval==false) {
        		
        	     bw.write(line);
        	     bw.write("\n");
        	}
        	else { 
        		;
        	}
        	//bw.write(line+"/n");
        }
        bw.close();
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
	
		
		//TestDriver d=new TestDriver();
		//TestDriver.users=(String)args[4];
		
		JobConf conf = new JobConf(TestDriver.class);
		conf.setJobName("Song-Classifier");
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		conf.setMapperClass(TestMapper.class);
		conf.setReducerClass(TestReducer.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		conf.setJarByClass(TestDriver.class);
        JobClient.runJob(conf);
        
                
        
        //JobConf conf1 = new JobConf(TestDriver.class);
        Configuration confs=new Configuration(); 
        JobConf conf1=new JobConf(confs);
       // JobConf conf1 = (JobConf)getConf();
		conf1.set("userID", "CAKCLXJ1332EB06A11");
		//conf1.set("mapred.job.tracker", "local");
		conf1.setJobName("User-Song-DataModifier");
		FileInputFormat.addInputPath(conf1, new Path(args[2]));
		FileOutputFormat.setOutputPath(conf1, new Path(args[3]));
		conf1.setMapperClass(UserSongMapper.class);
		conf1.setReducerClass(UserSongReducer.class);
		conf1.setOutputKeyClass(Text.class);
		conf1.setOutputValueClass(Text.class);
        conf1.setJarByClass(TestDriver.class);
		JobClient.runJob(conf1); 
        
        
        String command=args[4];
        Process proc=Runtime.getRuntime().exec(command);
        BufferedReader reader=new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line="";
        String newstr="";
        File file=new File("~/output2.txt");
        FileWriter fw=new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bw=new BufferedWriter(fw);
    
        
        filewrite(bw,reader);
        
        proc.waitFor();
        
        String command1="hadoop dfs -rmr hdfs:/usr/local/hadoop/output160";
        Process proc1=Runtime.getRuntime().exec(command1);
        proc1.waitFor();
        
        String command2="hadoop dfs -rmr hdfs:/usr/local/hadoop/output161";
        Process proc2=Runtime.getRuntime().exec(command2);
        proc2.waitFor();
        
        
	}
}