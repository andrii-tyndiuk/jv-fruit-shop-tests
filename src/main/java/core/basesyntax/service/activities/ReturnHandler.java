package core.basesyntax.service.activities;

import core.basesyntax.db.Storage;
import core.basesyntax.fruitrecord.FruitRecord;

public class ReturnHandler implements ActivityHandler {
    @Override
    public void apply(FruitRecord record) {
        if (Storage.fruitsQuantity.containsKey(record.getFruit())) {
            Storage.fruitsQuantity.merge(record.getFruit(),record.getAmount(),(Integer::sum));
        } else {
            throw new RuntimeException(
                    "Can't return the product because this product has never sold, "
                    + record.getFruit());
        }
    }
}