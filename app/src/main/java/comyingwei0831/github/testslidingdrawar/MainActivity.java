package comyingwei0831.github.testslidingdrawar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import hollowsoft.slidingdrawer.SlidingDrawer;
import hollowsoft.slidingdrawer.OnDrawerCloseListener;
import hollowsoft.slidingdrawer.OnDrawerOpenListener;
import hollowsoft.slidingdrawer.OnDrawerScrollListener;

public class MainActivity extends AppCompatActivity{

    SlidingDrawer drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = (SlidingDrawer) findViewById(R.id.vertical_drawer_activity_sliding_drawer_vertical_drawer);

        /*已修改SlidingDrawer，可以获取整个视图的高度，动态计算出TopOffset*/
       final ViewTreeObserver vto = drawer.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                //vto.removeOnPreDrawListener(this);
                int screenheight = drawer.getMeasuredHeight();
                int pannelHeight = drawer.getWholeViewHeight();
                int offfset = screenheight - pannelHeight;
                drawer.setTopOffset(offfset);
                return true;
            }
        });

//        Log.i("info",  "oncreate,"+height+","+width);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}
