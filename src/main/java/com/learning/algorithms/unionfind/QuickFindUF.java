package com.learning.algorithms.unionfind;

public class QuickFindUF {

    private int[] id;
    private int connectedComponentsCount;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        connectedComponentsCount = N;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];
        if (pId == qId)
            return;
        connectedComponentsCount--;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId)
                id[i] = qId;
        }
    }

    public int getConnectedComponentsCount() {
        return connectedComponentsCount;
    }

}
