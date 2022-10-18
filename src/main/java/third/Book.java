package third;

public class Book {

    private String name;
    private String author;
    private Integer rate;
    private Integer pages;

    public Book(String name, String author, Integer rate, Integer pages) {
        this.name = name;
        this.author = author;
        this.rate = rate;
        this.pages = pages;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
