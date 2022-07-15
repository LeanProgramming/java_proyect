package entity;

import java.io.InputStream;

public class Juegos {

    private int id_game;
    private String name;
    private String first_release_title;
    private String first_release_console;
    private int first_release_year;
    private String last_release_title;
    private String last_release_console;
    private int last_release_year;
    private String company;
    private InputStream img;

    public Juegos(int id_game, String name, String first_release_title, String first_release_console, int first_release_year, String last_release_title, String last_release_console, int last_release_year, String company) {
        this.id_game = id_game;
        this.name = name;
        this.first_release_title = first_release_title;
        this.first_release_console = first_release_console;
        this.first_release_year = first_release_year;
        this.last_release_title = last_release_title;
        this.last_release_console = last_release_console;
        this.last_release_year = last_release_year;
        this.company = company;
    }

    public Juegos(String name, String first_release_title, String first_release_console, int first_release_year, String last_release_title, String last_release_console, int last_release_year, String company) {
        this.name = name;
        this.first_release_title = first_release_title;
        this.first_release_console = first_release_console;
        this.first_release_year = first_release_year;
        this.last_release_title = last_release_title;
        this.last_release_console = last_release_console;
        this.last_release_year = last_release_year;
        this.company = company;
    }

    public int getId_game() {
        return id_game;
    }

    public String getName() {
        return name;
    }

    public String getFirst_release_title() {
        return first_release_title;
    }

    public String getFirst_release_console() {
        return first_release_console;
    }

    public int getFirst_release_year() {
        return first_release_year;
    }

    public String getLast_release_title() {
        return last_release_title;
    }

    public String getLast_release_console() {
        return last_release_console;
    }

    public int getLast_release_year() {
        return last_release_year;
    }

    public String getCompany() {
        return company;
    }

    public InputStream getImg() {
        return img;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirst_release_title(String first_release_title) {
        this.first_release_title = first_release_title;
    }

    public void setFirst_release_console(String first_release_console) {
        this.first_release_console = first_release_console;
    }

    public void setFirst_release_year(int first_release_year) {
        this.first_release_year = first_release_year;
    }

    public void setLast_release_title(String last_release_title) {
        this.last_release_title = last_release_title;
    }

    public void setLast_release_console(String last_release_console) {
        this.last_release_console = last_release_console;
    }

    public void setLast_release_year(int lastt_release_year) {
        this.last_release_year = lastt_release_year;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }
    
    @Override
    public String toString() {
        return "Juegos{" + "Posición=" + id_game + ", Serie=" + name + ", Primer Lanzamiento=" + first_release_title + ", Consola=" + first_release_console + ", Año=" + first_release_year + ", Último Lanzamiento=" + last_release_title + ", Consola=" + last_release_console + ", Año=" + last_release_year + ", Compañía=" + company + '}';
    }

    
    
}
