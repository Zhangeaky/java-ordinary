package gof23.chainOfResponsibityPattern.case1Filter;

import gof23.chainOfResponsibityPattern.case1Filter.domain.Content;

public interface SensitiveWordFilter {
    boolean doFilter(Content content);
}
