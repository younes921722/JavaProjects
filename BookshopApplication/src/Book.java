import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;                       //used for GUI
import javax.swing.table.DefaultTableModel; //used for GUI
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public  class Book {

    static ArrayList<Book> bookList = new ArrayList<>();
    static boolean statusBoolean = true;

    private String name;
    private String author;
    private double price;

     Book(){
    }

    public Book(String bookname, String bookauthor, int bookprice){
        Book newBook = new Book();
        newBook.name = bookname;
        newBook.author = bookauthor;
        newBook.price = bookprice;
        bookList.add(newBook);
    }
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

//    public int getNumber_Of_Objects() {
//        return Number_Of_Objects;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public static void dispalayAllBook(){
//        ArrayList<Book> listBook = Book.bookList;
//        if(listBook.isEmpty()){
//            System.out.println("There is no data");
//        }
//        else {//System.out.print("Index        Book name          Book Author              Price\n");
//            int counter =0;
//            for (Book book:listBook){
//                System.out.print(counter+" :"+book.getName()+"          "+book.getAuthor()+"         "+book.getPrice()+"\n");
//                counter++;
//            }
//        }
//    }
    public static void dispalayAllBook(){
    ArrayList<Book> listBook = Book.bookList;
    if(listBook.isEmpty()){
        System.out.println("There is no data");
    }
    else {//System.out.print("Index        Book name          Book Author              Price\n");
        Object[][] data = new Object[listBook.size()][3];
        for (int i = 0; i < listBook.size(); i++) {
            Book obj = listBook.get(i);
            data[i][0] = obj.getName();
            data[i][1] = obj.getAuthor();
            data[i][2] = obj.getPrice();
        }
        String[] columnNames = {"Book Name", "Author","Price"};
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Create a JTable with the table model
        JTable table = new JTable(tableModel);

        // Create a JFrame to hold the table
        JFrame frame = new JFrame("ArrayList Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }

//        int counter =0;
//        for (Book book:listBook){
//            System.out.print(counter+" :"+book.getName()+"          "+book.getAuthor()+"         "+book.getPrice()+"\n");
//            counter++;
//        }
    }

    public static void addbook(Scanner input){
        try{
            System.out.print("Enter the count of books : ");
            int countbook = input.nextInt();
            if(countbook <= 0){
                System.out.print("Not valid value, pleas enter a value >0 ");
            }else
                for (int i = 1; i <= countbook;i++){
                    System.out.print("Enter the book name "+i+" : ");
                    String dn = input.nextLine();
                    String bn = input.nextLine();
                    System.out.print("Enter the author name "+i+" : ");
                    String author = input.nextLine();
                    boolean matchFound = true;
                    Integer price = 0;
                    while (matchFound){
                        System.out.print("Enter the book1 price "+i+" : ");
                        price = input.nextInt();
                        Pattern pattern = Pattern.compile("[a-z,A-Z,!,@,#,$,%,^,&,*,(,),=,-,+,|,\",',/,.,<,?,>,~,`,_,]", Pattern.CASE_INSENSITIVE);
                        Matcher matcher = pattern.matcher(price.toString());
                        matchFound = matcher.find(); // ! gives the inverse of the boolean value
                        if(matchFound){
                            System.out.println("Please enter a numerical value !");
                        }else break;
                    }
                    Book Book = new Book(bn,author,price);

                }
        }catch (Exception e){
            System.out.println("Error : "+e);
            System.out.print("Not valid value, pleas enter a value >0 ");
            input = new Scanner(System.in);
            addbook(input);
        }
    }
    public static void updateBook(Scanner input){
        boolean bool = true;
        while(bool) {
            System.out.println("-----Update_Menu-----");
            System.out.println("1- Update book name");
            System.out.println("2- Update book author");
            System.out.println("3- Update book price");
            System.out.println("4- Back to Main Menu");
            System.out.println("5- Exit program");
            System.out.println("Enter your choice: ");
            int updateChoice = input.nextInt();

            switch (updateChoice) {
                case 1:
                    Book.dispalayAllBook();
                    System.out.print("Enter the index of the book that you want to change its name: ");
                    int book_index = input.nextInt();
                    System.out.print("Enter the new book name:");
                    String new_book_name = input.next();
                    Book oldBook = Book.bookList.get(book_index);
                    oldBook.setName(new_book_name);
                    System.out.print("The book name updated successfully\n");
                    break;
                case 2:
                    Book.dispalayAllBook();
                    System.out.print("Enter the index of the book that you want to change its author: ");
                    int author_index = input.nextInt();
                    System.out.print("Enter the new book author:");
                    String new_author_name = input.next();
                    Book oldAuthor = Book.bookList.get(author_index);
                    oldAuthor.setAuthor(new_author_name);
                    System.out.print("The book author updated successfully\n");
                    break;
                case 3:
                    Book.dispalayAllBook();
                    System.out.print("Enter the index of the book that you want to change its price: ");
                    int price_index = input.nextInt();
                    System.out.print("Enter the new book price:");
                    double new_price_name = input.nextDouble();
                    Book oldPrice = Book.bookList.get(price_index);
                    oldPrice.setPrice(new_price_name);
                    System.out.print("The book price updated successfully\n");
                    break;
                case 4:
                    bool = false;
                    break;
                case 5:

                    break;
            }
        }
    }
    public static void deleteBook(Scanner input){
        if(Book.bookList.isEmpty()){
            System.out.println("There is no book to delete !");
        }else
        {
              Book.dispalayAllBook();
              System.out.print("Enter the name of the book that you want to delete: ");
//            Book.bookList.remove(deleteBookIndex);
              String deleteBookIndex = input.nextLine();
              String deleteBookName = input.nextLine();
              Book book = getBookByName(deleteBookName);
              if(book == null){
                  System.out.println("---->The book does not exist !");
              }else {
                  Book.bookList.remove(book);
                  System.out.println("The book has been deleted successfully !");
              }
        }
    }
    public static void updateWithString(Scanner input){
        boolean bool = true;
        while(bool) {
            System.out.println("-----Update_Menu-----");
            System.out.println("1- Update book name");
            System.out.println("2- Update book author");
            System.out.println("3- Update book price");
            System.out.println("4- Back to Main Menu");
            System.out.println("5- Exit program");
            System.out.println("Enter your choice: ");
            int updateChoice = input.nextInt();

            switch (updateChoice) {
                case 1:
                    Book.dispalayAllBook();
                    System.out.print("Enter the name of the book that you want to change its name: ");
                    String bookiName = input.nextLine();
                    String book_name = input.nextLine();
                    Book book = Book.getBookByName(book_name);

                    if (book == null){
                        System.out.println("---->There is no book with this name!");
                    }else{
                        System.out.print("Enter the new book name:");
                        String new_book_name = input.nextLine();
                        book.setName(new_book_name);
                        System.out.print("---->The book name \""+book_name+"\" updated to \""+new_book_name+"\" successfully\n");
                    }

//                    Book oldBook = Book.bookList.get(book_index);
//                    oldBook.setName(new_book_name);
                    break;
                case 2:
                    Book.dispalayAllBook();
                    System.out.print("Enter the name of the book that you want to change its author: ");
                    String authorName = input.nextLine();
                    String book1_name = input.nextLine();
                    Book book1 = Book.getBookByName(book1_name);
                    if (book1 == null){
                        System.out.println("---->There is no book with this name!");
                    }else{
                        System.out.print("Enter the new author name of this book:");
                        String new_book_author_name = input.nextLine();
                        book1.setAuthor(new_book_author_name);
                        System.out.print("---->The author name of\""+book1_name+"\" updated successfully\n");
                    }
                    break;
                case 3:
                    Book.dispalayAllBook();
                    System.out.print("Enter the name of the book that you want to change its price: ");
                    String autoName = input.nextLine();//Must be checked later
                    String book2_name = input.nextLine();
                    Book book2 = Book.getBookByName(book2_name);
                    if (book2 == null){
                        System.out.println("---->There is no book with this name!");
                    }else{
                        System.out.print("Enter the new price of this book:");
                        double new_book_price = input.nextDouble();
                        book2.setPrice(new_book_price);
                        System.out.print("---->The price of\""+book2_name+"\" updated to \""+new_book_price+"\" successfully\n");
                    }
                    break;
                case 4:
                    bool = false;
                    break;
                case 5:
                    bool  = false;           // To exit the program we need to exit the loop for th Update Menu
                    statusBoolean = false;   // then assign false to the static attribute which will assign the false value to Main Menu in the main class
                    System.out.println("System powered off !");
                        break;               // the static attributes are the same as global variables

            }
        }

    }
    public static boolean exitFromUpdateMenu(Scanner input){
         int exitChoice = input.nextInt();
        return exitChoice != 5;
    }

    public static Book getBookByName(String name){ // the methods in java c and C++ can only return one value.
         for(Book book : bookList){
             if (book.name.equals(name)){
                 return book;
             }
         }
         return null;
    }
}
