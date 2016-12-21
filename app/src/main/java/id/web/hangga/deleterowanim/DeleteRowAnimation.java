package id.web.hangga.deleterowanim;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

/**
 * Created by hangga on 21/12/16.
 */

public class DeleteRowAnimation extends Animation {
    final int startWidth;
    final int targetWidth;

    final int startHeight;
    final int targetHeight;

    final float startAlpha;
    final float targetAlpha;

    private DeleteRowAnimation deleteRowAnimation;
    private View view;

    public DeleteRowAnimation(final View view) {
        deleteRowAnimation = this;
        this.view = view;
        this.targetHeight = 0;
        this.startHeight = view.getHeight();
        this.targetWidth = 0;
        this.startWidth = view.getWidth();
        this.startAlpha = view.getAlpha();
        this.targetAlpha = 0;
        this.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((LinearLayout)view.getParent()).removeView(view);
                    }
                }, deleteRowAnimation.getDuration());
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float newAlpha = (startAlpha + (targetAlpha - startAlpha) * interpolatedTime);
        view.setAlpha(newAlpha);

        int newHeight = (int) (startHeight + (targetHeight - startHeight) * interpolatedTime);
        int newWidth = (int) (startWidth + (targetWidth - startWidth) * interpolatedTime);
        view.getLayoutParams().height = newHeight;
        view.getLayoutParams().width = newWidth;
        view.requestLayout();
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }

    @Override
    public boolean hasStarted() {
        return super.hasStarted();
    }

}
