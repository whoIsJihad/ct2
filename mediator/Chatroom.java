package mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chatroom {
    List<User>users;
    List<String>messages;
    public Chatroom(){
        users = new ArrayList<>();
        messages=new ArrayList<>();
    }
    public void registerUser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        users.remove(user);
    }

    public void sendMessage(User user,String recipientName,String message){
        for(User u:users){
            if(u.name.equalsIgnoreCase(recipientName)){
                u.receiveMessage(user,message);
                String data;
                data = "from :"+user.name + "\n" + message + "\nto :" + recipientName;
                messages.add(data);
            }
        }
    }

    public void getMessageHistory(User user){
        System.out.println("Message History of "+user.name);
        for(User u:users){
            if(u.name.equalsIgnoreCase(user.name)){
                User recipient=u ;
                recipient.messages.forEach((sender, msg) -> {
                    System.out.println(sender.name + " : " + msg);
                });
            }
        }
    }
}

class User{
    public String name;
    public Chatroom chatroom;
    public HashMap<User,String> messages;
    public User(String name,Chatroom chatroom){
        this.name=name;
        this.chatroom=chatroom;
        this.messages=new HashMap<>();
    }

    public void sendMessage(String recipientName,String message){
        chatroom.sendMessage(this,recipientName,message);
    }
    public void receiveMessage(User user,String message){
        messages.put(user, message);
    }
}

class Main{
    public static void main(String[] args) {
        Chatroom chatroom=new Chatroom();
        User spongebob=new User("Spongebob", chatroom);
        chatroom.registerUser(spongebob);
        User patrick =new User("Patrick", chatroom);
        chatroom.registerUser(patrick);
        
        patrick.sendMessage("spongebob", "welcome back to reality,spongebob");
        spongebob.sendMessage("patrick", "I am just ahead of the curve,patrick");
        chatroom.getMessageHistory(patrick);
        chatroom.getMessageHistory(spongebob);
    }
}