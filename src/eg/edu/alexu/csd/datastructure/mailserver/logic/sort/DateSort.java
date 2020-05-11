package eg.edu.alexu.csd.datastructure.mailserver.logic.sort;

import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.ILinkedList;

public class DateSort implements ISort {
    private boolean isAscending;

    public DateSort(boolean isAscending) {
        this.isAscending = isAscending;
    }

    @Override
    public ILinkedList sort(ILinkedList list) {
        return null;
    }
}
