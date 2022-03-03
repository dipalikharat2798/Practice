package com.androdevdk.myfirstwear;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    private WearableRecyclerView wearableRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
        wearableRecyclerView = findViewById(R.id.wearableRecyclerView);
        // Enables Always-on
        setAmbientEnabled();
        // To align the edge children (first and last) with the center of the screen
        wearableRecyclerView.setEdgeItemsCenteringEnabled(true);

        wearableRecyclerView.setLayoutManager(new WearableLinearLayoutManager(this));
        CustomScrollingLayoutCallback customScrollingLayoutCallback =
                new CustomScrollingLayoutCallback();
        wearableRecyclerView.setLayoutManager(
                new WearableLinearLayoutManager(this, customScrollingLayoutCallback));
    }

    public class CustomScrollingLayoutCallback extends WearableLinearLayoutManager.LayoutCallback {
        /**
         * How much should we scale the icon at most.
         */
        private static final float MAX_ICON_PROGRESS = 0.65f;

        private float progressToCenter;

        @Override
        public void onLayoutFinished(View child, RecyclerView parent) {

            // Figure out % progress from top to bottom
            float centerOffset = ((float) child.getHeight() / 2.0f) / (float) parent.getHeight();
            float yRelativeToCenterOffset = (child.getY() / parent.getHeight()) + centerOffset;

            // Normalize for center
            progressToCenter = Math.abs(0.5f - yRelativeToCenterOffset);
            // Adjust to the maximum scale
            progressToCenter = Math.min(progressToCenter, MAX_ICON_PROGRESS);

            child.setScaleX(1 - progressToCenter);
            child.setScaleY(1 - progressToCenter);
        }
    }
}