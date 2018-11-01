package com.dgreenhalgh.android.simpleitemdecoration.grid;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * Adds an offset to the bottom of a RecyclerView with a GridLayoutManager or
 * its subclass.
 */
public class GridBottomOffsetItemDecoration extends RecyclerView.ItemDecoration {

    private int mOffsetPx;
    private Drawable mOffsetDrawable;
    private int mNumColumns;

    /**
     * Constructor that takes in the size of the offset to be added to the
     * bottom of the RecyclerView.
     *
     * @param offsetPx The size of the offset to be added to the bottom of the
     *                 RecyclerView in pixels
     * @param numColumns The number of columns in the grid of the RecyclerView
     */
    public GridBottomOffsetItemDecoration(int offsetPx, int numColumns) {
        mOffsetPx = offsetPx;
        mNumColumns = numColumns;
    }

    /**
     * Constructor that takes in a {@link Drawable} to be drawn at the bottom
     * of the RecyclerView.
     *
     * @param offsetDrawable The {@code Drawable} to be added to the bottom of
     *                       the RecyclerView
     * @param numColumns The number of columns in the grid of the RecyclerView
     */
    public GridBottomOffsetItemDecoration(Drawable offsetDrawable, int numColumns) {
        mOffsetDrawable = offsetDrawable;
        mNumColumns = numColumns;
    }

    /**
     * Determines the size and the location of the offset to be added to the
     * bottom of the RecyclerView.
     *
     * @param outRect The {@link Rect} of offsets to be added around the child view
     * @param view The child view to be decorated with an offset
     * @param parent The RecyclerView onto which dividers are being added
     * @param state The current RecyclerView.State of the RecyclerView
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int childCount = state.getItemCount();
        int lastRowChildCount = getLastRowChildCount(childCount);

        boolean childIsInBottomRow = parent.getChildAdapterPosition(view) >= childCount - lastRowChildCount;
        if (childIsInBottomRow) {
            if (mOffsetPx > 0) {
                outRect.bottom = mOffsetPx;
            } else {
                outRect.bottom = mOffsetDrawable.getIntrinsicHeight();
            }
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOffsetDrawable == null) {
            return;
        }

        int childCount = state.getItemCount();
        int lastRowChildCount = getLastRowChildCount(childCount);

        int parentLeft = parent.getPaddingLeft();
        int parentRight = parent.getWidth() - parent.getPaddingRight();
        int offsetDrawableTop = 0;
        int offsetDrawableBottom = 0;

        for (int i = childCount - lastRowChildCount; i < childCount; i++) {
            View child = parent.getChildAt(i);
            offsetDrawableTop = child.getBottom();
            offsetDrawableBottom = offsetDrawableTop + mOffsetDrawable.getIntrinsicHeight();
        }

        mOffsetDrawable.setBounds(parentLeft, offsetDrawableTop, parentRight, offsetDrawableBottom);
        mOffsetDrawable.draw(c);
    }

    private int getLastRowChildCount(int itemCount) {
        int lastRowChildCount = itemCount % mNumColumns;
        if (lastRowChildCount == 0) {
            lastRowChildCount = mNumColumns;
        }

        return lastRowChildCount;
    }
}
