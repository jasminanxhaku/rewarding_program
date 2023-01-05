package com.rewarding.program;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RewardsUtil {

    public static final int REWARDS_RATE = 2;
    public static final int FIRST_REWARD_THRESHOLD = 50;
    public static final int SECOND_REWARD_THRESHOLD = 100;

    public int calculateRewardPointsPerTrans(int transactionAmount) {
        log.debug("Customer Transaction Amount:::" + transactionAmount);

        int rewardPoints = 0;
        if (transactionAmount > SECOND_REWARD_THRESHOLD) {
            rewardPoints = (REWARDS_RATE * (transactionAmount - SECOND_REWARD_THRESHOLD) + FIRST_REWARD_THRESHOLD);
        } else if (transactionAmount > FIRST_REWARD_THRESHOLD) {
            rewardPoints = transactionAmount - FIRST_REWARD_THRESHOLD;
        }

        log.debug("Customer Reward Points:::" + rewardPoints);
        return rewardPoints;
    }
}
