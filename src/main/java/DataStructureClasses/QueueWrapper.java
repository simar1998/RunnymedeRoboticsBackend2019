package DataStructureClasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Simar on 2/18/2019.
 */

public class QueueWrapper {

    ArrayList<SubmitMatch> submitMatchArrayList = new ArrayList<>();

    public QueueWrapper() {
    }

    public QueueWrapper(ArrayList<SubmitMatch> submitMatchArrayList) {
        this.submitMatchArrayList = submitMatchArrayList;
    }

    public ArrayList<SubmitMatch> getSubmitMatchArrayList() {
        return submitMatchArrayList;
    }

    public void setSubmitMatchArrayList(ArrayList<SubmitMatch> submitMatchArrayList) {
        this.submitMatchArrayList = submitMatchArrayList;
    }

    public void addToQueueWrapper(SubmitMatch submitMatch){
        submitMatchArrayList.add(submitMatch);
    }

    public void insertSQL(){
        Iterator<SubmitMatch> submitMatchIterator = submitMatchArrayList.iterator();
        while (submitMatchIterator.hasNext()){
            submitMatchIterator.next().insertSQL(false);
        }
    }
}
