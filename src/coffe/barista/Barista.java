package coffe.barista;

import coffe.cashier.Menu;

public interface Barista {

    // 책임1. 커피를 만든다
    Coffee makeCoffee(Menu menu);
}
