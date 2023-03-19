package com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter;

import com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter.domain.Content;

/**
 * 责任链模式 Chain of responsibility
 *
 * 实现一套敏感词汇过滤
 */
public class AdsWordFilter implements SensitiveWordFilter{
    @Override
    public boolean doFilter(Content content) {
        System.out.println("广告过滤...");
        return true;
    }
}
