package examples;


import java.util.List;

public class Main {

    public static void main(String args[]) {
        WorkWithDB.connect();
/*        List<User> users = WorkWithDB.selectAll();
        outputList( users );
*/
        User user = new User("Maria","maria@ya.ru");
        WorkWithDB.insert(user);
        outputList( WorkWithDB.selectAll() );

        WorkWithDB.disconnect();
    }

    public static void outputList(List list){
        list.forEach(System.out::println);
    }
}
