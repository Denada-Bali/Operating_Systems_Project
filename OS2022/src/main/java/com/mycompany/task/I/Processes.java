/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task.I;

/**
 *
 * @author Denalda
 */
public class Processes {

    /* This methode calculate  waiting time for FCFS process */
    static void waitingTime(int processes[], int noOfProcesses, int burstTime[], int wtTime[]) {

        /* Waiting time for first process is 0 */
        wtTime[0] = 0;

        /* calculating waiting time */
        for (int i = 1; i < noOfProcesses; i++) {
            wtTime[i] = burstTime[i - 1] + wtTime[i - 1];
        }
    }

    /* cacluate turn around time for FCFS process and RR process */
    static void turnAroundTime(int processes[], int noOfProcesses, int burstTime[], int waitingTime[], int trnAroundTime[]) {

        /* calculating turnaround time by adding burstTime[i] + waitingTime[i] */
        for (int i = 0; i < noOfProcesses; i++) {
            trnAroundTime[i] = burstTime[i] + waitingTime[i];
        }
    }

    /* calculate the average time for FCFS process */
    static void averageTime(int processes[], int noOfProcesses, int burstTime[]) {
        /*Here I make a copy of waitingTime[], and turnaroundTime[] to store remaining burst times*/
        int waitingTime[] = new int[noOfProcesses], trnAroundTime[] = new int[noOfProcesses];
        int total_waitingTime = 0, total_turnAroundTime = 0;
        int arrivalTimes[] = new int[noOfProcesses];

        /* I called  the function to find waiting time of all processes */
        waitingTime(processes, noOfProcesses, burstTime, waitingTime);

        /*I Called  the function to find turn around time of all processes*/
        turnAroundTime(processes, noOfProcesses, burstTime, waitingTime, trnAroundTime);

        /* Here I have initialize the arrival times 0 if we want to display at the output section*/
        arrivalTimes[0] = 0;

        /* this helps me to display all processes with all details */
        //System.out.printf("Processes | Arrival Time | Burst time | Waiting time | Turn around time\n");
        System.out.printf("Processes | Burst time | Waiting time | Turn around time\n");

        for (int i = 0; i < noOfProcesses; i++) {
            /* here I'm calculating all waiting time and turn around time*/
            total_waitingTime = total_waitingTime + waitingTime[i];
            total_turnAroundTime = total_turnAroundTime + trnAroundTime[i];

            System.out.println("Process " + (i + 1) + ":\t" + /*arrivalTimes[i] +*/ burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + trnAroundTime[i]);

        }
        float s = (float) total_waitingTime / (float) noOfProcesses;

        int t = total_turnAroundTime / noOfProcesses;

        System.out.printf("\nAverage waiting time = %f", s);
        System.out.printf("\n");
        System.out.printf("\nAverage turn around time = %d ", t);
    }

    /* calculate the average time for SJF process */
    static void averageTimeSJF(int processes[], int noOfProcesses, int burstTime[]) {
        /*Here I make a copy of waitingTime[], and turnaroundTime[] to store remaining burst times*/
        int waitingTime[] = new int[noOfProcesses], trnAroundTime[] = new int[noOfProcesses];
        int arrivalTimes[] = new int[noOfProcesses];
        float total_waitingTime = 0, total_turnAroundTime = 0;

        int i, j, n, total = 0, pos, temp;

        /* Sort processes according to the Burst Time*/
        for (i = 0; i < noOfProcesses; i++) {
            pos = i;
            for (j = i + 1; j < noOfProcesses; j++) {
                if (burstTime[j] < burstTime[pos]) {
                    pos = j;
                }
            }

            temp = burstTime[i];
            burstTime[i] = burstTime[pos];
            burstTime[pos] = temp;

            temp = processes[i];
            processes[i] = processes[pos];
            processes[pos] = temp;
        }

        /* First process has 0 waiting time*/
        waitingTime[0] = 0;

        for (i = 1; i < noOfProcesses; i++) {
            waitingTime[i] = 0;
            for (j = 0; j < i; j++) {
                waitingTime[i] += burstTime[j];
            }
            total += waitingTime[i];
        }

        /* Calculating Average waiting time*/
        total_waitingTime = (float) total / noOfProcesses;
        total = 0;

        /* Here I have initialize the arrival times 0 if we want to display at the output section*/
        arrivalTimes[0] = 0;

        /* this helps me to display all processes with all details */
        // System.out.printf("Processes | Arrival Time | Burst time | Waiting time | Turn around time\n");
        System.out.printf("Processes | Burst time | Waiting time | Turn around time\n");

        for (i = 0; i < noOfProcesses; i++) {
            /* here I'm calculating all waiting time and turn around time*/
            trnAroundTime[i] = burstTime[i] + waitingTime[i];
            total += trnAroundTime[i];

            System.out.println("Process " + processes[i] + ":\t" + /*arrivalTimes[i] +*/ burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + trnAroundTime[i]);

        }

        total_turnAroundTime = (float) total / noOfProcesses;
        System.out.println("\n\nAverage Waiting Time: " + total_waitingTime);
        System.out.println("\nAverage Turnaround Time: " + total_turnAroundTime);

    }

    /* calculate the average time for FCFS process */
    static void waitingTimeRoundRobin(int processes[], int noOfProcesses, int burstTime[], int waitingTime[], int quantum) {

        /*Here I make a copy of burst times burstTime[] to store remaining burst times.*/
        int remainingBT[] = new int[noOfProcesses];

        for (int i = 0; i < noOfProcesses; i++) {
            remainingBT[i] = burstTime[i];
        }

        /* This variable is for current time*/
        int t = 0;

        /* With the while loop I keep traversing processes in round robin manner until all of them are not done */
        while (true) {
            boolean done = true;

            /* Traverse all processes one by one repeatedly */
            for (int i = 0; i < noOfProcesses; i++) {
                /* If burst time of a process is greater than 0 then only need to process further*/
                if (remainingBT[i] > 0) {
                    /* if there is a pending process*/
                    done = false;

                    if (remainingBT[i] > quantum) {

                        /* Increase the value of t, which shows how much time a process has been processed */
                        t += quantum;

                        /* Here I decrease the burstTime of current process by quantum*/
                        remainingBT[i] -= quantum;

                        /* If burst time is smaller than or equal toquantum, then the program increase the value of t*/
                        /* Which show how much time a process has been processed*/
                    } else {
                        t = t + remainingBT[i];
                        /* After we calculate the Waiting time which is the current time minus time used by this process*/
                        waitingTime[i] = t - burstTime[i];
                        /* When the process is fully executed, we make the remaining brust time equal to 0*/
                        remainingBT[i] = 0;
                    }
                }
            }
            /* This condition is if all processes are done*/
            if (done == true) {
                break;
            }
        }
    }

    /* calculate the average time for SJF process */
    static void averageTimeRR(int processes[], int noOfProcesses, int burstTime[], int quantum) {
        /*Here I make a copy of waitingTime[], and turnaroundTime[] to store remaining burst times*/
        int waitingTime[] = new int[noOfProcesses], trnAroundTime[] = new int[noOfProcesses];
        int arrivalTimes[] = new int[noOfProcesses];

        float total_waitingTime = 0, total_turnAroundTime = 0;

        /* I called the function to find waiting time of all processes */
        waitingTimeRoundRobin(processes, noOfProcesses, burstTime, waitingTime, quantum);

        /* I called the function to find turn around time of all processes */
        turnAroundTime(processes, noOfProcesses, burstTime, waitingTime, trnAroundTime);

        /* Here I have initialize the arrival times 0 if we want to display at the output section*/
        arrivalTimes[0] = 0;

        /* here I desplay processes with all details */
        //System.out.printf("Processes | Arrival Time | Burst time | Waiting time | Turn around time\n");
        System.out.printf("Processes | Burst time | Waiting time | Turn around time\n");

        for (int i = 0; i < noOfProcesses; i++) {
            /* Calculate total waiting time and total turn around time */
            total_waitingTime = total_waitingTime + waitingTime[i];
            total_turnAroundTime = total_turnAroundTime + trnAroundTime[i];

            System.out.println("Process " + processes[i] + ":\t" + /*arrivalTimes[i] +*/ burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + trnAroundTime[i]);

        }

        System.out.println("Average waiting time = " + (float) total_waitingTime / (float) noOfProcesses);

        System.out.println("Average turn around time = " + (float) total_turnAroundTime / (float) noOfProcesses);

    }

}
