package com.mohan.split.splitStrategy;

import com.mohan.split.Split;

import java.util.List;

public class PercentageSplitStrategy implements ISplitStrategy{
    @Override
    public void validateSplitRequest(List<Split> splits, double totalExpenseAmount) {
        double sum = 0;
        for (Split split : splits){
            sum += split.getAmountOwe();
        }
        if (sum != totalExpenseAmount){
            throw new IllegalArgumentException("Sum of participants share does not equal the total expense amount");
        }
    }
}
