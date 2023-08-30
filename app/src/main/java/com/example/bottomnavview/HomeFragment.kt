package com.example.bottomnavview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnavview.adapter.MovieAdapter
import com.example.bottomnavview.databinding.FragmentHomeBinding
import com.example.bottomnavview.model.Movie

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        initView()
        return binding.root
    }

    private fun initView() {
        val movie1 = Movie("HarryPotter","https://picsum.photos/200","Fantasy")
        val movie2 = Movie("CastAway","https://flxt.tmsimg.com/assets/p26553_p_v8_ay.jpg","Survival")
        val movie3 = Movie("Avengers EndGame","https://cdn.marvel.com/content/1x/avengersendgame_lob_crd_05.jpg","Action")
        val movie4 = Movie("Extraction2","https://static.wikia.nocookie.net/netflix/images/7/71/Extraction_2.jpg/revision/latest?cb=20230412080639","Action")
        val movie5 = Movie("Fast And Furious 9","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4LgMn8L0pUIkSbyZe__tYeEHHQuXROTk73g&usqp=CAU","Action & Cars")
        val movie6 = Movie("HarryPotter","https://m.media-amazon.com/images/M/MV5BNmQ0ODBhMjUtNDRhOC00MGQzLTk5MTAtZDliODg5NmU5MjZhXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_FMjpg_UX1000_.jpg","Fantasy")
        val movie7 = Movie("CastAway","https://flxt.tmsimg.com/assets/p26553_p_v8_ay.jpg","Survival")
        val movie8 = Movie("Avengers EndGame","https://cdn.marvel.com/content/1x/avengersendgame_lob_crd_05.jpg","Action")
        val movie9 = Movie("Extraction2","https://static.wikia.nocookie.net/netflix/images/7/71/Extraction_2.jpg/revision/latest?cb=20230412080639","Action")
        val movie10 = Movie("Fast And Furious 9","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4LgMn8L0pUIkSbyZe__tYeEHHQuXROTk73g&usqp=CAU","Action & Cars")
        val movie11 = Movie("HarryPotter","https://m.media-amazon.com/images/M/MV5BNmQ0ODBhMjUtNDRhOC00MGQzLTk5MTAtZDliODg5NmU5MjZhXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_FMjpg_UX1000_.jpg","Fantasy")
        val movie12 = Movie("CastAway","https://flxt.tmsimg.com/assets/p26553_p_v8_ay.jpg","Survival")
        val movie13 = Movie("Avengers EndGame","https://cdn.marvel.com/content/1x/avengersendgame_lob_crd_05.jpg","Action")
        val movie14 = Movie("Extraction2","https://static.wikia.nocookie.net/netflix/images/7/71/Extraction_2.jpg/revision/latest?cb=20230412080639","Action")
        val movie15 = Movie("Fast And Furious 9","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4LgMn8L0pUIkSbyZe__tYeEHHQuXROTk73g&usqp=CAU","Action & Cars")

        val listOfMovie = listOf(movie1,movie2,movie3,movie4,movie5,movie6,movie7,movie8,movie9,movie10,movie11,movie12,movie13,movie14,movie15)
        val movieAdapter = MovieAdapter(listOfMovie,requireContext())
        binding.movieRecyclerView.adapter = movieAdapter
    }



}