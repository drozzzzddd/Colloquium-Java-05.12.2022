import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

       public class BookShelf {
           public static void main (String args[]){}
            private List<Book> books;
            private SortingStrategy sortStrategy;

            public BookShelf() {
                this.books = new ArrayList<Book>();
                this.sortStrategy = new TitleSort();
                ;
            }

            public List<Book> getBooks() {
                return this.books;
            }

            public void removeBook(Book book) {
                this.books.remove(book);
            }

            public void addBook(Book book) {
                this.books.add(book);
            }

            public void setSortStrategy(SortingStrategy strategy) {
                this.sortStrategy = strategy;
            }

            public void sortBookShelf() {
                this.books = this.sortStrategy.sort(this.books);
            }

            public void showBooks() {
                for (Book book : this.books) {
                    System.out.println("Title: " + book.getTitle() + ", Length: " + book.getLength());
                }
            }
        }

