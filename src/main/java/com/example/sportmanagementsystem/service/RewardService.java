package com.example.sportmanagementsystem.service;


import com.example.sportmanagementsystem.model.Reward;
import com.example.sportmanagementsystem.model.User;
import com.example.sportmanagementsystem.repository.RewardRepository;
import com.example.sportmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RewardService {


    private final RewardRepository rewardRepository;



    @Autowired
    public RewardService(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }


    public List<Reward> retrieveAllRewards() {
        return rewardRepository.findAll();
    }

    public Reward findById(int id) {
        return rewardRepository.findById(id);
    }

    public void deleteById(int id) {
        rewardRepository.deleteById(id);
    }


    public Reward patchById(int id, Reward updateReward) {
        Reward reward = findById(id);
        reward.setRewardName(updateReward.getRewardName());
        return rewardRepository.save(reward);
    }


    public Reward createReward(Reward createRewardRequest) {
        return rewardRepository.save(createRewardRequest);
    }
}
