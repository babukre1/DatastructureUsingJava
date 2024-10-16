public class Book {
    private String title, author, year;

    Book() {
        title = "C#";
        author = "James";
        year = "2002";
    }
    public void setBookDetails(String myTitle, String myAuthor, String myYear) {
        title = myTitle;
        author = myAuthor;
        year = myYear;
    }

    public void display() {
        System.out.println("Title: " + title + " Author: " + author + " Year Published: " + year);
    }

}
