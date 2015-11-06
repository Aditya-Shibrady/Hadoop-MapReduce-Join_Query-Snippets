import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

@SuppressWarnings("unused")
public class Program1 
{
public static class B_Map extends Mapper<LongWritable, Text, Text, NullWritable>
{
private Text B_id = new Text();
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException 
{
String[] dataset = value.toString().split("\\^"); //as the seperator is charAt '\^' 
if (dataset[1].contains("Palo Alto"))
{
B_id.set(dataset[0]); //colmn 0 contains business ids
context.write(B_id, NullWritable.get());
}
}
}
public static void main (String[] args) throws IOException, ClassNotFoundException, InterruptedException
{
Configuration config = new Configuration();
String[] otherArgs = new GenericOptionsParser(config,args).getRemainingArgs();
// get all args
if (otherArgs.length != 2)  //2 arguments are needed: input and output 
{
System.err.println("Usage: Program1 <in> <out>");
System.exit(2);
}
// create a job with name "Program1"
@SuppressWarnings("deprecation")
Job job = new Job (config, "Program1");
job.setJarByClass(Program1.class);
job.setMapperClass(B_Map.class);
// set output key type
job.setOutputKeyClass(Text.class);
// set output value type
job.setOutputValueClass(NullWritable.class);
//set the HDFS path of the input data
FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
// set the HDFS path for the output
FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
//Wait till job completion
System.exit(job.waitForCompletion(true) ? 0 : 1);
}
}

