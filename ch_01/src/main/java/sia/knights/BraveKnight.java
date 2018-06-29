package sia.knights;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-29 15:11
 * Description: 构造注入实例，可以灵活接受多种类型的任务
 */
public class BraveKnight implements Knight {

    private Quest quest;

    // 在构造的时候把探险任务作为构造器参数传入。这是依赖注入的方式之一，即构造器注入(constructor injection)
    public BraveKnight(Quest quest) {   // Quest被注入进来，可以接受实现了Quest接口的任何任务
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
