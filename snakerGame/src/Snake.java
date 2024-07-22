import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class Snake {
    private char[][] snakeboard=null;
    private Queue<Node> queue=new LinkedList<Node>();
    int n,r,c;
    Scanner sc=new Scanner(System.in);

    Snake(int row,int col){
        snakeboard=new char[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                snakeboard[i][j]='0';
            }
        }
        queue.add(new Node(0,0));
        System.out.println("Enter number of positions where food to be added");
        this.n=sc.nextInt();
        System.out.println("enter positions : ");
        for(int i=0;i<n;i++){
            r=sc.nextInt();
            c=sc.nextInt();
            snakeboard[r][c]='X';

        }
        queue.add(new Node(0,0));

    }

    public void init(){
        System.out.println("Enter start position");
        int r,c;
        r=sc.nextInt();
        c=sc.nextInt();
        move(r,c);   

    }

    public void move(int r,int c){
        if (r>=0 && c>=0 && r<snakeboard.length && c<snakeboard[0].length){
            queue.add(new Node(r,c));
            if (snakeboard[r][c]=='.'){
                System.out.println("snake bitten");
                System.out.println("Game Over");
                System.exit(0);
            }
            else if (snakeboard[r][c]=='X'){
                n=n-1;
                snakeboard[r][c]='.';
            }
            else{
                Node node=queue.poll();
                System.out.print(node.getrow());
                System.out.println(node.getcol());
                System.out.println(r);
                snakeboard[node.getrow()][node.getcol()]='0';
                snakeboard[r][c]='.';

            }

            if (n==0){
                System.out.println("You won");
                System.exit(0);
            }
            else{
                display();
                System.out.println("Enter next position to move as L,R,U,D");
                char m=sc.next().charAt(0);
                if (m=='L'){
                    move(r,--c);
                }
                else if(m=='R'){
                    move(r,++c);
                }
                else if(m=='U'){
                    move(--r,c);
                }
                else{
                    move(++r,c);
                }

            }
            
        }
        else{
            System.out.println("you hitted");
            System.out.println("Game Over");
            System.exit(0);
        }

    }
    public void display(){
        System.out.print(snakeboard.length);
        System.out.println(snakeboard[0].length);
        for( char[] chars:snakeboard){
            for(int j=0;j<snakeboard[0].length;j++){
                System.out.print(chars[j]+" ");
            }
            System.out.println();
        }
    }

}
