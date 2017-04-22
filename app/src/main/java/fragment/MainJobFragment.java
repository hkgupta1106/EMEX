package fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.himanshu.emex.R;

import android.widget.TextView;

/**
 * Created by himanshu on 13/4/17.
 */

/**
 * main job fragment
 */
public class MainJobFragment extends Fragment {

    private static final String JOB_HISTORY = "jobhistory", MISSED_RIDE = "missedride";
    private ImageView imageView;
    private Button btnjobhistory, btnmissedjobs;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup viewGroup, final Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_main_job, viewGroup, false);

        imageView = (ImageView) view.findViewById(R.id.iv_back_button);
        imageView.setImageResource(R.drawable.ic_menu_button);

        TextView tvcustomtext = (TextView) view.findViewById(R.id.tv_custom_text);
        tvcustomtext.setText("Job History");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(Gravity.START);
            }
        });

        final ViewPager pager = (ViewPager) view.findViewById(R.id.vp_pager);
        pager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));

        btnjobhistory = (Button) view.findViewById(R.id.btn_job_history);
        btnmissedjobs = (Button) view.findViewById(R.id.btn_missed_jobs);
        btnjobhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                btnjobhistory.setBackgroundResource(R.color.colorPrimary);
                btnmissedjobs.setBackgroundResource(R.color.colorPrimaryDark);
                pager.setCurrentItem(0);
            }
        });

        btnmissedjobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                btnjobhistory.setBackgroundResource(R.color.colorPrimaryDark);
                btnmissedjobs.setBackgroundResource(R.color.colorPrimary);
                pager.setCurrentItem(1);
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                switch (position) {
                    case 0:
                        btnjobhistory.setBackgroundResource(R.color.colorPrimary);
                        btnmissedjobs.setBackgroundResource(R.color.colorPrimaryDark);

                        break;
                    case 1:
                        btnjobhistory.setBackgroundResource(R.color.colorPrimaryDark);
                        btnmissedjobs.setBackgroundResource(R.color.colorPrimary);

                        break;
                    default:
                        btnjobhistory.setBackgroundResource(R.color.colorPrimary);
                        btnmissedjobs.setBackgroundResource(R.color.colorPrimaryDark);
                }
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        return view;
    }

    /**
     * view pager adapter
     */
    class MyPagerAdapter extends FragmentPagerAdapter {

        /**
         * @param fm fragment manager object
         */
        public MyPagerAdapter(final FragmentManager fm) {
            super(fm);
        }

        /**
         * method to get fragment position
         *
         * @param pos position
         * @return position
         */
        @Override
        public Fragment getItem(final int pos) {
            switch (pos) {
                case 0:
                    return new JobFragment(JOB_HISTORY);
                case 1:
                    return new JobFragment(MISSED_RIDE);
                default:
                    return new JobFragment(JOB_HISTORY);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
