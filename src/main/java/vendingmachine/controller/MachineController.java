package vendingmachine.controller;

import java.util.List;
import vendingmachine.model.Money;
import vendingmachine.model.Product;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private static final String PURCHASE_EXCEPTION = "[ERROR] 구매할 수 없는 상품입니다.";
    private final InputView inputView;
    private final OutputView outputView;

    public MachineController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startMachine() {
        VendingMachine vendingMachine = new VendingMachine(getMachineMoneyFromInput());
        outputView.printAllCoins(vendingMachine.getCoins());
        vendingMachine.initializeProducts(getProducts());
        insertMoney(vendingMachine);
        vendingMachine.buyProduct(getPurchase(vendingMachine));
    }

    public void insertMoney(VendingMachine vendingMachine) {
        vendingMachine.insertMoney(getInsertMoney());
        outputView.printInsertMoney(vendingMachine.getMoney());
    }

    public void purchase(VendingMachine vendingMachine) {
        while (vendingMachine.isOpen()) {

        }
    }

    public Money getMachineMoneyFromInput() {
        try {
            return new Money(inputView.readMachineMoney());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return getMachineMoneyFromInput();
        }
    }

    public List<Product> getProducts() {
        return inputView.readProductList();
    }

    public int getInsertMoney() {
        return inputView.readInsertMoney();
    }

    public String getPurchase(VendingMachine vendingMachine) {
        try {
            String input = inputView.readPurchase();
            vendingMachine.isValidPurchase(input);
            return input;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println(PURCHASE_EXCEPTION);
            return getPurchase(vendingMachine);
        }
    }
}
