package com.startuph.startup.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.startuph.startup.R
import com.startuph.startup.adapter.ItemListAdapter
import com.startuph.startup.databinding.FragmentItemListBinding
import com.startuph.startup.model.ItemDataModel


class ItemListFragment : Fragment() {
    private var _binding: FragmentItemListBinding? = null

    private val binding get() = _binding!!
    var adapter: ItemListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.itemListFragRecycler.layoutManager = LinearLayoutManager(requireContext())
        var data: MutableList<ItemDataModel> = mutableListOf<ItemDataModel>()
        data.add(0, ItemDataModel(R.drawable.women, "Header1", "desc1"))
        data.add(1, ItemDataModel(R.drawable.women, "Header2", "desc2"))
        data.add(2, ItemDataModel(R.drawable.women, "Header3", "desc3"))
        data.add(3, ItemDataModel(R.drawable.women, "Header4", "desc4"))
        data.add(4, ItemDataModel(R.drawable.women, "Header5", "desc5"))
        data.add(5, ItemDataModel(R.drawable.women, "Header6", "desc6"))
        data.add(6, ItemDataModel(R.drawable.women, "Header7", "desc7"))
        adapter = ItemListAdapter(
            requireContext(),
            data
        )
        binding.itemListFragRecycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

    }
}