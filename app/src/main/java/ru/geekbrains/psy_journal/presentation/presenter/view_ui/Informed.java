package ru.geekbrains.psy_journal.presentation.presenter.view_ui;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface Informed extends MvpView {
	@StateStrategyType(SingleStateStrategy.class)
	void showEmpty();
	@StateStrategyType(SingleStateStrategy.class)
	void showGood(String message);
	@StateStrategyType(SingleStateStrategy.class)
	void showBad(String error);
}
