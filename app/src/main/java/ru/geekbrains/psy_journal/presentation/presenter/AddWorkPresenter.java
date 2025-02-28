package ru.geekbrains.psy_journal.presentation.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.geekbrains.psy_journal.data.repositories.model.Category;
import ru.geekbrains.psy_journal.data.repositories.model.Functional;
import ru.geekbrains.psy_journal.data.repositories.model.Group;
import ru.geekbrains.psy_journal.data.repositories.model.Journal;
import ru.geekbrains.psy_journal.data.repositories.model.WorkForm;
import ru.geekbrains.psy_journal.data.repositories.RoomHelper;
import ru.geekbrains.psy_journal.presentation.presenter.view_ui.AddWorkView;

@InjectViewState
public class AddWorkPresenter extends MvpPresenter<AddWorkView> implements
	Settable,
	SettableByDate,
	SettableByTime,
	SettableByFunction{

	private static final float HOUR_IN_MINUTES = 60.0f;
	private Journal journal;
	private boolean isRepeated;
	private Disposable disposable;

    @Inject  RoomHelper roomHelper;

	public Journal getJournal() {
		return journal;
	}

    private void getNames() {
        disposable = roomHelper.getListFullNames()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> getViewState().getNames(list),
                        e -> Log.e("getNames: ", e.getMessage()));
    }

	public void initialize(Journal journal){
        getNames();
		if (journal == null) this.journal = new Journal();
		else {
			this.journal = journal;
			isRepeated = true;
			init();
		}
	}

	private void init(){
		getViewState().showDate(journal.getDate());
		getViewState().showNumberOfPeople(journal.getQuantityPeople());
		getViewState().showHours(journal.getWorkTime());
		getCategory(journal.getIdCategory());
		getGroup(journal.getIdGroup());
		getViewState().showName(journal.getName());
		getViewState().showDeclaredRequest(journal.getDeclaredRequest());
		getViewState().showRealRequest(journal.getRealRequest());
		getWorkForm(journal.getIdWorkForm());
		getViewState().showTd(journal.getCodeTd());
		getViewState().showComment(journal.getComment());
	}

	private void getWorkForm(int id){
		if (id == 0) return;
		disposable = roomHelper.getItemWorkForm(id)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(workForm -> getViewState().showWorkForm(workForm.getName()),
				e -> Log.e("getWorkForm: ", e.getMessage()));
	}

	private void getGroup(int id) {
		if (id == 0) return;
		disposable = roomHelper.getItemGroup(id)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(group -> getViewState().showGroup(group.getName()),
					e -> Log.e("getGroup: ", e.getMessage()));
	}

	private void getCategory(int id){
		if (id == 0) return;
		disposable = roomHelper.getItemCategory(id)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(category -> getViewState().showCategory(category.getName()),
				e -> Log.e("getCategory: ", e.getMessage()));
	}

	public void addWorkIntoDatabase(){
		if (isRepeated)	roomHelper.updateItemJournal(journal)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe();
		else roomHelper.insertItemJournal(journal)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe();
	}

    public void setGroup(Group group) {
        journal.setIdGroup(group.getId());
	}

	@Override
    public void saveSelectedCategory(Category category) {
		journal.setIdCategory(category.getId());
		getViewState().showCategory(category.getName());
	}

	@Override
    public void saveSelectedGroup(Group group) {
		journal.setIdGroup(group.getId());
		getViewState().showGroup(group.getName());
	}

	@Override
    public void saveSelectedWorkForm(WorkForm workForm) {
		journal.setIdWorkForm(workForm.getId());
		getViewState().showWorkForm(workForm.getName());
	}

	@Override
	public void setDate(long date) {
		journal.setDate(date);
		getViewState().showDate(date);
	}

	@Override
	public void setHours(int hour, int minutes) {
		float hours = hour + minutes / HOUR_IN_MINUTES;
		journal.setWorkTime(hours);
		getViewState().showHours(hours);
	}

	@Override
	public void setFunction(Functional function, boolean close) {
		String code = function.getCode();
//		if (code.equals(Constants.CODE_OF_OTHER_ACTIVITY)){
//			code = function.getName();
//		}
		if (close){
			journal.setCodeTd(code);
			getViewState().closeDialogs();
			getViewState().showTd(function.getName());
		} else getViewState().openDialogue(function);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (disposable != null) disposable.dispose();
	}
}