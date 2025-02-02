package com.liyz.dubbo.service.search.service;

import com.liyz.dubbo.service.search.model.ShortPathDO;
import com.liyz.dubbo.service.search.repository.ShortPathRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 注释:
 *
 * @author mark
 * @version 1.0.0
 * @date 2020/11/5 10:40
 */
@Slf4j
@Service
public class ShortPathService {

    @Autowired
    ShortPathRepository shortPathRepository;
    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 删除
     *
     * @param id
     */
    public void delete(String id) {
        List<String> ids = new ArrayList<>();
        ids.add(id);
        delete(ids);
    }

    /**
     * 删除
     *
     * @param ids
     */
    public void delete(List<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<ShortPathDO> doList = new ArrayList<>(ids.size());
            for (String id : ids) {
                ShortPathDO shortPathDO = new ShortPathDO();
                shortPathDO.setId(id);
                doList.add(shortPathDO);
            }
            shortPathRepository.deleteAll(doList);
        }
    }
}
