package info.jdelectronics.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by daniel on 2/1/16.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;

    public class crimeInfo {
        public Crime crime;
        public int crime_index;
    }

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public boolean deleteCrime(Crime c) {
        Crime crime;
        UUID cId = c.getId();
        for (int i=0;i<mCrimes.size();i++) {
            crime = mCrimes.get(i);
            if(crime.getId().equals(cId)) {
                mCrimes.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public crimeInfo getCrime(UUID id) {
        Crime crime;
        for (int i=0;i<mCrimes.size();i++) {
            crime = mCrimes.get(i);
            if (crime.getId().equals(id)) {
                crimeInfo info = new crimeInfo();
                info.crime = crime;
                info.crime_index = i;
                return info;
            }
        }
        return null;
    }
}
