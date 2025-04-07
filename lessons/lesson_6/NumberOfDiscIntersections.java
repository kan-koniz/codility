// https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
package lessons.lesson_6;

import java.util.*;

public class NumberOfDiscIntersections {
    enum EventType {
        OPEN,
        CLOSE
    }

    class Event {
        long position;
        EventType type;

        Event(long position, EventType type) {
            this.position = position;
            this.type = type;
        }
    }

    public int solution(int[] A) {
        int N = A.length;
        List<Event> events = new ArrayList<>();

        for (int  i = 0; i < N; i++) {
            events.add(new Event(i - (long)A[i], EventType.OPEN));
            events.add(new Event(i + (long)A[i], EventType.CLOSE));
        }

        Collections.sort(events, (a, b) -> {
            if (a.position == b.position) {
                return a.type.ordinal() - b.type.ordinal();
            }

            return Long.compare(a.position, b.position);
        });

        int activeDiscs = 0;
        int intersections = 0;

        for (Event event: events) {
            if (event.type == EventType.OPEN) {
                intersections += activeDiscs;
                activeDiscs++;

                if (intersections > 10000000) {
                    return -1;
                }
            } else {
                activeDiscs--;
            }
        }

        return intersections;
    }
    
}
