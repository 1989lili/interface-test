package com.tuling.xxy.service;

import com.tuling.xxy.entity.AgencyTest;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 *  待办服务类
 *
 * @author xiongxy
 * @since 2021-09-11
 */
public interface AgencyTestService extends IService<AgencyTest> {

    /**
     * 查询所有待办
     * @return
     */
    List<AgencyTest> getAll();

}
