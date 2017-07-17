package seek.zz.uidemo.animation.demo;

import android.app.Activity;
import android.os.Bundle;

import seek.zz.uidemo.R;
import seek.zz.uidemo.animation.ActivityAnimationTool;

public class NextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAnimationTool.prepareAnimation(this);
        setContentView(R.layout.activity_next);
        ActivityAnimationTool.animate(this, 100);
    }

    @Override
    protected void onStop() {
        ActivityAnimationTool.cancel(this);
        super.onStop();
    }
}
