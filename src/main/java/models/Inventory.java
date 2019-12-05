package models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_prod")
    private LocalDate dateProd;

    @Column(name = "size")
    private int size;

    @Column(name = "type")
    private String type;


    public Inventory(){}

    public Inventory(LocalDate dateProd, String type, int size){
        this.dateProd = dateProd;
        this.type = type;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateProd() {
        return dateProd;
    }

    public void setDateProd(LocalDate dateProd) {
        this.dateProd = dateProd;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "models.Inventory{" +
                "id=" + id +
                ", date_prod=" + dateProd.toString() +
                ", size=" + size +
                ", type=" + type +
                "}";
    }
}
