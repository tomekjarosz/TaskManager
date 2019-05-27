import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TaskManager {

    Scanner sc = new Scanner(System.in);
    private Queue<Task> lowQueue = new LinkedList<>();
    private Queue<Task> highQueue = new LinkedList<>();

    void controlLoop(){

        int userOption = -1;

        do {

            System.out.println("co chcesz zrobić?");
            System.out.println("0 - koniec programu");
            System.out.println("1 - dodać zadanie");
            System.out.println("2 - wyświetlić zadanie do wykonania");
            System.out.println("3 - pokaż wszystkie zadania");

            userOption = sc.nextInt();
            sc.nextLine();

            switch (userOption) {

                case 1:
                    addTask();
                    break;

                case 2:
                    pickTask();
                    break;

                case 3:
                    displayTasks();
                    break;
            }

        } while (userOption!=0);

    }

    private void addTask(){

        System.out.println("tworzymy nowy task!");
        System.out.println("podaj nazwę:");
        String name = sc.nextLine();
        System.out.println("podaj opis:");
        String desc = sc.nextLine();
        System.out.println("podaj priorytet (wysoki/niski)");
        String priority = sc.nextLine();

        Task task = new Task(name, desc);

        switch (priority){

            case "wysoki":
                highQueue.offer(task);
                break;
            case "niski":
                lowQueue.offer(task);
                break;

            default:
                lowQueue.offer(task);
        }
    }

    private void pickTask(){

        if(highQueue.peek()!=null){
            System.out.println(highQueue.poll().toString());
        } else if (lowQueue.peek()!=null){
            System.out.println(lowQueue.poll().toString());
        } else {
            System.out.println("nie ma nic do roboty");
        }
    }

    private void displayTasks(){

        System.out.println("zadania PRIORYTETOWE: ");

        for (Task item:highQueue){
            System.out.println(item.toString());
        }

        System.out.println("zadania POZOSTAŁE: ");

        for (Task item:lowQueue){
            System.out.println(item.toString());
        }
    }
}
