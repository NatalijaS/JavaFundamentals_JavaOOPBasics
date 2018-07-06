package _03_Inheritance_Exercises._02_BookShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;

public class Main{
        public static void main(String[] args) throws IOException, IllegalClassFormatException {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String author = reader.readLine();
                String title = reader.readLine();
                Double price = Double.parseDouble(reader.readLine());

                Book book = new Book(author, title, price);
                GoldenEditionBook goldenEditionBook = new GoldenEditionBook( author, title, price);

                Method[] bookDeclaredMethods = Book.class.getDeclaredMethods();
                Method[] goldenBookDeclaredMethods = GoldenEditionBook.class.getDeclaredMethods();

                if (goldenBookDeclaredMethods.length > 1) {
                    throw new IllegalClassFormatException("Code duplication in GoldenEditionBook!");
                }

                System.out.println(book);
                System.out.println(goldenEditionBook);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
}
