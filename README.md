Snippets:

Q1. 
 List each business Id that are located in “Palo Alto” using the full_address column as the filter column. 

Sample output:

23244444
232ewe33

Q2 

Find the top ten rated businesses using the average ratings. 
Recall that star column in review.csv file represents the rating.

Please answer the question by calculating the average ratings given to each business using the review.csv file. 

Sample output:
business id              
xdf12344444444


Q3:
List the  business_id , full address and categories of the Top 10 businesses using the average ratings.  

This will require you to use  review.csv and business.csv files.

Please use reduce side join and job chaining technique to answer this problem.


Sample output:
business id               full address           categories                                    avg rating
xdf12344444444,      CA 91711       List['Local Services', 'Carpet Cleaning']	5.0


Q4: 
List the 'user id' and 'stars' of users that reviewed businesses located in Stanford 
Required files are 'business'  and 'review'.

Please use Map side join technique to answer this problem.
Hint: Please load all data in business.csv file into the distributed cache. 

Sample output
                                                   
	       
User id
stars
0WaCdhr3aXb0G0niwTMGTg
4.0


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
