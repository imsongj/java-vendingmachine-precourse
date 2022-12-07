package vendingmachine.controller;

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
        getMachineMoney();
    }

    public int getMachineMoney() {
        outputView.askMachineMoney();
        return inputView.readMachineMoney();
    }
}
