package com.example.group_work;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CollectionAdapter extends FragmentStateAdapter {
    public CollectionAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int).
        Fragment fragment;
        switch (position){
            case 0:
                fragment  = new DownFragment();
                break;
            case 1:
                fragment = new UpLoad_fragment();
                break;
            default:
                fragment = new ObjectFragment();
                break;
        }

//        Bundle args = new Bundle();
        // The object is just an integer.
//        args.putString(ObjectFragment.ARG_OBJECT,  Integer.toString( position + 1) );
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
