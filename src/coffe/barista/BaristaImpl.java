package coffe.barista;

import coffe.cashier.Menu;

public class BaristaImpl implements Barista{

    @Override
    public Coffee makeCoffee(Menu menu) {
        switch (menu) {
            case ESPRESSO :
                return new Coffee(menu.name(), Taste.쓴맛);
            case AMERICANO :
                return new Coffee(menu.name(), Taste.진한맛);
            case LATTE:
                return new Coffee(menu.name(), Taste.고소한맛);
            case MOCHA:
                return new Coffee(menu.name(), Taste.단맛);
            default:
                return null;
        }
    }
}
