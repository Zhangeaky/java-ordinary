package com.zhangeaky.algorithm.course.chapter01;

public interface UF {

    /**
     * 在点 p q 之间建立一条连接
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     * 返回 点 p 所在的联通分量的标识
     * @param p
     * @return
     */
    int find(int p);

    /**
     * p q 是否存在于同一个联通分量
     *
     * @return
     */
    boolean connected(int p, int q);

    /**
     * 返回联通分量的个数
     *
     * @return
     */
    int count();


}
