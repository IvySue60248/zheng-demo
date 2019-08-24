package com.ivy.zheng.commons.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseService<Record, Example> {
    /**
     * 根据条件查询记录数量
     * @param example
     * @return
     */
    long countByExample(Example example);

    /**
     * 按条件删除
     * @param example
     * @return
     */
    int deleteByExample(Example example);

    /**
     * 按主键删除
     * @param logId
     * @return
     */
    int deleteByPrimaryKey(Integer logId);

    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(Record record);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insertSelective(Record record);

    /**
     * 按条件查询（包括BLOB字段）。只有当数据表中的字段类型有为二进制的才会产生。
     * @param example
     * @return
     */
    List<Record> selectByExampleWithBLOBs(Example example);

    /**
     * 按条件查询
     * @param example
     * @return
     */
    List<Record> selectByExample(Example example);

    /**
     * 按主键查询
     * @param logId
     * @return
     */
    Record selectByPrimaryKey(Integer logId);

    /**
     * 按条件更新值不为null的字段更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    /**
     * 按条件更新（包括BLOB字段）
     * @param record
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example);

    /**
     * 按条件更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    /**
     * 按主键更新值不为null的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Record record);

    /**
     * 按主键更新（包括BLOB字段）
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Record record);

    /**
     * 按主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record);
}
