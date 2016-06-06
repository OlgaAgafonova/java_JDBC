package examples;


import java.util.List;

public class Main {

    public static void main(String args[]) {
        WorkWithDB.connect();
/*        List<User> users = WorkWithDB.selectAll();
        outputList( users );
*/
  /*      User user = new User("Maria",3,"maria@ya.ru");
        User user2 = new User("Maria",5,"maria@ya.ru");
        WorkWithDB.insert(user);
        WorkWithDB.insert(user2);
        outputList( WorkWithDB.selectAll() );


        WorkWithDB.deleteByAge(3);
        outputList( WorkWithDB.selectAll() );
        WorkWithDB.deleteByName("Maria");
*/

        WorkWithDB.updateNameByID("Freddy",10);
        outputList( WorkWithDB.selectAll() );

        WorkWithDB.disconnect();
    }

    public static void outputList(List list){
        list.forEach(System.out::println);
    }
}
