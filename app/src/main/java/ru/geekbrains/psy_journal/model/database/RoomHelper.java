package ru.geekbrains.psy_journal.model.database;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import ru.geekbrains.psy_journal.di.App;
import ru.geekbrains.psy_journal.model.data.Category;
import ru.geekbrains.psy_journal.model.data.Group;
import ru.geekbrains.psy_journal.model.data.Journal;
import ru.geekbrains.psy_journal.model.data.OTF;
import ru.geekbrains.psy_journal.model.data.TD;
import ru.geekbrains.psy_journal.model.data.TF;
import ru.geekbrains.psy_journal.model.data.WorkForm;
import ru.geekbrains.psy_journal.model.database.dao.CategoryDao;
import ru.geekbrains.psy_journal.model.database.dao.GroupDao;
import ru.geekbrains.psy_journal.model.database.dao.JournalDao;
import ru.geekbrains.psy_journal.model.database.dao.OTFDao;
import ru.geekbrains.psy_journal.model.database.dao.TDDao;
import ru.geekbrains.psy_journal.model.database.dao.TFDao;
import ru.geekbrains.psy_journal.model.database.dao.WorkFormDao;

public class RoomHelper {

    @Inject
    JournalDao journalDao;

    @Inject
    OTFDao otfDao;

    @Inject
    TFDao tfDao;

    @Inject
    TDDao tdDao;

    @Inject
    CategoryDao categoryDao;

    @Inject
    GroupDao groupDao;

    @Inject
    WorkFormDao workFormDao;

    public RoomHelper() {
        App.getAppComponent().inject(this);
    }

    //Возвращает список всех зарегистрированных единиц работы
    public Single<List<Journal>> getJournalList() {
        return journalDao.getAll().subscribeOn(Schedulers.io());
    }

    //Возвращает список Обобщенных трудовых функций
    public Single<List<OTF>> getOTFList() {
        return otfDao.getAllOtf().subscribeOn(Schedulers.io());
    }

    //Возвращает список Трудовых функций, относящихся к указанной Обобщенной трудовой функции
    public Single<List<TF>> getTFList(int idOTF) {
        return tfDao.getTfByOtf(idOTF).subscribeOn(Schedulers.io());
    }

    //Возвращает список Трудовых действий, относящихся к указанной Трудовой функции
    public Single<List<TD>> getTDList(int idTF) {
        return tdDao.getTdByTf(idTF).subscribeOn(Schedulers.io());
    }

    //Возвращает список категорий людей, с которыми работает пользователь
    public Single<List<Category>> getListCategory() {
        return categoryDao.getAllCategories().subscribeOn(Schedulers.io());
    }

    //Возвращает список групп(классов), с которыми работает пользователь
    public Single<List<Group>> getListGroups() {
        return groupDao.getAllGroups().subscribeOn(Schedulers.io());
    }

    //Возвращает список форм работы пользователя
    public Single<List<WorkForm>> getListWorkForms() {
        return workFormDao.getAllWorkForms().subscribeOn(Schedulers.io());
    }

    public Long insertItemJournal(Journal journal) {
        return journalDao.insert(journal);
    }

    public int deleteItemJournal(Journal journal) {
        return journalDao.delete(journal);
    }

    public int updateItemJournal(Journal journal) {
        return journalDao.update(journal);
    }

    public Single<Long> insertItemOTF(OTF otf) {
        return Single.create((SingleOnSubscribe<Long>)
                emitter -> otfDao.insert(otf)).subscribeOn(Schedulers.io());
    }

    public int deleteItemOTF(OTF otf) {
        return otfDao.delete(otf);
    }

    public int updateItemOTF(OTF otf) {
        return otfDao.update(otf);
    }

    public Single<Long> insertItemTF(TF tf) {
        return Single.create((SingleOnSubscribe<Long>)
                emitter -> tfDao.insert(tf)).subscribeOn(Schedulers.io());
    }

    public int deleteItemTF(TF tf) {
        return tfDao.delete(tf);
    }

    public int updateItemTF(TF tf) {
        return tfDao.update(tf);
    }

    public Single<Long> insertItemTD(TD td) {
        return Single.create((SingleOnSubscribe<Long>)
                emitter -> tdDao.insert(td)).subscribeOn(Schedulers.io());
    }

    public int deleteItemTD(TD td) {
        return tdDao.delete(td);
    }

    public int updateItemTD(TD td) {
        return tdDao.update(td);
    }

    public Single<Long> insertItemCategory(Category category) {
        return Single.create((SingleOnSubscribe<Long>)
                emitter -> categoryDao.insert(category)).subscribeOn(Schedulers.io());
    }

    public int deleteItemCategory(Category category) {
        return categoryDao.delete(category);
    }

    public int updateItemCategory(Category category) {
        return categoryDao.update(category);
    }

    public Single<Long> insertItemGroup(Group group) {
        return Single.create((SingleOnSubscribe<Long>)
                emitter -> groupDao.insert(group)).subscribeOn(Schedulers.io());
    }

    public int deleteItemGroup(Group group) {
        return groupDao.delete(group);
    }

    public int updateItemGroup(Group group) {
        return groupDao.delete(group);
    }

    public Single<Long> insertItemWorkForm(WorkForm workForm) {
        return Single.create((SingleOnSubscribe<Long>)
                emitter -> workFormDao.insert(workForm)).subscribeOn(Schedulers.io());
    }

    public int deleteItemWorkForm(WorkForm workForm) {
        return workFormDao.delete(workForm);
    }

    public int updateItemWorkForm(WorkForm workForm) {
        return workFormDao.update(workForm);
    }

}
