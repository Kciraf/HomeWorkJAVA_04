import java.io.File;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// В калькулятор добавьте возможность отменить последнюю операцию. (Не выполнил ранее ДЗ, потому воспользовался Вашим кодом калькулятора(((  

public class Exercise03 {
    public static void main(String[] args) {
        Deque<String> calcHistory = new ArrayDeque<String>();

        try {
            File file = new File("log.txt");
            FileWriter fileWriter = new FileWriter(file, );
            String flagContinue = "yes";

            while (flagContinue.equals("yes")) {
                
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите операцию (+ - * /): ");
            char op = scanner.nextLine().charAt(0);
            System.out.print("Введите второе число: ");
            int b = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case '+':
                    System.out.println(a + " + " + b + " = " + add(a, b));
                    fileWriter.write(a + " + " + b + " = " + add(a, b)  + '\n');
                    calcHistory.add(a + " + " + b + " = " + add(a, b));
                break;
                case '-':
                    System.out.println(a + " - " + b + " = " + minus(a, b));
                    fileWriter.write(a + " - " + b + " = " + minus(a, b) + '\n');
                    calcHistory.add(a + " - " + b + " = " + minus(a, b));
                break;
                case '*':
                    System.out.println(a + " * " + b + " = " + multi(a, b));
                    fileWriter.write(a + " * " + b + " = " + multi(a, b) + '\n');
                    calcHistory.add(a + " * " + b + " = " + multi(a, b));
                break;
                case '/':
                    System.out.println(a + " / " + b + " = " + divide(a, b));
                    fileWriter.write(a + " / " + b + " = " + divide(a, b) + '\n');
                    calcHistory.add(a + " / " + b + " = " + divide(a, b));
                break;
                default:
                    System.out.println("Wrong operation!");
                break;
            }
            System.out.println("Что делаем?\n Введите yes если продолжаем \n Введите del, если надо удалисть данные из истории и закончить \n Ведите что угодно другое для окончания ");
            flagContinue = (String) scanner.nextLine().toLowerCase();
            if (flagContinue.equals("del")) {
                calcHistory.removeLast();
                fileWriter.write("Выбрана операция удаления последнего действия из истории.");
            }
                      
        }
            fileWriter.write("Останов вычислений.");
            fileWriter.flush(); 
            fileWriter.close();
            System.out.println(calcHistory);
        }
        catch (Exception e){
            System.out.println("Исключение при работе с файлом.");
        }

    }

    private static int divide(int a, int b) {
        if (b != 0) return a / b;
        return -1;
    }

    private static int multi(int a, int b) {
        return a * b;
    }

    private static int minus(int a, int b) {
        return a - b;
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
