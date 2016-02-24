package info.jdelectronics.android.criminalintent;


import android.content.Intent;
import android.support.v4.app.Fragment;


/**
 * Created by daniel on 2/2/16.
 */
public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.Callbacks, CrimeFragment.Callbacks {

    @Override protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if(findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        }
        else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_container,newDetail).commit();
        }
    }

    @Override
    public void onCrimeUpdate(Crime crime, String caller) {
        if (caller.equals(CrimeFragment.CALLBACK_ID)) {
            CrimeListFragment listFragment = (CrimeListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            listFragment.updateUI();
        }
        else if (caller.equals(CrimeListFragment.CALLBACK_ID)) {
            CrimeFragment crimeFragment = (CrimeFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment_container);
            crimeFragment.updateUI();
        }
    }

    @Override
    public void onCrimeDelete() {
        Fragment newDetail = new Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_container,newDetail).commit();
        CrimeListFragment listFragment = (CrimeListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        listFragment.updateUI();

    }

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
