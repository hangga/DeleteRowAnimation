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

    public static int ALPHA = 0;
    public static int SWIPE_LEFT = 1;
    public static int SWIPE_UP = 2;

    public void setAnimType(int animType) {
        this.animType = animType;
    }

    private int animType = ALPHA; // default

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
        if (this.animType == ALPHA) {
            float newAlpha = (startAlpha + (targetAlpha - startAlpha) * interpolatedTime);
            view.setAlpha(newAlpha);
        } else if (this.animType == SWIPE_LEFT){
            int newWidth = (int) (startWidth + (targetWidth - startWidth) * interpolatedTime);
            view.getLayoutParams().width = newWidth;
            view.requestLayout();
        } else if (this.animType == SWIPE_UP){
            int newHeight = (int) (startHeight + (targetHeight - startHeight) * interpolatedTime);
            view.getLayoutParams().height = newHeight;
            view.requestLayout();
        }
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
