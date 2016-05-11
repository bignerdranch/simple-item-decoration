package com.dgreenhalgh.android.simpleitemdecoration.linear;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Adds an offset to the start of a RecyclerView using a LinearLayoutManager or
 * its subclass.
 * <p>
 * If the RecyclerView.LayoutManager is oriented vertically, the offset will be
 * added to the top of the RecyclerView. If the LayoutManager is oriented
 * horizontally, the offset will be added to the left of the RecyclerView.
 */
public class StartOffsetItemDecoration extends RecyclerView.ItemDecoration {

    private int mOffsetPx;
    private Drawable mOffsetDrawable;
    private int mOrientation;

    /**
     * Constructor that takes in the size of the offset to be added to the
     * start of the RecyclerView.
     *
     * @param offsetPx The size of the offset to be added to the start of the
     *                 RecyclerView in pixels
     */
    public StartOffsetItemDecoration(int offsetPx) {
        mOffsetPx = offsetPx;
    }

    /**
     * Constructor that takes in a {@link Drawable} to be drawn at the start of
     * the RecyclerView.
     *
     * @param offsetDrawable The {@code Drawable} to be added to the start of
     *                       the RecyclerView
     */
    public StartOffsetItemDecoration(Drawable offsetDrawable) {
        mOffsetDrawable = offsetDrawable;
    }

    /**
     * Constructor that takes in a drawable resource ID referencing a {@link Drawable}
     * to be drawn at the start of the RecyclerView.
     *
     * @param context A context
     * @param offsetDrawableResId A resource ID referencing a {@code Drawable} to be
     *                            added to the start of the RecyclerView
     */
    public StartOffsetItemDecoration(Context context, @DrawableRes int offsetDrawableResId) {
        mOffsetDrawable = ContextCompat.getDrawable(context, offsetDrawableResId);
    }

    /**
     * Determines the size and location of the offset to be added to the start
     * of the RecyclerView.
     *
     * @param outRect The {@link Rect} of offsets to be added around the child view
     * @param view The child view to be decorated with an offset
     * @param parent The RecyclerView onto which dividers are being added
     * @param state The current RecyclerView.State of the RecyclerView
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) > 0) {
            return;
        }

        mOrientation = ((LinearLayoutManager) parent.getLayoutManager()).getOrientation();
        if (mOrientation == LinearLayoutManager.HORIZONTAL) {
            if (mOffsetPx > 0) {
                outRect.left = mOffsetPx;
            } else if (mOffsetDrawable != null) {
                outRect.left = mOffsetDrawable.getIntrinsicWidth();
            }
        } else if (mOrientation == LinearLayoutManager.VERTICAL) {
            if (mOffsetPx > 0) {
                outRect.top = mOffsetPx;
            } else if (mOffsetDrawable != null) {
                outRect.top = mOffsetDrawable.getIntrinsicHeight();
            }
        }
    }

    /**
     * Draws horizontal or vertical offset onto the start of the parent
     * RecyclerView.
     *
     * @param c The {@link Canvas} onto which an offset will be drawn
     * @param parent The RecyclerView onto which an offset is being added
     * @param state The current RecyclerView.State of the RecyclerView
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOffsetDrawable == null) {
            return;
        }

        if (mOrientation == LinearLayoutManager.HORIZONTAL) {
            drawOffsetHorizontal(c, parent);
        } else if (mOrientation == LinearLayoutManager.VERTICAL) {
            drawOffsetVertical(c, parent);
        }
    }


    private void drawOffsetHorizontal(Canvas canvas, RecyclerView parent) {
        int parentTop = parent.getPaddingTop();
        int parentBottom = parent.getHeight() - parent.getPaddingBottom();
        int parentLeft = parent.getPaddingLeft();
        int offsetDrawableRight = parentLeft + mOffsetDrawable.getIntrinsicWidth();

        mOffsetDrawable.setBounds(parentLeft, parentTop, offsetDrawableRight, parentBottom);
        mOffsetDrawable.draw(canvas);
    }

    private void drawOffsetVertical(Canvas canvas, RecyclerView parent) {
        int parentLeft = parent.getPaddingLeft();
        int parentRight = parent.getWidth() - parent.getPaddingRight();
        int parentTop = parent.getPaddingTop();
        int offsetDrawableBottom = parentTop + mOffsetDrawable.getIntrinsicHeight();

        mOffsetDrawable.setBounds(parentLeft, parentTop, parentRight, offsetDrawableBottom);
        mOffsetDrawable.draw(canvas);
    }
}
