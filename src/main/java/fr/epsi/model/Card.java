package fr.epsi.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "card")
public class Card implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private int numero;
    private String date;
    private int code;

    @ManyToOne(fetch = FetchType.EAGER)
    private Admin admins;


    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setAdmins(Admin admins) {
        this.admins = admins;
    }

    public Admin getAdmins() {
        return admins;
    }
}
