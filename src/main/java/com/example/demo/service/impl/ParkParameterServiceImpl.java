package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.ParkParameter;
import com.example.demo.dao.ParkParameterDao;
import com.example.demo.service.IParkParameterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author JFREE
 * @since 2018-11-06
 */
@Service
public class ParkParameterServiceImpl extends ServiceImpl<ParkParameterDao, ParkParameter> implements IParkParameterService {


    public String get() {
        QueryWrapper<ParkParameter> q = new QueryWrapper<>();
        q.isNotNull("park_id");
        q.eq("para_key", "12");
        q.select("id", "created_at");
        return q.toString();
    }

}
