package com.example.demo.service.impl;

import com.example.demo.mapper.DeptMapper;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.pojo.Dept;
import com.example.demo.pojo.DeptLog;
import com.example.demo.service.DeptLogService;
import com.example.demo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;


    public List<Dept> list() {
        return deptMapper.list();
    }


//    @Log

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) throws Exception {
        try {

            deptMapper.deleteById(id);


            empMapper.deleteByDeptId(id);
        } finally {

            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("部門IDによる削除" + id );
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);

    }

}
