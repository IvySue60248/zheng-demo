package com.ivy.zheng.commons.base;

import java.lang.reflect.Method;
import java.util.List;

public class BaseServiceImpl<Mapper, Record, Example> implements BaseService<Record, Example> {

    private Mapper mapper;

    @Override
    public long countByExample(Example example) {
        try {
            Method countByExample = mapper.getClass().getDeclaredMethod("countByExample", example.getClass());
            Object result = countByExample.invoke(mapper, example);
            return Long.valueOf(String.valueOf(result));
        } catch (Exception ex) {

        }
        return 0;
    }

    @Override
    public int deleteByExample(Example example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer logId) {
        return 0;
    }

    @Override
    public int insert(Record record) {
        return 0;
    }

    @Override
    public int insertSelective(Record record) {
        return 0;
    }

    @Override
    public List<Record> selectByExampleWithBLOBs(Example example) {
        return null;
    }

    @Override
    public List<Record> selectByExample(Example example) {
        return null;
    }

    @Override
    public Record selectByPrimaryKey(Integer logId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Record record, Example example) {
        return 0;
    }

    @Override
    public int updateByExampleWithBLOBs(Record record, Example example) {
        return 0;
    }

    @Override
    public int updateByExample(Record record, Example example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Record record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Record record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Record record) {
        return 0;
    }
}
