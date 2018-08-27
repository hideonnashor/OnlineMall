package org.onlinemall.dao.itf;

import org.onlinemall.domain.Category;

public interface CategoryDao {
    public Category queryByName(String cateName);
}
