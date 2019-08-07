public class Workshop {
    private int distributor;
    private String factoryId;
    private int number;

    public final String idFormat = "%s-ws-%d";

    public final String nameFormat = "name-%s";

    public Workshop(int distributor, String factoryId) {
        this.distributor = distributor;
        this.factoryId = factoryId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDistributor() {
        return distributor;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public int getNumber() {
        return number;
    }

    public String getId() {
        return String.format(idFormat, factoryId, number);
    }

    public String getName() {
        return String.format(nameFormat, getId());
    }
}
