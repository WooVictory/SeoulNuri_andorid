package com.hello.seoulnuri;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hello.seoulnuri.info.InfoFragment;
import com.hello.seoulnuri.view.course.CourseFragment;
import com.hello.seoulnuri.view.planner.PlannerFragment;

public class MainActivity extends AppCompatActivity
        implements MainFragment.OnFragmentInteractionListener,
        InfoFragment.OnFragmentInteractionListener,
        PlannerFragment.OnFragmentInteractionListener,
        CourseFragment.OnFragmentInteractionListener,
        MypageFragment.OnFragmentInteractionListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            Window w = getWindow(); // in Activity's onCreate() for instance
            //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/


        PagerAdapter adapter = new PagerAdapter(
                getSupportFragmentManager()
        );
        CustomViewPager viewPager = (CustomViewPager) findViewById(R.id.view_pager);
        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(adapter);
        




        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 56));

        final ImageView mainIcon = new ImageView(this);
        mainIcon.setImageResource(R.drawable.bar_main);
        mainIcon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final ImageView infoIcon = new ImageView(this);
        infoIcon.setImageResource(R.drawable.bar_info);
        infoIcon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final ImageView plannerIcon = new ImageView(this);
        plannerIcon.setImageResource(R.drawable.bar_planner);
        plannerIcon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final ImageView courseIcon = new ImageView(this);
        courseIcon.setImageResource(R.drawable.bar_course);
        courseIcon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final ImageView mypageIcon = new ImageView(this);
        mypageIcon.setImageResource(R.drawable.bar_mypage);
        mypageIcon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final ImageView mainIconAct = new ImageView(this);
        mainIconAct.setImageResource(R.drawable.bar_main_active);
        mainIconAct.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final ImageView infoIconAct = new ImageView(this);
        infoIconAct.setImageResource(R.drawable.bar_info_active);
        infoIconAct.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final ImageView plannerIconAct = new ImageView(this);
        plannerIconAct.setImageResource(R.drawable.bar_planner_active);
        plannerIconAct.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final ImageView courseIconAct = new ImageView(this);
        courseIconAct.setImageResource(R.drawable.bar_course_active);
        courseIconAct.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final ImageView mypageIconAct = new ImageView(this);
        mypageIconAct.setImageResource(R.drawable.bar_mypage_active);
        mypageIconAct.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        tabLayout.getTabAt(0).setCustomView(mainIconAct);
        tabLayout.getTabAt(1).setCustomView(infoIcon);
        tabLayout.getTabAt(2).setCustomView(plannerIcon);
        tabLayout.getTabAt(3).setCustomView(courseIcon);
        tabLayout.getTabAt(4).setCustomView(mypageIcon);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ImageView iv = (ImageView) tab.getCustomView();
                switch (tab.getPosition()) {
                    case 0:
                        iv.setImageResource(R.drawable.bar_main_active);
                        break;
                    case 1:
                        iv.setImageResource(R.drawable.bar_info_active);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.bar_planner_active);
                        break;
                    case 3:
                        iv.setImageResource(R.drawable.bar_course_active);
                        break;
                    case 4:
                        iv.setImageResource(R.drawable.bar_mypage_active);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab1) {
                ImageView iv = (ImageView) tab1.getCustomView();
                switch (tab1.getPosition()) {
                    case 0:
                        iv.setImageResource(R.drawable.bar_main);
                        break;
                    case 1:
                        iv.setImageResource(R.drawable.bar_info);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.bar_planner);
                        break;
                    case 3:
                        iv.setImageResource(R.drawable.bar_course);
                        break;
                    case 4:
                        iv.setImageResource(R.drawable.bar_mypage);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab2) {
                Log.d("reselected tap", String.valueOf(tab2.getPosition()));
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}