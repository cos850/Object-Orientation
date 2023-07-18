package coffe.cashier;

import coffe.barista.Coffee;
import coffe.barista.Barista;
import coffe.barista.BaristaImpl;

import java.util.EnumSet;

public class CashierImpl implements Cashier{

    private EnumSet<Menu> menuSet;
    private Barista barista;

    public CashierImpl(){
        menuSet = EnumSet.allOf(Menu.class);
        barista = new BaristaImpl();
    }
    @Override
    public EnumSet<Menu> showMenu() {
        return menuSet;
    }

    @Override
    public Coffee takeOrder(Menu menu, int money) {
        if(menu.price == money) {
            return barista.makeCoffee(menu);
        }
        throw new RuntimeException("메뉴 가격이 맞지 않습니다. 다시 주문하시길 바랍니다.");
    }
}
