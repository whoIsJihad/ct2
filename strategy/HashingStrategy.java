package strategy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public interface HashingStrategy {
    String hash(String str);
}

class MD5Hashing implements HashingStrategy {
    public String hash(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(str.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

class SHA256Hashing implements HashingStrategy{
    public String hash(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(str.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

class HashingContext{
    HashingStrategy hashingStrategy;
    
    public void setStrategy(HashingStrategy hashingStrategy){
        this.hashingStrategy=hashingStrategy;
    }

    public String  generateHash(String str){
        if(hashingStrategy!=null){
            return hashingStrategy.hash(str);
        }
        return "No strategy set";
    }
}
class Main{
    public static void main(String[] args) {
        String str="Lets put a smile on that face";
        HashingContext hashingContext=new HashingContext();
        hashingContext.setStrategy(new MD5Hashing());
        System.out.println(hashingContext.generateHash(str));
        hashingContext.setStrategy(new SHA256Hashing());
        System.out.println(hashingContext.generateHash(str));

    }
}