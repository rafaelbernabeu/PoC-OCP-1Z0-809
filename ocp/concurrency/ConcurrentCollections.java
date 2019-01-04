package concurrency;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 *
 */
public class ConcurrentCollections {

    //                                                                                                    Ordered?  |  Sorted  |  Blocking
    private ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();                            //    No           No          No
    private ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();                //    Yes          No          No
    private ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();                //    Yes          No          No
    private ConcurrentSkipListMap concurrentSkipListMapl4 = new ConcurrentSkipListMap();              //    Yes          Yes         No
    private ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();                //    Yes          Yes         No
    private List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();                         //    Yes          No          No
    private Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();                            //    No           No          No
    private LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();                      //    Yes          No          Yes
    private LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();                      //    Yes          No          Yes

}
