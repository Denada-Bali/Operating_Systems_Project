/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.task.I;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Denalda
 */
public class TestProcesses {

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
                fcfs();
                break;
            case 2:
                sjf();
                break;
            case 3:
                rr();
                break;
            default:
                System.out.print("Don't exist!! Try Again ");
        }
    }

    /* Function to execute FCFS process*/
    static void fcfs() {
        /* I called the class where the methods are built*/
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of processes you want to store: \n");
        int noOfProcesses = input.nextInt();

        /* validate if the entered burst time is integer or not */
        try {
            validateBurstTimeFCFS(noOfProcesses);

        } catch (InputMismatchException ex) {
            System.out.println("Number not an integer. Try again!");
            validateBurstTimeFCFS(noOfProcesses);
        }
    }

    /* Function to execute SJF process*/
    static void sjf() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of processes you want to store: \n");
        int processes = input.nextInt();

        int noOfProcesses = processes;
        /* validate if the entered burst time is integer or not */
        try {
            validateBurstTimeSJF(noOfProcesses);

        } catch (InputMismatchException ex) {
            System.out.println("Number not an integer. Try again!");
            validateBurstTimeSJF(noOfProcesses);
        }
    }

    /* Function to execute RR process*/
    static void rr() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of processes you want to store: \n");
        int noOfProcesses = input.nextInt();

        /* validate if the entered burst time is integer or not */
        try {
            validateBurstTimeRR(noOfProcesses);

        } catch (InputMismatchException ex) {
            System.out.println("Number not an integer. Try again!");
            validateBurstTimeRR(noOfProcesses);
        }
    }

    static void validateBurstTimeFCFS(int noOfProcesses) {

        Processes myProcess = new Processes();
        Scanner input = new Scanner(System.in);

        /*Here I make a copy of all burstTime[], waitingTime[], and turnaroundTime[] to store remaining burst times*/
        int Process[] = new int[noOfProcesses];
        int burstTime[] = new int[noOfProcesses];
        int waitingTime[] = new int[noOfProcesses];
        int turnaroundTime[] = new int[noOfProcesses];

        /* Insert burst time for as many processes as requested by the user*/
        for (int i = 0; i < noOfProcesses; i++) {

            System.out.println("Enter Burst Time For Process " + (i + 1) + ": ");
            burstTime[i] = input.nextInt();
            Process[i] = i + 1;
        }

        /* Call the function that helps me do the calculations*/
        myProcess.averageTime(Process, noOfProcesses, burstTime);

        System.out.print("\n");

        /* To see the execution order*/
        System.out.print("\nOrder of execution: ");
        for (int i = 0; i < noOfProcesses; i++) {

            System.out.print("P" + Process[i] + "(" + burstTime[i] + ")");
            // System.out.print("P" + (i + 1) + "(" + burstTime[i] + ")");
        }
    }

    static void validateBurstTimeSJF(int noOfProcesses) {
        Processes myProcess = new Processes();

        Scanner input = new Scanner(System.in);

        /*Here I make a copy of all burstTime[], waitingTime[], and turnaroundTime[] to store remaining burst times*/
        int process[] = new int[noOfProcesses];
        int burstTime[] = new int[noOfProcesses];
        int waitingTime[] = new int[noOfProcesses];
        int turnaroundTime[] = new int[noOfProcesses];

        /* Insert burst time for as many processes as requested by the user*/
        for (int i = 0; i < noOfProcesses; i++) {
            System.out.println("Enter Burst Time For Process " + (i + 1) + ": ");
            burstTime[i] = input.nextInt();
            process[i] = i + 1;

        }
        /* Call the function that helps me do the calculations*/
        myProcess.averageTimeSJF(process, noOfProcesses, burstTime);

        System.out.print("\n");

        /* To see the execution order*/
        System.out.print("\nOrder of execution: ");
        for (int i = 0; i < noOfProcesses; i++) {

            System.out.print("P" + process[i] + "(" + burstTime[i] + ")");
        }

    }

    static void validateBurstTimeRR(int noOfProcesses) {
        Processes myProcess = new Processes();

        Scanner input = new Scanner(System.in);

        /*Here I make a copy of all burstTime[], waitingTime[], and turnaroundTime[] to store remaining burst times*/
        int Process[] = new int[noOfProcesses];
        int burstTime[] = new int[noOfProcesses];
        int waitingTime[] = new int[noOfProcesses];
        int turnaroundTime[] = new int[noOfProcesses];

        /* Insert burst time for as many processes as requested by the user*/
        for (int i = 0; i < noOfProcesses; i++) {
            System.out.println("Enter Burst Time For Process " + (i + 1) + ": ");
            burstTime[i] = input.nextInt();
            Process[i] = i + 1;
        }

        /* if we want the quantum time to be chosen by the user then the below way is valid.*/
        int quantum = 5;
//        System.out.println("\nEnter the Time Quantum:");
//        quantum = input.nextInt();

        /* Call the function that helps me do the calculations*/
        myProcess.averageTimeRR(Process, noOfProcesses, burstTime, quantum);

        System.out.print("\n");

        /* To see the execution order*/
        System.out.print("\nOrder of execution: ");
        for (int i = 0; i < noOfProcesses; i++) {

            System.out.print("P" + Process[i] + "(" + burstTime[i] + ")");
        }
    }
}
