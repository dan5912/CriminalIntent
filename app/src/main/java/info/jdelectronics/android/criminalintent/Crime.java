package info.jdelectronics.android.criminalintent;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by daniel on 2/1/16.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE, MM:dd:yyyy h:mm:aa ");

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public StringBuffer getDateString() {
        StringBuffer dateString = new StringBuffer();
        DATE_FORMAT.format(mDate,dateString,new FieldPosition(DateFormat.DEFAULT));
        return dateString;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
