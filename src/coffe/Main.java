package coffe;

import coffe.barista.Coffee;
import coffe.cashier.Cashier;
import coffe.cashier.CashierImpl;
import coffe.cashier.Menu;
import coffe.customer.Customer;
import coffe.customer.CustomerImpl;

import java.util.EnumSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cashier cashier = new CashierImpl();

        // 메뉴 선택
        EnumSet<Menu> menuSet = cashier.showMenu();
        System.out.println("\n[메뉴]");
        menuSet.stream().forEach(System.out::println);

        System.out.print("\n주문할 메뉴 이름을 입력하세요 : ");
        String menuName = sc.nextLine();

        // 주문
        Customer customer = new CustomerImpl(5000, menuName, cashier);
        Coffee coffee = customer.order(menuSet);

        System.out.println("\n[주문 결과]\n커피 이름: " + coffee.name + "\n커피 맛: " + coffee.taste);
    }
}
