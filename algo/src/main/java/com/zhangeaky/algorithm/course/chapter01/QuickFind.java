package com.zhangeaky.algorithm.course.chapter01;

/**
 * 一种find 调用十分快速的实现
 */
public class QuickFind implements UF{

    private int[] id;

    private int count;

    public QuickFind(int N) {
        this.count = N;
        this.id = new int[N];
        for (int i=0;i<N;i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {

        int pID = find(p);
        int qId = find(q);

        if (qId == pID) return;

        for (int i=0;i<id.length;i++) {
            if (id[i] == qId) id[i] = pID;
        }

    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
