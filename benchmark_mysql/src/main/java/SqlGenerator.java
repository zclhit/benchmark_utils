import randomGen.RandomEquipment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class SqlGenerator {
    private static final String dir = "/Users/changle.zhang/";
    private static final String distributor_json = "{\"id\": %d, \"name\": \"%s\", \"updatedBy\": \"SYSTEM\", \"migratable\": null, \"createdDate\": 1558870194149, \"updatedDate\": 1565017380983, \"publicWechat\": {\"name\": \"%s\", \"userName\": \"gh_3ddd5a04a64a\", \"accessToken\": \"24_td2PLvfyBV8n5p2M5D-eG-zX8kEWkjMKFH40IBF2kUdw-_mFsmRD3FwUvoYSDpiEKVt9aqw3aOZDEwB__32_YEpKGWODqzioJolFz3-0YRDsTcX_q13SUe4fDyBKUGTZGdMUHJdGX31B8nV2RSRdAJDVWV\", \"jsApiTicket\": \"d3yp2Ud9Gzwj6dnSWFhcRS_1CmGVM875QFTI06vAfOhk5OOPWMJmDpRpYINRPJC9sxPalEkjsgwFTnPybWiG3Q\", \"refreshToken\": \"refreshtoken@@@Th6vV7FrS0HzTBml9xtVuPhgRdvzr2cVmShiOXmB4Ig\", \"publicWechatId\": \"wx668096ee9229e002\", \"templateMessageIds\": {}}, \"latestOperation\": \"REFRESH_PUBLIC_WECHAT_TOKEN\", \"enterpriseWechat\": null, \"distributorYinKeId\": null}";
    private static final String factory_json = "{\"id\": \"%s\", \"name\": \"%s\", \"image\": null, \"domain\": \"地铁\", \"address\": {\"title\": \"天府四街\", \"address\": \"四川省成都市武侯区\", \"latitude\": 30.542340011, \"longitude\": 104.052750014}, \"comment\": null, \"disable\": false, \"createdBy\": \"BaiZhaoYi\", \"updatedBy\": \"lyy-ljs\", \"disableMsg\": \"\", \"createdDate\": 1553671786376, \"updatedDate\": 1559112402336, \"distributorId\": %d, \"factoryAccount\": {\"password\": \"abc123456\", \"updatedDate\": null, \"loginUserName\": \"baizhaoyi523\"}, \"totalOilVolume\": 1000, \"yinKeFactoryId\": null, \"factoryContacts\": [{\"name\": \"白兆逸\", \"phoneNumber\": \"18086801644\"}], \"latestOperation\": \"UPDATED\", \"mainEquipmentType\": \"工程机械\", \"defaultRoleForNewUser\": \"ADMIN\"}";
    private static final String workshop_json = "{\"id\": \"%s\", \"name\": \"%s\", \"deleted\": false, \"createdBy\": \"lixiang\", \"factoryId\": \"%s\", \"updatedBy\": \"lixiang\", \"createdDate\": 1564650385547, \"updatedDate\": 1564650385547, \"latestOperation\": \"CREATE\"}";
    private static final String equipment_json = "{\"id\": \"%s\", \"name\": \"%s\", \"image\": null, \"model\": null, \"number\": \"%s\", \"source\": \"FACTORY\", \"deleted\": false, \"unicode\": null, \"createdBy\": \"7c5804f9-269e-4a2a-8419-896d0e4d9f24\", \"factoryId\": \"%s\", \"updatedBy\": \"cad9a497-76b9-4a9c-b82a-717623c6d2f3\", \"workshopId\": \"%s\", \"createdDate\": 1562571122323, \"description\": null, \"installDate\": \"2019-07\", \"updatedDate\": 1564468748652, \"manufacturer\": \"555\", \"distributorId\": %d, \"latestOperation\": \"ADD_LUBRICANT_POINT\", \"lubricantPoints\": [{\"id\": 1, \"type\": \"HYDRAULIC_OILS\", \"brand\": \"壳牌\", \"remark\": \"\", \"volume\": {\"unit\": \"L\", \"volume\": %d}, \"deleted\": true, \"product\": \"壳牌客户专用润滑油ACBolaiteBS-01\", \"nickname\": \"\", \"schedule\": %d, \"filterType\": \"\", \"createdDate\": 1562576033757, \"updatedDate\": 1562656809301, \"lubricantPart\": \"测试用油部位\", \"changeOilMonth\": 0, \"latestChangeOilDate\": \"2019-07-15\"}]}";
    private static final String maintenance_record_oil_inspection = "{\"fe\": \"%d\", \"id\": \"%s\", \"cst\": \"%d\", \"tan\": \"%d\", \"date\": \"2019-07-09\", \"type\": \"OIL_INSPECTION\", \"images\": [], \"result\": null, \"comment\": null, \"deleted\": false, \"moisture\": {\"unit\": \"PPM\", \"value\": \"%d\"}, \"oilColor\": \"DARK_BROWN\", \"ticketId\": null, \"factoryId\": \"%s\", \"oilStatus\": \"ACTION\", \"updatedBy\": \"e97b4283-edce-4d82-ace6-5cc170dc1e88\", \"suggestion\": \"了\", \"cleanliness\": \"LV8\", \"createdDate\": 1562657995006, \"equipmentId\": \"%s\", \"updatedDate\": 1562657995006, \"serviceValue\": null, \"customMetrics\": [{\"name\": \"%s\", \"value\": \"%s\"}], \"distributorId\": %d, \"warningHandled\": false, \"latestOperation\": \"CREATED\", \"lubricantPointId\": 1, \"maintenanceRecordType\": \"OIL_INSPECTION\", \"customOilInspectionStandards\": null}";
    private static final String maintenance_record_custom = "{\"id\": \"%s\", \"date\": \"2019-06-18\", \"type\": \"CUSTOM\", \"images\": [], \"comment\": null, \"deleted\": false, \"factoryId\": \"%s\", \"updatedBy\": \"c3a8ac71-be0f-4d0a-997f-e74b02efd895\", \"templateId\": \"8a01ca36-f88f-4036-9bd0-dbf6f09e910a\", \"createdDate\": 1560839556188, \"equipmentId\": \"%s\", \"updatedDate\": 1560839556188, \"fieldRecords\": [{\"value\": null, \"fieldId\": \"ac1b71a5-4599-478c-b7b6-d056bc91cc4d\", \"fieldType\": \"DIGITAL\"}], \"templateName\": \"模版\", \"distributorId\": %d, \"latestOperation\": \"CREATED\", \"maintenanceRecordType\": \"CUSTOM\"}";
    private static final String maintenance_device = "{\"id\": \"%s\", \"date\": \"2019-07-09\", \"type\": \"MAINTAIN_DEVICE\", \"images\": [], \"comment\": \"测试\", \"deleted\": false, \"factoryId\": \"%s\", \"updatedBy\": \"612cae3a-5210-459b-bbc5-b8bd947943c8\", \"customType\": \"噢噢噢哦哦\", \"accessories\": [{\"name\": \"%s\", \"amount\": %d, \"price\":%d}], \"createdDate\": 1562637515823, \"equipmentId\": \"%s\", \"updatedDate\": 1562657342622, \"faultMessage\": {\"reason\": \"%s\", \"duration\": %d, \"position\": \"%s\"}, \"distributorId\": %d, \"latestOperation\": \"UPDATED\", \"maintenanceRecordType\": \"MAINTAIN_DEVICE\"}";
    private static final String add_oil_json = "{\"id\": \"%s\", \"date\": \"2019-07-01\", \"type\": \"ADD_OIL\", \"brand\": \"其他\", \"color\": \"CLEAR\", \"images\": [], \"volume\": {\"unit\": \"L\", \"volume\": %d}, \"comment\": null, \"deleted\": false, \"product\": \"AERO HFA\", \"pressure\": null, \"factoryId\": \"%s\", \"updatedBy\": \"yaohongchang\", \"createdDate\": 1561968262592, \"equipmentId\": \"%s\", \"temperature\": 15, \"updatedDate\": 1561968262592, \"distributorId\": %d, \"isReachStandard\": true, \"latestOperation\": \"CREATED\", \"lubricantPointId\": 1, \"maintenanceRecordType\": \"ADD_OIL\"}";
    private static final String check_maintenance_json = "{\"id\": \"%s\", \"date\": \"2019-08-06\", \"type\": \"CHECK\", \"color\": null, \"images\": [], \"comment\": null, \"deleted\": false, \"warning\": %s, \"pressure\": null, \"factoryId\": \"%s\", \"updatedBy\": \"cad9a497-76b9-4a9c-b82a-717623c6d2f3\", \"createdDate\": 1565073403577, \"equipmentId\": \"%s\", \"temperature\": null, \"updatedDate\": 1565074513361, \"distributorId\": %d, \"warningHandled\": false, \"isReachStandard\": null, \"latestOperation\": \"UPDATED\", \"lubricantPointId\": 1, \"maintenanceRecordType\": \"CHECK\"}";
    private static final String oil_injection_record = "{\"id\": \"%s\", \"date\": \"2019-07-11\", \"type\": \"OIL_INJECTION\", \"brand\": \"壳牌\", \"images\": [], \"comment\": null, \"deleted\": false, \"product\": \"壳牌客户专用润滑油ACBolaiteBS-01\", \"ticketId\": \"10019082\", \"factoryId\": \"%s\", \"oilVolume\": {\"unit\": \"L\", \"volume\": %d}, \"updatedBy\": \"SYSTEM\", \"createdDate\": 1562837359344, \"equipmentId\": \"%s\", \"updatedDate\": 1562837359344, \"distributorId\": %d, \"latestOperation\": \"CONVERTED\", \"lubricantPointId\": 1, \"maintenanceRecordType\": \"FIELD_SERVICE\"}";

    public static void main(String[] args) {
        generateTruncateTableSql("truncate.sql");

        Distributor distributor = new Distributor();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(new File(dir + "distributor.sql")), StandardCharsets.UTF_8))) {
            for (int d = 0; d < 5; d++) {
                // distributor id from 0 to 4
                distributor.setNumber(d);
                writer.write(saveDistributorSql(distributor));
                Factory factory = new Factory(distributor.getNumber());
                for (int f = 0; f < 4000; f++) {
                    // factory id from 0 to 3999
                    factory.setNumber(f);
                    writer.write(saveFactorySql(factory));

                    Workshop workshop = new Workshop(d, factory.getId());
                    for (int w = 0; w < 2; w++) {
                        // workshop id from 0 to 1
                        workshop.setNumber(w);
                        writer.write(saveWorkshopSql(workshop));

                        Equipment equipment = new Equipment(d, workshop.getId(), workshop.getFactoryId());
                        for (int e = 0; e < 5; e++) {
                            // equipment id from 0 to 5
                            equipment.setNumber(e);
                            writer.write(saveEquipmentSql(equipment));
                        }
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Random rand = new Random();

        try (final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(new File(dir + "maintenance.sql")), StandardCharsets.UTF_8));) {
            // 50k oil inspection maintenance record
            for (int oi = 0; oi < 50000; oi++) {
                writer.write(saveOilInspectionSql(rand, oi));
            }
            // 100k custom maintenance record
            for (int c = 0; c < 100000; c++) {
                writer.write(saveCustomSql(rand, c));
            }
            // 100k device maintenance record
            for (int dm = 0; dm < 100000; dm++) {
                writer.write(saveDeviceMaintenanceSql(rand, dm));
            }
            // 50k add oil maintenance record
            for (int dm = 0; dm < 50000; dm++) {
                writer.write(saveAddOilSql(rand, dm));
            }
            // 50k check record
            for (int ck = 0; ck < 50000; ck++) {
                writer.write(saveCheckMaintenanceSql(rand, ck));
            }
            // 50k oil injection record
            for (int oi = 0; oi < 50000; oi++) {
                writer.write(saveOilInjectionSql(rand, oi));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String saveOilInjectionSql(Random rand, int oi) {
        RandomEquipment equipment = new RandomEquipment(rand);
        String maintenanceId = "oil-injection-" + oi;
        String factoryId = getFactoryId(equipment);
        String equipmentId = getEquipmentId(equipment);
        int oilVolume = rand.nextInt(20);
        String json = String.format(oil_injection_record, maintenanceId, factoryId, oilVolume, equipmentId, equipment.getDistributor());
        return "INSERT INTO maintenance_record(ID, JSON_CONTENT) values ('" + maintenanceId + "','" + json + "');\n";
    }

    private static String saveCheckMaintenanceSql(Random rand, int ck) {
        RandomEquipment equipment = new RandomEquipment(rand);
        String maintenanceId = "check-" + ck;
        String factoryId = getFactoryId(equipment);
        String equipmentId = getEquipmentId(equipment);
        boolean warning = rand.nextBoolean();
        String json = String.format(check_maintenance_json, maintenanceId, warning, factoryId, equipmentId, equipment.getDistributor());
        return "INSERT INTO maintenance_record(ID, JSON_CONTENT) values ('" + maintenanceId + "','" + json + "');\n";
    }

    private static String saveAddOilSql(Random rand, int ao) {
        RandomEquipment equipment = new RandomEquipment(rand);
        String maintenanceId = "add-oil-" + ao;
        String factoryId = getFactoryId(equipment);
        String equipmentId = getEquipmentId(equipment);
        int oilVolume = rand.nextInt(20);
        String json = String.format(add_oil_json, maintenanceId, oilVolume, factoryId, equipmentId, equipment.getDistributor());
        return "INSERT INTO maintenance_record(ID, JSON_CONTENT) values ('" + maintenanceId + "','" + json + "');\n";
    }

    private static String saveDeviceMaintenanceSql(Random rand, int dm) {
        RandomEquipment equipment = new RandomEquipment(rand);
        String maintenanceId = "main-device-" + dm;
        String factoryId = getFactoryId(equipment);
        String equipmentId = getEquipmentId(equipment);
        String accName = "acc" + rand.nextInt(20);
        int accAmount = rand.nextInt(20);
        int accPrice = rand.nextInt(40);
        String faultReason = "fault_reason";
        int duration = rand.nextInt(30);
        String faultPos = "fault_position";
        String json = String.format(maintenance_device, maintenanceId, factoryId, accName, accAmount, accPrice, equipmentId, faultReason, duration, faultPos, equipment.getDistributor());
        return "INSERT INTO maintenance_record(ID, JSON_CONTENT) values ('" + maintenanceId + "','" + json + "');\n";
    }

    private static String saveCustomSql(Random rand, int c) {
        RandomEquipment equipment = new RandomEquipment(rand);
        String maintenanceId = "main-custom-" + c;
        String factoryId = getFactoryId(equipment);
        String equipmentId = getEquipmentId(equipment);
        String json = String.format(maintenance_record_custom, maintenanceId, factoryId, equipmentId, equipment.getDistributor());
        return "INSERT INTO maintenance_record(ID, JSON_CONTENT) values ('" + maintenanceId + "','" + json + "');\n";
    }

    private static String saveOilInspectionSql(Random rand, int r) {
        RandomEquipment equipment = new RandomEquipment(rand);
        String maintenanceId = "main-oil-inspection-" + r;
        int fe = rand.nextInt(10);
        int cst = rand.nextInt(10);
        int tan = rand.nextInt(10);
        int mValue = rand.nextInt(20);
        String customName = "name" + rand.nextInt(20);
        String customValue = "value" + rand.nextInt(20);
        String factoryId = getFactoryId(equipment);
        String equipmentId = getEquipmentId(equipment);
        String json = String.format(maintenance_record_oil_inspection, fe, maintenanceId, cst, tan, mValue, factoryId, equipmentId, customName, customValue, equipment.getDistributor());
        return "INSERT INTO maintenance_record(ID, JSON_CONTENT) values('" + maintenanceId + "','" + json + "');";
    }

    private static String getEquipmentId(RandomEquipment equipment) {
        return "dis-" + equipment.getDistributor() + "-fac-" + equipment.getFactory() +
                "-ws-" + equipment.getWorkshop() + "-eq-" + equipment.getEquipment();
    }

    private static String getFactoryId(RandomEquipment equipment) {
        return "name-dis-" + equipment.getDistributor() + "-fac-" + equipment.getFactory();
    }

    private static String saveEquipmentSql(Equipment equipment) {
        String json = String.format(equipment_json, equipment.getId(), equipment.randomName(), equipment.getNumber(), equipment.getFactoryId(), equipment.getWorkshopId(), equipment.getDistributorId(), equipment.randomVolume(), equipment.randomSchedule());
        return "INSERT INTO equipment(ID, JSON_CONTENT) values ('" + equipment.getId() + "','" + json + "');\n";
    }

    private static String saveWorkshopSql(Workshop workshop) {
        String name = workshop.getName();
        String json = String.format(workshop_json, workshop.getId(), name, workshop.getFactoryId());
        return "INSERT INTO workshop (ID, JSON_CONTENT) values('" + workshop.getId() + "','" + json + "');\n";
    }

    private static String saveFactorySql(Factory factory) {
        String name = factory.getName();
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
