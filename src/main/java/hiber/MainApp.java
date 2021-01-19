package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        System.out.println("111111 " + userService);

        Car car1 = new Car("Toyota Corolla", 2);
        Car car2 = new Car("Lada Granta", 3);
        Car car3 = new Car("Kia Rio", 4);
        Car car4 = new Car("Reno Duster", 5);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setCar(car1);
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        user2.setCar(car2);
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        user3.setCar(car3);
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        user4.setCar(car4);

        car1.setUser(user1);
        car2.setUser(user2);
        car3.setUser(user3);
        car4.setUser(user4);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);

        userService.addCar(car1);
        userService.addCar(car2);
        userService.addCar(car3);
        userService.addCar(car4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
