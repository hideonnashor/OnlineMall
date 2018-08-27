package org.onlinemall.domain;

import java.util.Map;

public class Category implements Bean<Category>{
    private int cateId;
    private String cateName;

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public <Category> Category mapToBean(Map<String, Object> map) {
        this.setCateId((Integer) map.get("cate_id"));
        this.setCateName((String) map.get("cate_name"));
        return (Category) this;
    }
}
