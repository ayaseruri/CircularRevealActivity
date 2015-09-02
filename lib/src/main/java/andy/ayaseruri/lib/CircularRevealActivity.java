package andy.ayaseruri.lib;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import io.codetail.widget.RevealFrameLayout;

public class CircularRevealActivity extends AppCompatActivity {

    private int[] mClickPoint = new int[2];
    private int circularRevealDuration = 600;

    @Override
    public void setContentView(int layoutResID) {
        final View userView = LayoutInflater.from(this).inflate(layoutResID, null);
        setContentView(userView);
    }

    @Override
    public void setContentView(final View userView) {
        int viewRootId = getResources().getIdentifier("activity_circular_reveal", "layout", getPackageName());
        super.setContentView(viewRootId);

        final RevealFrameLayout revealFrameLayout = (RevealFrameLayout)findViewById(R.id.ripples_effect_activity_root);
        revealFrameLayout.addView(userView);

        int[] clickPoint = getIntent().getIntArrayExtra("start_point");
        if(null != clickPoint){
            mClickPoint = clickPoint;
        }

        final DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);

        revealFrameLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                revealFrameLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                int finalRadius = Math.max(dm.widthPixels, dm.heightPixels);
                SupportAnimator animator =
                        ViewAnimationUtils.createCircularReveal(userView, mClickPoint[0], mClickPoint[1], 0, finalRadius);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(circularRevealDuration);
                animator.start();
                return false;
            }
        });
    }

    public void setCircularRevealDuration(int duration){
        this.circularRevealDuration = duration;
    }

    public void setStartPoint(int x, int y){
        mClickPoint[0] = x;
        mClickPoint[1] = y;
    }
}
