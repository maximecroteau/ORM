package fr.epsi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin extends User {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Card> card;

    public Admin(){
        List<Card> cr = new ArrayList<>();
        this.setCard(cr);
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public List<Card> getCard() {
        return card;
    }
}