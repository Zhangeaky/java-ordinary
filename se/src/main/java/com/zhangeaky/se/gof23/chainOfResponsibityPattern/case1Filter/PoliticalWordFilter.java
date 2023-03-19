package com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter;

import com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter.domain.Content;

public class PoliticalWordFilter implements SensitiveWordFilter {

    @Override
    public boolean doFilter(Content content) {
        System.out.println("政治敏感词汇过滤...");
        return true;
    }
}

