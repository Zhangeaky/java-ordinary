package GoF23.chainOfResponsibityPattern.case1Filter;

import GoF23.chainOfResponsibityPattern.case1Filter.domain.Content;

public interface SensitiveWordFilter {
    boolean doFilter(Content content);
}
