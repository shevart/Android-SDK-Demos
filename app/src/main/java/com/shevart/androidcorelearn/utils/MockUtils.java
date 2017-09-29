package com.shevart.androidcorelearn.utils;

import com.shevart.androidcorelearn.common.SimpleItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockUtils {
    private static final int DEF_LIST_SIZE = 25;

    private static long nextId = 0;
    private static List<String> titles = new ArrayList<>();
    private static List<String> descriptions = new ArrayList<>();
    private static Random random = new Random();

    static {
        titles.add("Audi");
        titles.add("BMW");
        titles.add("Mercedes");
        titles.add("Opel");
        titles.add("Ford");
        titles.add("Volkswagen");

        descriptions.add("McLaren says development is underway at the McLaren Special Operations division.");
        descriptions.add("To the casual observer this test mule doesn't immediately stand out as the hottest T-Roc, with the same front-end design, ride height and side view.");
        descriptions.add("The large alloys are the only other indication that this isn't an ordinary T-Roc, but expect the production model to feature more aggresive lower body styling.");
        descriptions.add("However, it won't be covered in slits and spoilers, as R models are usually quite understated. ");
    }

    @SuppressWarnings("WeakerAccess")
    public static final class SimpleItems {
        public static ArrayList<SimpleItem> generateSimpleItemsList() {
            ArrayList<SimpleItem> items = new ArrayList<>(DEF_LIST_SIZE + 1);
            for (int i = 0; i < DEF_LIST_SIZE; i++) {
                items.add(generateSimpleItem());
            }
            return items;
        }

        public static SimpleItem generateSimpleItem() {
            SimpleItem item = new SimpleItem();
            item.setId(getNextId());
            item.setTitle(getNextTitle());
            item.setDescription(getNextDescription());
            return item;
        }
    }

    private static long getNextId() {
        return nextId++;
    }

    private static String getNextTitle() {
        return titles.get(random.nextInt(titles.size()));
    }

    private static String getNextDescription() {
        return descriptions.get(random.nextInt(descriptions.size()));
    }
}
