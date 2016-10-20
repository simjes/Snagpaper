package com.simjes.snagpaper.wallpaperlist;

import android.widget.AbsListView;

public abstract class EndlessScrollListener implements AbsListView.OnScrollListener {
    private int visibleLimit = 10;
    private int offset = 2;
    private int previousTotalItemCount = 0;
    private boolean loading = true;
    private int startPageIndex = 0;

    public EndlessScrollListener() {

    }

    public EndlessScrollListener(int visibleLimit) {
        this.visibleLimit = visibleLimit;
    }

    public EndlessScrollListener(int startPageIndex, int visibleLimit) {
        this.startPageIndex = startPageIndex;
        this.visibleLimit = visibleLimit;
        this.offset = startPageIndex;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (totalItemCount < previousTotalItemCount) {
            offset = startPageIndex;
            previousTotalItemCount = totalItemCount;
            if (totalItemCount == 0) {

                loading = true;
            }
        }
        if (loading && (totalItemCount > previousTotalItemCount)) {
            loading = false;
            previousTotalItemCount = totalItemCount;
        }
        if (!loading && (firstVisibleItem + visibleItemCount + visibleLimit) >= totalItemCount) {
            loading = onLoadMore(offset++, totalItemCount);
        }
    }

    public abstract boolean onLoadMore(int offset, int totalItemsCount);

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }
}
