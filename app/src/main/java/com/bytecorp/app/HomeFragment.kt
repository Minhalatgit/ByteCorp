package com.bytecorp.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.login

class HomeFragment : Fragment() {

    companion object {
        const val IMAGE_URL =
            "https://www.skechers.com/dw/image/v2/BDCN_PRD/on/demandware.static/-/Library-Sites-SkechersSharedLibrary/default/dwb5402fa1/images/Landing/men/SKX44314-2020-New-Site-Q2-Content-Grid_M_Casual-Sneakers_51286-NVW.jpg?sw=356"
    }

    private val list = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list.add(Item(IMAGE_URL, "Item name", "$20.00"))
        list.add(Item(IMAGE_URL, "Item name", "$20.00"))
        list.add(Item(IMAGE_URL, "Item name", "$20.00"))
        list.add(Item(IMAGE_URL, "Item name", "$20.00"))
        list.add(Item(IMAGE_URL, "Item name", "$20.00"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filter.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }

        hotDealsRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        trendingRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        hotDealsRv.adapter = ItemAdapter(requireContext(), list)
        trendingRv.adapter = ItemAdapter(requireContext(), list)
    }
}
