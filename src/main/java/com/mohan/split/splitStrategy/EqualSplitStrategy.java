package com.mohan.split.splitStrategy;

import com.mohan.split.Split;

import java.util.List;

public class EqualSplitStrategy implements ISplitStrategy{
    @Override
    public void validateSplitRequest(List<Split> splits, double totalExpenseAmount) {
        double amountToPay = totalExpenseAmount / splits.size();
        for (Split split : splits){
            if (split.getAmountOwe() != amountToPay){
                throw new IllegalArgumentException("Split strategy requires amount to be split equally across participants");
            }
        }
    }
}
