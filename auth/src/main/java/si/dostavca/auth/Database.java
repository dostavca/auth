package si.dostavca.auth;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Database {

    private List<User> users = new ArrayList<>();

    void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        User user1 = new User();
        user1.setUsername("zanozbot");
        user1.setPassword("geslo");

        User user2 = new User();
        user2.setUsername("aljazb");
        user2.setPassword("geslo");

        users.add(user1);
        users.add(user2);
    }

    public boolean checkUser(User user) {
        for (User u : users) {
            if(u.getUsername().equals(user.getUsername())
                    && u.getPassword().equals(user.getPassword()))
                return true;
        }
        return false;
    }

}
