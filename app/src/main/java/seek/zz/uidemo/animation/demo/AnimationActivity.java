package seek.zz.uidemo.animation.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import seek.zz.uidemo.R;
import seek.zz.uidemo.animation.ActivityAnimationTool;
import seek.zz.uidemo.animation.BlurEffect;
import seek.zz.uidemo.animation.CloseEffect;
import seek.zz.uidemo.animation.FoldingEffect;
import seek.zz.uidemo.animation.SkewEffect;
import seek.zz.uidemo.animation.SplitEffect;
import seek.zz.uidemo.animation.WaterEffect;

public class AnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        ActivityAnimationTool.init(new WaterEffect());
        findViewById(R.id.iv).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivityAnimationTool.startActivity(AnimationActivity.this, new Intent(AnimationActivity.this, NextActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_blur:
                ActivityAnimationTool.init(new BlurEffect());
                break;
            case R.id.action_close:
                ActivityAnimationTool.init(new CloseEffect());
                break;
            case R.id.action_split:
                ActivityAnimationTool.init(new SplitEffect());
                break;
//            case R.id.action_twister:
//                ActivityAnimationTool.init(new TwisterEffect());
//                break;
            case R.id.action_folding:
                ActivityAnimationTool.init(new FoldingEffect());
                break;
            case R.id.action_skew:
                ActivityAnimationTool.init(new SkewEffect());
                break;
            case R.id.action_water:
                ActivityAnimationTool.init(new WaterEffect());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
