package vendingmachine.controller;

import java.util.List;
import vendingmachine.model.Product;
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

    public void startMachine() {
        VendingMachine vendingMachine = new VendingMachine(getMachineMoney());
        outputView.printAllCoins(vendingMachine.getCoins());
        getProducts();
    }

    public int getMachineMoney() {
        outputView.askMachineMoney();
        return inputView.readMachineMoney();
    }

    public List<Product> getProducts() {
        outputView.askProducts();
        return inputView.readProductList();
    }
}
