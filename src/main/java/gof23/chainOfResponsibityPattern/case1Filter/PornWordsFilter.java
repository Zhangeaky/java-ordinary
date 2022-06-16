package gof23.chainOfResponsibityPattern.case1Filter;

import gof23.chainOfResponsibityPattern.case1Filter.domain.Content;

public class PornWordsFilter implements SensitiveWordFilter{

    @Override
    public boolean doFilter(Content content) {

        System.out.println("色情词汇过滤...");
        return true;
    }
}
