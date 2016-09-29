package remix.myplayer.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import remix.myplayer.R;
import remix.myplayer.ui.MultiChoice;
import remix.myplayer.ui.dialog.TimerDialog;

/**
 * @ClassName
 * @Description
 * @Author Xiaoborui
 * @Date 2016/9/29 10:37
 */
public class MultiChoiceActivity extends ToolbarActivity {
    protected MultiChoice mMultiChoice = null;

    public void setMultiChoice(MultiChoice MultiChoice) {
        this.mMultiChoice = MultiChoice;
    }

    public MultiChoice getMultiChoice(){
        return mMultiChoice;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(Color.parseColor("#ffffffff"));
//        toolbar.setBackgroundColor(ColorUtil.getColor(ThemeStore.MATERIAL_COLOR_PRIMARY));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.common_btn_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNavigation();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toolbar_search:
                        startActivity(new Intent(ToolbarActivity.this, SearchActivity.class));
                        break;
                    case R.id.toolbar_timer:
                        startActivity(new Intent(ToolbarActivity.this, TimerDialog.class));
                        break;
                    case R.id.toolbar_delete:
                        if(mMultiChoice != null)
                            mMultiChoice.OnDelete();
                        break;
                    case R.id.toolbar_add_playing:
                        if(mMultiChoice != null)
                            mMultiChoice.OnAddToPlayingList();
                        break;
                    case R.id.toolbar_add_playlist:
                        if(mMultiChoice != null)
                            mMultiChoice.OnAddToPlayList();
                        break;
                }
                return true;
            }
        });
    }
}