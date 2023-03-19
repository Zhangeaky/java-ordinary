package com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter;

import com.zhangeaky.se.gof23.chainOfResponsibityPattern.case1Filter.domain.Content;

public class Application {


    public static void main(String[] args) {
        FilterPipeline pipeline = new FilterPipeline();

        pipeline.addFilter(new AdsWordFilter());
        pipeline.addFilter(new PoliticalWordFilter());
        pipeline.addFilter(new PornWordsFilter());
        pipeline.filter(new Content("嗓子痛请用金嗓子！"));
    }
}
