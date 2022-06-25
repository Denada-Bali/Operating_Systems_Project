/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task.II;

import com.mycompany.task.I.Processes;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Denalda
 */
public class TestProcessesRandom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        /*Switch case to select one of the proces*/
        System.out.print("Select the process: \n 1. FCFS \n 2. SJF \n 3. RR \n");

        int process = input.nextInt();
        switch (process) {

            case 1:
                FCFSrandom();
                break;
            case 2:
                SJFrandom();
                break;
            case 3:
                RRrandom();
                break;
            default:
                System.out.print("Don't exist!! Try Again ");

        }

    }

    static void FCFSrandom() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of processes you want to store: \n");
        int noOfProcesses = input.nextInt();
        /* validate if the entered burst time is integer or not */
        try {
            validateBurstTimeFCFS(noOfProcesses);

        } catch (InputMismatchException ex) {
            System.out.println("Number not an integer. Try again!\n");
            validateBurstTimeFCFS(noOfProcesses);
        }

    }

    /* Function to execute SJF process*/
    private static void SJFrandom() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of processes you want to store: \n");
        int noOfProcesses = input.nextInt();
        /* validate if the entered burst time is integer or not */
        try {
            validateBurstTimeSJF(noOfProcesses);

        } catch (InputMismatchException ex) {
            System.out.println("Number not an integer. Try again!\n");
            validateBurstTimeSJF(noOfProcesses);
        }
    }

    private static void RRrandom() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of processes you want to store: \n");
        int noOfProcesses = input.nextInt();
        /* validate if the entered burst time is integer or not */
        try {
            validateBurstTimeRR(noOfProcesses);

        } catch (InputMismatchException ex) {
            System.out.println("Number not an integer. Try again!\n");
            validateBurstTimeRR(noOfProcesses);
        }

    }

    private static void validateBurstTimeFCFS(int noOfProcesses) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        ProcessesRandom pr = new ProcessesRandom();

        int nrOfProcesses;
        int min, max;

        /*Here I make a copy of all burstTime[], waitingTime[], and turnaroundTime[] to store remaining burst times*/
        int Process[] = new int[noOfProcesses];
        int burstTime[] = new int[noOfProcesses];
        int waitingTime[] = new int[noOfProcesses];
        int turnaroundTime[] = new int[noOfProcesses];

        /* Insert burst time for as many processes as requested by the user in random way*/
        System.out.println("Enter Range For Random Burst Times ");
        System.out.print("From: \n");
        min = input.nextInt();
        System.out.print("To: \n");
        max = input.nextInt();

        for (int i = 0; i < noOfProcesses; i++) {
            burstTime[i] = random.nextInt((max - min) + 1) + min;
            Process[i] = i + 1;
        }

        /* Call the function that helps me do the calculations*/
        pr.averageTime(Process, noOfProcesses, burstTime);

        System.out.print("\n");

        /* To see the execution order*/
        System.out.print("\nOrder of execution: ");
        for (int i = 0; i < noOfProcesses; i++) {

            System.out.print("P" + Process[i] + "(" + burstTime[i] + ")");
            // System.out.print("P" + (i + 1) + "(" + burstTime[i] + ")");
        }
    }

    static void validateBurstTimeSJF(int noOfProcesses) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        ProcessesRandom pr = new ProcessesRandom();

        int nrOfProcesses;
        int min, max;

        /*Here I make a copy of all burstTime[], waitingTime[], and turnaroundTime[] to store remaining burst times*/
        int process[] = new int[noOfProcesses];
        int burstTime[] = new int[noOfProcesses];
        int waitingTime[] = new int[noOfProcesses];
        int turnaroundTime[] = new int[noOfProcesses];

        /* Insert burst time for as many processes as requested by the user in random way*/
        System.out.println("Enter Range For Random Burst Times ");
        System.out.print("From: \n");
        min = input.nextInt();
        System.out.print("To: \n");
        max = input.nextInt();

        for (int i = 0; i < noOfProcesses; i++) {
            burstTime[i] = random.nextInt((max - min) + 1) + min;
            process[i] = i + 1;
        }
        /* Call the function that helps me do the calculations*/
        pr.averageTimeSJF(process, noOfProcesses, burstTime);

        System.out.print("\n");

        /* To see the execution order*/
        System.out.print("\nOrder of execution: ");
        for (int i = 0; i < noOfProcesses; i++) {

            System.out.print("P" + process[i] + "(" + burstTime[i] + ")");
        }
    }

    static void validateBurstTimeRR(int noOfProcesses) {

        ProcessesRandom pr = new ProcessesRandom();

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int nrOfProcesses;
        int min = 0, max = 0;

        /*Here I make a copy of all burstTime[], waitingTime[], and turnaroundTime[] to store remaining burst times*/
        int Process[] = new int[noOfProcesses];
        int burstTime[] = new int[noOfProcesses];
        int waitingTime[] = new int[noOfProcesses];
        int turnaroundTime[] = new int[noOfProcesses];

        /* Insert burst time for as many processes as requested by the user in random way*/
        System.out.println("Enter Range For Random Burst Times ");
        System.out.print("From: \n");
        min = input.nextInt();
        System.out.print("To: \n");
        max = input.nextInt();

        for (int i = 0; i < noOfProcesses; i++) {

            burstTime[i] = random.nextInt((max - min) + 1) + min;
            Process[i] = i + 1;
        }

        /* if we want the quantum time to be chosen by the user then the below way is valid.*/
        int quantum = 5;
//        System.out.println("\nEnter the Time Quantum:");
//        quantum = input.nextInt();

        /* Call the function that helps me do the calculations*/
        pr.averageTimeRR(Process, noOfProcesses, burstTime, quantum);

        System.out.print("\n");

        /* To see the execution order*/
        System.out.print("\nOrder of execution: ");
        for (int i = 0; i < noOfProcesses; i++) {

            System.out.print("P" + Process[i] + "(" + burstTime[i] + ")");

        }

    }
}
