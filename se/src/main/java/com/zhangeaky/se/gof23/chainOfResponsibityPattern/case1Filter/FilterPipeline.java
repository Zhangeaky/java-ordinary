package com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter;

import com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter.domain.Content;

import java.util.ArrayList;
import java.util.List;

public class FilterPipeline {

    private List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter) {
        this.filters.add(filter);
    }

    public boolean filter(Content content) {
        for (SensitiveWordFilter filter : filters) {
            boolean necessary = filter.doFilter(content);
            if (!necessary) {
                return false;
            }
        }
        return true;
    }
}
