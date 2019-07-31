package com.delvo.commerce;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyRewardFragment extends Fragment {


    public MyRewardFragment() {
        // Required empty public constructor
    }
    private RecyclerView rewardsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_reward, container, false);
        rewardsRecyclerView=view.findViewById(R.id.my_rewards_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rewardsRecyclerView.setLayoutManager(layoutManager);
        List<RewardModel> rewardModelList=new ArrayList<>();
        rewardModelList.add(new RewardModel("CashBack","Till 2nd June 2019","Get 20% Cash back when you pay using UPI payment method upto Rs.100 & Total cart amount between Rs.20-1000"));
        rewardModelList.add(new RewardModel("Rewards","Till 1st June 2019","Get 30% Cash back when you pay using UPI payment method upto Rs.100 & Total cart amount between Rs.20-1000"));
        rewardModelList.add(new RewardModel("Demo","Till 30th June 2019","Get 40% Cash back when you pay using UPI payment method upto Rs.100 & Total cart amount between Rs.20-1000"));
        rewardModelList.add(new RewardModel("Swadhin","Till 2nd June 2019","Get 50% Cash back when you pay using UPI payment method upto Rs.100 & Total cart amount between Rs.20-1000"));
        rewardModelList.add(new RewardModel("CashBack","Till 2nd June 2019","Get 60% Cash back when you pay using UPI payment method upto Rs.100 & Total cart amount between Rs.20-1000"));
        rewardModelList.add(new RewardModel("CashBack","Till 2nd June 2019","Get 70% Cash back when you pay using UPI payment method upto Rs.100 & Total cart amount between Rs.20-1000"));
       MyRewardAdaptor myRewardAdaptor=new MyRewardAdaptor(rewardModelList);
       rewardsRecyclerView.setAdapter(myRewardAdaptor);
       myRewardAdaptor.notifyDataSetChanged();

        return view;
    }

}
