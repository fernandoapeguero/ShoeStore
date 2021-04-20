package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {


    var _shoes = MutableLiveData<MutableList<Shoe>>()


    init {
        _shoes.value = mutableListOf(
            Shoe(
                "Air Jordan Retro",
                10.5,
                "Nike",
                "best shoes around",
                mutableListOf(
                    "air_jordan"
                )
            ),
            Shoe(
                "Air Jordan 4",
                10.5,
                "Nike",
                "This Air Jordan 4 Golf retains the iconic Air Jordan 4 design intact, while bearing the familiar OG colorway of White/Fire Red-Tech Grey-Black.",
                mutableListOf(
                    "https://d1zkmbbkp46fmz.cloudfront.net/rmZ4vdONJxp2u6Dw64y2un9RVP0=/0/1/6/3/0163a17afdd9f84c86480a6713d1d10f746256ed_nike_Air_Jordan_4_Retro_White_Fire_Red_Black_Tech_Grey_DC7770_160_1.jpg",
                    "https://images.solecollector.com/complex/images/c_crop,h_1105,w_1965,x_20,y_514/xfdgz9uaguocb9bn81eu/air-jordan-4-iv-retro-what-the-ci1184-146-pair"
                )
            )
        )
    }
}