package com.ivy.zheng.commons.base;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.List;

@Slf4j
public class BaseServiceImpl<Mapper, Record, Example> implements BaseService<Record, Example> {

    private Mapper mapper;

    public long countByExample(Example example) {
        try {
            Method countByExample = mapper.getClass().getDeclaredMethod("countByExample", example.getClass());
            Object result = countByExample.invoke(mapper, example);
            return Long.valueOf(String.valueOf(result));
        } catch (Exception ex) {
            log.error("countByExample exception", ex);
        }
        return 0;
    }

    public int deleteByExample(Example example) {
        return 0;
    }

    public int deleteByPrimaryKey(Integer logId) {
        return 0;
    }

    public int insert(Record record) {
        return 0;
    }

    public int insertSelective(Record record) {
        return 0;
    }

    public List<Record> selectByExampleWithBLOBs(Example example) {
        return null;
    }

    public List<Record> selectByExample(Example example) {
        return null;
    }

    public Record selectByPrimaryKey(Integer logId) {
        return null;
    }

    public int updateByExampleSelective(Record record, Example example) {
        return 0;
    }

    public int updateByExampleWithBLOBs(Record record, Example example) {
        return 0;
    }

    public int updateByExample(Record record, Example example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(Record record) {
        return 0;
    }

    public int updateByPrimaryKeyWithBLOBs(Record record) {
        return 0;
    }

    public int updateByPrimaryKey(Record record) {
        return 0;
    }
}
