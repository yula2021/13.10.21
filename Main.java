package org.itstep;


public class Main {

    public static void main(String[] args) {
Mixer mixer = new Mixer(18,60);
mixer.regulate(70, 30);
        System.out.println("Temp: "+ mixer.calcTemp());

Switch sw = new Switch();
sw.setState(true);
        System.out.println(sw.isState());

     Account account = new Account();
     account.addMoney(100);
        System.out.println("Cумма = "+ account.getAmount());

Book book = new Book("name", "auther", Genres.Fantasy);
       // System.out.println(book.toString());

        Compass compass = new Compass();
        compass.setAzimuth(50);
        System.out.println(compass.getDirect());

    }
}
class Mixer{
    private double coldTemp;
    private double hotTemp;
    private int cold;
    private int hot;

    Mixer(double coldTemp, double hotTemp){
        this.coldTemp = coldTemp;
        this.hotTemp = hotTemp;

    }
    public void regulate(int cold, int hot){
        if (cold<0) this.cold = 0;
        else if (cold>100) this.cold = 100;
        else this.cold = cold;
            if (hot<0) this.hot = 0;
        else if (hot>100) this.hot = 100;
        else this.hot = hot;
    }
    public double calcTemp(){
        double result = (cold*coldTemp+hot*hotTemp)/(cold+hot);
        return result;

    }
/*class IncorrectNominalException extends Exception {
    public IncorrectNominalException(String errorMessage) {
        super(errorMessage);*/

}
class  Switch{
    private boolean state = false;

    public boolean isState(){
        return state;
    }


    public void setState(boolean state) {
        this.state = state;
    }
}
class Account{
    private double amount = 0;

    public void addMoney(double summ){
        amount+=summ;
    }

    public double getAmount() {
        return amount;
    }
}

enum Genres{Fantasy, SciFi, Mystery, Thriller, Romance};
class Book{
    private String name;
    private String author;
    private int pages;
    private Genres genres;
    Book(String name, String author, Genres genre){
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.genres = genre;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public Genres getGenres() {
        return genres;
    }
    public String toString(){
        return String.format("Book: %s, author: %s, pages: %d ");
    }
}
enum Directions {NORTH, EAST, SOUTH, WEST};
class Compass{
    private int azimuth;

    public void setAzimuth(int azimuth) {
        this.azimuth = azimuth;
    }
    public Directions getDirect(){
        if ((azimuth > 315) || (azimuth < 45))
            return Directions.NORTH;
        else if (azimuth < 135) return Directions.EAST;
        else if (azimuth < 225) return Directions.SOUTH;
        else return Directions.WEST;

    }
}