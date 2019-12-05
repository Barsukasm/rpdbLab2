package models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Rents")
public class Rents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Clients client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item")
    private Inventory item;

    @Column(name = "rent_end")
    private LocalDate rentEnd;

    @Column(name = "rent_start")
    private LocalDate rentStart;

    public Rents(){}

    public Rents(Clients client, Inventory item,LocalDate rentStart){
        this.client = client;
        this.item = item;
        this.rentStart = rentStart;
    }

    public int getId() {
        return id;
    }

    public Clients getId_client() {
        return client;
    }

    public void setId_client(Clients client) {
        this.client = client;
    }

    public Inventory getId_item() {
        return item;
    }

    public void setId_item(Inventory item) {
        this.item = item;
    }

    public LocalDate getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(LocalDate rentEnd) {
        this.rentEnd = rentEnd;
    }

    public LocalDate getRentStart() {
        return rentStart;
    }

    public void setRentStart(LocalDate rentStart) {
        this.rentStart = rentStart;
    }

    @Override
    public String toString() {
        return "Rents{" +
                "id=" + id +
                ", id_client=" + client +
                ", id_item=" + item +
                ", rentEnd=" + rentEnd +
                ", rentStart=" + rentStart +
                '}';
    }
}
