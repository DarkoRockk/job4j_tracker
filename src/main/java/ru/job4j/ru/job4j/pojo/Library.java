package ru.job4j.ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("\"Clean code\"", 345);
        Book book2 = new Book("\"Dracula\"", 567);
        Book book3 = new Book("\"Harry Potter\"", 387);
        Book book4 = new Book("\"Lord of the rings\"", 765);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Book: " + book.getName() + " pages: " + book.getPages());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Book: " + book.getName() + " pages: " + book.getPages());
        }
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean code")) {
                System.out.println("Book: " + book.getName() + " pages: " + book.getPages());
            }
        }

    }
}
