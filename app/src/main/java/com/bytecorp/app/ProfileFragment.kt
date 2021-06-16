package com.bytecorp.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.login

class ProfileFragment : Fragment() {

    companion object {
        const val IMAGE_URL =
            "https://www.skechers.com/dw/image/v2/BDCN_PRD/on/demandware.static/-/Library-Sites-SkechersSharedLibrary/default/dwb5402fa1/images/Landing/men/SKX44314-2020-New-Site-Q2-Content-Grid_M_Casual-Sneakers_51286-NVW.jpg?sw=356"
    }

    private val list = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list.add(
            Post(
                IMAGE_URL,
                "Header",
                "He'll want to use your yacht, and I don't want this thing smelling like fish."
            )
        )
        list.add(
            Post(
                IMAGE_URL,
                "Header",
                "He'll want to use your yacht, and I don't want this thing smelling like fish."
            )
        )
        list.add(
            Post(
                IMAGE_URL,
                "Header",
                "He'll want to use your yacht, and I don't want this thing smelling like fish."
            )
        )
        list.add(
            Post(
                IMAGE_URL,
                "Header",
                "He'll want to use your yacht, and I don't want this thing smelling like fish."
            )
        )
        list.add(
            Post(
                IMAGE_URL,
                "Header",
                "He'll want to use your yacht, and I don't want this thing smelling like fish."
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selection.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    postsRv.visibility = View.VISIBLE
                    photos.visibility = View.GONE
                } else {
                    postsRv.visibility = View.GONE
                    photos.visibility = View.VISIBLE
                }
            }

        })

        postsRv.layoutManager =
            LinearLayoutManager(requireContext())

        postsRv.adapter = PostAdapter(requireContext(), list)
    }
}
