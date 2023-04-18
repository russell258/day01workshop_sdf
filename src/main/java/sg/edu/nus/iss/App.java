package sg.edu.nus.iss;
import java.util.Scanner;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //shoppingCart array list to hold the items
        List<String> cartItems = new ArrayList<String>();
        
        //open console for input from keyboard
        Console con = System.console();

        String input = "";

        System.out.println("Welcome to your shopping cart");
        while (!input.equals("quit")){
            input = con.readLine("Type 'help' to show list of commands>>");

            if (input.equals("help")){
                System.out.println("'list' to show a list of items in the shopping cart");
                System.out.println("'add <item name>, ...");
                System.out.println("'delete' <item number>");
                System.out.println("'quit' to terminate the program");
            }

            if (input.startsWith("add")){
            // do something here
            input = input.replace(',',' ');
            Scanner scan = new Scanner (input.substring(4));

            String content ="";
            while (scan.hasNext()){
                content = scan.next();
                cartItems.add(content);
                } 
                if (cartItems.contains(content)){
                    System.out.println(content+ " already in cart");
                }else{
                    cartItems.add(content);
                }
            }
            if (input.equals("list")){
                int i = 0;
                for (String item: cartItems){
                    i++;
                    System.out.println(i + ". " + item);
                }
            }
            if (input.startsWith("delete")){
                Scanner scan = new Scanner(input.substring(6));
                String content = "";
                while (scan.hasNext()){
                    content = scan.next();
                    int listIndex = Integer.parseInt(content);

                    if (listIndex <cartItems.size()){
                        cartItems.remove(listIndex);
                    } else {
                        System.err.println("Incorrect item index");
                    }
                }
            }
        }
    }
}
