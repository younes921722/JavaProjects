import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
           Scanner input = new Scanner(System.in);
           boolean status = true;
        try{
           while (status){
               System.out.println("-----Main__Menu-----");
               System.out.println("1- Display all books");
               System.out.println("2- Add book");
               System.out.println("3- Update book");
               System.out.println("4- Delete book");
               System.out.println("5- Search book");
               System.out.println("6- Exit");
               System.out.println("Enter your choice: ");


                       int choice = input.nextInt();
                       switch (choice){
                           case 1:
                               Book.dispalayAllBook();
                               break;
                           case 2:
                               Book.addbook(input);
                               break;
                           case 3:
                               if(Book.bookList.isEmpty()){
                                   System.out.println("There is no book to update !\nTry add some books clicking on the number 2");
                                   break;
                               }
//                               Book.updateBook(input);
                                 Book.updateWithString(input);
                                 status=Book.statusBoolean;
                               break;
                           case 4:
                               Book.deleteBook(input);

                               break;
                           case 5:
                               if(Book.bookList.isEmpty()){
                                   System.out.println("There is no book to look for !\nTry add some books clicking on the number 2");
                                   break;
                               }
                                System.out.println("Enter the name that you are looking for: ");
                                String bb = input.nextLine();
                                String Lfbook = input.nextLine();
                                Book foundBook = Book.getBookByName(Lfbook);
                                if(foundBook == null){
                                    System.out.println("The book not found !");
                                }
                                else {
                                    System.out.println("The book name: "+foundBook.getName());
                                    System.out.println("The book author: "+foundBook.getAuthor());
                                    System.out.println("The book price: "+foundBook.getPrice());
                                }
                               break;
                           case 6:
                               status = false;
                               System.out.println("The program powered off !");
                               break;
                           default:
                               System.out.println("Please try to enter un number between 1 and 6 !");

                       }

                   }
               }catch (Exception e) {
                    System.out.println(e.toString() + "\nTry enter a number in the menu please!");
                    main(args);// we called the function main again in the case of the error
                }

           }
        }
