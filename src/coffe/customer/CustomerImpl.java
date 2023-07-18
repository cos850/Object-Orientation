package coffe.customer;

import coffe.barista.Coffee;
import coffe.cashier.Cashier;
import coffe.cashier.Menu;

import java.util.EnumSet;

public class CustomerImpl implements Customer {

    int money;
    String menuName;
    Cashier cashier;

    public CustomerImpl(int money, String menuName, Cashier cashier){
        this.money = money;
        this.menuName = menuName;
        this.cashier = cashier;
    }

    @Override
    public Coffee order(EnumSet<Menu> menuSet) {
        Menu menu = menuSet.stream().filter(m-> m.name.equals(this.menuName)).findFirst().orElseThrow();
        return cashier.takeOrder(menu, pay(menu.price));
    }

    public int pay(int price) {
        if(money - price > 0){
            money -= price;
            return price;
        }
        throw new RuntimeException("잔액이 부족합니다.");
    }
}
