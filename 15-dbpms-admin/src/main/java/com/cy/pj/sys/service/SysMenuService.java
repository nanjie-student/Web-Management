package com.cy.pj.sys.service;

import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.pojo.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {
    int saveObject(SysMenu sysMenu);
    List<Node> findZtreeMenuNodes();
    List<Map<String,Object>> findObjects();
}
