package com.tuling.xxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuling.xxy.annotation.ReplaceMethod;
import com.tuling.xxy.entity.AgencyTest;
import com.tuling.xxy.mapper.AgencyTestMapper;
import com.tuling.xxy.service.AgencyTestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author xiongxy
 * @since 2021-09-11
 */
@Service
public class AgencyTestServiceImpl extends ServiceImpl<AgencyTestMapper, AgencyTest> implements AgencyTestService {

    @Autowired
    AgencyTestMapper agencyTestMapper;

    @Override
    @ReplaceMethod
    public List<AgencyTest> getAll() {
        return agencyTestMapper.selectList(new QueryWrapper<>());
    }
}
