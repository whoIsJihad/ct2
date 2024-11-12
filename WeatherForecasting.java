import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public void alert(){
        String[] conditions = {"Possibilty of Snow", "Possibility of Storm"};

        // Create an instance of Random
        Random random = new Random();

        // Generate a random index between 0 and the last index of the array
        for(User user:subscribers){
            int randomIndex = random.nextInt(conditions.length);
            user.alertUser(conditions[randomIndex]);
        }

    }


}

class User {
    public String condition;
    public String name;
    public String severeWeather;

    public User(String name) {
        this.name=name;
        this.condition = "Default Condition";
    }

    public void update(String condition) {
        this.condition = condition;
    }
    public void alertUser(String severeWeather){
        this.severeWeather=severeWeather;
    }
    public String toString(){
        return name;
    }
    public void displayWeather(){
        System.out.println(this.condition);
        System.out.println(this.severeWeather);
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
        weatherForecasting.alert();
        spongobob.displayWeather();
        patrick.displayWeather();
    }
}