package com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter;

import com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter.domain.Content;

public interface SensitiveWordFilter {
    boolean doFilter(Content content);
}
