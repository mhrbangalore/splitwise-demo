package com.mohan.split.splitStrategy;

import com.mohan.split.Split;

import java.util.List;

public interface ISplitStrategy {

    void validateSplitRequest(final List<Split> splits, final double totalExpenseAmount);

}
