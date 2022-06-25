# Operating_Systems_Project

![image](https://user-images.githubusercontent.com/86987951/175788981-b1b9375f-ee09-4f54-8cdb-da2f7fa636f6.png)

![image](https://user-images.githubusercontent.com/86987951/175788931-275ef1a8-20eb-49cb-b0ab-2681299f708c.png)

![image](https://user-images.githubusercontent.com/86987951/175788949-06e8ed31-5c89-4886-8184-2be834b548b6.png)

# Execution and installation:

I have implemented my project in java language, on NetBeans IDE. The project consisted of two tasks where in each of them we had to develop several algorithms for each process First- Come First-Served (FCFS), non-preemptive Shortest-Job-First (SJF), and Round Robin.
I can say that the development of these algorithms was very challenging and enjoyable at the same time. I chose to develop all three algorithms for each process in one program and I think that was the best way and choice. Whereas a start, when the user executes the program he prints three processes one after the other together with personal id this made possible by a switch case in the main class, I have created some relevant functions (I say some relevant functions because in program I chose to check if the burst time value which was entered manually by the user or even automatically taken randomly by the program (in the second task) to be only integer and for this reason I used a try-catch to catch this error if the user enter a character or a decimal number in the burst time). In the method class I have created some corresponding methods where they calculate the waiting time, turnaround time, and average time for all three processes. Exactly, I created only one turnaround time function for FCFS process and RR process because their calculation was the same. While the waiting time function for all three processes is different.
Also, the program code is well documented.

As for the second task, the source code is the same, the only difference is that at the burst time input the program takes it randomly where the user must specify the start time and end time (min and max range).
 
# Task 1. Screenshots:
# Select the process – Main Class
![image](https://user-images.githubusercontent.com/86987951/175788574-41a65714-9630-4ff8-a3a3-c24fee36b46b.png)

# FCFS
![image](https://user-images.githubusercontent.com/86987951/175788618-b58b2340-128d-4df6-8a25-cf16563889a5.png)

![image](https://user-images.githubusercontent.com/86987951/175788629-3037ed1a-6909-4c0f-9b28-5109d60c315d.png)

# SJF
![image](https://user-images.githubusercontent.com/86987951/175788642-47e5b8e5-7265-4fc2-8367-b968c9deeb6b.png)

![image](https://user-images.githubusercontent.com/86987951/175788646-7027c9cf-82dc-4acc-8d51-f94436af5a8f.png)

# RR
![image](https://user-images.githubusercontent.com/86987951/175788653-064d2bdd-5226-4ff2-a20c-c478b291f3b8.png)

![image](https://user-images.githubusercontent.com/86987951/175788675-33a73042-ea8d-41b8-8433-790f785f6110.png)
  
# Task 2 Screenshots:
# Select the process – Main Class
![image](https://user-images.githubusercontent.com/86987951/175788688-50aee7dd-4822-48e2-9161-bbdb98a49fc8.png)

# FCFS
![image](https://user-images.githubusercontent.com/86987951/175788693-4720cb86-02c5-4b6f-ae19-098ccde5177b.png)
![image](https://user-images.githubusercontent.com/86987951/175788698-058234f3-3534-49fa-8723-5ee23a64d46e.png)

![image](https://user-images.githubusercontent.com/86987951/175788700-dbf37b54-e119-4be9-a77a-be322b995a76.png)
![image](https://user-images.githubusercontent.com/86987951/175788701-989f281f-5323-4818-8482-1916370182c0.png)
 
# SJF
![image](https://user-images.githubusercontent.com/86987951/175788714-519e2c22-0aa5-46d9-9e4d-611f067c2f3b.png)
![image](https://user-images.githubusercontent.com/86987951/175788717-e4fbf3ac-2787-4811-b7a6-3fabfdf6363a.png)

![image](https://user-images.githubusercontent.com/86987951/175788722-b3622e41-0c55-48a9-9343-b6d572d20c46.png)
![image](https://user-images.githubusercontent.com/86987951/175788727-9ba44fc7-6be5-4c09-ae84-7b823dffb5ed.png)
 
# RR
![image](https://user-images.githubusercontent.com/86987951/175788735-cba1c5e1-2b70-4721-8887-e618ba122d10.png)
![image](https://user-images.githubusercontent.com/86987951/175788744-cfe8d614-67e4-437b-8c43-503bb91645b4.png)

![image](https://user-images.githubusercontent.com/86987951/175788747-2dc5a05a-b7fa-4acd-a9b9-9ff1aeac63bb.png)

 
# Task 2 Explanation of the results
I did the simulation 30 times for the algorithm (10 times each string) as required in the template.

# FCFS
![image](https://user-images.githubusercontent.com/86987951/175788801-f009e323-5fda-4a88-bea2-ab9611ad839f.png)

Based on the test results for all three ranges we can see very clearly in the graph above that range 8-12 produced the lowest waiting time and range 1-20 produced the highest average waiting time. Thus, we come to the conclusion that in a small range we will get the best average waiting time. Although, compared to the range 5-15 and 1-20 the difference of the average waiting time is not very large. As we see the average waiting time 5 - 15 is 44.4 ms while for 1-20 it is 45 ms
 
# SJF
![image](https://user-images.githubusercontent.com/86987951/175788851-af32256f-0fb5-4ff9-b028-84f9951848d9.png)

In the SJF process the opposite of the FCFS process occurred. In the last and longest range (1- 20) we see that the average waiting time decreased, which means that at longer time intervals we get better average waiting time. If we look carefully at the three sequences, we understand that there is no big difference between the intervals the difference between the first (8-12) and last interval (1-20) is 5.81 ms and for the second interval (5-15) and the last interval (1-20) it is only
1.19 ms.
 
# RR
![image](https://user-images.githubusercontent.com/86987951/175788870-a7593042-5b24-46c5-a01b-b9391857079f.png)

In the round robin process, we notice that the average waiting time decreases as the intervals expand. The first interval (8-12) with the second interval (5-15) has a distance of 19.55 ms and with the third interval (1-20), 30.2 ms. Whereas the second interval (5-15) with the third interval (1-20) has a distance of 10.65 ms.
 
# Comparison between algorithms for respective burst times:

# Sequence 8-12:

As we saw from the calculations the SJF process is the fastest which gives the lowest average waiting time. After the SJF process the fastest is the FCFS process which has a difference of approximately 33.0 ms with the third RR process.

# Sequence 5 – 15:

In this range the fastest average waiting time is given by the SJF process with an average of
37.17 ms. It is followed by the FCFS process with an average of 44.4 ms, while the Round Robin process is the one that has the lowest waiting time with 58.28 ms.

# Sequence 1-20:

Even in this interval the SJF process has a faster waiting time than other processes with 35.98 ms, followed by FCFS with 45.1 ms and the process with the lowest waiting time is round robin with 47.6 ms.

# Conclusion:

As we see in all intervals, round robin with time quantum 5 was the process with a pretty high average waiting time. And the SJF process was faster than the other two processes in all cases.
