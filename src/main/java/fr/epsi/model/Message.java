package fr.epsi.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String texte;
    private int note;

    public Message() {
        this.setNote(0);

    }

    public void like (User who){
        if(who.getId() != getUser().getId()){
            this.setNote(getNote()+1, who);
        }
    }

    public void dislike (User who){
        if(who.getId() != getUser().getId()){
            this.setNote(getNote()-1, who);
        }
    }


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Channel channel;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<User> whoLike;

    public void setId(long id) { this.id = id; }

    public long getId() { return id; }

    public void setTexte(String texte) { this.texte = texte; }

    public String getTexte() { return texte; }

    public void setUser(User user) { this.user = user; }

    public User getUser() { return user; }

    public void setWhoLike(List<User> whoLike) {
        this.whoLike = whoLike;
    }

    public List<User> getWhoLike() {
        return whoLike;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

    public boolean islike(long id){
        for(User u : getWhoLike()){
            if (u.getId() == id){
                return true;
            }
        }
        return false;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setNote(int note, User u) {
        if(!islike(u.getId())) {
            this.note = note;
            getWhoLike().add(u);
        }
    }

    public int getNote() {
        return note;
    }



}
