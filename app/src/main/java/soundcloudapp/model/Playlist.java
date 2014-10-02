package soundcloudapp.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Playlist {

    private static TreeMap<Integer, Track> sTracks = new TreeMap<Integer, Track>();
    private static Integer sCounter = 0;
    private static Integer sCurrentPosition;

    public static void addTrack(Track track) {
        sTracks.put(sCounter, track);
        sCounter++;
    }

    public static Track getTrack(Integer key) {
        return sTracks.get(key);
    }

    public static Integer getSize() {
        return sCounter;
    }

    public static Track getNextTrack(Track track) {
        Map.Entry<Integer, Track> nextEntry = sTracks.higherEntry(sCurrentPosition);

        Track nextTrack;
        if (nextEntry != null) {
            nextTrack = nextEntry.getValue();
            sCurrentPosition++;
        } else {
            nextTrack = sTracks.firstEntry().getValue();
            sCurrentPosition = 0;
        }

        return nextTrack;
    }

//    public static Track getPreviousTrack(Track track) {
//        Map.Entry<Integer, Track> previousEntry = sTracks.lowerEntry(sCurrentPosition);
//
//        Track previousTrack;
//        if (previousEntry != null) {
//            previousTrack = previousEntry.getValue();
//            sCurrentPosition--;
//        } else {
//            previousEntry = sTracks.lastEntry().getValue();
//            sCurrentPosition = sCounter;
//        }
//
//        return previousTrack;
//    }
}