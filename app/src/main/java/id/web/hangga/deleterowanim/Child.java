package id.web.hangga.deleterowanim;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by hangga on 20/12/16.
 */

public class Child extends RelativeLayout {

    public ImageView getImgDelete() {
        return imgDelete;
    }

    private ImageView imgDelete;
    private Context mContext;
    private Child child;

    private static long DURASI = 1000;

    public Child(Context context, Integer color) {
        super(context);
        initInflate(context);
        this.setBackgroundColor(color);
    }

    public Child(Context context) {
        super(context);
        initInflate(context);
    }

    public Child(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate(context);
    }

    public Child(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate(context);
    }

    public void initInflate(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_child, this);
        init(context);
    }

    private void init(Context context){
        child = this;
        mContext = context;
        if (!isInEditMode()){
            imgDelete = (ImageView) findViewById(R.id.imgDelete);
            /*imgDelete.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    DeleteRowAnimation anim = new DeleteRowAnimation(child);
                    anim.setDuration(DURASI);
                    child.startAnimation(anim);
                }
            });*/
        }
    }
}
