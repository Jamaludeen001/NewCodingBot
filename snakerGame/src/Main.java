import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int row,col;
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE GRID SIZE :");
        row=sc.nextInt();
        col=sc.nextInt();
        Snake snake=new Snake(row,col);
        snake.init();
    }
}
