package sia.knights;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-29 15:09
 * Description: 紧耦合实例
 */
public class DamselRescuingKnight implements Knight {

    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        this.quest = new RescueDamselQuest();   // 与ResuceDamselQuest紧耦合，只能接受指定的quest
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
