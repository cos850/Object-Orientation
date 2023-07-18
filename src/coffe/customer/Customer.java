package coffe.customer;

import coffe.barista.Coffee;
import coffe.cashier.Menu;

import java.util.EnumSet;

public interface Customer {
    // 책임1. 주문한다
    Coffee order(EnumSet<Menu> menuSet);
}
