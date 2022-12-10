package vendingmachine.controller;

import vendingmachine.model.Money;

import vendingmachine.model.Products;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public MachineController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        VendingMachine vendingMachine = initializeVendingMachine();
        vendingMachine.insertMoney(getInsertMoney());
        purchase(vendingMachine);
        end(vendingMachine);
    }

    public VendingMachine initializeVendingMachine() {
        VendingMachine vendingMachine = new VendingMachine(getMachineMoney());
        outputView.printInitialCoins(vendingMachine.getCoins());
        vendingMachine.initializeProducts(getProducts());
        return vendingMachine;
    }

    public void purchase(VendingMachine vendingMachine) {
        while (vendingMachine.isOpen()) {
            outputView.printInsertMoney(vendingMachine.getInsertedMoney());
            vendingMachine.buyProduct(getPurchase(vendingMachine));
        }
    }

    public void end(VendingMachine vendingMachine) {
        outputView.printInsertMoney(vendingMachine.getInsertedMoney());
        outputView.printChanges(vendingMachine.getChanges());
    }

    public Money getMachineMoney() {
        try {
            return new Money(inputView.readMachineMoney());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return getMachineMoney();
        }
    }

    public Products getProducts() {
        try {
            return new Products(inputView.readProductList());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return getProducts();
        }
    }

    public Money getInsertMoney() {
        try {
            return new Money(inputView.readInsertMoney());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return getInsertMoney();
        }
    }

    public String getPurchase(VendingMachine vendingMachine) {
        try {
            String input = inputView.readPurchase();
            vendingMachine.isValidPurchase(input);
            return input;
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return getPurchase(vendingMachine);
        }
    }
}
