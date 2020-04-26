package com.zalocoders.cornerstone.Adapters;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.zalocoders.cornerstone.fragments.DiscoverFragment;
import com.zalocoders.cornerstone.fragments.FeedFragment;
import com.zalocoders.cornerstone.fragments.GivingFragment;
import com.zalocoders.cornerstone.fragments.HymnalFragment;
import com.zalocoders.cornerstone.fragments.SermonFragment;



public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0 :
            return new SermonFragment();
            case 1:
                return  new GivingFragment();
            case 2:
                return  new FeedFragment();
            case 3:
                return new DiscoverFragment();
            case 4:
                return new HymnalFragment();
            default:
                return  new FeedFragment();

        }


    }

    @Override
    public int getCount() {
        return 5;
    }
}
