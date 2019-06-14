package ru.geekbrains.psy_journal.model.database;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.geekbrains.psy_journal.di.App;
import ru.geekbrains.psy_journal.model.data.Category;
import ru.geekbrains.psy_journal.model.data.Group;
import ru.geekbrains.psy_journal.model.data.OTF;
import ru.geekbrains.psy_journal.model.data.TD;
import ru.geekbrains.psy_journal.model.data.TF;
import ru.geekbrains.psy_journal.model.data.WorkForm;

/**
 * Огромный такой костыль, который сейчас заменяет класс, который должен парсить xml с профстандартом
 */
public class DataBaseFirstLoader {

    @Inject
    RoomHelper roomHelper;

    List<OTF> otfList = new ArrayList<>();
    List<TF> tfList = new ArrayList<>();
    ArrayList<TD> tdList = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();
    List<Group> groupList = new ArrayList<>();
    List<WorkForm> workFormList = new ArrayList<>();

    public DataBaseFirstLoader() {
        App.getAppComponent().inject(this);
    }

    public void initDataBase() {
        otfList.add(new OTF(1, "A", "Психолого-педагогическое сопровождение образовательного процесса в образовательных организациях общего, профессионального и дополнительного образования, сопровождение основных и дополнительных образовательных программ"));
        otfList.add(new OTF(2, "B", "Оказание психолого-педагогической помощи лицам с ограниченными возможностями здоровья, испытывающим трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетним обучающимся, признанным в случаях и в порядке, которые предусмотрены уголовно-процессуальным законодательством, подозреваемыми, обвиняемыми или подсудимыми по уголовному делу либо являющимся потерпевшими или свидетелями преступления"));
//        roomHelper.insertListOTF(otfList).subscribe();
	    roomHelper.initializeOTF(otfList);

        tfList.add(new TF(1, "А/01.7", "Психолого-педагогическое и методическое сопровождение реализации основных и дополнительных образовательных программ", 1));
        tfList.add(new TF(2, "А/02.7", "Психологическая экспертиза (оценка) комфортности и безопасности образовательной среды образовательных организаций", 1));
        tfList.add(new TF(3, "А/03.7", "Психологическое консультирование субъектов образовательного процесса", 1));
        tfList.add(new TF(4, "А/04.7", "Коррекционно-развивающая работа с детьми и обучающимися, в том числе работа по восстановлению и реабилитации", 1));
        tfList.add(new TF(5, "А/05.7", "Психологическая диагностика детей и обучающихся", 1));
        tfList.add(new TF(6, "А/06.7", "Психологическое просвещение субъектов образовательного процесса", 1));
        tfList.add(new TF(7, "А/07.7", "Психопрофилактика (профессиональная деятельность, направленная на сохранение и укрепление психологического здоровья обучающихся в процессе обучения и воспитания в образовательных организациях)", 1));
        tfList.add(new TF(8, "В/01.6", "Психологическое просвещение субъектов образовательного процесса в области работы по поддержке лиц с ограниченными возможностями здоровья, детей и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации", 2));
        tfList.add(new TF(9, "В/02.7", "Психологическая профилактика нарушений поведения и отклонений в развитии лиц с ограниченными возможностями здоровья, детей и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации", 2));
        tfList.add(new TF(10, "В/03.7", "Психологическое консультирование лиц с ограниченными возможностями здоровья и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации", 2));
        tfList.add(new TF(11, "В/04.7", "Психологическая коррекция поведения и развития детей и обучающихся с ограниченными возможностями здоровья, а также обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации", 2));
        tfList.add(new TF(12, "В/05.7", "Психологическая диагностика особенностей лиц с ограниченными возможностями здоровья, обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в случаях и в порядке, которые предусмотрены уголовно-процессуальным законодательством, подозреваемыми, обвиняемыми или подсудимыми по уголовному делу либо являющихся потерпевшими или свидетелями преступления, по запросу органов и учреждений системы профилактики безнадзорности и правонарушений несовершеннолетних", 2));
//        roomHelper.insertListTF(tfList).subscribe();
	    roomHelper.initializeTF(tfList);

        tdList.add(new TD(1, "А/01.7.1", "Формирование и реализация планов развивающей работы с обучающимися с учетом их индивидуально-психологических особенностей", 1));
        tdList.add(new TD(2, "А/01.7.2", "Разработка программ развития универсальных учебных действий, программ воспитания и социализации обучающихся, воспитанников, коррекционных программ", 1));
        tdList.add(new TD(3, "А/01.7.3", "Разработка психологических рекомендаций по формированию и реализации индивидуальных учебных планов для творчески одаренных обучающихся и воспитанников", 1));
        tdList.add(new TD(4, "А/01.7.4", "Разработка совместно с педагогом индивидуальных учебных планов обучающихся с учетом их психологических особенностей", 1));
        tdList.add(new TD(5, "А/01.7.5", "Разработка и реализация мониторинга личностной и метапредметной составляющей результатов освоения основной общеобразовательной программы, установленной федеральными государственными образовательными стандартами", 1));
        tdList.add(new TD(6, "А/01.7.6", "Оформление и ведение документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 1));
        tdList.add(new TD(7, "А/02.7.1", "Психологический мониторинг и анализ эффективности использования методов и средств образовательной деятельности", 2));
        tdList.add(new TD(8, "А/02.7.2", "Психологическая экспертиза программ развития образовательной организации с целью определения степени безопасности и комфортности образовательной среды", 2));
        tdList.add(new TD(9, "А/02.7.3", "Консультирование педагогов и преподавателей образовательных организаций при выборе образовательных технологий с учетом индивидуально-психологических особенностей и образовательных потребностей обучающихся", 2));
        tdList.add(new TD(10, "А/02.7.4", "Оказание психологической поддержки педагогам и преподавателям в проектной деятельности по совершенствованию образовательного процесса", 2));
        tdList.add(new TD(11, "А/02.7.5", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 2));
        tdList.add(new TD(12, "А/03.7.1", "Консультирование обучающихся по проблемам самопознания, профессионального самоопределения, личностным проблемам, вопросам взаимоотношений в коллективе и другим вопросам", 3));
        tdList.add(new TD(13, "А/03.7.2", "Консультирование администрации, педагогов, преподавателей и других работников образовательных организаций по проблемам взаимоотношений в трудовом коллективе и другим профессиональным вопросам", 3));
        tdList.add(new TD(14, "А/03.7.3", "Консультирование педагогов и преподавателей по вопросам разработки и реализации индивидуальных программ для построения индивидуального образовательного маршрута с учетом особенностей и образовательных потребностей конкретного обучающегося", 3));
        tdList.add(new TD(15, "А/03.7.4", "Консультирование родителей (законных представителей) по проблемам взаимоотношений с обучающимися, их развития, профессионального самоопределения и другим вопросам", 3));
        tdList.add(new TD(16, "А/03.7.5", "Консультирование администрации образовательной организации, педагогов, преподавателей, родителей (законных представителей) по психологическим проблемам обучения, воспитания и развития обучающихся", 3));
        tdList.add(new TD(17, "А/03.7.6", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 3));
        tdList.add(new TD(18, "А/04.7.1", "Разработка и реализация планов проведения коррекционно-развивающих занятий для детей и обучающихся, направленных на развитие интеллектуальной, эмоционально-волевой сферы, познавательных процессов, снятие тревожности, решение проблем в сфере общения, преодоление проблем в общении и поведении", 4));
        tdList.add(new TD(19, "А/04.7.2", "Организация и совместное осуществление педагогами, учителями-дефектологами, учителями-логопедами, социальными педагогами психолого-педагогической коррекции выявленных в психическом развитии детей и обучающихся недостатков, нарушений социализации и адаптации", 4));
        tdList.add(new TD(20, "А/04.7.3", "Формирование и реализация планов по созданию образовательной среды для обучающихся с особыми образовательными потребностями, в том числе одаренных обучающихся", 4));
        tdList.add(new TD(21, "А/04.7.4", "Проектирование в сотрудничестве с педагогами индивидуальных образовательных маршрутов для обучающихся", 4));
        tdList.add(new TD(22, "А/04.7.5", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 4));
        tdList.add(new TD(23, "А/05.7.1", "Психологическая диагностика с использованием современных образовательных технологий, включая информационные образовательные Ресурсы", 5));
        tdList.add(new TD(24, "А/05.7.2", "Скрининговые обследования (мониторинг) с целью анализа динамики психического развития, определение лиц, нуждающихся в психологической помощи", 5));
        tdList.add(new TD(25, "А/05.7.3", "Составление психолого-педагогических заключений по результатам диагностического обследования с целью ориентации педагогов, преподавателей, администрации образовательных организаций и родителей (законных представителей) в проблемах личностного и социального развития обучающихся", 5));
        tdList.add(new TD(26, "А/05.7.4", "Определение степени нарушений в психическом, личностном и социальном развитии детей и обучающихся, участие в работе психолого-медико-педагогических комиссий и консилиумов", 5));
        tdList.add(new TD(27, "А/05.7.5", "Изучение интересов, склонностей, способностей детей и обучающихся, предпосылок одаренности", 5));
        tdList.add(new TD(28, "А/05.7.6", "Осуществление с целью помощи в профориентации комплекса диагностических мероприятий по изучению способностей, склонностей, направленности и мотивации, личностных, характерологических и прочих особенностей в соответствии с федеральными государственными образовательными стандартами общего образования соответствующего уровня", 5));
        tdList.add(new TD(29, "А/05.7.7", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 5));
        tdList.add(new TD(30, "А/06.7.1", "Ознакомление педагогов, преподавателей и администрации образовательных организаций с современными исследованиями в области психологии дошкольного, младшего школьного, подросткового, юношеского возраста", 6));
        tdList.add(new TD(31, "А/06.7.2", "Информирование субъектов образовательного процесса о формах и результатах своей профессиональной деятельности", 6));
        tdList.add(new TD(32, "А/06.7.3", "Ознакомление педагогов, преподавателей, администрации образовательных организаций и родителей (законных представителей) с основными условиями психического развития ребенка (в рамках консультирования, педагогических советов)", 6));
        tdList.add(new TD(33, "А/06.7.4", "Ознакомление педагогов, преподавателей и администрации образовательных организаций с современными исследованиями в области профилактики социальной адаптации", 6));
        tdList.add(new TD(34, "А/06.7.5", "Просветительская работа с родителями (законными представителями) по принятию особенностей поведения, миропонимания, интересов и склонностей, в том числе одаренности ребенка", 6));
        tdList.add(new TD(35, "А/06.7.6", "Информирование о факторах, препятствующих развитию личности детей, воспитанников и обучающихся о мерах по оказанию им различного вида психологической помощи", 6));
        tdList.add(new TD(36, "А/06.7.7", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 6));
        tdList.add(new TD(37, "А/07.7.1", "Выявление условий, неблагоприятно влияющих на развитие личности обучающихся", 7));
        tdList.add(new TD(38, "А/07.7.2", "Разработка психологических рекомендаций по проектированию образовательной среды, комфортной и безопасной для личностного развития обучающегося на каждом возрастном этапе, для своевременного предупреждения нарушений в развитии и становлении личности, ее аффективной, интеллектуальной и волевой сфер", 7));
        tdList.add(new TD(39, "А/07.7.3", "Планирование и реализация совместно с педагогом превентивных мероприятий по профилактике возникновения социальной дезадаптации, аддикций и девиаций поведения", 7));
        tdList.add(new TD(40, "А/07.7.4", "Разъяснение субъектам образовательного процесса необходимости применения сберегающих здоровье технологий, оценка результатов их применения", 7));
        tdList.add(new TD(41, "А/07.7.5", "Разработка рекомендаций субъектам образовательного процесса по вопросам психологической готовности и адаптации к новым образовательным условиям (поступление в дошкольную образовательную организацию, начало обучения, переход на новый уровень образования, в новую образовательную организацию)", 7));
        tdList.add(new TD(42, "А/07.7.6", "Разработка рекомендаций для педагогов, преподавателей по вопросам социальной интеграции и социализации дезадаптивных обучающихся и воспитанников, обучающихся с девиантными и аддиктивными проявлениями в поведении", 7));
        tdList.add(new TD(43, "А/07.7.7", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 7));
        tdList.add(new TD(44, "B/01.6.1", "Ознакомление педагогов, преподавателей и администрации образовательных организаций и организаций, осуществляющих образовательную деятельность, с современными исследованиями в области психологии дошкольного, младшего школьного, подросткового, юношеского возраста лиц с ограниченными возможностями здоровья, детей и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетним обучающимся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 8));
        tdList.add(new TD(45, "B/01.6.2", "Ознакомление педагогов, преподавателей, администрации образовательных организаций и организаций, осуществляющих образовательную деятельность, а также родителей (законных представителей) с основными условиями психического развития лиц с ограниченными возможностями здоровья, детей и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации (в рамках консультирования, педагогических советов)", 8));
        tdList.add(new TD(46, "B/01.6.3", "Просветительская работа с родителями (законными представителями) лиц с ограниченными возможностями здоровья, детей и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 8));
        tdList.add(new TD(47, "B/01.6.4", "Ознакомление педагогов, преподавателей и администрации образовательных организаций с современными исследованиями в области профилактики социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 8));
        tdList.add(new TD(48, "B/01.6.5", "Помощь в формировании психологической культуры субъектов образовательного процесса", 8));
        tdList.add(new TD(49, "B/01.6.6", "Помощь в сохранении и укреплении психологического здоровья лиц с ограниченными возможностями здоровья, детей и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 8));
        tdList.add(new TD(50, "B/01.6.7", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 8));
        tdList.add(new TD(51, "B/02.7.1", "Выявление условий, затрудняющих становление и развитие личности лиц с ограниченными возможностями здоровья, детей и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления, с учетом особенностей их психофизического развития, индивидуальных возможностей и особых образовательных потребностей", 9));
        tdList.add(new TD(52, "B/02.7.2", "Профилактическая работа с учетом особенностей психофизического развития, индивидуальных возможностей и особых образовательных потребностей лиц с ограниченными возможностями здоровья, детей и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 9));
        tdList.add(new TD(53, "B/02.7.3", "Разработка предложений по формированию сберегающих здоровье образовательных технологий, здорового образа жизни", 9));
        tdList.add(new TD(54, "B/02.7.4", "Разработка рекомендаций родителям (законным представителям) по вопросам психологической готовности к переходу на следующий уровень образования лиц с ограниченными возможностями здоровья, детей и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 9));
        tdList.add(new TD(55, "B/02.7.5", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 9));
        tdList.add(new TD(56, "B/03.7.1", "Консультирование обучающихся по проблемам самопознания, профессионального самоопределения, личностным проблемам", 10));
        tdList.add(new TD(57, "B/03.7.2", "Консультирование преподавателей и других работников образовательной организации и организации, осуществляющей образовательную деятельность, по проблемам взаимоотношений с обучающимися и другим профессиональным вопросам", 10));
        tdList.add(new TD(58, "B/03.7.3", "Консультирование педагогических работников по вопросам разработки и реализации индивидуальных программ обучения для лиц с ограниченными возможностями здоровья и обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления, с учетом особенностей и образовательных потребностей конкретного обучающегося", 10));
        tdList.add(new TD(59, "B/03.7.4", "Консультирование родителей (законных представителей) по проблемам взаимоотношений с обучающимися, воспитанниками с ограниченными возможностями здоровья, а также находящимися в трудных жизненных ситуациях, по вопросам их профессионального самоопределения", 10));
        tdList.add(new TD(60, "B/03.7.5", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 10));
        tdList.add(new TD(61, "B/04.7.1", "Разработка и реализация планов коррекционно-развивающих занятий для обучающихся, направленных на развитие интеллектуальной, эмоционально-волевой сферы, познавательных процессов, снятие тревожности, решение проблем в сфере общения", 11));
        tdList.add(new TD(62, "B/04.7.2", "Организация и осуществление совместно со специалистами (педагогами, преподавателями, учителями-дефектологами, учителями-логопедами) психолого-педагогической коррекции отклонений в психическом развитии обучающихся, нарушений социализации", 11));
        tdList.add(new TD(63, "B/04.7.3", "Формирование совместно с иными педагогическими работниками для обучающихся с ограниченными возможностями здоровья, а также для обучающихся, находящихся в трудной жизненной ситуации, образовательной среды, удовлетворяющей их интересам и потребностям", 11));
        tdList.add(new TD(64, "B/04.7.4", "Разработка программ психологической коррекции поведения и нарушений в развитии обучающихся и сопровождение их реализации в образовательной организации и организации, осуществляющей образовательную деятельность", 11));
        tdList.add(new TD(65, "B/04.7.5", "Проведение коррекционно-развивающих занятий с обучающимися в соответствии с категорией детей с ограниченными возможностями здоровья", 11));
        tdList.add(new TD(66, "B/04.7.6", "Разработка и проведение профилактических, диагностических, развивающих мероприятий в образовательных организациях различных типов", 11));
        tdList.add(new TD(67, "B/04.7.7", "Разработка и реализация программ профилактики и коррекции девиаций и асоциального поведения обучающихся", 11));
        tdList.add(new TD(68, "B/04.7.8", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 11));
        tdList.add(new TD(69, "B/05.7.1", "Психологическая диагностика с использованием современных образовательных технологий, включая информационные образовательные ресурсы", 12));
        tdList.add(new TD(70, "B/05.7.2", "Скрининговые обследования с целью мониторинга психического развития лиц с ограниченными возможностями здоровья, обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 12));
        tdList.add(new TD(71, "B/05.7.3", "Составление психолого-педагогических заключений по результатам диагностического обследования с целью ориентации педагогов и родителей (законных представителей) в проблемах личностного и социального развития лиц с ограниченными возможностями здоровья, обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 12));
        tdList.add(new TD(72, "B/05.7.4", "Определение степени нарушений в психическом и личностном развитии лиц с ограниченными возможностями здоровья, обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 12));
        tdList.add(new TD(73, "B/05.7.5", "Изучение интересов, склонностей, способностей лиц с ограниченными возможностями здоровья, обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 12));
        tdList.add(new TD(74, "B/05.7.6", "Осуществление с целью профориентации комплекса диагностических мероприятий по изучению мотивации, личностных, характерологических особенностей лиц с ограниченными возможностями здоровья, обучающихся, испытывающих трудности в освоении основных общеобразовательных программ, развитии и социальной адаптации, в том числе несовершеннолетних обучающихся, признанных в установленном порядке обвиняемыми или подсудимыми, либо являющихся потерпевшими или свидетелями преступления", 12));
        tdList.add(new TD(75, "B/05.7.7", "Ведение профессиональной документации (планы работы, протоколы, журналы, психологические заключения и отчеты)", 12));
//        roomHelper.insertListTD(tdList).subscribe();
	    roomHelper.initializeTD(tdList);

        categoryList.add(new Category(1, "Классные руководители"));
        categoryList.add(new Category(2, "Педагоги"));
        categoryList.add(new Category(3, "Обучающиеся"));
        categoryList.add(new Category(4, "Родители"));
        categoryList.add(new Category(5, "Администрация"));
        roomHelper.insertListCategory(categoryList).subscribe();

        groupList.add(new Group("5а"));
        groupList.add(new Group("5б"));
        groupList.add(new Group("5в"));
        groupList.add(new Group("5г"));
        groupList.add(new Group("6а"));
        groupList.add(new Group("6б"));
        groupList.add(new Group("6в"));
        groupList.add(new Group("6г"));
        roomHelper.insertListGroups(groupList).subscribe();

        workFormList.add(new WorkForm(1, "Дианостика"));
        workFormList.add(new WorkForm(2, "Профилактическая акция"));
        workFormList.add(new WorkForm(3, "Консультация"));
        workFormList.add(new WorkForm(4, "Тренинговое занятие"));
        workFormList.add(new WorkForm(5, "Развитие"));
        workFormList.add(new WorkForm(6, "Профилактика"));
        roomHelper.insertListWorkForms(workFormList).subscribe();
    }
}
