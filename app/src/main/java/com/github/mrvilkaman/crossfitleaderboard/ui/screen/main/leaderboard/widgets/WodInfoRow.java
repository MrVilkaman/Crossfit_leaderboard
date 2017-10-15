package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard.widgets;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.github.mrvilkaman.crossfitleaderboard.R;
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseCustomView;
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter;

public class WodInfoRow extends BaseCustomView<BasePresenter> {

	public WodInfoRow(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	public WodInfoRow(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onViewCreate(@NonNull View inflate, @NonNull Context context, @Nullable AttributeSet attrs) {

	}

	@Override
	protected int getLayoutId() {
		return R.layout.item_wod_info_row;
	}
}
