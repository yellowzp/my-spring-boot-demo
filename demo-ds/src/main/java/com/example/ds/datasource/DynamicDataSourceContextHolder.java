package com.example.ds.datasource;

/**
 * 数据源上下文
 */
public class DynamicDataSourceContextHolder {

    /**
     * 主数据源 配置文件内的数据源
     */
    public final static Long MASTER_DATASOURCE_ID = 0L;

    /**
     * 当前线程的数据源的id
     */
    private final static ThreadLocal<Long> CURRENT_DATASOURCE_ID = new ThreadLocal<Long>() {

        /**
         * 默认主数据库
         * @return ...
         */
        @Override
        protected Long initialValue() {
            return MASTER_DATASOURCE_ID;
        }
    };

    /**
     * 设置当前数据源
     * @param id 数据源的id
     */
    public static void setCurrentDatasourceId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }
        CURRENT_DATASOURCE_ID.set(id);
    }

    public static Long getCurrentDatasourceId() {
        return CURRENT_DATASOURCE_ID.get();
    }

    /**
     * 重置数据源至主数据源
     */
    public static void reset() {
        CURRENT_DATASOURCE_ID.set(MASTER_DATASOURCE_ID);
    }



}
