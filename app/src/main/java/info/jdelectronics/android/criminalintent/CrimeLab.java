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
        public int crime_id;
    };

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Every other one
            mCrimes.add(crime);
        }
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
                info.crime_id = i;
                return info;
            }
        }
        return null;
    }
}
