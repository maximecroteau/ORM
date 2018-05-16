package fr.epsi.dao;

import fr.epsi.model.*;
import org.junit.Test;

import javax.persistence.PersistenceException;

public class UserDaoTest {

    /**
    @Test
    public void insertUser() {
        User user = new User();
        user.setFirstname("Benjamin");
        user.setLastname("Tourman");

        System.out.println(new UserDao().save(user));
    }

    @Test
    public void getUser() {
        User u = new UserDao().get(1);
        System.out.println(u.getFirstname());
    }

    @Test(expected = PersistenceException.class)
     public void uniqueEmail() {
                User user1 = new User();
                user1.setFirstname("Benjamin");
                user1.setLastname("Tourman");
                user1.setEmail("tourman.benjamin@gmail.com");

                User user2 = new User();
                user2.setFirstname("Test");
                user2.setLastname("Test");
                user2.setEmail("tourman.benjamin@gmail.com");

                new UserDao().save(user1);
                new UserDao().save(user2);
    }


    @Test
    public void insertMessage() {

        Channel channel = new Channel();
        channel.setTitle("Channel 1");

        User user = new User();
        user.setFirstname("Maxime");
        user.setLastname("Croteau");
        user.setUsername("Max");
        user.setPassword("motdepasse");
        user.getChannels().add(channel);

        Message msg = new Message();
        msg.setTexte("Voici un message");
        msg.setUser(user);
        msg.setChannel(channel);

        channel.getUsers().add(user);
        channel.getMessages().add(msg);

        System.out.println(new ChannelDao().save(channel));
        System.out.println(new UserDao().save(user));
        System.out.println(new MessageDao().save(msg));

        System.out.println(channel.getId());

    }

    @Test
    public void getChannel() {
        Channel c = new ChannelDao().get(6);
        System.out.println(c.getTitle());
        System.out.println(c.getMessages().get(1).getTexte());
        System.out.println(c.getUsers().get(1).getUsername());
        System.out.println(c.getUsers().get(1).getPassword());
    }

    @Test
    public void getMessage() {

        Channel channel = new ChannelDao().get(6);
        Message msg = channel.getMessages().get(1);
        User user = msg.getUser();

        System.out.println("Note : " + msg.getNote());
        msg.like(user);
        System.out.println("Note : " + msg.getNote());

        User user2 = new User();
        user2.setFirstname("Ma");
        user2.setLastname("cr");
        user2.setUsername("Maxcr");
        user2.setPassword("motdepasse");
        user2.getChannels().add(channel);

        msg.like(user2);
        System.out.println("Note : " + msg.getNote());


    } **/

    @Test
    public void getCard(){
        Admin admin = new Admin();
        admin.setFirstname("Admin");
        admin.setLastname("Admin");
        admin.setUsername("Adm");
        admin.setPassword("root");

        Card card = new Card();
        card.setNumero(123456789);
        card.setDate("04/19");
        card.setCode(123);
        card.setAdmins(admin);

        admin.getCard().add(card);

        new AdminDao().save(admin);
        new CardDao().save(card);
    }

}
