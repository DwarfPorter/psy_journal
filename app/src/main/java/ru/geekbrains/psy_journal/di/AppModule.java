package ru.geekbrains.psy_journal.di;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.geekbrains.psy_journal.data.database.DataBaseFirstLoader;
import ru.geekbrains.psy_journal.data.repositories.RoomHelper;
import ru.geekbrains.psy_journal.data.database.dao.AppDatabase;
import ru.geekbrains.psy_journal.data.database.dao.CategoryDao;
import ru.geekbrains.psy_journal.data.database.dao.GroupDao;
import ru.geekbrains.psy_journal.data.database.dao.JournalDao;
import ru.geekbrains.psy_journal.data.database.dao.OTFDao;
import ru.geekbrains.psy_journal.data.database.dao.ReportDao;
import ru.geekbrains.psy_journal.data.database.dao.TDDao;
import ru.geekbrains.psy_journal.data.database.dao.TFDao;
import ru.geekbrains.psy_journal.data.database.dao.WorkFormDao;
import ru.geekbrains.psy_journal.presentation.view.dialogs.factory.CatalogFactory;

import static ru.geekbrains.psy_journal.Constants.DATABASE_NAME;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context getContext() {
        return context;
    }

    @Provides
    RoomHelper getRoomHelper() {
        return new RoomHelper();
    }

    @Provides
    JournalDao getJournalDao() {
        return getAppDatabase().journalDao();
    }

    @Provides
    OTFDao getOTFDao() {
        return getAppDatabase().otfDao();
    }

    @Provides
    TFDao getTFDao() {
        return getAppDatabase().tfDao();
    }

    @Provides
    TDDao getTDDao() {
        return getAppDatabase().tdDao();
    }

    @Provides
    CategoryDao getCategoryDao() {
        return getAppDatabase().categoryDao();
    }

    @Provides
    GroupDao getGroupDao() {
        return getAppDatabase().groupDao();
    }

    @Provides
    WorkFormDao getWorkFormDao() {
        return getAppDatabase().workFormDao();
    }

    @Provides
    AppDatabase getAppDatabase() {
        return Room.databaseBuilder(context,
                AppDatabase.class, DATABASE_NAME).build();
    }

    @Provides
    @Singleton
    DataBaseFirstLoader getDataBaseFirstLoader() {
        return new DataBaseFirstLoader();
    }

    @Provides
    @Singleton
    CatalogFactory getCatalogFactory() {
        return new CatalogFactory();
    }

    @Provides
    ReportDao getReportDao() {
        return getAppDatabase().reportDao();
    }

}
