class Laptop {
    private String name;
    private Double diagonal;
    private String OS;
    private Integer price;

    Laptop(String name){
        this.name = name;
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

    public void setPrice(Integer price) {
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

    public Integer getPrice() {
        return this.price;
    }

    public String toString(){
        return name + " " + diagonal + " " + OS + " " + price;
    }
}

class LaptopBuilder {
    private Laptop laptop;
    LaptopBuilder(String name){
        laptop = new Laptop(name);
    }

    public LaptopBuilder setDiagonal(Double diagonal){
        laptop.setDiagonal(diagonal);
        return this;
    }

    public LaptopBuilder setOS(String OS){
        laptop.setOS(OS);
        return this;
    }

    public LaptopBuilder setPrice(Integer price){
        laptop.setPrice(price);
        return this;
    }

    public Laptop build(){
        return laptop;
    }
}

class Builder {
    public static void main(String[] args) {
        Laptop akzholsLaptop = new LaptopBuilder("Macbook Pro").build();
        System.out.println(akzholsLaptop.toString());

        Laptop talgatsLaptop = new LaptopBuilder("Lenovo").setDiagonal(13.0).setOS("Linux").setPrice(400000).build();
        System.out.println(talgatsLaptop.toString());

        Laptop SanzharsLaptop = new LaptopBuilder("Acer").setPrice(500000).build();
        System.out.println(SanzharsLaptop.toString());
    }
}