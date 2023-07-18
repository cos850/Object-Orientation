package coffe.cashier;

public enum Menu {
    ESPRESSO("Espresso", 500, "에스프레소"),
    LATTE("Latte", 4500, "라떼"),
    AMERICANO("Americano", 3000, "아메리카노"),
    MOCHA("Mocha", 5000, "모카");

    public String name;
    public int price;
    public String desc;

    Menu(String name, int price, String desc){
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name + "(" + price + "): " + desc;
    }
}
