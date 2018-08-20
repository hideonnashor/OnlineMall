package org.onlinemall.domain;

import java.util.Map;

public interface Bean<T> {
    public <T> T mapToBean(Map<String,Object> map);

}
