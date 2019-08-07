import java.util.Random;

public class Equipment {
    private int distributorId;
    private String workshopId;
    private String factoryId;
    private Random rand = new Random();

    private final String idFormat = "%s-eq-%d";

    public Equipment(int distributorId, String workshopId, String factoryId) {
        this.distributorId = distributorId;
        this.workshopId = workshopId;
        this.factoryId = factoryId;
    }

    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return String.format(idFormat, workshopId, number);
    }

    public String getNumber() {
        return "测试线" + number + "号机";
    }

    public String randomName() {
        return "randName" + rand.nextInt(10);
    }

    public int randomVolume() {
        return rand.nextInt(20);
    }

    public int randomSchedule() {
        return rand.nextInt(11) + 1;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public String getWorkshopId() {
        return workshopId;
    }

    public String getFactoryId() {
        return factoryId;
    }
}
