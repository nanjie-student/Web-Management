package com.cy.pj.sys.service.impl;

import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.pojo.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;


@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;


    @Override
    public int saveObject(SysMenu sysMenu) {
        //1.参数校验
        if(sysMenu==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(sysMenu.getName()))
            throw new IllegalArgumentException("菜单名不能为空");
        //.......
        //2.保存菜单
        int rows=sysMenuDao.insertObject(sysMenu);
        return rows;
    }

    @Override
    public List<Node> findZtreeMenuNodes() {
        return sysMenuDao.findZtreeMenuNodes();
    }

    @Override
    public List<Map<String, Object>> findObjects() {
        //......
        return sysMenuDao.findObjects();
    }
}
