package com.example.ds.enums;


public enum DataSourceTypeEnum {

    MYSQL("MYSQL", "MYSQL 6.0以下版本", "com.mysql.jdbc.Driver"),

    MYSQL_8("MYSQL_8", "MYSQL 8.0及以上版本", "com.mysql.cj.jdbc.Driver"),

    POSTGRESQL("POSTGRESQL", "PostgreSql", "org.postgresql.Driver"),
    ;

    /**
     * 类型
     */
    private final String type;

    /**
     * 类型名称
     */
    private final String name;

    /**
     * 驱动类名
     */
    private final String driverName;

    DataSourceTypeEnum(String type, String name, String driverName) {
        this.type = type;
        this.name = name;
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static String getDriverNameByType(String type) {
        if (type == null) {
            return null;
        }
        for (DataSourceTypeEnum e: DataSourceTypeEnum.values()) {
            if (e.getType().equals(type)) {
                return e.getDriverName();
            }
        }
        return null;
    }

    /**
     * 判断驱动类是否存在
     * @param type 数据库类型
     * @return boolean
     */
    public boolean existsDriverName(String type) {
        try {
            Class.forName(getDriverNameByType(type));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
