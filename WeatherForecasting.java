import java.util.ArrayList;
import java.util.List;

public class WeatherForecasting {
    List<User> subscribers;

    public WeatherForecasting() {
        subscribers = new ArrayList<>();
    }

    public void addUser(User user) {
        subscribers.add(user);
    }

    public void removeUser(User user) {
        subscribers.remove(user);
    }

    public void notifyUsers() {
        // here is app will judge the users location ,geographical data like temperature
        // and upddate the condition of the user accordingly
        for (User user : subscribers)
            user.update("Weather Condition for "+user.toString());
    }

}

class User {
    public String condition;
    public String name;

    public User(String name) {
        this.name=name;
        this.condition = "Default Condition";
    }

    public void update(String condition) {
        this.condition = condition;
    }
    public String toString(){
        return name;
    }
}

class Main{
    public static void main(String[] args) {
        WeatherForecasting weatherForecasting=new WeatherForecasting();
        User spongobob=new User("spongebob");
        User patrick=new User("patrick");

        weatherForecasting.addUser(patrick);
        weatherForecasting.addUser(spongobob);
        weatherForecasting.notifyUsers();
        System.out.println(spongobob.condition);
        System.out.println(patrick.condition);
    }
}