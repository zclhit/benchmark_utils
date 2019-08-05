import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SqlGenerator {
    public static final String dir = "/Users/changle.zhang/";
    public static final String distributor_json = "{\"id\": %d, \"name\": \"%s\", \"updatedBy\": \"SYSTEM\", \"migratable\": null, \"createdDate\": 1558870194149, \"updatedDate\": 1565017380983, \"publicWechat\": {\"name\": \"%s\", \"userName\": \"gh_3ddd5a04a64a\", \"accessToken\": \"24_td2PLvfyBV8n5p2M5D-eG-zX8kEWkjMKFH40IBF2kUdw-_mFsmRD3FwUvoYSDpiEKVt9aqw3aOZDEwB__32_YEpKGWODqzioJolFz3-0YRDsTcX_q13SUe4fDyBKUGTZGdMUHJdGX31B8nV2RSRdAJDVWV\", \"jsApiTicket\": \"d3yp2Ud9Gzwj6dnSWFhcRS_1CmGVM875QFTI06vAfOhk5OOPWMJmDpRpYINRPJC9sxPalEkjsgwFTnPybWiG3Q\", \"refreshToken\": \"refreshtoken@@@Th6vV7FrS0HzTBml9xtVuPhgRdvzr2cVmShiOXmB4Ig\", \"publicWechatId\": \"wx668096ee9229e002\", \"templateMessageIds\": {}}, \"latestOperation\": \"REFRESH_PUBLIC_WECHAT_TOKEN\", \"enterpriseWechat\": null, \"distributorYinKeId\": null}";
    public static final String factory_json = "{\"id\": \"%s\", \"name\": \"%s\", \"image\": null, \"domain\": \"地铁\", \"address\": {\"title\": \"天府四街\", \"address\": \"四川省成都市武侯区\", \"latitude\": 30.542340011, \"longitude\": 104.052750014}, \"comment\": null, \"disable\": false, \"createdBy\": \"BaiZhaoYi\", \"updatedBy\": \"lyy-ljs\", \"disableMsg\": \"\", \"createdDate\": 1553671786376, \"updatedDate\": 1559112402336, \"distributorId\": %d, \"factoryAccount\": {\"password\": \"abc123456\", \"updatedDate\": null, \"loginUserName\": \"baizhaoyi523\"}, \"totalOilVolume\": 1000, \"yinKeFactoryId\": null, \"factoryContacts\": [{\"name\": \"白兆逸\", \"phoneNumber\": \"18086801644\"}], \"latestOperation\": \"UPDATED\", \"mainEquipmentType\": \"工程机械\", \"defaultRoleForNewUser\": \"ADMIN\"}";

    public static void main(String[] args) {
        generateTruncateTableSql("truncate.sql");

        Distributor distributor = new Distributor();
        for (int d = 1000; d < 1005; d++) {
            // distributor id from 1000 to 10004\
            distributor.setNumber(d);
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(new File(dir + "distributor" + d + ".sql")), "UTF-8"));) {
                writer.write(saveDistributorSql(distributor));
                Factory factory = new Factory(distributor.getNumber());
                for (int f = 0; f < 4000; f++) {
                    factory.setNumber(f);
                    writer.write(saveFactorySql(factory));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String saveFactorySql(Factory factory) {
        String name = "factory" + factory.getNumber();
        String json = String.format(factory_json, factory.getId(), name, factory.getDistributorNumber());
        return "INSERT INTO factory (ID, JSON_CONTENT) values ('" + factory.getId() + "','" + json + "');\n";
    }

    private static String saveDistributorSql(Distributor distributor) {
        String name = "distributor" + distributor.getNumber();
        String json = String.format(distributor_json, distributor.getNumber(), name, name);
        return "INSERT INTO distributor (ID, JSON_CONTENT) values (" + distributor.getNumber() + ",'" + json + "');\n";
    }

    private static void generateTruncateTableSql(String filename) {
        String[] tableNames = {
                "distributor",
                "equipment",
                "factory",
                "workshop",
                "maintenance_record",
                "lubricantpoint"
        };
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(new File(dir + filename)), "UTF-8"));) {
            for (String table : tableNames) {
                writer.write("Truncate Table " + table + ";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
