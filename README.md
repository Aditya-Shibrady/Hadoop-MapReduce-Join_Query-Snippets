Command to run 1:
1) Log into HDFS machine
2) Run the following commands:
	hdfs dfs -rmr /output*
hadoop jar Big1.jar com.pkg.src.Question1 <location of business.csv> /output
3) view the file by running:
	hdfs dfs -cat /output/*

Command to run 2:
1) Log into HDFS machine
2) Run the following commands:
	hdfs dfs -rmr /output*
hadoop jar Big2.jar com.pkg.src.QuestionTwo <location of review.csv> /output
3) view the file by running:
	hdfs dfs -cat /output/*

Command to run 3:
1) Log into HDFS machine
2) Run the following commands:
	hadoop jar Big3.jar com.pkg.src.Problem3 <location of review.csv> /yelpdatafall/business/business.csv /output1 /output2
3) view the file by running:
	hdfs dfs -cat /output2/*

Command to run 4:
1) Log into HDFS machine
2) Run the following commands:
	hdfs dfs -rmr /output*
	hadoop jar Big4.jar com.pkg.src.Question4 <location of review.csv> <location of business.csv>  /output
3) view the file by running:
	hdfs dfs -cat /output/*
