package randomGen;

import java.util.Random;

public class RandomEquipment {
    int distributor;
    int factory;
    int workshop;
    int equipment;

    public RandomEquipment(Random rand) {
        this.distributor = rand.nextInt(5);
        this.factory = rand.nextInt(4000);
        this.workshop = rand.nextInt(2);
        this.equipment = rand.nextInt(5);
    }

    public int getDistributor() {
        return distributor;
    }

    public int getFactory() {
        return factory;
    }

    public int getWorkshop() {
        return workshop;
    }

    public int getEquipment() {
        return equipment;
    }
}
