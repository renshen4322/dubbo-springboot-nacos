package com.liyz.dubbo.service.search.remote;

import com.liyz.dubbo.common.remote.bo.PageBaseBO;
import com.liyz.dubbo.common.remote.page.Page;
import com.liyz.dubbo.service.search.bo.RiskConsensusBO;
import com.liyz.dubbo.service.search.bo.RiskConsensusPageQueryBO;

import java.util.List;
import java.util.Map;

/**
 * 注释:
 *
 * @author mark
 * @version 1.0.0
 * @date 2020/7/16 15:18
 */
public interface RemoteRiskConsensusService {

    int save(RiskConsensusBO riskConsensusBO);

    int save(List<RiskConsensusBO> list);

    void delete(Long id);

    void delete(List<Long> ids);

    Page<RiskConsensusBO> search(PageBaseBO pageBaseBO);

    Page<RiskConsensusBO> search(RiskConsensusPageQueryBO queryBO);

    Page<RiskConsensusBO> searchForHighlight(RiskConsensusPageQueryBO queryBO);

    Map<String,Object> aggregateForSentimentType(RiskConsensusPageQueryBO queryBO);
}
