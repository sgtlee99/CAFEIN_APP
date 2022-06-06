package signuppack

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(frgmentActivity: FragmentActivity):
    FragmentStateAdapter(frgmentActivity) {

    val fList = listOf<Fragment>(
        SurveyActivity1(), SurveyActivity2(), SurveyActivity3(), SurveyActivity4(),
        SurveyActivity5(), SurveyActivity6(), SurveyActivity7()
    )

    override fun getItemCount(): Int {
        return fList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fList[position]
    }

}