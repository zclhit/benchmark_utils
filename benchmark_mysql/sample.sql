-- add factory
insert into factory(id, json_content) values ('2b24531c-cb1c-4801-a993-1a3b70b1678e', {"id": "2b24531c-cb1c-4801-a993-1a3b70b1678e", "name": "传感器测试工厂", "image": null, "domain": "纺织", "address": {"title": "深圳宝安国际机场", "address": "广东省深圳市宝安区广深公路与机场南路交汇处西北侧", "latitude": 22.631834, "longitude": 113.81621}, "comment": null, "disable": false, "createdBy": "TangJiuJun", "updatedBy": "TangJiuJun", "disableMsg": "", "createdDate": 1563325949393, "updatedDate": 1563325949393, "distributorId": 100, "factoryAccount": {"password": "123456", "updatedDate": null, "loginUserName": "test01"}, "totalOilVolume": 1000, "yinKeFactoryId": null, "factoryContacts": [{"name": "张三", "phoneNumber": "13512345678"}], "latestOperation": "CREATED", "mainEquipmentType": "浆纱机", "defaultRoleForNewUser": "ADMIN"});

-- add workshop
insert into workshop(id, json_content) values ('1c8f455c-0384-4ea7-b311-ffbe951c6054',{"id": "1c8f455c-0384-4ea7-b311-ffbe951c6054", "name": "车间10001", "deleted": false, "createdBy": "SYSTEM", "factoryId": "2b24531c-cb1c-4801-a993-1a3b70b1678e", "updatedBy": "xuhuihui", "createdDate": 1562047861312, "updatedDate": 1562047861312, "latestOperation": "CREATE"});

-- add equipment
insert into equipment(id, json_content) values ('0875886d-9f20-4b7b-b1c5-fbd8600a0903', {"id": "0875886d-9f20-4b7b-b1c5-fbd8600a0903", "name": "设备大类", "image": null, "model": null, "number": "12345", "source": "FACTORY", "deleted": false, "unicode": null, "createdBy": "bfda1d18-93a2-4524-89fa-22b2264c1707", "factoryId": "2b24531c-cb1c-4801-a993-1a3b70b1678e", "updatedBy": "SYSTEM", "workshopId": "1c8f455c-0384-4ea7-b311-ffbe951c6054", "createdDate": 1562250619989, "description": null, "installDate": "2019-07", "updatedDate": 1563159999356, "manufacturer": "制造商", "distributorId": 100, "latestOperation": "UPDATE_LUBRICANT_POINT", "lubricantPoints": [{"id": 1, "type": "HYDRAULIC_OILS", "brand": "壳牌", "remark": "", "volume": {"unit": "L", "volume": 5.5}, "deleted": false, "product": "壳牌客户专用润滑油ACBolaiteBS-01", "nickname": "", "schedule": 1, "filterType": "", "createdDate": 1562251412985, "updatedDate": 1562749920508, "lubricantPart": "用油点", "changeOilMonth": 0, "latestChangeOilDate": "2019-07-12"}]}

-- add maintenance record
insert into maintenance_record(id, json_content) values ('05ed3425-8a0c-4ab5-8768-12930f28f155',{"fe": "", "id": "0645d076-cc5e-4ccc-9217-619d992dedc7", "cst": "", "tan": "", "date": "2019-07-22", "type": "OIL_INSPECTION", "images": [], "result": null, "comment": null, "deleted": false, "moisture": {"unit": null, "value": ""}, "oilColor": null, "ticketId": null, "factoryId": "2b24531c-cb1c-4801-a993-1a3b70b1678e", "oilStatus": "ACTION", "updatedBy": "a000fac4-8bed-11e9-a4d5-0017fa006b35", "suggestion": "", "cleanliness": null, "createdDate": 1563783064719, "equipmentId": "0875886d-9f20-4b7b-b1c5-fbd8600a0903", "updatedDate": 1563784044146, "serviceValue": null, "customMetrics": [], "distributorId": 100, "warningHandled": true, "latestOperation": "UPDATED", "lubricantPointId": 1, "maintenanceRecordType": "OIL_INSPECTION", "customOilInspectionStandards": null});