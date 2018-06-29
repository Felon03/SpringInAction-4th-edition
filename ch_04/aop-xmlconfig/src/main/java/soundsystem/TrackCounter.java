package soundsystem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-06 21:19
 * Description:
 */
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
