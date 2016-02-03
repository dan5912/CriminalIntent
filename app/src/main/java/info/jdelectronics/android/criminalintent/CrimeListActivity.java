package info.jdelectronics.android.criminalintent;


import android.support.v4.app.Fragment;


/**
 * Created by daniel on 2/2/16.
 */
public class CrimeListActivity extends SingleFragmentActivity {



    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
