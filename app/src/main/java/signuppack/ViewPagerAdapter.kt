package signuppack

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(frgmentActivity: FragmentActivity):
    FragmentStateAdapter(frgmentActivity) {

    val fList = listOf<Fragment>(SurveyFragment1(), SurveyFragment2(), SurveyFragment3(),
        SurveyFragment4(), SurveyFragment5(), SurveyFragment6(), SurveyFragment7())

    override fun getItemCount(): Int {
        return fList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fList[position]
    }

}