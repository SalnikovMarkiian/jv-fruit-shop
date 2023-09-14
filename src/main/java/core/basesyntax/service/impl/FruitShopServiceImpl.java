package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;

import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }
    @Override
    public void processData(List<FruitTransaction> transactionList) {
        for (FruitTransaction fruitTransaction : transactionList) {
            operationStrategy.getHandler(fruitTransaction.getOperation()).handle(fruitTransaction);
        }
    }
}
