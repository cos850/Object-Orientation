package coffe.cashier;

import coffe.barista.Coffee;

import java.util.EnumSet;

public interface Cashier {
    // 책임1. 메뉴판을 보여준다
    EnumSet<Menu> showMenu();

    // 책임2. 주문을 받는다
    Coffee takeOrder(Menu menu, int money);
}
