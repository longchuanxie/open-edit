package com.xielc1.group.open.edit.web.vo;

import com.xielc1.group.open.edit.constant.EnumManager;

import java.io.Serializable;

public class SearchReturnVO implements Serializable {
    private static final long serialVersionUID = 3397505602126067809L;
    private EnumManager.ModuleEnum module;
    /*主键*/
    private String id;
    /*摘要*/
    private String abstractContext;

    public EnumManager.ModuleEnum getModule() {
        return module;
    }

    public void setModule(EnumManager.ModuleEnum module) {
        this.module = module;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbstractContext() {
        return abstractContext;
    }

    public void setAbstractContext(String abstractContext) {
        this.abstractContext = abstractContext;

    }
}
