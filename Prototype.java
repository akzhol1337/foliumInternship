interface Prototypeable {
    Prototypeable createClone();
}

class Laptop implements Prototypeable{
    private String name;
    private Double diagonal;
    private String OS;
    private int price;

    Laptop(String name, Double diagonal, String OS, int price){
        this.name = name;
        this.diagonal = diagonal;
        this.OS = OS;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiagonal(Double Diagonal) {
        this.diagonal = Diagonal;
    }

    public void setOS(String OS) {
        this.OS = OS;
        
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getlaptopName() {
        return this.name;
    }

    public Double getDiagonal() {
        return this.diagonal;
    }

    public String getOS() {
        return this.OS;
    }

    public int getPrice() {
        return this.price;
    }

    public Prototypeable createClone() {
        return new Laptop(name, diagonal, OS, price);
    }

    public String toString(){
        return name + " " + diagonal + " " + OS + " " + price;
    }
}

public class Prototype {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Macbook Pro", 14.0, "Mac Os", 1000000); 
        System.out.println(laptop.toString());

        Laptop clone1 = (Laptop) laptop.createClone();
        Laptop clone2 = (Laptop) laptop.createClone();

        clone1.setName("new Name");

        System.out.println(laptop.toString());
        System.out.println(clone1.toString());
        System.out.println(clone2.toString());
    }  
}