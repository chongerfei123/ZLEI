package com.example.zl.zlei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.zl.zlei.View.frg.channalfrg.BabyFragment;
import com.example.zl.zlei.View.frg.channalfrg.ConstellationFragment;
import com.example.zl.zlei.View.frg.channalfrg.EducationFragment;
import com.example.zl.zlei.View.frg.channalfrg.EntertainmentFragment;
import com.example.zl.zlei.View.frg.channalfrg.FinanceFragment;
import com.example.zl.zlei.View.frg.channalfrg.HealthFragment;
import com.example.zl.zlei.View.frg.channalfrg.MilitaryFragment;
import com.example.zl.zlei.View.frg.channalfrg.NBAFragment;
import com.example.zl.zlei.View.frg.channalfrg.PEFragment;
import com.example.zl.zlei.View.frg.channalfrg.SharesFragment;
import com.example.zl.zlei.View.frg.channalfrg.TechnologyFragment;
import com.example.zl.zlei.View.frg.channalfrg.TopFragment;
import com.example.zl.zlei.View.frg.channalfrg.WomenFragment;
import com.example.zl.zlei.View.frg.channalfrg.XinWenFragment;

import java.util.ArrayList;

/**
 * Created by zl on 2017/5/8.
 */
//["头条","新闻","财经","体育","娱乐","军事","教育","科技","NBA","股票","星座","女性","健康","育儿"]}
public class MyPagerAdapter extends FragmentPagerAdapter {
    private static ArrayList<String> channalList = new ArrayList<String>(){{add("头条"); add("新闻");add("财经"); add("体育");add("娱乐");
                                    add("军事");add("教育"); add("科技");add("NBA"); add("股票");add("星座"); add("女性");add("健康"); add("育儿");}};
    private TopFragment topFragment = null;
    private XinWenFragment xinWenFragment = null;
    private FinanceFragment financeFragment = null;
    private PEFragment peFragment = null;
    private EntertainmentFragment entertainmentFragment = null;
    private MilitaryFragment militaryFragment = null;
    private EducationFragment educationFragment = null;
    private TechnologyFragment technologyFragment = null;
    private NBAFragment nbaFragment = null;
    private SharesFragment sharesFragment = null;
    private ConstellationFragment constellationFragment = null;
    private WomenFragment womenFragment = null;
    private HealthFragment healthFragment = null;
    private BabyFragment babyFragment = null;
    private Fragment currentFragment = null;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments() {
        Log.e("sout","initFragments");
        if (topFragment == null){
            topFragment = new TopFragment();
        }
        if (xinWenFragment == null){
            xinWenFragment = new XinWenFragment();
        }
        if (financeFragment == null){
            financeFragment = new FinanceFragment();
        }
        if (peFragment == null){
            peFragment = new PEFragment();
        }
        if (entertainmentFragment == null){
            entertainmentFragment = new EntertainmentFragment();
        }
        if (militaryFragment == null){
            militaryFragment = new MilitaryFragment();
        }
        if (educationFragment == null){
            educationFragment = new EducationFragment();
        }
        if (technologyFragment == null){
            technologyFragment = new TechnologyFragment();
        }
        if (nbaFragment == null){
            nbaFragment = new NBAFragment();
        }
        if (sharesFragment == null){
            sharesFragment = new SharesFragment();
        }
        if (constellationFragment == null){
            constellationFragment = new ConstellationFragment();
        }
        if (womenFragment == null){
            womenFragment = new WomenFragment();
        }
        if (healthFragment == null){
            healthFragment = new HealthFragment();
        }
        if (babyFragment == null){
            babyFragment = new BabyFragment();
        }
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("sout","getItem");
        switch (position) {
            case 0:currentFragment = topFragment; break;
            case 1:currentFragment = xinWenFragment; break;
            case 2:currentFragment = financeFragment; break;
            case 3:currentFragment = peFragment; break;
            case 4:currentFragment = entertainmentFragment; break;
            case 5:currentFragment = militaryFragment; break;
            case 6:currentFragment = educationFragment; break;
            case 7:currentFragment = technologyFragment; break;
            case 8:currentFragment = nbaFragment; break;
            case 9:currentFragment = sharesFragment; break;
            case 10:currentFragment = constellationFragment; break;
            case 11:currentFragment = womenFragment; break;
            case 12:currentFragment = healthFragment; break;
            case 13:currentFragment = babyFragment; break;
        }

        return currentFragment;
    }

    @Override
    public int getCount() {
        return channalList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return channalList.get(position);
    }
}
